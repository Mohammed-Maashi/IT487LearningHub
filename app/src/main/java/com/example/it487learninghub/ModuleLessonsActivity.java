package com.example.it487learninghub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ModuleLessonsActivity extends AppCompatActivity {

    // Interface components
    private TextView tvModuleTitle;
    private TextView tvModuleSubtitle;
    private TextView tvModuleProgress;
    private TextView tvModulePercent;

    private ProgressBar moduleProgressBar;
    private RecyclerView recyclerLessons;

    // Lesson Adapter
    private LessonAdapter lessonAdapter;

    // SQLite database
    private LearningDatabaseHelper databaseHelper;

    // Selected module information
    private int moduleId;
    private String moduleTitle;
    private String moduleCategory;

    // Current lessons and completion states
    private List<LessonAdapter.Lesson> lessons =
            new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_module_lessons);

        // Handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets bars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            bars.left,
                            bars.top,
                            bars.right,
                            bars.bottom
                    );

                    return insets;
                }
        );

        initializeViews();

        // Validate selected module
        if (!receiveModuleData()) {
            finish();
            return;
        }

        // Initialize SQLite database
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        displayModuleInformation();
        setupRecyclerView();
        setupBackButton();

        // Load saved progress
        refreshLessonProgress();
    }

    // Connect Java variables with XML components
    private void initializeViews() {

        tvModuleTitle = findViewById(
                R.id.tvModuleTitle
        );

        tvModuleSubtitle = findViewById(
                R.id.tvModuleSubtitle
        );

        tvModuleProgress = findViewById(
                R.id.tvModuleProgress
        );

        tvModulePercent = findViewById(
                R.id.tvModulePercent
        );

        moduleProgressBar = findViewById(
                R.id.moduleProgressBar
        );

        recyclerLessons = findViewById(
                R.id.recyclerLessons
        );
    }

    // Receive selected module data
    private boolean receiveModuleData() {

        moduleId = getIntent().getIntExtra(
                "module_id", -1
        );

        moduleTitle = getIntent().getStringExtra(
                "module_title"
        );

        moduleCategory = getIntent().getStringExtra(
                "module_category"
        );

        return moduleId >= 1
                && moduleId <= 14
                && moduleTitle != null
                && !moduleTitle.trim().isEmpty();
    }

    // Display selected module information
    private void displayModuleInformation() {

        tvModuleTitle.setText(moduleTitle);

        String category = moduleCategory == null
                ? ""
                : moduleCategory.toUpperCase(Locale.US);

        String subtitle = String.format(
                Locale.US,
                "MODULE %02d · %s",
                moduleId,
                category
        );

        tvModuleSubtitle.setText(subtitle);
    }

    // Configure RecyclerView and lesson navigation
    private void setupRecyclerView() {

        recyclerLessons.setLayoutManager(
                new LinearLayoutManager(this)
        );

        lessonAdapter = new LessonAdapter(lesson -> {

            Intent intent = new Intent(
                    ModuleLessonsActivity.this,
                    LessonDetailsActivity.class
            );

            intent.putExtra(
                    "module_id",
                    lesson.moduleId
            );

            intent.putExtra(
                    "lesson_number",
                    lesson.number
            );

            intent.putExtra(
                    "lesson_title",
                    lesson.title
            );

            intent.putExtra(
                    "module_title",
                    moduleTitle
            );

            startActivity(intent);
        });

        recyclerLessons.setAdapter(lessonAdapter);
    }

    // Load lesson completion states from SQLite
    private void refreshLessonProgress() {

        if (databaseHelper == null || lessonAdapter == null) {
            return;
        }

        // Get lesson titles from repository
        List<LessonAdapter.Lesson> sourceLessons =
                CourseContentRepository
                        .getLessonsForModule(moduleId);

        List<LessonAdapter.Lesson> updatedLessons =
                new ArrayList<>();

        // Read completion status for each lesson
        for (LessonAdapter.Lesson lesson : sourceLessons) {

            boolean completed =
                    databaseHelper.isLessonCompleted(
                            moduleId,
                            lesson.number
                    );

            LessonAdapter.Lesson updatedLesson =
                    new LessonAdapter.Lesson(
                            lesson.moduleId,
                            lesson.number,
                            lesson.title,
                            completed
                    );

            updatedLessons.add(updatedLesson);
        }

        // Replace the displayed lesson list
        lessons = updatedLessons;

        lessonAdapter.setLessons(lessons);

        // Update module completion statistics
        updateModuleProgress();
    }

    // Calculate module progress using saved data
    private void updateModuleProgress() {

        int totalLessons = lessons.size();
        int completedLessons = 0;

        for (LessonAdapter.Lesson lesson : lessons) {

            if (lesson.completed) {
                completedLessons++;
            }
        }

        int progressPercent = totalLessons == 0
                ? 0
                : (int) Math.round(
                completedLessons * 100.0
                        / totalLessons
        );

        tvModulePercent.setText(
                progressPercent + "%"
        );

        tvModuleProgress.setText(
                completedLessons
                        + " of "
                        + totalLessons
                        + " lessons completed"
        );

        moduleProgressBar.setProgress(
                progressPercent
        );
    }

    // Refresh progress when returning from a lesson
    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null && lessonAdapter != null) {
            refreshLessonProgress();
        }
    }

    // Return to Explore
    private void setupBackButton() {

        findViewById(R.id.btnBack).setOnClickListener(
                v -> finish()
        );
    }

    // Release database resources
    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
