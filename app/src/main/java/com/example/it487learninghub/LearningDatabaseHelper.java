package com.example.it487learninghub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class LearningDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME =
            "it487_learning.db";

    // Version 3 introduces quiz attempt history
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_PROGRESS =
            "lesson_progress";

    private static final String TABLE_NOTES =
            "notes";

    private static final String TABLE_QUIZ_ATTEMPTS =
            "quiz_attempts";

    public LearningDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create all tables for new installations
    @Override
    public void onCreate(SQLiteDatabase db) {

        createProgressTable(db);
        createNotesTable(db);
        createQuizAttemptsTable(db);
    }

    // Preserve existing data during upgrades
    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion) {

        // Version 2: Notes
        if (oldVersion < 2) {
            createNotesTable(db);
        }

        // Version 3: Quiz attempts
        if (oldVersion < 3) {
            createQuizAttemptsTable(db);
        }
    }

    // =====================================
    // DATABASE TABLES
    // =====================================

    private void createProgressTable(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS "
                        + TABLE_PROGRESS + " ("
                        + "module_id INTEGER NOT NULL, "
                        + "lesson_number INTEGER NOT NULL, "
                        + "completed INTEGER NOT NULL DEFAULT 0, "
                        + "bookmarked INTEGER NOT NULL DEFAULT 0, "
                        + "PRIMARY KEY (module_id, lesson_number)"
                        + ")"
        );
    }

    private void createNotesTable(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS "
                        + TABLE_NOTES + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "title TEXT NOT NULL, "
                        + "content TEXT NOT NULL, "
                        + "created_at INTEGER NOT NULL, "
                        + "updated_at INTEGER NOT NULL"
                        + ")"
        );
    }

    private void createQuizAttemptsTable(
            SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS "
                        + TABLE_QUIZ_ATTEMPTS + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "module_id INTEGER NOT NULL, "
                        + "correct_answers INTEGER NOT NULL, "
                        + "total_questions INTEGER NOT NULL, "
                        + "score_percent INTEGER NOT NULL, "
                        + "completed_at INTEGER NOT NULL"
                        + ")"
        );

        db.execSQL(
                "CREATE INDEX IF NOT EXISTS "
                        + "idx_quiz_attempts_module "
                        + "ON " + TABLE_QUIZ_ATTEMPTS
                        + " (module_id, completed_at DESC)"
        );
    }

    // =====================================
    // LESSON COMPLETION
    // =====================================

    public void setLessonCompleted(
            int moduleId,
            int lessonNumber,
            boolean completed) {

        updateFlag(
                moduleId,
                lessonNumber,
                "completed",
                completed
        );
    }

    public boolean isLessonCompleted(
            int moduleId,
            int lessonNumber) {

        return readFlag(
                moduleId,
                lessonNumber,
                "completed"
        );
    }

    // =====================================
    // LESSON BOOKMARKS
    // =====================================

    public void setLessonBookmarked(
            int moduleId,
            int lessonNumber,
            boolean bookmarked) {

        updateFlag(
                moduleId,
                lessonNumber,
                "bookmarked",
                bookmarked
        );
    }

    public boolean isLessonBookmarked(
            int moduleId,
            int lessonNumber) {

        return readFlag(
                moduleId,
                lessonNumber,
                "bookmarked"
        );
    }

    // Insert or update a lesson flag
    private void updateFlag(
            int moduleId,
            int lessonNumber,
            String column,
            boolean value) {

        if (moduleId < 1 || lessonNumber < 1) {
            return;
        }

        SQLiteDatabase db = getWritableDatabase();

        ContentValues initial = new ContentValues();

        initial.put("module_id", moduleId);
        initial.put("lesson_number", lessonNumber);

        db.insertWithOnConflict(
                TABLE_PROGRESS,
                null,
                initial,
                SQLiteDatabase.CONFLICT_IGNORE
        );

        ContentValues updates = new ContentValues();

        updates.put(column, value ? 1 : 0);

        db.update(
                TABLE_PROGRESS,
                updates,
                "module_id=? AND lesson_number=?",
                new String[]{
                        String.valueOf(moduleId),
                        String.valueOf(lessonNumber)
                }
        );
    }

    private boolean readFlag(
            int moduleId,
            int lessonNumber,
            String column) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.query(
                TABLE_PROGRESS,
                new String[]{column},
                "module_id=? AND lesson_number=?",
                new String[]{
                        String.valueOf(moduleId),
                        String.valueOf(lessonNumber)
                },
                null,
                null,
                null
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0) == 1;
            }
        }

        return false;
    }

    // Count completed lessons in one module
    public int getCompletedCountForModule(int moduleId) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM "
                        + TABLE_PROGRESS
                        + " WHERE module_id=? AND completed=1",
                new String[]{
                        String.valueOf(moduleId)
                }
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        return 0;
    }

    // Count completed lessons across the course
    public int getTotalCompletedLessons() {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM "
                        + TABLE_PROGRESS
                        + " WHERE completed=1",
                null
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        return 0;
    }

    // =====================================
    // NOTE DATA MODEL
    // =====================================

    public static class Note {

        public final long id;
        public final String title;
        public final String content;
        public final long createdAt;
        public final long updatedAt;

        public Note(
                long id,
                String title,
                String content,
                long createdAt,
                long updatedAt) {

            this.id = id;
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }

    // =====================================
    // CREATE NOTE
    // =====================================

    public long insertNote(
            String title,
            String content) {

        if (title == null || title.trim().isEmpty()) {
            return -1;
        }

        SQLiteDatabase db = getWritableDatabase();

        long currentTime = System.currentTimeMillis();

        ContentValues values = new ContentValues();

        values.put("title", title.trim());

        values.put(
                "content",
                content == null ? "" : content.trim()
        );

        values.put("created_at", currentTime);
        values.put("updated_at", currentTime);

        return db.insert(
                TABLE_NOTES,
                null,
                values
        );
    }

    // =====================================
    // READ AND SEARCH NOTES
    // =====================================

    public List<Note> getAllNotes() {
        return searchNotes("");
    }

    public List<Note> searchNotes(String searchText) {

        List<Note> notes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String selection = null;
        String[] selectionArgs = null;

        if (searchText != null
                && !searchText.trim().isEmpty()) {

            selection = "title LIKE ? OR content LIKE ?";

            String query = "%" + searchText.trim() + "%";

            selectionArgs = new String[]{
                    query,
                    query
            };
        }

        try (Cursor cursor = db.query(
                TABLE_NOTES,
                new String[]{
                        "id",
                        "title",
                        "content",
                        "created_at",
                        "updated_at"
                },
                selection,
                selectionArgs,
                null,
                null,
                "updated_at DESC, id DESC"
        )) {

            while (cursor.moveToNext()) {

                Note note = new Note(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getLong(3),
                        cursor.getLong(4)
                );

                notes.add(note);
            }
        }

        return notes;
    }

    // =====================================
    // UPDATE NOTE
    // =====================================

    public boolean updateNote(
            long noteId,
            String title,
            String content) {

        if (noteId <= 0
                || title == null
                || title.trim().isEmpty()) {

            return false;
        }

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("title", title.trim());

        values.put(
                "content",
                content == null ? "" : content.trim()
        );

        values.put(
                "updated_at",
                System.currentTimeMillis()
        );

        int affectedRows = db.update(
                TABLE_NOTES,
                values,
                "id=?",
                new String[]{
                        String.valueOf(noteId)
                }
        );

        return affectedRows > 0;
    }

    // =====================================
    // DELETE NOTE
    // =====================================

    public boolean deleteNote(long noteId) {

        if (noteId <= 0) {
            return false;
        }

        SQLiteDatabase db = getWritableDatabase();

        int affectedRows = db.delete(
                TABLE_NOTES,
                "id=?",
                new String[]{
                        String.valueOf(noteId)
                }
        );

        return affectedRows > 0;
    }

    // =====================================
    // COUNT NOTES
    // =====================================

    public int getNotesCount() {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM " + TABLE_NOTES,
                null
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        return 0;
    }

    // =====================================
    // QUIZ ATTEMPT DATA MODEL
    // =====================================

    public static class QuizAttempt {

        public final long id;
        public final int moduleId;
        public final int correctAnswers;
        public final int totalQuestions;
        public final int scorePercent;
        public final long completedAt;

        public QuizAttempt(
                long id,
                int moduleId,
                int correctAnswers,
                int totalQuestions,
                int scorePercent,
                long completedAt) {

            this.id = id;
            this.moduleId = moduleId;
            this.correctAnswers = correctAnswers;
            this.totalQuestions = totalQuestions;
            this.scorePercent = scorePercent;
            this.completedAt = completedAt;
        }
    }

    // =====================================
    // SAVE QUIZ ATTEMPT
    // =====================================

    public long insertQuizAttempt(
            int moduleId,
            int correctAnswers,
            int totalQuestions) {

        if (moduleId < 1
                || moduleId > 14
                || totalQuestions <= 0
                || correctAnswers < 0
                || correctAnswers > totalQuestions) {

            return -1;
        }

        int scorePercent = (int) Math.round(
                correctAnswers * 100.0 / totalQuestions
        );

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("module_id", moduleId);
        values.put("correct_answers", correctAnswers);
        values.put("total_questions", totalQuestions);
        values.put("score_percent", scorePercent);

        values.put(
                "completed_at",
                System.currentTimeMillis()
        );

        return db.insert(
                TABLE_QUIZ_ATTEMPTS,
                null,
                values
        );
    }

    // =====================================
    // READ QUIZ ATTEMPTS
    // =====================================

    public List<QuizAttempt> getQuizAttemptsForModule(
            int moduleId) {

        List<QuizAttempt> attempts = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.query(
                TABLE_QUIZ_ATTEMPTS,
                new String[]{
                        "id",
                        "module_id",
                        "correct_answers",
                        "total_questions",
                        "score_percent",
                        "completed_at"
                },
                "module_id=?",
                new String[]{
                        String.valueOf(moduleId)
                },
                null,
                null,
                "completed_at DESC, id DESC"
        )) {

            while (cursor.moveToNext()) {

                QuizAttempt attempt = new QuizAttempt(
                        cursor.getLong(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getLong(5)
                );

                attempts.add(attempt);
            }
        }

        return attempts;
    }

    // =====================================
    // COUNT QUIZ ATTEMPTS
    // =====================================

    public int getTotalQuizAttempts() {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM "
                        + TABLE_QUIZ_ATTEMPTS,
                null
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        return 0;
    }

    public int getQuizAttemptCountForModule(int moduleId) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM "
                        + TABLE_QUIZ_ATTEMPTS
                        + " WHERE module_id=?",
                new String[]{
                        String.valueOf(moduleId)
                }
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        return 0;
    }

    // =====================================
    // LATEST QUIZ SCORE
    // =====================================

    public int getLatestQuizScoreForModule(int moduleId) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT score_percent FROM "
                        + TABLE_QUIZ_ATTEMPTS
                        + " WHERE module_id=?"
                        + " ORDER BY completed_at DESC, id DESC"
                        + " LIMIT 1",
                new String[]{
                        String.valueOf(moduleId)
                }
        )) {

            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        }

        // No attempts yet
        return -1;
    }

    // =====================================
    // BEST QUIZ SCORE
    // =====================================

    public int getBestQuizScoreForModule(int moduleId) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT MAX(score_percent) FROM "
                        + TABLE_QUIZ_ATTEMPTS
                        + " WHERE module_id=?",
                new String[]{
                        String.valueOf(moduleId)
                }
        )) {

            if (cursor.moveToFirst()
                    && !cursor.isNull(0)) {

                return cursor.getInt(0);
            }
        }

        return -1;
    }

    // =====================================
    // AVERAGE QUIZ SCORE
    // =====================================

    public double getAverageQuizScoreForModule(
            int moduleId) {

        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.rawQuery(
                "SELECT AVG(score_percent) FROM "
                        + TABLE_QUIZ_ATTEMPTS
                        + " WHERE module_id=?",
                new String[]{
                        String.valueOf(moduleId)
                }
        )) {

            if (cursor.moveToFirst()
                    && !cursor.isNull(0)) {

                return cursor.getDouble(0);
            }
        }

        return -1;
    }
}
