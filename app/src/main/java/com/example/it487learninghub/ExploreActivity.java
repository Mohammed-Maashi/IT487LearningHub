package com.example.it487learninghub;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExploreActivity extends AppCompatActivity {

    // Interface components
    private RecyclerView recyclerModules;
    private ModuleAdapter moduleAdapter;
    private EditText editSearch;

    // Category filter buttons
    private Button btnAll;
    private Button btnAndroid;
    private Button btnReact;

    // Curriculum progress components
    private TextView tvCurriculumCount;
    private ProgressBar exploreProgressBar;

    // SQLite database
    private LearningDatabaseHelper databaseHelper;

    // All learning modules
    private final List<ModuleAdapter.Module> allModules =
            new ArrayList<>();

    // Current category filter
    private String selectedCategory = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explore);

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

        // Initialize SQLite
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        // Load the 14 course modules
        loadModules();

        // Configure modules RecyclerView
        setupRecyclerView();

        // Configure search and category filters
        setupSearch();
        setupFilters();

        // Configure bottom navigation
        setupNavigation();

        // Display initial module list
        filterModules();
    }

    // =====================================
    // INITIALIZE VIEWS
    // =====================================

    private void initializeViews() {

        recyclerModules = findViewById(
                R.id.recyclerModules
        );

        editSearch = findViewById(
                R.id.editSearch
        );

        btnAll = findViewById(
                R.id.btnAll
        );

        btnAndroid = findViewById(
                R.id.btnAndroid
        );

        btnReact = findViewById(
                R.id.btnReact
        );

        tvCurriculumCount = findViewById(
                R.id.tvCurriculumCount
        );

        exploreProgressBar = findViewById(
                R.id.exploreProgressBar
        );
    }

    // =====================================
    // LOAD ALL LEARNING MODULES
    // =====================================

    private void loadModules() {

        allModules.clear();

        allModules.add(new ModuleAdapter.Module(
                1, "Course Foundations", 3, "Foundation"
        ));

        allModules.add(new ModuleAdapter.Module(
                2, "Android and Java Fundamentals", 4, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                3, "Android Project Structure", 3, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                4, "Layouts and Material Design", 5, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                5, "Activity Lifecycle", 3, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                6, "Dialogs and RecyclerView", 4, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                7, "Intents and Data Storage", 6, "Android"
        ));

        allModules.add(new ModuleAdapter.Module(
                8, "React and React Native", 3, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                9, "JSX and Rendering", 3, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                10, "Props, State and Context", 4, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                11, "Component Lifecycle", 3, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                12, "React Native Projects", 3, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                13, "Responsive Flexbox", 3, "React Native"
        ));

        allModules.add(new ModuleAdapter.Module(
                14, "Maps and Sensors", 3, "React Native"
        ));
    }

    // =====================================
    // CONFIGURE RECYCLERVIEW
    // =====================================

    private void setupRecyclerView() {

        recyclerModules.setLayoutManager(
                new LinearLayoutManager(this)
        );

        moduleAdapter = new ModuleAdapter(module -> {

            Intent intent = new Intent(
                    ExploreActivity.this,
                    ModuleLessonsActivity.class
            );

            // Pass module information
            intent.putExtra(
                    "module_id",
                    module.number
            );

            intent.putExtra(
                    "module_title",
                    module.title
            );

            intent.putExtra(
                    "module_count",
                    module.lessonCount
            );

            intent.putExtra(
                    "module_category",
                    module.category
            );

            startActivity(intent);
        });

        recyclerModules.setAdapter(moduleAdapter);
    }

    // =====================================
    // LOAD MODULE PROGRESS FROM SQLITE
    // =====================================

    private void refreshModulesProgress() {

        if (databaseHelper == null) {
            return;
        }

        List<ModuleAdapter.Module> updatedModules =
                new ArrayList<>();

        for (ModuleAdapter.Module module : allModules) {

            // Read completed lessons from SQLite
            int completedLessons = databaseHelper
                    .getCompletedCountForModule(
                            module.number
                    );

            // Create updated module with progress
            ModuleAdapter.Module updatedModule =
                    new ModuleAdapter.Module(
                            module.number,
                            module.title,
                            module.lessonCount,
                            module.category,
                            completedLessons
                    );

            updatedModules.add(updatedModule);
        }

        // Replace old module data
        allModules.clear();
        allModules.addAll(updatedModules);

        // Refresh currently selected category and search
        filterModules();
    }

    // =====================================
    // SEARCH MODULES
    // =====================================

    private void setupSearch() {

        editSearch.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after) {
                    }

                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count) {

                        filterModules();
                    }

                    @Override
                    public void afterTextChanged(
                            Editable s) {
                    }
                }
        );
    }

    // =====================================
    // CATEGORY FILTERS
    // =====================================

    private void setupFilters() {

        // ALL
        btnAll.setOnClickListener(v -> {

            selectedCategory = "All";

            updateFilterButtons();
            filterModules();
        });

        // ANDROID
        btnAndroid.setOnClickListener(v -> {

            selectedCategory = "Android";

            updateFilterButtons();
            filterModules();
        });

        // REACT NATIVE
        btnReact.setOnClickListener(v -> {

            selectedCategory = "React Native";

            updateFilterButtons();
            filterModules();
        });

        updateFilterButtons();
    }

    // Filter modules by category and search
    private void filterModules() {

        if (moduleAdapter == null || editSearch == null) {
            return;
        }

        String query = editSearch.getText()
                .toString()
                .trim()
                .toLowerCase(Locale.ROOT);

        List<ModuleAdapter.Module> filtered =
                new ArrayList<>();

        for (ModuleAdapter.Module module : allModules) {

            boolean categoryMatches =
                    selectedCategory.equals("All")
                            || module.category.equals(
                            selectedCategory
                    );

            boolean searchMatches =
                    module.title
                            .toLowerCase(Locale.ROOT)
                            .contains(query);

            if (categoryMatches && searchMatches) {
                filtered.add(module);
            }
        }

        // Adapter displays each module's saved progress
        moduleAdapter.setModules(filtered);
    }

    // =====================================
    // FILTER BUTTON APPEARANCE
    // =====================================

    private void updateFilterButtons() {

        styleButton(
                btnAll,
                selectedCategory.equals("All")
        );

        styleButton(
                btnAndroid,
                selectedCategory.equals("Android")
        );

        styleButton(
                btnReact,
                selectedCategory.equals("React Native")
        );
    }

    private void styleButton(
            Button button,
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
    // OVERALL CURRICULUM PROGRESS
    // =====================================

    private void updateCurriculumProgress() {

        if (databaseHelper == null) {
            return;
        }

        int totalLessons = 0;

        for (ModuleAdapter.Module module : allModules) {

            totalLessons += CourseContentRepository
                    .getLessonsForModule(module.number)
                    .size();
        }

        int completedLessons =
                databaseHelper.getTotalCompletedLessons();

        completedLessons = Math.max(
                0,
                Math.min(completedLessons, totalLessons)
        );

        int progressPercent = totalLessons == 0
                ? 0
                : (int) Math.round(
                completedLessons * 100.0
                        / totalLessons
        );

        tvCurriculumCount.setText(
                String.format(
                        Locale.US,
                        "%d Modules · %d/%d Lessons · %d%%",
                        allModules.size(),
                        completedLessons,
                        totalLessons,
                        progressPercent
                )
        );

        exploreProgressBar.setProgress(
                progressPercent
        );
    }

    // =====================================
    // BOTTOM NAVIGATION
    // =====================================

    private void setupNavigation() {

        // HOME
        findViewById(R.id.navHome).setOnClickListener(
                v -> openScreen(MainActivity.class)
        );

        // EXPLORE
        findViewById(R.id.navExplore).setOnClickListener(
                v -> recyclerModules.smoothScrollToPosition(0)
        );

        // NOTES
        findViewById(R.id.navNotes).setOnClickListener(
                v -> openScreen(NotesActivity.class)
        );

        // PROGRESS
        findViewById(R.id.navProgress).setOnClickListener(
                v -> openScreen(ProgressActivity.class)
        );
    }

    // Navigate to another screen
    private void openScreen(Class<?> targetActivity) {

        Intent intent = new Intent(
                ExploreActivity.this,
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

    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null) {

            // Refresh every module's completion status
            refreshModulesProgress();

            // Refresh overall course progress
            updateCurriculumProgress();
        }
    }

    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
