package com.example.it487learninghub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProgressActivity extends AppCompatActivity {

    // Overall progress components
    private TextView tvOverallProgress;
    private TextView tvOverallLessonCount;
    private TextView tvCompletedLessons;
    private TextView tvRemainingLessons;

    private ProgressBar overallProgressBar;
    private RecyclerView recyclerModuleProgress;
    private ScrollView progressScrollView;

    // Quiz performance components
    private TextView tvSelectedQuizModule;
    private TextView tvQuizLatestScore;
    private TextView tvQuizBestScore;
    private TextView tvQuizAverageScore;
    private TextView tvQuizAttemptsCount;
    private TextView tvQuizNoAttempts;

    // Module progress adapter
    private ModuleProgressAdapter moduleProgressAdapter;

    // SQLite database
    private LearningDatabaseHelper databaseHelper;

    // Default selected module
    private int selectedQuizModuleId = 5;

    // All course modules
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_progress);

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

        // Restore selected module after rotation
        if (savedInstanceState != null) {

            selectedQuizModuleId =
                    savedInstanceState.getInt(
                            "selected_quiz_module",
                            5
                    );
        }

        if (selectedQuizModuleId < 1
                || selectedQuizModuleId > MODULE_TITLES.length) {

            selectedQuizModuleId = 5;
        }

        // Initialize interface components
        initializeViews();

        // Initialize SQLite database
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        // Configure RecyclerView
        setupRecyclerView();

        // Configure module selection
        setupQuizModuleSelector();

        // Configure bottom navigation
        setupNavigation();

        // Read progress and quiz statistics
        refreshAllStatistics();
    }

    // =====================================
    // INITIALIZE VIEWS
    // =====================================

    private void initializeViews() {

        tvOverallProgress = findViewById(
                R.id.tvOverallProgress
        );

        tvOverallLessonCount = findViewById(
                R.id.tvOverallLessonCount
        );

        tvCompletedLessons = findViewById(
                R.id.tvCompletedLessons
        );

        tvRemainingLessons = findViewById(
                R.id.tvRemainingLessons
        );

        overallProgressBar = findViewById(
                R.id.overallProgressBar
        );

        recyclerModuleProgress = findViewById(
                R.id.recyclerModuleProgress
        );

        progressScrollView = findViewById(
                R.id.progressScrollView
        );

        // Quiz statistics
        tvSelectedQuizModule = findViewById(
                R.id.tvSelectedQuizModule
        );

        tvQuizLatestScore = findViewById(
                R.id.tvQuizLatestScore
        );

        tvQuizBestScore = findViewById(
                R.id.tvQuizBestScore
        );

        tvQuizAverageScore = findViewById(
                R.id.tvQuizAverageScore
        );

        tvQuizAttemptsCount = findViewById(
                R.id.tvQuizAttemptsCount
        );

        tvQuizNoAttempts = findViewById(
                R.id.tvQuizNoAttempts
        );
    }

    // =====================================
    // MODULE PROGRESS RECYCLERVIEW
    // =====================================

    private void setupRecyclerView() {

        recyclerModuleProgress.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // The parent ScrollView handles scrolling
        recyclerModuleProgress.setNestedScrollingEnabled(false);

        moduleProgressAdapter = new ModuleProgressAdapter(
                module -> {

                    Intent intent = new Intent(
                            ProgressActivity.this,
                            ModuleLessonsActivity.class
                    );

                    intent.putExtra(
                            "module_id",
                            module.moduleId
                    );

                    intent.putExtra(
                            "module_title",
                            module.title
                    );

                    intent.putExtra(
                            "module_count",
                            module.totalLessons
                    );

                    intent.putExtra(
                            "module_category",
                            getModuleCategory(module.moduleId)
                    );

                    startActivity(intent);
                }
        );

        recyclerModuleProgress.setAdapter(
                moduleProgressAdapter
        );
    }

    // Determine module category
    private String getModuleCategory(int moduleId) {

        if (moduleId == 1) {
            return "Foundation";
        }

        if (moduleId <= 7) {
            return "Android";
        }

        return "React Native";
    }

    // =====================================
    // REFRESH ALL STATISTICS
    // =====================================

    private void refreshAllStatistics() {

        refreshProgress();
        refreshQuizStatistics();
    }

    // =====================================
    // LESSON PROGRESS FROM SQLITE
    // =====================================

    private void refreshProgress() {

        if (databaseHelper == null
                || moduleProgressAdapter == null) {

            return;
        }

        List<ModuleProgressAdapter.ModuleProgress>
                moduleProgressList = new ArrayList<>();

        int totalLessons = 0;
        int completedLessons = 0;

        // Read progress for all 14 modules
        for (int i = 0; i < MODULE_TITLES.length; i++) {

            int moduleId = i + 1;

            int moduleTotal = CourseContentRepository
                    .getLessonsForModule(moduleId)
                    .size();

            int moduleCompleted = databaseHelper
                    .getCompletedCountForModule(moduleId);

            moduleCompleted = Math.max(
                    0,
                    Math.min(moduleCompleted, moduleTotal)
            );

            totalLessons += moduleTotal;
            completedLessons += moduleCompleted;

            ModuleProgressAdapter.ModuleProgress progress =
                    new ModuleProgressAdapter.ModuleProgress(
                            moduleId,
                            MODULE_TITLES[i],
                            moduleCompleted,
                            moduleTotal
                    );

            moduleProgressList.add(progress);
        }

        // Update progress cards
        moduleProgressAdapter.setModules(
                moduleProgressList
        );

        // Calculate overall completion percentage
        int progressPercent = totalLessons == 0
                ? 0
                : (int) Math.round(
                completedLessons * 100.0 / totalLessons
        );

        // Display overall percentage
        tvOverallProgress.setText(
                String.format(
                        Locale.US,
                        "%d%%",
                        progressPercent
                )
        );

        // Display completed lessons
        tvOverallLessonCount.setText(
                String.format(
                        Locale.US,
                        "%d of %d lessons completed",
                        completedLessons,
                        totalLessons
                )
        );

        // Update progress bar
        overallProgressBar.setProgress(
                progressPercent
        );

        // Completed lessons statistic
        tvCompletedLessons.setText(
                String.valueOf(completedLessons)
        );

        // Remaining lessons statistic
        int remainingLessons =
                totalLessons - completedLessons;

        tvRemainingLessons.setText(
                String.valueOf(remainingLessons)
        );
    }

    // =====================================
    // QUIZ MODULE SELECTOR
    // =====================================

    private void setupQuizModuleSelector() {

        findViewById(
                R.id.cardQuizModuleSelector
        ).setOnClickListener(v -> {

            showQuizModuleDialog();
        });

        updateSelectedModuleTitle();
    }

    // Open selection dialog
    private void showQuizModuleDialog() {

        String[] moduleOptions =
                new String[MODULE_TITLES.length];

        for (int i = 0; i < MODULE_TITLES.length; i++) {

            moduleOptions[i] = String.format(
                    Locale.US,
                    "Module %02d - %s",
                    i + 1,
                    MODULE_TITLES[i]
            );
        }

        new AlertDialog.Builder(this)
                .setTitle("Select Quiz Module")
                .setSingleChoiceItems(
                        moduleOptions,
                        selectedQuizModuleId - 1,
                        (dialog, which) -> {

                            selectedQuizModuleId = which + 1;

                            // Update selected module
                            updateSelectedModuleTitle();

                            // Read selected module statistics
                            refreshQuizStatistics();

                            dialog.dismiss();
                        }
                )
                .setNegativeButton(
                        "Cancel",
                        null
                )
                .show();
    }

    // Display selected module name
    private void updateSelectedModuleTitle() {

        int index = selectedQuizModuleId - 1;

        if (index >= 0
                && index < MODULE_TITLES.length) {

            tvSelectedQuizModule.setText(
                    MODULE_TITLES[index]
            );
        }
    }

    // =====================================
    // QUIZ STATISTICS FROM SQLITE
    // =====================================

    private void refreshQuizStatistics() {

        if (databaseHelper == null) {
            return;
        }

        int moduleId = selectedQuizModuleId;

        // Read saved attempts count
        int attemptsCount = databaseHelper
                .getQuizAttemptCountForModule(moduleId);

        // Update total attempts
        tvQuizAttemptsCount.setText(
                String.valueOf(attemptsCount)
        );

        // Show empty state if no attempts exist
        if (attemptsCount == 0) {

            tvQuizLatestScore.setText("—");
            tvQuizBestScore.setText("—");
            tvQuizAverageScore.setText("—");

            tvQuizNoAttempts.setText(
                    "No quiz attempts yet for this module."
            );

            tvQuizNoAttempts.setVisibility(
                    View.VISIBLE
            );

            return;
        }

        // Read latest score
        int latestScore = databaseHelper
                .getLatestQuizScoreForModule(moduleId);

        // Read best score
        int bestScore = databaseHelper
                .getBestQuizScoreForModule(moduleId);

        // Read average score
        double averageScore = databaseHelper
                .getAverageQuizScoreForModule(moduleId);

        // Update latest score
        tvQuizLatestScore.setText(
                formatScore(latestScore)
        );

        // Update best score
        tvQuizBestScore.setText(
                formatScore(bestScore)
        );

        // Update average score
        if (averageScore >= 0) {

            tvQuizAverageScore.setText(
                    String.format(
                            Locale.US,
                            "%.1f%%",
                            averageScore
                    )
            );

        } else {

            tvQuizAverageScore.setText("—");
        }

        // Hide empty state
        tvQuizNoAttempts.setVisibility(
                View.GONE
        );
    }

    // Format integer quiz scores
    private String formatScore(int score) {

        if (score < 0) {
            return "—";
        }

        return String.format(
                Locale.US,
                "%d%%",
                score
        );
    }

    // =====================================
    // BOTTOM NAVIGATION
    // =====================================

    private void setupNavigation() {

        // HOME
        findViewById(
                R.id.navHome
        ).setOnClickListener(
                v -> openScreen(MainActivity.class)
        );

        // EXPLORE
        findViewById(
                R.id.navExplore
        ).setOnClickListener(
                v -> openScreen(ExploreActivity.class)
        );

        // NOTES
        findViewById(
                R.id.navNotes
        ).setOnClickListener(
                v -> openScreen(NotesActivity.class)
        );

        // PROGRESS: Scroll to the top
        findViewById(
                R.id.navProgress
        ).setOnClickListener(
                v -> progressScrollView.smoothScrollTo(0, 0)
        );
    }

    // Navigate to another screen
    private void openScreen(Class<?> targetActivity) {

        Intent intent = new Intent(
                ProgressActivity.this,
                targetActivity
        );

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP
        );

        startActivity(intent);
        finish();
    }

    // =====================================
    // ACTIVITY LIFECYCLE
    // =====================================

    // Preserve the selected quiz module
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt(
                "selected_quiz_module",
                selectedQuizModuleId
        );
    }

    // Refresh statistics on return
    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null
                && moduleProgressAdapter != null) {

            refreshAllStatistics();
        }
    }

    // Release SQLite resources
    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
