package com.example.it487learninghub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestionRepository {

    public static final int QUESTIONS_PER_QUIZ = 10;

    // Get 10 random questions for one module
    public static List<QuizQuestion> getRandomQuestions(
            int moduleId) {

        return getRandomQuestions(
                moduleId,
                QUESTIONS_PER_QUIZ
        );
    }

    // Get a specified number of random questions
    public static List<QuizQuestion> getRandomQuestions(
            int moduleId,
            int requestedCount) {

        List<QuizQuestion> questionBank =
                getQuestionBankForModule(moduleId);

        // Do not start an incomplete quiz
        if (requestedCount <= 0
                || questionBank.size() < requestedCount) {

            return new ArrayList<>();
        }

        // Shuffle the questions
        Collections.shuffle(questionBank);

        List<QuizQuestion> selectedQuestions =
                new ArrayList<>();

        for (int i = 0; i < requestedCount; i++) {

            QuizQuestion originalQuestion =
                    questionBank.get(i);

            // Also shuffle the answer choices
            selectedQuestions.add(
                    shuffleAnswerOptions(originalQuestion)
            );
        }

        return selectedQuestions;
    }

    // Count available questions for a module
    public static int getQuestionCount(int moduleId) {

        return getQuestionBankForModule(moduleId).size();
    }

    // Check whether a module has enough questions
    public static boolean isModuleReady(int moduleId) {

        return getQuestionCount(moduleId)
                >= QUESTIONS_PER_QUIZ;
    }

    // Shuffle choices without changing the correct answer
    private static QuizQuestion shuffleAnswerOptions(
            QuizQuestion question) {

        String[] originalOptions =
                question.getOptions();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < originalOptions.length; i++) {
            indexes.add(i);
        }

        Collections.shuffle(indexes);

        String[] shuffledOptions = new String[4];

        int newCorrectIndex = -1;

        for (int i = 0; i < 4; i++) {

            int originalIndex = indexes.get(i);

            shuffledOptions[i] =
                    originalOptions[originalIndex];

            if (originalIndex
                    == question.getCorrectAnswerIndex()) {

                newCorrectIndex = i;
            }
        }

        return new QuizQuestion(
                question.getModuleId(),
                question.getQuestionText(),
                shuffledOptions,
                newCorrectIndex,
                question.getExplanation()
        );
    }

    // Build question bank for selected module
    private static List<QuizQuestion> getQuestionBankForModule(
            int moduleId) {

        List<QuizQuestion> questions =
                new ArrayList<>();

        switch (moduleId) {

            case 1:
                addFoundationsQuestions(questions);
                break;

            case 2:
                addAndroidFundamentalsQuestions(questions);
                break;

            case 3:
                addProjectStructureQuestions(questions);
                break;

            case 4:
                addLayoutsQuestions(questions);
                break;

            case 5:
                addLifecycleQuestions(questions);
                break;

            case 6:
                addDialogsAndRecyclerViewQuestions(questions);
                break;

            case 7:
                addIntentsAndStorageQuestions(questions);
                break;

            case 8:
                addReactAndReactNativeQuestions(questions);
                break;

            case 9:
                addJsxAndRenderingQuestions(questions);
                break;

            case 10:
                addPropsStateContextQuestions(questions);
                break;

            case 11:
                addComponentLifecycleQuestions(questions);
                break;

            case 12:
                addReactNativeProjectsQuestions(questions);
                break;

            case 13:
                addResponsiveFlexboxQuestions(questions);
                break;

            case 14:
                addMapsAndSensorsQuestions(questions);
                break;


            default:
                // Unknown module ID: return an empty bank.
                break;
        }

        return questions;
    }

    // Helper method for creating questions
    private static void addQuestion(
            List<QuizQuestion> questions,
            int moduleId,
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            int correctIndex,
            String explanation) {

        questions.add(
                new QuizQuestion(
                        moduleId,
                        questionText,
                        new String[]{
                                optionA,
                                optionB,
                                optionC,
                                optionD
                        },
                        correctIndex,
                        explanation
                )
        );
    }

    // =====================================
    // MODULE 04
    // LAYOUTS AND MATERIAL DESIGN
    // =====================================

    private static void addLayoutsQuestions(
            List<QuizQuestion> questions) {

        int moduleId = 4;

        addQuestion(
                questions, moduleId,
                "Which layout arranges child views in a single row or column?",
                "FrameLayout",
                "LinearLayout",
                "ConstraintLayout",
                "GridLayout",
                1,
                "LinearLayout arranges its child views in one horizontal or vertical direction."
        );

        addQuestion(
                questions, moduleId,
                "Which attribute controls the direction of a LinearLayout?",
                "android:gravity",
                "android:padding",
                "android:orientation",
                "android:visibility",
                2,
                "The android:orientation attribute sets a LinearLayout to horizontal or vertical."
        );

        addQuestion(
                questions, moduleId,
                "Which layout positions views using constraints?",
                "ConstraintLayout",
                "LinearLayout",
                "FrameLayout",
                "TableLayout",
                0,
                "ConstraintLayout uses relationships between views and their parent to determine positions."
        );

        addQuestion(
                questions, moduleId,
                "What does match_parent mean for a view's width?",
                "The width is always 100dp",
                "The width matches the available parent size",
                "The width depends only on the text",
                "The view becomes invisible",
                1,
                "match_parent requests the available size provided by the parent layout."
        );

        addQuestion(
                questions, moduleId,
                "What does wrap_content mean?",
                "Fill the entire screen",
                "Use a fixed width",
                "Use the size needed for the content",
                "Remove all margins",
                2,
                "wrap_content allows a view to size itself according to its content and layout constraints."
        );

        addQuestion(
                questions, moduleId,
                "Which unit is commonly recommended for Android layout dimensions?",
                "px",
                "sp",
                "dp",
                "mm",
                2,
                "Density-independent pixels (dp) help maintain consistent physical sizing across different screen densities."
        );

        addQuestion(
                questions, moduleId,
                "Which unit should normally be used for text sizes?",
                "sp",
                "dp",
                "px",
                "in",
                0,
                "Scale-independent pixels (sp) account for font scaling preferences and screen density."
        );

        addQuestion(
                questions, moduleId,
                "What is the purpose of padding?",
                "To move a view outside its parent",
                "To add space inside a view",
                "To change the activity name",
                "To hide a layout",
                1,
                "Padding adds space between a view's content and its boundaries."
        );

        addQuestion(
                questions, moduleId,
                "What does a layout margin control?",
                "Space outside a view",
                "Text capitalization",
                "Database storage",
                "Screen rotation",
                0,
                "Margins define space outside a view, subject to the rules of its parent layout."
        );

        addQuestion(
                questions, moduleId,
                "Which XML attribute sets the text displayed by a TextView?",
                "android:hint",
                "android:text",
                "android:id",
                "android:layout_width",
                1,
                "android:text specifies the text content shown by a TextView."
        );

        addQuestion(
                questions, moduleId,
                "Which attribute controls how content is aligned inside a TextView?",
                "android:gravity",
                "android:layout_margin",
                "android:orientation",
                "android:elevation",
                0,
                "android:gravity controls the alignment of content within a view."
        );

        addQuestion(
                questions, moduleId,
                "What is the purpose of Material Design in Android?",
                "Replacing the Java language",
                "Creating consistent and usable interfaces",
                "Removing XML resources",
                "Managing SQLite tables",
                1,
                "Material Design provides design guidelines and components for consistent and usable interfaces."
        );
    }

    // =====================================
    // MODULE 05
    // ACTIVITY LIFECYCLE
    // =====================================

    private static void addLifecycleQuestions(
            List<QuizQuestion> questions) {

        int moduleId = 5;

        addQuestion(
                questions, moduleId,
                "Which lifecycle method is called when an Activity is first created?",
                "onPause()",
                "onCreate()",
                "onStop()",
                "onDestroy()",
                1,
                "onCreate() is used for the initial creation and setup of an Activity."
        );

        addQuestion(
                questions, moduleId,
                "Which method is called when an Activity becomes interactive?",
                "onStop()",
                "onPause()",
                "onResume()",
                "onDestroy()",
                2,
                "onResume() is called when an Activity enters the resumed state and can interact with the user."
        );

        addQuestion(
                questions, moduleId,
                "Which callback occurs when an Activity becomes visible?",
                "onStart()",
                "onDestroy()",
                "onPause()",
                "onRestart()",
                0,
                "onStart() is called as an Activity becomes visible to the user."
        );

        addQuestion(
                questions, moduleId,
                "Which callback indicates that an Activity is losing focus?",
                "onCreate()",
                "onPause()",
                "onStart()",
                "onRestart()",
                1,
                "onPause() is called when an Activity is leaving the resumed state."
        );

        addQuestion(
                questions, moduleId,
                "Which callback occurs when an Activity is no longer visible?",
                "onResume()",
                "onCreate()",
                "onStop()",
                "onStart()",
                2,
                "onStop() is called when an Activity is no longer visible to the user."
        );

        addQuestion(
                questions, moduleId,
                "Which callback is called when a stopped Activity is about to start again?",
                "onDestroy()",
                "onRestart()",
                "onPause()",
                "onCreate()",
                1,
                "onRestart() is called when a stopped Activity is restarting."
        );

        addQuestion(
                questions, moduleId,
                "Which callback may be called before an Activity is destroyed?",
                "onDestroy()",
                "onResume()",
                "onStart()",
                "onRestart()",
                0,
                "onDestroy() can be called during Activity destruction, but it is not guaranteed when the system terminates the app process."
        );

        addQuestion(
                questions, moduleId,
                "What is the normal callback order when an Activity launches?",
                "onResume(), onStart(), onCreate()",
                "onCreate(), onStart(), onResume()",
                "onPause(), onCreate(), onStop()",
                "onStop(), onStart(), onResume()",
                1,
                "An Activity normally moves through onCreate(), onStart(), and onResume() when it first launches."
        );

        addQuestion(
                questions, moduleId,
                "Which callback normally follows onPause() when an Activity becomes completely hidden?",
                "onStop()",
                "onCreate()",
                "onRestart()",
                "onResume()",
                0,
                "An Activity typically enters the stopped state after onPause() when it is no longer visible."
        );

        addQuestion(
                questions, moduleId,
                "Which method can save temporary UI state before an Activity is recreated?",
                "onDestroy()",
                "onSaveInstanceState()",
                "onStart()",
                "finish()",
                1,
                "onSaveInstanceState() can save temporary state into a Bundle for later restoration."
        );

        addQuestion(
                questions, moduleId,
                "Which callback can restore saved state after onStart()?",
                "onStop()",
                "onPause()",
                "onRestoreInstanceState()",
                "onRestart()",
                2,
                "onRestoreInstanceState() is called after onStart() when saved instance state is available."
        );

        addQuestion(
                questions, moduleId,
                "What commonly happens to an Activity during a screen rotation?",
                "It always stops the application permanently",
                "It is typically destroyed and recreated",
                "It skips all lifecycle callbacks",
                "It automatically deletes SQLite data",
                1,
                "A configuration change such as rotation typically causes Activity recreation unless the app handles it differently."
        );

        addQuestion(
                questions, moduleId,
                "Which method is commonly used to initialize the Activity layout?",
                "onCreate()",
                "onStop()",
                "onPause()",
                "onRestart()",
                0,
                "The Activity layout is commonly initialized in onCreate() using setContentView()."
        );

        addQuestion(
                questions, moduleId,
                "What is the normal order when a stopped Activity returns to the foreground?",
                "onStart(), onDestroy(), onPause()",
                "onRestart(), onStart(), onResume()",
                "onCreate(), onStop(), onPause()",
                "onPause(), onStop(), onRestart()",
                1,
                "A stopped Activity normally passes through onRestart(), onStart(), and onResume() when returning."
        );
    }


    // MODULE 01 - Course Foundations
    private static void addFoundationsQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 1;

        addQuestion(questions, moduleId,
                "What is a mobile application?",
                "A program designed to run on mobile devices",
                "A desktop operating system",
                "A database server only",
                "A computer hardware component",
                0,
                "Mobile applications are software designed for smartphones, tablets, or other mobile devices.");

        addQuestion(questions, moduleId,
                "Which consideration is especially important when designing a mobile app?",
                "Assuming unlimited battery power",
                "Ignoring touch interaction",
                "Supporting different screen sizes",
                "Using mouse-only controls",
                2,
                "Mobile interfaces should adapt to device sizes and touch-based interaction.");

        addQuestion(questions, moduleId,
                "What is a native Android application typically built to run on?",
                "Only web browsers",
                "The Android platform",
                "Only macOS",
                "A remote spreadsheet",
                1,
                "A native Android app targets Android devices and uses Android platform capabilities.");

        addQuestion(questions, moduleId,
                "What is Android Studio?",
                "A mobile operating system",
                "An IDE used for Android development",
                "A graphics card",
                "A cloud database language",
                1,
                "Android Studio is an integrated development environment for building and testing Android apps.");

        addQuestion(questions, moduleId,
                "Why do developers use an Android emulator?",
                "To replace all source code",
                "To test an app on a simulated Android device",
                "To commit Git changes",
                "To convert Java directly to HTML",
                1,
                "An emulator simulates an Android device for development and testing.");

        addQuestion(questions, moduleId,
                "What does SDK stand for?",
                "Software Development Kit",
                "System Design Kernel",
                "Secure Data Key",
                "Source Deployment Keyboard",
                0,
                "An SDK provides tools, libraries, and other resources to develop software for a platform.");

        addQuestion(questions, moduleId,
                "What is version control primarily used for?",
                "Increasing screen brightness",
                "Tracking and managing changes to files",
                "Removing the need for backups",
                "Replacing application testing",
                1,
                "Version control records file changes and supports collaboration and recovery.");

        addQuestion(questions, moduleId,
                "Which command initializes a Git repository in a folder?",
                "git push",
                "git init",
                "git merge",
                "git clone --delete",
                1,
                "git init creates a new local Git repository in the current folder.");

        addQuestion(questions, moduleId,
                "Which command displays the status of tracked and untracked Git files?",
                "git status",
                "git rename",
                "git login",
                "git build",
                0,
                "git status reports the current working tree and staging area state.");

        addQuestion(questions, moduleId,
                "What does git commit do?",
                "Uploads an app to Google Play",
                "Records staged changes in repository history",
                "Starts the Android emulator",
                "Deletes all branches",
                1,
                "git commit creates a new local history snapshot of staged changes.");

        addQuestion(questions, moduleId,
                "What is the purpose of a Git branch?",
                "To test an app without an emulator",
                "To create a separate line of development",
                "To define an Android layout",
                "To store SQL database rows",
                1,
                "Branches allow parallel development without immediately changing another branch.");

        addQuestion(questions, moduleId,
                "Which Git command normally uploads local commits to a remote repository?",
                "git pull",
                "git diff",
                "git push",
                "git status",
                2,
                "git push transfers local commits to a remote branch.");

    }

    // MODULE 02 - Android and Java Fundamentals
    private static void addAndroidFundamentalsQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 2;

        addQuestion(questions, moduleId,
                "Android is primarily an operating system for which devices?",
                "Mobile and other supported smart devices",
                "Only desktop printers",
                "Only mainframe computers",
                "Only web servers",
                0,
                "Android is an operating system used on phones, tablets, and other supported device categories.");

        addQuestion(questions, moduleId,
                "In Android development, what does an Activity commonly represent?",
                "A single focused user interface screen",
                "A CSS stylesheet",
                "An SQL trigger",
                "A Git branch",
                0,
                "An Activity is an Android component that provides a window for user interaction.");

        addQuestion(questions, moduleId,
                "Which Java keyword allows a class to inherit from another class?",
                "import",
                "extends",
                "implementsOnly",
                "package",
                1,
                "The extends keyword declares that a Java class inherits from a superclass.");

        addQuestion(questions, moduleId,
                "Which Java method is a common Android Activity entry point for initial setup?",
                "onCreate()",
                "onStop()",
                "equals()",
                "toString()",
                0,
                "The onCreate() callback is typically used to initialize an Activity.");

        addQuestion(questions, moduleId,
                "What is the purpose of a Java class?",
                "Grouping related data and behavior",
                "Defining only screen pixels",
                "Replacing AndroidManifest.xml",
                "Downloading Gradle",
                0,
                "A class defines a type with fields, methods, and behavior.");

        addQuestion(questions, moduleId,
                "Which language commonly describes Android view layouts in resource files?",
                "SQL",
                "XML",
                "Bash",
                "Markdown",
                1,
                "Android view hierarchies are commonly declared in XML layout resources.");

        addQuestion(questions, moduleId,
                "Where are traditional Android layout XML files commonly stored?",
                "res/layout",
                "res/mipmap",
                "assets/sql",
                "gradle/wrapper",
                0,
                "Layout resources are stored in the res/layout directory.");

        addQuestion(questions, moduleId,
                "What does AndroidManifest.xml declare?",
                "App components and key configuration",
                "Only Java comments",
                "Only image dimensions",
                "Git commit history",
                0,
                "The manifest declares Android application components, permissions, and other configuration.");

        addQuestion(questions, moduleId,
                "What is the Android SDK used for?",
                "Compiling and developing Android apps",
                "Replacing the Java language",
                "Designing Git branches",
                "Hosting email accounts",
                0,
                "Android SDK tools and APIs are used to build, run, and test Android apps.");

        addQuestion(questions, moduleId,
                "What is Gradle primarily responsible for in an Android project?",
                "Managing builds and dependencies",
                "Drawing all app icons by hand",
                "Tracking GPS location by itself",
                "Sending text messages",
                0,
                "Gradle automates builds, configuration, and dependency management.");

        addQuestion(questions, moduleId,
                "Which window helps developers inspect runtime log messages?",
                "Logcat",
                "File Explorer only",
                "GitHub Issues only",
                "Color Picker",
                0,
                "Logcat displays logging output from Android apps and the system.");

        addQuestion(questions, moduleId,
                "What is the role of an emulator during Android development?",
                "Testing app behavior without a physical phone",
                "Automatically writing every feature",
                "Replacing Android permissions",
                "Storing source code permanently",
                0,
                "An emulator provides a virtual Android device for testing.");

    }

    // MODULE 03 - Android Project Structure
    private static void addProjectStructureQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 3;

        addQuestion(questions, moduleId,
                "Which file declares Android app components such as activities?",
                "AndroidManifest.xml",
                "strings.xml",
                "README.md",
                ".gitignore",
                0,
                "AndroidManifest.xml identifies app components and certain platform requirements.");

        addQuestion(questions, moduleId,
                "Which folder normally contains Android Java source code?",
                "app/src/main/java",
                "app/src/main/res/drawable",
                "app/build/outputs",
                "gradle/wrapper",
                0,
                "Application Java classes are commonly located under app/src/main/java.");

        addQuestion(questions, moduleId,
                "Where should an Android layout resource normally be saved?",
                "res/layout",
                "res/values",
                "res/mipmap",
                "res/raw/sql",
                0,
                "XML screen layouts normally belong in the res/layout resource directory.");

        addQuestion(questions, moduleId,
                "Which resource file is commonly used for user-visible strings?",
                "strings.xml",
                "AndroidManifest.xml",
                "proguard-rules.pro",
                "gradle.properties",
                0,
                "Strings are commonly placed in res/values/strings.xml to support reuse and localization.");

        addQuestion(questions, moduleId,
                "What is the typical role of res/drawable?",
                "Storing images and drawable resources",
                "Saving SQL queries only",
                "Listing Git commits",
                "Compiling Java bytecode",
                0,
                "The drawable resource directory contains graphics and drawable definitions.");

        addQuestion(questions, moduleId,
                "What does the mipmap resource directory commonly contain?",
                "Launcher icons",
                "App databases",
                "Git branches",
                "JVM source files",
                0,
                "Launcher icons are often stored in mipmap resource folders.");

        addQuestion(questions, moduleId,
                "Which Gradle file typically configures an Android app module?",
                "app/build.gradle or app/build.gradle.kts",
                "res/layout/main.xml",
                "README.md",
                "AndroidManifest.xml",
                0,
                "The app module build script defines its Android settings and dependencies.");

        addQuestion(questions, moduleId,
                "What is the role of the generated R class?",
                "Providing IDs for compiled resources",
                "Storing app passwords",
                "Managing database migrations",
                "Replacing all view IDs",
                0,
                "The R class exposes identifiers for compiled resources such as layouts and strings.");

        addQuestion(questions, moduleId,
                "Which XML attribute assigns an ID to a view?",
                "android:id",
                "android:textSize",
                "android:padding",
                "android:gravity",
                0,
                "android:id declares an identifier that application code can use to refer to a view.");

        addQuestion(questions, moduleId,
                "What is the purpose of the app/src/main directory?",
                "Holding main application source, manifest, and resources",
                "Storing emulator snapshots only",
                "Containing external Git repositories",
                "Saving release reviews",
                0,
                "app/src/main contains the main source set for an Android app.");

        addQuestion(questions, moduleId,
                "Where are external libraries commonly declared for the Android app module?",
                "In the dependencies section of the module build script",
                "In each TextView label",
                "In the app launcher icon",
                "In the Git commit title",
                0,
                "Gradle module dependencies are listed in the app module build script.");

        addQuestion(questions, moduleId,
                "What does an application package or namespace help organize?",
                "Application classes and generated resources",
                "Only phone brightness settings",
                "Only emulator RAM",
                "Only GitHub usernames",
                0,
                "Packages and namespaces help organize code and resource references.");

    }

    // MODULE 06 - Dialogs and RecyclerView
    private static void addDialogsAndRecyclerViewQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 6;

        addQuestion(questions, moduleId,
                "Which Android class can build a simple confirmation dialog?",
                "AlertDialog.Builder",
                "SQLiteDatabase",
                "RecyclerView.Adapter",
                "SensorManager",
                0,
                "AlertDialog.Builder can configure dialog content and buttons.");

        addQuestion(questions, moduleId,
                "What is a DialogFragment useful for?",
                "Managing a dialog as a Fragment",
                "Storing CSV files",
                "Replacing the Android manifest",
                "Drawing map markers",
                0,
                "DialogFragment integrates dialog behavior with Fragment lifecycle management.");

        addQuestion(questions, moduleId,
                "Which Android UI element displays a short, transient text message?",
                "Toast",
                "RecyclerView",
                "ContentProvider",
                "IntentFilter",
                0,
                "A Toast displays brief feedback without requiring navigation.");

        addQuestion(questions, moduleId,
                "Which component presents a scrollable list of many items efficiently?",
                "RecyclerView",
                "EditText",
                "AlertDialog",
                "ProgressBar",
                0,
                "RecyclerView efficiently displays large or changing collections of items.");

        addQuestion(questions, moduleId,
                "What is the main responsibility of a RecyclerView.Adapter?",
                "Creating and binding item views to data",
                "Changing the device operating system",
                "Requesting GPS permissions",
                "Initializing SQLite tables",
                0,
                "An Adapter creates ViewHolders and binds data to views.");

        addQuestion(questions, moduleId,
                "What does a RecyclerView.ViewHolder usually store?",
                "References to views in an item layout",
                "Only the app theme colors",
                "A list of system services",
                "Every Git commit",
                0,
                "ViewHolders cache references to item views for efficient reuse.");

        addQuestion(questions, moduleId,
                "Which component determines how RecyclerView items are laid out?",
                "LayoutManager",
                "Toast",
                "AndroidManifest",
                "SharedPreferences",
                0,
                "A RecyclerView LayoutManager positions and measures its item views.");

        addQuestion(questions, moduleId,
                "Which layout manager displays items in a vertical or horizontal list?",
                "LinearLayoutManager",
                "SQLiteOpenHelper",
                "SensorManager",
                "ActivityManager",
                0,
                "LinearLayoutManager lays out RecyclerView items in one direction.");

        addQuestion(questions, moduleId,
                "Why does RecyclerView recycle item views?",
                "To reduce repeated view creation and improve performance",
                "To delete items from SQLite",
                "To disable scrolling",
                "To change screen orientation",
                0,
                "Recycling reuses item views as they move offscreen instead of recreating them each time.");

        addQuestion(questions, moduleId,
                "Which Adapter callback binds data to an existing ViewHolder?",
                "onBindViewHolder()",
                "onCreate()",
                "onStop()",
                "onSaveInstanceState()",
                0,
                "onBindViewHolder() updates a ViewHolder with data for a position.");

        addQuestion(questions, moduleId,
                "Which Adapter method returns the number of displayed items?",
                "getItemCount()",
                "getViewTypeCountOnly()",
                "getDatabaseVersion()",
                "getLayoutGravity()",
                0,
                "getItemCount() reports the Adapter data set size.");

        addQuestion(questions, moduleId,
                "What is a suitable response when a user taps a list row?",
                "Handle the click in a listener and open the relevant detail",
                "Always delete all rows",
                "Ignore the click unconditionally",
                "Restart the emulator",
                0,
                "A click listener can open details or perform an action for the selected item.");

    }

    // MODULE 07 - Intents and Data Storage
    private static void addIntentsAndStorageQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 7;

        addQuestion(questions, moduleId,
                "What is an explicit Intent usually used for?",
                "Starting a known app component",
                "Sending a request to any matching app only",
                "Declaring an XML color",
                "Creating a SQL table",
                0,
                "An explicit Intent names the component to be started.");

        addQuestion(questions, moduleId,
                "What does an implicit Intent describe?",
                "An action that matching components may handle",
                "A Java class constructor",
                "A SQLite primary key",
                "A Gradle plugin version",
                0,
                "An implicit Intent specifies an action or data for compatible apps to handle.");

        addQuestion(questions, moduleId,
                "Which Intent action is commonly used to view a web page?",
                "Intent.ACTION_VIEW",
                "Intent.ACTION_DELETE_ALL",
                "Intent.ACTION_COMMIT",
                "Intent.ACTION_LAYOUT",
                0,
                "ACTION_VIEW can request that a suitable app display a URI.");

        addQuestion(questions, moduleId,
                "Which Intent method attaches an extra value?",
                "putExtra()",
                "getResources()",
                "setContentView()",
                "execSQL()",
                0,
                "putExtra() associates a key with an additional value in an Intent.");

        addQuestion(questions, moduleId,
                "Which method reads a String extra from an Intent?",
                "getStringExtra()",
                "putString()",
                "readStringFromSql()",
                "getLayoutInflater()",
                0,
                "getStringExtra() retrieves a String stored under an Intent extra key.");

        addQuestion(questions, moduleId,
                "What is SharedPreferences primarily useful for?",
                "Saving small key-value settings",
                "Rendering a RecyclerView",
                "Downloading Gradle packages",
                "Displaying an alert dialog",
                0,
                "SharedPreferences stores small amounts of persistent key-value data.");

        addQuestion(questions, moduleId,
                "Which SharedPreferences.Editor method applies changes asynchronously to disk?",
                "apply()",
                "rollback()",
                "finish()",
                "inflate()",
                0,
                "apply() updates in-memory values immediately and schedules an asynchronous disk write.");

        addQuestion(questions, moduleId,
                "Which Android helper class manages SQLite database creation and upgrades?",
                "SQLiteOpenHelper",
                "ActivityManager",
                "AlertDialog.Builder",
                "RecyclerView.ViewHolder",
                0,
                "SQLiteOpenHelper assists with opening, creating, and upgrading local SQLite databases.");

        addQuestion(questions, moduleId,
                "What is ContentValues commonly used for in SQLite operations?",
                "Holding column values for insert or update",
                "Specifying a UI layout direction",
                "Representing an Android Intent",
                "Starting an emulator",
                0,
                "ContentValues stores column/value pairs passed to insert() or update().");

        addQuestion(questions, moduleId,
                "Which object represents the result rows of an Android SQLite query?",
                "Cursor",
                "Toast",
                "Intent",
                "FragmentManager",
                0,
                "A Cursor exposes rows returned from an SQLite query.");

        addQuestion(questions, moduleId,
                "Which SQL command removes matching rows from a table?",
                "DELETE",
                "SELECT",
                "CREATE",
                "ORDER BY",
                0,
                "DELETE removes rows that match its WHERE condition, or all rows if no filter is supplied.");

        addQuestion(questions, moduleId,
                "Why use parameter placeholders in database queries?",
                "To bind values safely instead of concatenating user input",
                "To skip database connections",
                "To make all results alphabetical",
                "To disable SQL statements",
                0,
                "Parameterized queries help separate SQL syntax from input values and reduce injection risks.");

    }

    // MODULE 08 - React and React Native
    private static void addReactAndReactNativeQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 8;

        addQuestion(questions, moduleId,
                "What is React primarily used for?",
                "Building component-based user interfaces",
                "Configuring Android sensors directly",
                "Managing Git repositories",
                "Creating SQLite tables automatically",
                0,
                "React is a JavaScript library for constructing user interfaces from components.");

        addQuestion(questions, moduleId,
                "What is React Native designed to build?",
                "Native mobile applications using React concepts",
                "Only desktop SQL databases",
                "Only browser extensions",
                "Only Java servlets",
                0,
                "React Native uses React concepts to build apps with native platform UI components.");

        addQuestion(questions, moduleId,
                "Which language is commonly used for React Native application logic?",
                "JavaScript or TypeScript",
                "SQL only",
                "XML only",
                "Assembly only",
                0,
                "React Native apps commonly use JavaScript or TypeScript.");

        addQuestion(questions, moduleId,
                "Which component is typically used as a container in React Native?",
                "View",
                "div",
                "table",
                "body",
                0,
                "React Native provides the View component as a general-purpose container.");

        addQuestion(questions, moduleId,
                "Which React Native component displays text?",
                "Text",
                "span",
                "labelHTML",
                "paragraph",
                0,
                "Text displays strings and nested text elements in React Native.");

        addQuestion(questions, moduleId,
                "How does React Native differ from React for the browser?",
                "It renders native platform components instead of browser DOM elements",
                "It never uses components",
                "It only supports CSS files",
                "It requires a browser tab for each screen",
                0,
                "React Native renders native platform views rather than browser DOM nodes.");

        addQuestion(questions, moduleId,
                "What is a component in React?",
                "A reusable piece of user interface",
                "A fixed SQL table",
                "A device driver",
                "A GitHub issue",
                0,
                "Components encapsulate UI structure and behavior for reuse.");

        addQuestion(questions, moduleId,
                "What does JSX commonly let developers express?",
                "UI markup-like syntax within JavaScript",
                "Only SQL queries",
                "Android manifest permissions",
                "Native machine instructions",
                0,
                "JSX is syntax used to describe user interface elements inside JavaScript code.");

        addQuestion(questions, moduleId,
                "Which React Native API helps organize component styles?",
                "StyleSheet.create()",
                "SQLiteOpenHelper",
                "Intent.putExtra()",
                "setContentView()",
                0,
                "StyleSheet.create() is commonly used to define reusable React Native styles.");

        addQuestion(questions, moduleId,
                "What is a cross-platform benefit of React Native?",
                "Sharing substantial UI and logic across Android and iOS",
                "Removing the need to test on both platforms",
                "Guaranteed identical appearance on all devices",
                "Disabling native device features",
                0,
                "React Native can share much code between platforms but still requires platform testing.");

        addQuestion(questions, moduleId,
                "Which service can help start a React Native project without configuring every native build tool?",
                "Expo",
                "SQLite",
                "Logcat",
                "Git blame",
                0,
                "Expo provides tools and services that simplify many React Native development workflows.");

        addQuestion(questions, moduleId,
                "Can React Native access native device features?",
                "Yes, through supported APIs and native modules",
                "No, never",
                "Only by displaying HTML tables",
                "Only by writing XML layouts for each View",
                0,
                "React Native can interact with native capabilities through APIs and modules.");

    }

    // MODULE 09 - JSX and Rendering
    private static void addJsxAndRenderingQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 9;

        addQuestion(questions, moduleId,
                "What does JSX stand for?",
                "JavaScript XML",
                "Java Syntax Extension",
                "JSON Xchange",
                "Java eXecutable Markup",
                0,
                "JSX stands for JavaScript XML and is a syntax extension used with React.");

        addQuestion(questions, moduleId,
                "How do you insert a JavaScript expression into JSX?",
                "Wrap the expression in curly braces",
                "Put it inside SQL quotes",
                "Prefix it with a dollar sign only",
                "Use an Android Intent",
                0,
                "JSX uses curly braces to embed JavaScript expressions.");

        addQuestion(questions, moduleId,
                "How should React component names usually begin in JSX?",
                "With an uppercase letter",
                "With a digit",
                "With an at sign",
                "With a slash",
                0,
                "React treats capitalized JSX tags as custom components.");

        addQuestion(questions, moduleId,
                "What does the map() method commonly help do in React?",
                "Render a list from an array",
                "Request Android location permission",
                "Save SQLite transactions",
                "Define Gradle dependencies",
                0,
                "map() transforms an array into a list of elements or other values.");

        addQuestion(questions, moduleId,
                "Why should list elements usually have stable keys?",
                "To help React identify changed items between renders",
                "To make text automatically bold",
                "To stop all state updates",
                "To replace component props",
                0,
                "Stable keys help React match list items across renders.");

        addQuestion(questions, moduleId,
                "Which JavaScript operator is often used for one of two JSX branches?",
                "Conditional (ternary) operator",
                "Bitwise NOT only",
                "Assignment operator only",
                "Increment operator only",
                0,
                "A ternary expression selects one of two rendered results based on a condition.");

        addQuestion(questions, moduleId,
                "What can the && operator be used for in JSX?",
                "Conditionally rendering content when an expression is truthy",
                "Copying files to a remote repository",
                "Connecting SQLite tables",
                "Starting a new Activity",
                0,
                "The logical AND operator can render content when its left condition is truthy.");

        addQuestion(questions, moduleId,
                "What is a React Fragment useful for?",
                "Grouping elements without adding an extra wrapper node",
                "Connecting the phone to Wi-Fi",
                "Storing app permissions",
                "Declaring SQL column types",
                0,
                "Fragments group multiple child elements without introducing an additional wrapper element.");

        addQuestion(questions, moduleId,
                "Which React Native component should contain directly rendered text?",
                "Text",
                "View only with plain string children",
                "ScrollBar",
                "StatusBar",
                0,
                "Text strings in React Native should normally be wrapped in a Text component.");

        addQuestion(questions, moduleId,
                "What does a JSX element describe?",
                "The UI React should render",
                "A compiled Android APK",
                "A network port",
                "An SQL query result",
                0,
                "JSX elements describe the structure of rendered UI.");

        addQuestion(questions, moduleId,
                "What is a common way to pass data to a child component in JSX?",
                "Using props as element attributes",
                "Using only Android Bundles",
                "Editing the package manager cache",
                "Storing data only in Logcat",
                0,
                "Props pass values from a parent component to a child.");

        addQuestion(questions, moduleId,
                "What does conditional rendering mean?",
                "Displaying UI based on application conditions",
                "Always showing every component",
                "Deleting all hidden data",
                "Disabling JavaScript",
                0,
                "Conditional rendering changes which UI elements are returned for a given state.");

    }

    // MODULE 10 - Props, State and Context
    private static void addPropsStateContextQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 10;

        addQuestion(questions, moduleId,
                "What are props in React?",
                "Inputs passed from a parent to a component",
                "A built-in SQL database",
                "Only CSS animations",
                "Android permissions",
                0,
                "Props provide read-only inputs for a component.");

        addQuestion(questions, moduleId,
                "Should a child component directly modify its received props?",
                "No, props should be treated as read-only",
                "Yes, always",
                "Only if they contain strings",
                "Only in React Native",
                0,
                "A component should not directly mutate its props.");

        addQuestion(questions, moduleId,
                "What is state used for in React?",
                "Data that can change and cause a component to update",
                "A fixed Java classpath",
                "Only the device location",
                "An Android manifest file",
                0,
                "State holds component data that changes over time and affects rendering.");

        addQuestion(questions, moduleId,
                "Which React Hook is commonly used to declare local state?",
                "useState()",
                "useContextOnly()",
                "useLayout()",
                "useSQLite()",
                0,
                "useState() creates a state value and an updater function.");

        addQuestion(questions, moduleId,
                "What is the recommended way to update state returned by useState?",
                "Call the provided setter function",
                "Directly assign a new value to the state variable",
                "Modify props from the child",
                "Restart the Android emulator",
                0,
                "React state should be updated using the setter returned by useState.");

        addQuestion(questions, moduleId,
                "What does lifting state up mean?",
                "Moving shared state to a common ancestor component",
                "Moving all files to the root directory",
                "Changing a View elevation",
                "Copying data to every child without control",
                0,
                "Lifting state up lets related components share a single source of truth.");

        addQuestion(questions, moduleId,
                "What problem can Context help reduce?",
                "Passing the same props through many intermediate components",
                "Installing Java",
                "Rendering lists with keys",
                "Building an APK",
                0,
                "Context can reduce prop drilling for values needed by many descendants.");

        addQuestion(questions, moduleId,
                "Which Hook reads a React context value?",
                "useContext()",
                "useStateOnly()",
                "useSQLite()",
                "usePermission()",
                0,
                "useContext() allows a component to read the current value of a context.");

        addQuestion(questions, moduleId,
                "What can cause a React component to render again?",
                "An update to its state",
                "Only a change in Android battery level",
                "Only running git init",
                "Only renaming a package",
                0,
                "A state change can trigger a re-render of the relevant component.");

        addQuestion(questions, moduleId,
                "Which statement best compares props and state?",
                "Props are inputs; state is component-managed data",
                "Props are always mutable; state never changes",
                "Both are SQLite tables",
                "Neither can affect rendering",
                0,
                "Props come from a parent, while state is managed by a component or its Hook.");

        addQuestion(questions, moduleId,
                "When is a functional state updater useful?",
                "When the next value depends on the previous value",
                "Only when displaying static text",
                "Only when using Android XML",
                "When state never changes",
                0,
                "A functional update receives the previous state, avoiding reliance on a potentially stale value.");

        addQuestion(questions, moduleId,
                "What is a suitable use for Context?",
                "A theme or user preference shared across many components",
                "Every single character of static text",
                "Replacing all component state in every app",
                "Automatically persisting data to SQLite",
                0,
                "Context is useful for widely shared values such as theme settings or authenticated user context.");

    }

    // MODULE 11 - Component Lifecycle
    private static void addComponentLifecycleQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 11;

        addQuestion(questions, moduleId,
                "What does mounting mean for a React component?",
                "The component is added to the rendered tree",
                "The component is permanently deleted",
                "The app is uploaded to a store",
                "The database is upgraded",
                0,
                "Mounting occurs when a component becomes part of the rendered UI tree.");

        addQuestion(questions, moduleId,
                "What does unmounting mean?",
                "A component is removed from the rendered tree",
                "A device is rotated",
                "A Java class is imported",
                "A Git branch is created",
                0,
                "Unmounting occurs when React removes a component from the UI tree.");

        addQuestion(questions, moduleId,
                "Which React Hook is commonly used for side effects in function components?",
                "useEffect()",
                "useStateOnly()",
                "useProps()",
                "useDatabase()",
                0,
                "useEffect() can synchronize a component with external systems after rendering.");

        addQuestion(questions, moduleId,
                "What is a common purpose of an effect cleanup function?",
                "Removing subscriptions or timers created by the effect",
                "Deleting JSX components permanently",
                "Reformatting CSS",
                "Running Gradle",
                0,
                "Cleanup can release listeners, subscriptions, or other resources when appropriate.");

        addQuestion(questions, moduleId,
                "When does an effect with an empty dependency array normally run?",
                "After mount, with cleanup on unmount; development behavior may differ",
                "After every key press without exception",
                "Before each Java statement",
                "Only after a database query",
                0,
                "An empty dependency array usually limits the effect to the mount lifecycle; development Strict Mode can re-run it.");

        addQuestion(questions, moduleId,
                "What usually happens if useEffect has no dependency array?",
                "It runs after each committed render",
                "It can never run",
                "It only runs once on app installation",
                "It runs only when the phone rotates",
                0,
                "Without a dependency array, an effect runs after every committed render.");

        addQuestion(questions, moduleId,
                "Why list dependencies in useEffect?",
                "To re-run an effect when referenced reactive values change",
                "To declare Android permissions",
                "To create new SQL columns",
                "To replace the component name",
                0,
                "React uses the dependency list to determine when to re-synchronize an effect.");

        addQuestion(questions, moduleId,
                "What is a render in React?",
                "Computing the UI from current props and state",
                "Saving every value to SQLite",
                "Downloading a new Android SDK",
                "Destroying all components",
                0,
                "Rendering computes the element tree described by the component.");

        addQuestion(questions, moduleId,
                "Which action can trigger a component update?",
                "Changing the state used by the component",
                "Only deleting a Git branch",
                "Only changing wallpaper",
                "Only restarting Android Studio",
                0,
                "State updates can cause React to render again with new data.");

        addQuestion(questions, moduleId,
                "Why should component rendering avoid unintended side effects?",
                "Rendering may be repeated and should remain predictable",
                "React forbids all calculations",
                "JSX cannot contain strings",
                "Only one component may render",
                0,
                "Keeping renders pure makes repeated rendering predictable and safe.");

        addQuestion(questions, moduleId,
                "What is a typical useEffect use case?",
                "Adding and cleaning up an external event listener",
                "Choosing a Java package name",
                "Creating an AndroidManifest",
                "Editing Git commit history",
                0,
                "An effect can subscribe to an external event and return cleanup to unsubscribe.");

        addQuestion(questions, moduleId,
                "What may cause React to remount an element rather than preserve its state?",
                "Changing its key at the same position",
                "Changing a plain text color only",
                "Logging to the console",
                "Adding a comment to JavaScript",
                0,
                "React uses identity, including keys, when deciding whether to preserve component state.");

    }

    // MODULE 12 - React Native Projects
    private static void addReactNativeProjectsQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 12;

        addQuestion(questions, moduleId,
                "What is a common prerequisite for running React Native JavaScript tooling?",
                "Node.js",
                "SQLite Browser only",
                "Android XML Parser only",
                "GitHub Desktop only",
                0,
                "Node.js is used to run many React Native and Expo development tools.");

        addQuestion(questions, moduleId,
                "What does npm commonly manage in a React Native project?",
                "JavaScript packages and dependencies",
                "Only device screen brightness",
                "Only SQLite tables",
                "Only Android permissions",
                0,
                "npm is a package manager for JavaScript dependencies and scripts.");

        addQuestion(questions, moduleId,
                "Which command can create a new Expo app using the current recommended tool?",
                "npx create-expo-app",
                "git uninstall",
                "java init-expo",
                "sqlite3 create-app",
                0,
                "npx create-expo-app initializes an Expo project with its starter configuration.");

        addQuestion(questions, moduleId,
                "Which command is commonly used to start the Expo development server?",
                "npx expo start",
                "npm delete android",
                "git push expo",
                "javac ExpoApp.java",
                0,
                "npx expo start launches the Expo development server.");

        addQuestion(questions, moduleId,
                "What is Expo Go?",
                "A mobile client for opening compatible Expo development projects",
                "A SQL query editor",
                "An Android version control system",
                "A Java compiler",
                0,
                "Expo Go can run supported Expo projects on a physical device.");

        addQuestion(questions, moduleId,
                "Why does Expo show a QR code during development?",
                "To help a device open the development project",
                "To publish an app to every store",
                "To replace source code",
                "To generate a new Git branch",
                0,
                "Scanning the QR code can connect Expo Go or a compatible client to the dev server.");

        addQuestion(questions, moduleId,
                "What is Expo Snack?",
                "A browser-based environment for experimenting with React Native code",
                "A database migration tool",
                "An Android manifest editor",
                "A Git hosting service",
                0,
                "Expo Snack lets developers prototype and share React Native examples in the browser.");

        addQuestion(questions, moduleId,
                "What is the Metro bundler used for?",
                "Bundling JavaScript for React Native development",
                "Designing launcher icons only",
                "Creating SQL indexes",
                "Assigning Android permissions",
                0,
                "Metro transforms and bundles JavaScript and assets for React Native.");

        addQuestion(questions, moduleId,
                "Where are reusable JavaScript dependencies listed in a typical project?",
                "package.json",
                "AndroidManifest.xml only",
                "strings.xml only",
                "gradle-wrapper.jar only",
                0,
                "package.json declares package metadata, scripts, and dependencies.");

        addQuestion(questions, moduleId,
                "Why should a React Native app be tested on different devices?",
                "To catch layout and platform-specific differences",
                "Because the code cannot be shared",
                "To delete old source code",
                "To avoid checking functionality",
                0,
                "Screen sizes and platform behaviors can differ even with shared code.");

        addQuestion(questions, moduleId,
                "What can a simulator or emulator help test?",
                "App navigation and user interfaces on virtual devices",
                "Only Git branch permissions",
                "Only cloud backups",
                "Only SQL syntax highlighting",
                0,
                "Simulators and emulators allow device behavior to be tested without physical hardware.");

        addQuestion(questions, moduleId,
                "What is a useful benefit of Expo during early development?",
                "A streamlined workflow for running and previewing projects",
                "Guaranteed zero platform differences",
                "Automatic replacement for all tests",
                "A requirement to write every screen in XML",
                0,
                "Expo tooling simplifies common React Native setup and iteration tasks.");

    }

    // MODULE 13 - Responsive Flexbox
    private static void addResponsiveFlexboxQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 13;

        addQuestion(questions, moduleId,
                "What is the default flexDirection in React Native?",
                "column",
                "row",
                "row-reverse only",
                "none",
                0,
                "React Native flex containers use column as the default direction.");

        addQuestion(questions, moduleId,
                "Which flexDirection value arranges children horizontally?",
                "row",
                "column",
                "vertical",
                "stack",
                0,
                "flexDirection: row places children along a horizontal main axis.");

        addQuestion(questions, moduleId,
                "Which property aligns children along the main axis?",
                "justifyContent",
                "alignItems",
                "opacity",
                "fontWeight",
                0,
                "justifyContent controls distribution along the main axis.");

        addQuestion(questions, moduleId,
                "Which property commonly aligns children along the cross axis?",
                "alignItems",
                "justifyContent",
                "flexDirectionOnly",
                "fontSize",
                0,
                "alignItems controls alignment perpendicular to the main axis.");

        addQuestion(questions, moduleId,
                "What does flex: 1 generally do in a React Native flex container?",
                "Allow the element to grow to fill available space",
                "Rotate the element by one degree",
                "Set the width to one pixel",
                "Disable the layout",
                0,
                "A positive flex value allows a child to grow and fill available space according to Flexbox rules.");

        addQuestion(questions, moduleId,
                "What does justifyContent: \"space-between\" do?",
                "Distributes remaining space between items",
                "Centers every item on both axes",
                "Hides the last child",
                "Changes text to uppercase",
                0,
                "space-between places the first and last items at the ends and distributes spacing between items.");

        addQuestion(questions, moduleId,
                "Which property allows items to wrap onto another line when needed?",
                "flexWrap",
                "textAlign",
                "elevation",
                "zIndex",
                0,
                "flexWrap can allow flex items to flow onto additional lines.");

        addQuestion(questions, moduleId,
                "Which property adds space inside a component boundary?",
                "padding",
                "margin",
                "position",
                "opacity",
                0,
                "Padding creates internal spacing around content.");

        addQuestion(questions, moduleId,
                "Which property adds space outside a component boundary?",
                "margin",
                "padding",
                "fontSize",
                "displayText",
                0,
                "Margins provide spacing outside an element.");

        addQuestion(questions, moduleId,
                "Which utility can read the current window dimensions in React Native?",
                "useWindowDimensions()",
                "useLayoutInspectorOnly()",
                "getSqlWidth()",
                "git status",
                0,
                "useWindowDimensions() provides dimensions that update when the window size changes.");

        addQuestion(questions, moduleId,
                "How are React Native styles usually represented?",
                "JavaScript style objects",
                "Only HTML class attributes",
                "Only Android XML",
                "Only SQL tables",
                0,
                "React Native typically uses JavaScript objects or StyleSheet.create() for styling.");

        addQuestion(questions, moduleId,
                "What is a practical goal of responsive mobile layout?",
                "Adapting usability across different screen dimensions",
                "Assuming all devices have the same resolution",
                "Using fixed pixels for every element",
                "Hiding content on small screens",
                0,
                "Responsive layouts adapt sizes and arrangement to the available screen space.");

    }

    // MODULE 14 - Maps and Sensors
    private static void addMapsAndSensorsQuestions(
            List<QuizQuestion> questions) {
        final int moduleId = 14;

        addQuestion(questions, moduleId,
                "What do latitude and longitude represent?",
                "Geographic coordinates of a location",
                "Screen width and height",
                "Sensor sampling intervals",
                "SQL table indexes",
                0,
                "Latitude and longitude describe a geographic position on Earth.");

        addQuestion(questions, moduleId,
                "What should an app normally do before reading a user's location?",
                "Request appropriate location permission",
                "Delete all stored data",
                "Enable airplane mode",
                "Skip user consent",
                0,
                "Apps should request appropriate permission and explain why location is needed.");

        addQuestion(questions, moduleId,
                "What is a map marker used for?",
                "Showing a specific location on a map",
                "Changing the Android theme",
                "Restarting the GPS chip",
                "Storing a Java class",
                0,
                "Markers visually identify positions or points of interest on a map.");

        addQuestion(questions, moduleId,
                "What is a point of interest (POI)?",
                "A notable place such as a restaurant or landmark",
                "The maximum screen brightness",
                "An Android Java method",
                "A type of SQL transaction",
                0,
                "Points of interest identify meaningful places on a map.");

        addQuestion(questions, moduleId,
                "What should an app do if location permission is denied?",
                "Handle the denial gracefully and offer alternatives",
                "Crash immediately",
                "Read location without permission",
                "Disable the entire phone",
                0,
                "Permission denial should be handled without crashing or bypassing privacy choices.");

        addQuestion(questions, moduleId,
                "What does location accuracy describe?",
                "How close an estimated location may be to the actual position",
                "The number of map colors",
                "The device battery percentage",
                "The size of an image",
                0,
                "Location accuracy indicates the uncertainty of an estimated position.");

        addQuestion(questions, moduleId,
                "Which sensor commonly measures acceleration along device axes?",
                "Accelerometer",
                "Ambient light sensor",
                "Barometer",
                "Proximity sensor",
                0,
                "An accelerometer measures acceleration forces along axes, including gravity effects depending on the API.");

        addQuestion(questions, moduleId,
                "Which sensor measures angular velocity or rotational motion?",
                "Gyroscope",
                "Thermometer",
                "Light sensor",
                "Pressure sensor",
                0,
                "A gyroscope provides device angular velocity measurements.");

        addQuestion(questions, moduleId,
                "Which sensor can provide magnetic field measurements?",
                "Magnetometer",
                "Accelerometer",
                "Microphone",
                "Touchscreen",
                0,
                "A magnetometer measures the surrounding magnetic field.");

        addQuestion(questions, moduleId,
                "Which sensor detects ambient illumination?",
                "Light sensor",
                "Gyroscope",
                "Barometer",
                "Accelerometer",
                0,
                "An ambient light sensor measures light levels, often in lux.");

        addQuestion(questions, moduleId,
                "Why should an app unregister sensor listeners when they are not needed?",
                "To save resources and battery",
                "To delete the sensor hardware",
                "To reset Git commits",
                "To remove location permission permanently",
                0,
                "Unregistering sensor listeners avoids unnecessary sampling and resource use.");

        addQuestion(questions, moduleId,
                "Why should an app limit how often it requests location updates?",
                "To balance freshness, privacy, and battery consumption",
                "To force more screen redraws",
                "To disable map zoom",
                "To avoid all permission requests",
                0,
                "Frequent location updates can use more energy and raise privacy concerns.");

    }
}
