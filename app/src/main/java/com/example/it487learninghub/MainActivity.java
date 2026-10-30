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

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // ==========================================
    // HOME DASHBOARD COMPONENTS
    // ==========================================

    private TextView tvProgress;
    private TextView tvLessonCount;
    private ProgressBar courseProgressBar;

    // ==========================================
    // SQLITE DATABASE
    // ==========================================

    private LearningDatabaseHelper databaseHelper;

    // ==========================================
    // COURSE INFORMATION
    // ==========================================

    private static final int TOTAL_LESSONS = 50;

    private static final String QUIZ_DIALOG_TAG =
            "quiz_selection_dialog";

    // All 14 learning modules
    private static final String[] MODULE_TITLES = {

            "Course Foundations",

            "Android and Java Fundamentals",

            "Android Project Structure",

            "Layouts and Material Design",

            "Activity Lifecycle",

            "Dialogs and RecyclerView",

            "Intents and Data Storage",

            "React and React Native",

            "JSX and Rendering",

            "Props, State and Context",

            "Component Lifecycle",

            "React Native Projects",

            "Responsive Flexbox",

            "Maps and Sensors"
    };

    // ==========================================
    // ACTIVITY LIFECYCLE
    // ==========================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

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

        // Initialize SQLite database
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        // Configure navigation and buttons
        setupNavigation();

        // Display saved learning progress
        updateCourseProgress();
    }

    // ==========================================
    // INITIALIZE INTERFACE COMPONENTS
    // ==========================================

    private void initializeViews() {

        tvProgress = findViewById(
                R.id.tvProgress
        );

        tvLessonCount = findViewById(
                R.id.tvLessonCount
        );

        courseProgressBar = findViewById(
                R.id.courseProgressBar
        );
    }

    // ==========================================
    // UPDATE COURSE PROGRESS FROM SQLITE
    // ==========================================

    private void updateCourseProgress() {

        if (databaseHelper == null) {
            return;
        }

        int completedLessons =
                databaseHelper.getTotalCompletedLessons();

        // Keep completed lesson count within bounds
        completedLessons = Math.max(
                0,
                Math.min(
                        completedLessons,
                        TOTAL_LESSONS
                )
        );

        // Calculate course progress
        int progressPercent = (int) Math.round(
                completedLessons * 100.0 / TOTAL_LESSONS
        );

        // Update progress percentage
        tvProgress.setText(
                String.format(
                        Locale.US,
                        "%d%%",
                        progressPercent
                )
        );

        // Update completed lessons count
        tvLessonCount.setText(
                String.format(
                        Locale.US,
                        "%d of %d lessons completed",
                        completedLessons,
                        TOTAL_LESSONS
                )
        );

        // Update progress bar
        courseProgressBar.setProgress(
                progressPercent
        );
    }

    // ==========================================
    // CONFIGURE NAVIGATION
    // ==========================================

    private void setupNavigation() {

        // EXPLORE
        findViewById(
                R.id.navExplore
        ).setOnClickListener(
                v -> openExplore()
        );

        // START LEARNING
        findViewById(
                R.id.btnStartLearning
        ).setOnClickListener(
                v -> openExplore()
        );

        // ANDROID LEARNING PATH
        findViewById(
                R.id.cardAndroid
        ).setOnClickListener(
                v -> openExplore()
        );

        // REACT NATIVE LEARNING PATH
        findViewById(
                R.id.cardReact
        ).setOnClickListener(
                v -> openExplore()
        );

        // NOTES
        findViewById(
                R.id.navNotes
        ).setOnClickListener(
                v -> openNotes()
        );

        // PROGRESS
        findViewById(
                R.id.navProgress
        ).setOnClickListener(
                v -> openProgress()
        );

        // QUICK PRACTICE
        // Open a real DialogFragment
        findViewById(
                R.id.cardPractice
        ).setOnClickListener(
                v -> showQuizSelectionDialog()
        );
    }

    // ==========================================
    // OPEN EXPLORE ACTIVITY
    // ==========================================

    private void openExplore() {

        Intent intent = new Intent(
                MainActivity.this,
                ExploreActivity.class
        );

        startActivity(intent);
    }

    // ==========================================
    // OPEN NOTES ACTIVITY
    // ==========================================

    private void openNotes() {

        Intent intent = new Intent(
                MainActivity.this,
                NotesActivity.class
        );

        startActivity(intent);
    }

    // ==========================================
    // OPEN PROGRESS ACTIVITY
    // ==========================================

    private void openProgress() {

        Intent intent = new Intent(
                MainActivity.this,
                ProgressActivity.class
        );

        startActivity(intent);
    }

    // ==========================================
    // QUIZ SELECTION DIALOGFRAGMENT
    // ==========================================

    private void showQuizSelectionDialog() {

        // Prevent duplicate dialog instances
        if (getSupportFragmentManager()
                .findFragmentByTag(QUIZ_DIALOG_TAG) != null) {
            return;
        }

        // Prevent showing a dialog after state is saved
        if (getSupportFragmentManager()
                .isStateSaved()) {
            return;
        }

        // Create DialogFragment for all 14 modules
        QuizSelectionDialogFragment dialog =
                QuizSelectionDialogFragment.newInstance(
                        MODULE_TITLES
                );

        // Display the quiz selection dialog
        dialog.show(
                getSupportFragmentManager(),
                QUIZ_DIALOG_TAG
        );
    }

    // ==========================================
    // REFRESH HOME DASHBOARD
    // ==========================================

    @Override
    protected void onResume() {

        super.onResume();

        // Refresh saved progress when returning Home
        if (databaseHelper != null) {
            updateCourseProgress();
        }
    }

    // ==========================================
    // RELEASE DATABASE RESOURCES
    // ==========================================

    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {

            databaseHelper.close();

            databaseHelper = null;
        }

        super.onDestroy();
    }
}
