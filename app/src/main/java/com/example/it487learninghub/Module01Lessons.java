package com.example.it487learninghub;

public final class Module01Lessons {

    // Prevent creating instances
    private Module01Lessons() {
    }

    // =====================================
    // GET MODULE 01 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return mobileDevelopmentOverview();

            case 2:
                return developmentToolsAndWorkflow();

            case 3:
                return gitAndGitHubBasics();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Mobile Application Development Overview
    // =====================================

    private static LessonContent
    mobileDevelopmentOverview() {

        String summary =
                "Understand mobile application development, "
                        + "the differences between native and "
                        + "cross-platform approaches, and "
                        + "the process of creating mobile apps.";

        String explanation =
                "Mobile application development is "
                        + "the process of designing, building, "
                        + "testing, and maintaining applications "
                        + "for mobile devices.\n\n"

                        + "MOBILE PLATFORMS:\n"
                        + "Android and iOS are two major "
                        + "mobile operating systems. "
                        + "Each provides its own development "
                        + "tools, frameworks, and APIs.\n\n"

                        + "NATIVE DEVELOPMENT:\n"
                        + "Native applications are developed "
                        + "for a specific platform.\n\n"

                        + "Android development commonly uses "
                        + "Kotlin or Java, while iOS development "
                        + "commonly uses Swift.\n\n"

                        + "Native applications can use "
                        + "platform-specific features "
                        + "and development tools directly.\n\n"

                        + "CROSS-PLATFORM DEVELOPMENT:\n"
                        + "Cross-platform frameworks allow "
                        + "developers to share significant "
                        + "portions of an application's code "
                        + "across multiple platforms.\n\n"

                        + "React Native is an example of "
                        + "a cross-platform framework.\n\n"

                        + "APPLICATION ARCHITECTURE:\n"
                        + "Mobile applications typically "
                        + "combine a user interface, "
                        + "application logic, and "
                        + "data management.\n\n"

                        + "Some applications communicate "
                        + "with remote servers, while others "
                        + "store data locally using "
                        + "solutions such as SQLite.\n\n"

                        + "USER EXPERIENCE:\n"
                        + "Good mobile applications provide "
                        + "clear navigation, responsive "
                        + "interfaces, and understandable "
                        + "feedback for user actions.\n\n"

                        + "DEVELOPMENT PROCESS:\n"
                        + "A typical process includes "
                        + "requirements analysis, interface "
                        + "design, implementation, testing, "
                        + "deployment, and maintenance.\n\n"

                        + "APPLICATION TESTING:\n"
                        + "Developers test apps on emulators "
                        + "and physical devices to identify "
                        + "errors and usability problems.";

        String takeaway =
                "Mobile development requires "
                        + "choosing a platform and "
                        + "development approach, designing "
                        + "the interface, implementing "
                        + "application logic, managing data, "
                        + "and testing the finished app.";

        String code =
                "// Android Java navigation example\n"
                        + "// Inside MainActivity, after setContentView()\n\n"

                        + "findViewById(R.id.btnStartLearning)\n"
                        + "    .setOnClickListener(v -> {\n\n"

                        + "        Intent intent = new Intent(\n"
                        + "                MainActivity.this,\n"
                        + "                ExploreActivity.class\n"
                        + "        );\n\n"

                        + "        startActivity(intent);\n"
                        + "    });";

        String codeExplanation =
                "This Android Java example shows "
                        + "a common mobile interaction.\n\n"

                        + "The application finds a button "
                        + "defined in its XML layout.\n\n"

                        + "setOnClickListener() registers "
                        + "an action that runs when "
                        + "the user taps the button.\n\n"

                        + "An explicit Intent identifies "
                        + "ExploreActivity as the next screen.\n\n"

                        + "startActivity() opens that Activity.\n\n"

                        + "This is a code excerpt rather than "
                        + "a complete Activity class. "
                        + "It assumes the button and target "
                        + "Activity already exist.";

        String question =
                "Which development approach aims "
                        + "to reuse application code "
                        + "across Android and iOS?";

        String[] options = {
                "Android XML layouts only",
                "Cross-platform development",
                "SQLite database management",
                "AndroidManifest configuration"
        };

        String answerExplanation =
                "Cross-platform frameworks allow "
                        + "developers to share code "
                        + "between mobile platforms. "
                        + "React Native is one example.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                answerExplanation
        );
    }

    // =====================================
    // LESSON 02
    // Development Tools and Workflow
    // =====================================

    private static LessonContent
    developmentToolsAndWorkflow() {

        String summary =
                "Learn how development environments, "
                        + "build tools, debugging utilities, "
                        + "and testing support "
                        + "the mobile development workflow.";

        String explanation =
                "A development workflow describes "
                        + "the steps and tools used to "
                        + "turn an application idea "
                        + "into a working product.\n\n"

                        + "INTEGRATED DEVELOPMENT ENVIRONMENT:\n"
                        + "An IDE provides tools for editing "
                        + "code, organizing project files, "
                        + "running applications, and "
                        + "investigating errors.\n\n"

                        + "Android Studio is the official "
                        + "IDE for Android application "
                        + "development.\n\n"

                        + "CODE EDITOR:\n"
                        + "The code editor helps developers "
                        + "write Java, Kotlin, XML, "
                        + "and other project files.\n\n"

                        + "ANDROID SDK:\n"
                        + "The Android Software Development Kit "
                        + "provides platform APIs and tools "
                        + "required to build Android apps.\n\n"

                        + "GRADLE:\n"
                        + "Gradle automates the build process "
                        + "and manages external dependencies.\n\n"

                        + "ANDROID EMULATOR:\n"
                        + "An emulator runs a virtual "
                        + "Android device so developers "
                        + "can test applications "
                        + "without a physical phone.\n\n"

                        + "DEBUGGING:\n"
                        + "A debugger can pause a program "
                        + "at breakpoints and allow developers "
                        + "to inspect variables and "
                        + "execution flow.\n\n"

                        + "LOGCAT:\n"
                        + "Logcat displays messages "
                        + "from Android applications "
                        + "and the Android system.\n\n"

                        + "ADB:\n"
                        + "Android Debug Bridge allows "
                        + "developers to communicate "
                        + "with connected Android devices "
                        + "and emulators.\n\n"

                        + "VERSION CONTROL:\n"
                        + "Git records changes to source "
                        + "code and helps developers "
                        + "collaborate on projects.\n\n"

                        + "DEVELOPMENT CYCLE:\n"
                        + "Developers typically write code, "
                        + "build the application, run tests, "
                        + "identify problems, and improve "
                        + "the implementation.\n\n"

                        + "RELEASE PREPARATION:\n"
                        + "Before distributing an application, "
                        + "developers should verify its behavior, "
                        + "check permissions, fix important bugs, "
                        + "and prepare a release build.";

        String takeaway =
                "An effective workflow combines "
                        + "code editing, Gradle builds, "
                        + "device testing, debugging, "
                        + "and version control.";

        String code =
                "# Example Android development commands\n"
                        + "# Run in macOS Terminal\n\n"

                        + "# Build a debug APK from project root\n"
                        + "./gradlew assembleDebug\n\n"

                        + "# List connected Android devices\n"
                        + "adb devices\n\n"

                        + "# View Android device logs\n"
                        + "adb logcat\n\n"

                        + "# Common debug APK output location\n"
                        + "app/build/outputs/apk/debug/app-debug.apk";

        String codeExplanation =
                "The first command uses the "
                        + "Gradle Wrapper to build "
                        + "a debug APK.\n\n"

                        + "adb devices lists devices "
                        + "and emulators connected "
                        + "to the development computer.\n\n"

                        + "adb logcat displays "
                        + "device and application logs "
                        + "until it is stopped.\n\n"

                        + "The final line shows a common "
                        + "APK output path. "
                        + "It is not an executable command.\n\n"

                        + "The commands assume that "
                        + "the Android SDK tools "
                        + "are installed and that adb "
                        + "is available in the "
                        + "terminal environment.";

        String question =
                "Which build tool is used "
                        + "by Android Studio to "
                        + "compile applications "
                        + "and manage dependencies?";

        String[] options = {
                "Logcat",
                "Android Emulator",
                "Gradle",
                "SQLite"
        };

        String answerExplanation =
                "Gradle manages the Android "
                        + "build process and project "
                        + "dependencies. It helps compile, "
                        + "package, and prepare applications.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                2,
                answerExplanation
        );
    }

    // =====================================
    // LESSON 03
    // Git and GitHub Basics
    // =====================================

    private static LessonContent gitAndGitHubBasics() {

        String summary =
                "Understand Git version control, "
                        + "GitHub repositories, commits, "
                        + "branches, and collaboration "
                        + "in software development.";

        String explanation =
                "Git is a distributed "
                        + "version control system "
                        + "used to record changes "
                        + "to files over time.\n\n"

                        + "WHY VERSION CONTROL MATTERS:\n"
                        + "Version control makes it easier "
                        + "to track changes, review "
                        + "project history, and collaborate "
                        + "with other developers.\n\n"

                        + "GIT VS GITHUB:\n"
                        + "Git is the version control tool.\n\n"

                        + "GitHub is a platform "
                        + "for hosting Git repositories "
                        + "and supporting collaboration.\n\n"

                        + "REPOSITORY:\n"
                        + "A repository stores project files "
                        + "and their version history.\n\n"

                        + "WORKING DIRECTORY:\n"
                        + "The working directory contains "
                        + "the files a developer "
                        + "is currently editing.\n\n"

                        + "STAGING AREA:\n"
                        + "git add selects file changes "
                        + "for inclusion in the next commit.\n\n"

                        + "COMMITS:\n"
                        + "A commit records a snapshot "
                        + "of staged changes in "
                        + "the local repository history.\n\n"

                        + "BRANCHES:\n"
                        + "Branches allow developers "
                        + "to work on changes separately "
                        + "from other development work.\n\n"

                        + "REMOTE REPOSITORIES:\n"
                        + "A remote repository is stored "
                        + "outside the local machine, "
                        + "often on a platform like GitHub.\n\n"

                        + "PUSH AND PULL:\n"
                        + "git push uploads local commits "
                        + "to a remote repository.\n\n"

                        + "git pull retrieves and integrates "
                        + "changes from a remote branch.\n\n"

                        + "PULL REQUESTS:\n"
                        + "GitHub pull requests support "
                        + "reviewing proposed changes "
                        + "before merging them.\n\n"

                        + "GOOD PRACTICES:\n"
                        + "Write meaningful commit messages, "
                        + "review changed files before committing, "
                        + "and avoid committing passwords, "
                        + "API keys, or other secrets.\n\n"

                        + "GITIGNORE:\n"
                        + "A .gitignore file specifies "
                        + "untracked files and patterns "
                        + "that Git should ignore.";

        String takeaway =
                "Git tracks project history "
                        + "through commits and branches. "
                        + "GitHub hosts repositories "
                        + "and provides collaboration tools "
                        + "such as pull requests.";

        String code =
                "# Check the working tree\n"
                        + "git status\n\n"

                        + "# Stage a changed Java file\n"
                        + "git add app/src/main/java/"
                        + "com/example/it487learninghub/"
                        + "MainActivity.java\n\n"

                        + "# Commit staged changes locally\n"
                        + "git commit -m \"Update home screen\"\n\n"

                        + "# Push commits to the remote main branch\n"
                        + "git push origin main";

        String codeExplanation =
                "git status shows which files "
                        + "have changed and which "
                        + "changes are staged.\n\n"

                        + "git add stages the specified "
                        + "Java file for the next commit.\n\n"

                        + "git commit records a local "
                        + "snapshot of the staged changes "
                        + "with a descriptive message.\n\n"

                        + "git push origin main sends "
                        + "local commits from the main "
                        + "branch to the configured "
                        + "origin remote.\n\n"

                        + "The example assumes Git has "
                        + "already been initialized, "
                        + "your author information "
                        + "is configured, and a remote "
                        + "named origin exists.\n\n"

                        + "Your actual branch name "
                        + "may differ from main. "
                        + "Review the project status "
                        + "before running these commands.";

        String question =
                "Which Git command records "
                        + "a snapshot of staged changes "
                        + "in the local repository history?";

        String[] options = {
                "git status",
                "git commit",
                "git fetch",
                "git clone"
        };

        String answerExplanation =
                "git commit creates a commit "
                        + "containing staged changes "
                        + "in the local repository.\n\n"

                        + "git status shows repository state, "
                        + "git fetch retrieves remote data, "
                        + "and git clone copies a repository.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                answerExplanation
        );
    }
}
