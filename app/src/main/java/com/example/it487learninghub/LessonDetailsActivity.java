package com.example.it487learninghub;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class LessonDetailsActivity extends AppCompatActivity {

    // =====================================
    // SELECTED LESSON
    // =====================================

    private int moduleId;
    private int lessonNumber;
    private String lessonTitle;

    // =====================================
    // SQLITE DATABASE
    // =====================================

    private LearningDatabaseHelper databaseHelper;

    // Saved lesson state
    private boolean completed = false;
    private boolean bookmarked = false;

    // =====================================
    // LESSON CONTENT
    // =====================================

    private LessonContent lessonContent;

    private boolean contentReady = false;

    private String codeText = "";
    private String answerExplanation = "";
    private int correctAnswer = -1;

    // Selected tab
    private String currentSection = "learn";

    // =====================================
    // INTERFACE COMPONENTS
    // =====================================

    private TextView tvLessonMeta;
    private TextView tvLessonTitle;
    private TextView tvLessonSummary;
    private TextView tvLessonExplanation;
    private TextView tvKeyTakeaway;

    private TextView tvCodeExample;
    private TextView tvCodeExplanation;

    private TextView tvPracticeQuestion;
    private TextView tvAnswerFeedback;

    private TextView btnBookmark;

    // Learning sections
    private View sectionLearn;
    private View sectionCode;
    private View sectionPractice;

    // Tabs
    private MaterialButton tabLearn;
    private MaterialButton tabCode;
    private MaterialButton tabPractice;

    // Action buttons
    private MaterialButton btnCopyCode;
    private MaterialButton btnCheckAnswer;
    private MaterialButton btnCompleteLesson;

    // Practice components
    private RadioGroup rgPracticeAnswers;
    private RadioButton[] answers;

    // =====================================
    // ACTIVITY CREATION
    // =====================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_lesson_details);

        // Handle Android system bars
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

        // Initialize interface components
        initializeViews();

        // Validate selected lesson
        if (!receiveLessonData()) {

            Toast.makeText(
                    this,
                    "Invalid lesson information",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
            return;
        }

        // Initialize SQLite database
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        // Display lesson title and number
        displayLessonInformation();

        // Load content from the new repository
        loadLessonContent();

        // Configure tabs and buttons
        setupTabs();
        setupButtons();

        // Restore completion and bookmark states
        restoreLessonState();

        // Restore the selected tab after screen recreation
        if (savedInstanceState != null) {

            currentSection = savedInstanceState.getString(
                    "selected_section",
                    "learn"
            );
        }

        showSection(currentSection);
    }

    // =====================================
    // INITIALIZE VIEWS
    // =====================================

    private void initializeViews() {

        tvLessonMeta = findViewById(
                R.id.tvLessonMeta
        );

        tvLessonTitle = findViewById(
                R.id.tvLessonTitle
        );

        tvLessonSummary = findViewById(
                R.id.tvLessonSummary
        );

        tvLessonExplanation = findViewById(
                R.id.tvLessonExplanation
        );

        tvKeyTakeaway = findViewById(
                R.id.tvKeyTakeaway
        );

        tvCodeExample = findViewById(
                R.id.tvCodeExample
        );

        tvCodeExplanation = findViewById(
                R.id.tvCodeExplanation
        );

        tvPracticeQuestion = findViewById(
                R.id.tvPracticeQuestion
        );

        tvAnswerFeedback = findViewById(
                R.id.tvAnswerFeedback
        );

        btnBookmark = findViewById(
                R.id.btnBookmark
        );

        // Learning sections
        sectionLearn = findViewById(
                R.id.sectionLearn
        );

        sectionCode = findViewById(
                R.id.sectionCode
        );

        sectionPractice = findViewById(
                R.id.sectionPractice
        );

        // Tabs
        tabLearn = findViewById(
                R.id.tabLearn
        );

        tabCode = findViewById(
                R.id.tabCode
        );

        tabPractice = findViewById(
                R.id.tabPractice
        );

        // Action buttons
        btnCopyCode = findViewById(
                R.id.btnCopyCode
        );

        btnCheckAnswer = findViewById(
                R.id.btnCheckAnswer
        );

        btnCompleteLesson = findViewById(
                R.id.btnCompleteLesson
        );

        // Practice answer group
        rgPracticeAnswers = findViewById(
                R.id.rgPracticeAnswers
        );

        answers = new RadioButton[]{
                findViewById(R.id.rbAnswer1),
                findViewById(R.id.rbAnswer2),
                findViewById(R.id.rbAnswer3),
                findViewById(R.id.rbAnswer4)
        };
    }

    // =====================================
    // RECEIVE LESSON INFORMATION
    // =====================================

    private boolean receiveLessonData() {

        moduleId = getIntent().getIntExtra(
                "module_id",
                -1
        );

        lessonNumber = getIntent().getIntExtra(
                "lesson_number",
                -1
        );

        lessonTitle = getIntent().getStringExtra(
                "lesson_title"
        );

        return moduleId >= 1
                && moduleId <= 14
                && lessonNumber > 0
                && lessonTitle != null
                && !lessonTitle.trim().isEmpty();
    }

    // =====================================
    // DISPLAY LESSON INFORMATION
    // =====================================

    private void displayLessonInformation() {

        tvLessonMeta.setText(
                String.format(
                        Locale.US,
                        "MODULE %02d · LESSON %02d",
                        moduleId,
                        lessonNumber
                )
        );

        tvLessonTitle.setText(
                lessonTitle
        );
    }

    // =====================================
    // LOAD CONTENT FROM REPOSITORY
    // =====================================

    private void loadLessonContent() {

        // Request content for the selected lesson
        lessonContent =
                LessonContentRepository.getLessonContent(
                        moduleId,
                        lessonNumber
                );

        // Check whether educational content exists
        contentReady = lessonContent != null;

        // Reset practice feedback
        tvAnswerFeedback.setVisibility(View.GONE);

        rgPracticeAnswers.clearCheck();

        if (!contentReady) {

            displayPendingContent();
            return;
        }

        // Display educational content
        displayReadyContent(lessonContent);
    }

    // =====================================
    // DISPLAY AVAILABLE LESSON CONTENT
    // =====================================

    private void displayReadyContent(
            LessonContent content) {

        // LEARN TAB
        tvLessonSummary.setText(
                content.getSummary()
        );

        tvLessonExplanation.setText(
                content.getExplanation()
        );

        tvKeyTakeaway.setText(
                content.getKeyTakeaway()
        );

        // CODE TAB
        codeText = content.getCodeExample();

        if (content.hasCodeExample()) {

            tvCodeExample.setText(codeText);

            btnCopyCode.setVisibility(View.VISIBLE);

        } else {

            tvCodeExample.setText(
                    "No code example is available for this lesson."
            );

            btnCopyCode.setVisibility(View.GONE);
        }

        tvCodeExplanation.setText(
                content.getCodeExplanation()
        );

        // PRACTICE TAB
        tvPracticeQuestion.setText(
                content.getPracticeQuestion()
        );

        String[] options =
                content.getPracticeOptions();

        for (int i = 0; i < answers.length; i++) {

            answers[i].setText(
                    options[i]
            );
        }

        correctAnswer =
                content.getCorrectAnswerIndex();

        answerExplanation =
                content.getAnswerExplanation();

        rgPracticeAnswers.setVisibility(View.VISIBLE);

        btnCheckAnswer.setVisibility(View.VISIBLE);
    }

    // =====================================
    // DISPLAY CONTENT COMING SOON
    // =====================================

    private void displayPendingContent() {

        // Reset unused content
        codeText = "";
        answerExplanation = "";
        correctAnswer = -1;

        // Learn tab
        tvLessonSummary.setText(
                "IT487 interactive learning lesson."
        );

        tvLessonExplanation.setText(
                "Educational content for \""
                        + lessonTitle
                        + "\" is being prepared "
                        + "from the course materials."
        );

        tvKeyTakeaway.setText(
                "Key concepts will appear here."
        );

        // Code tab
        tvCodeExample.setText(
                "Code examples are being prepared."
        );

        tvCodeExplanation.setText(
                "Worked examples will be added soon."
        );

        btnCopyCode.setVisibility(View.GONE);

        // Practice tab
        tvPracticeQuestion.setText(
                "Practice questions are being prepared."
        );

        rgPracticeAnswers.setVisibility(View.GONE);

        btnCheckAnswer.setVisibility(View.GONE);

        tvAnswerFeedback.setVisibility(View.GONE);
    }

    // =====================================
    // RESTORE SAVED LESSON STATE
    // =====================================

    private void restoreLessonState() {

        if (databaseHelper == null) {
            return;
        }

        // Read completion state from SQLite
        completed = databaseHelper.isLessonCompleted(
                moduleId,
                lessonNumber
        );

        // Read bookmark state from SQLite
        bookmarked = databaseHelper.isLessonBookmarked(
                moduleId,
                lessonNumber
        );

        updateBookmarkUI();
        updateCompletionUI();
    }

    // =====================================
    // BOOKMARK LESSON
    // =====================================

    private void toggleBookmark() {

        if (databaseHelper == null) {
            return;
        }

        boolean newBookmarkState = !bookmarked;

        // Save bookmark to SQLite
        databaseHelper.setLessonBookmarked(
                moduleId,
                lessonNumber,
                newBookmarkState
        );

        // Read the saved state
        bookmarked = databaseHelper.isLessonBookmarked(
                moduleId,
                lessonNumber
        );

        updateBookmarkUI();

        Toast.makeText(
                this,
                bookmarked
                        ? "Lesson bookmarked"
                        : "Bookmark removed",
                Toast.LENGTH_SHORT
        ).show();
    }

    // Update bookmark icon
    private void updateBookmarkUI() {

        btnBookmark.setText(
                bookmarked ? "★" : "☆"
        );

        btnBookmark.setContentDescription(
                bookmarked
                        ? "Remove bookmark"
                        : "Bookmark lesson"
        );
    }

    // =====================================
    // COMPLETE LESSON
    // =====================================

    private void completeLesson() {

        // Do not complete lessons without content
        if (!contentReady) {

            Toast.makeText(
                    this,
                    "Lesson content is not ready yet",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (completed || databaseHelper == null) {
            return;
        }

        // Save lesson completion
        databaseHelper.setLessonCompleted(
                moduleId,
                lessonNumber,
                true
        );

        // Verify saved completion
        completed = databaseHelper.isLessonCompleted(
                moduleId,
                lessonNumber
        );

        updateCompletionUI();

        if (completed) {

            Toast.makeText(
                    this,
                    "Lesson completed successfully!",
                    Toast.LENGTH_SHORT
            ).show();

        } else {

            Toast.makeText(
                    this,
                    "Unable to save lesson completion",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    // Update completion button state
    private void updateCompletionUI() {

        if (!contentReady) {

            btnCompleteLesson.setText(
                    "Lesson Content Coming Soon"
            );

            btnCompleteLesson.setEnabled(false);

        } else if (completed) {

            btnCompleteLesson.setText(
                    "Lesson Completed ✓"
            );

            btnCompleteLesson.setEnabled(false);

        } else {

            btnCompleteLesson.setText(
                    "Mark Lesson as Complete"
            );

            btnCompleteLesson.setEnabled(true);
        }
    }

    // =====================================
    // CONFIGURE LEARNING TABS
    // =====================================

    private void setupTabs() {

        tabLearn.setOnClickListener(
                v -> showSection("learn")
        );

        tabCode.setOnClickListener(
                v -> showSection("code")
        );

        tabPractice.setOnClickListener(
                v -> showSection("practice")
        );
    }

    // Display selected section
    private void showSection(String section) {

        if (!"learn".equals(section)
                && !"code".equals(section)
                && !"practice".equals(section)) {

            section = "learn";
        }

        currentSection = section;

        sectionLearn.setVisibility(
                section.equals("learn")
                        ? View.VISIBLE
                        : View.GONE
        );

        sectionCode.setVisibility(
                section.equals("code")
                        ? View.VISIBLE
                        : View.GONE
        );

        sectionPractice.setVisibility(
                section.equals("practice")
                        ? View.VISIBLE
                        : View.GONE
        );

        styleTab(
                tabLearn,
                section.equals("learn")
        );

        styleTab(
                tabCode,
                section.equals("code")
        );

        styleTab(
                tabPractice,
                section.equals("practice")
        );
    }

    // Apply Dark Premium colors to tabs
    private void styleTab(
            MaterialButton button,
            boolean selected) {

        int background = selected
                ? R.color.primary_blue
                : R.color.surface_dark;

        int textColor = selected
                ? R.color.white
                : R.color.text_primary;

        button.setBackgroundTintList(
                ColorStateList.valueOf(
                        ContextCompat.getColor(
                                this,
                                background
                        )
                )
        );

        button.setTextColor(
                ContextCompat.getColor(
                        this,
                        textColor
                )
        );
    }

    // =====================================
    // CONFIGURE LESSON BUTTONS
    // =====================================

    private void setupButtons() {

        // Back to Module Lessons
        findViewById(
                R.id.btnLessonBack
        ).setOnClickListener(
                v -> finish()
        );

        // Copy example code
        btnCopyCode.setOnClickListener(v -> {

            if (codeText == null
                    || codeText.trim().isEmpty()) {

                return;
            }

            ClipboardManager clipboard =
                    (ClipboardManager) getSystemService(
                            Context.CLIPBOARD_SERVICE
                    );

            if (clipboard != null) {

                clipboard.setPrimaryClip(
                        ClipData.newPlainText(
                                "Lesson Code",
                                codeText
                        )
                );

                Toast.makeText(
                        this,
                        "Code copied",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Check practice answer
        btnCheckAnswer.setOnClickListener(
                v -> checkAnswer()
        );

        // Save or remove bookmark
        btnBookmark.setOnClickListener(
                v -> toggleBookmark()
        );

        // Mark lesson as completed
        btnCompleteLesson.setOnClickListener(
                v -> completeLesson()
        );
    }

    // =====================================
    // CHECK PRACTICE ANSWER
    // =====================================

    private void checkAnswer() {

        if (!contentReady || correctAnswer < 0) {
            return;
        }

        int selectedIndex = -1;

        // Read selected answer
        for (int i = 0; i < answers.length; i++) {

            if (answers[i].isChecked()) {

                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {

            Toast.makeText(
                    this,
                    "Please select an answer",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        boolean correct =
                selectedIndex == correctAnswer;

        // Display correct answer and explanation
        String correctAnswerText =
                answers[correctAnswer]
                        .getText()
                        .toString();

        String message = correct
                ? "Correct!"
                : "Incorrect answer.";

        message += "\n\nCorrect answer: "
                + correctAnswerText
                + "\n\n"
                + answerExplanation;

        tvAnswerFeedback.setText(message);

        tvAnswerFeedback.setTextColor(
                ContextCompat.getColor(
                        this,
                        correct
                                ? R.color.success_green
                                : R.color.text_primary
                )
        );

        tvAnswerFeedback.setVisibility(
                View.VISIBLE
        );
    }

    // =====================================
    // PRESERVE SELECTED TAB
    // =====================================

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString(
                "selected_section",
                currentSection
        );
    }

    // =====================================
    // RELEASE SQLITE RESOURCES
    // =====================================

    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
