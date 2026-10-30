package com.example.it487learninghub;

public final class Module03Lessons {

    private Module03Lessons() {
    }

    // =====================================
    // GET MODULE 03 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return androidProjectAnatomy();

            case 2:
                return activitiesAndManifest();

            case 3:
                return resourcesAndBuildFiles();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Android Project Anatomy
    // =====================================

    private static LessonContent androidProjectAnatomy() {

        String summary =
                "Explore the main folders and files "
                        + "of an Android Studio project and "
                        + "understand their responsibilities.";

        String explanation =
                "An Android Studio project contains "
                        + "source code, interface resources, "
                        + "configuration files, and build settings.\n\n"

                        + "THE APP MODULE:\n"
                        + "An Android project normally contains "
                        + "an app module where the application "
                        + "source code and resources are stored.\n\n"

                        + "JAVA SOURCE CODE:\n"
                        + "The app/src/main/java folder contains "
                        + "Java classes such as Activities, "
                        + "database helpers, and adapters.\n\n"

                        + "RESOURCE DIRECTORY:\n"
                        + "The app/src/main/res folder contains "
                        + "resources used by the application.\n\n"

                        + "The layout folder stores XML "
                        + "interface layouts.\n\n"

                        + "The drawable folder stores "
                        + "graphics and drawable resources.\n\n"

                        + "The values folder commonly contains "
                        + "strings, colors, dimensions, and styles.\n\n"

                        + "ANDROID MANIFEST:\n"
                        + "AndroidManifest.xml describes "
                        + "important application components "
                        + "and declarations required by Android.\n\n"

                        + "GRADLE BUILD FILES:\n"
                        + "Gradle configuration controls "
                        + "application build settings and "
                        + "external dependencies.\n\n"

                        + "TEST DIRECTORIES:\n"
                        + "The test directory normally contains "
                        + "local unit tests, while androidTest "
                        + "contains instrumented tests "
                        + "that run on Android devices.";

        String takeaway =
                "An Android project separates Java "
                        + "source code, XML resources, "
                        + "manifest declarations, and "
                        + "Gradle build configuration.";

        String code =
                "IT487LearningHub/\n"
                        + "|\n"
                        + "+-- app/\n"
                        + "|   |\n"
                        + "|   +-- src/main/\n"
                        + "|   |   |\n"
                        + "|   |   +-- java/\n"
                        + "|   |   |   +-- MainActivity.java\n"
                        + "|   |   |   +-- ExploreActivity.java\n"
                        + "|   |   |   +-- LearningDatabaseHelper.java\n"
                        + "|   |   |\n"
                        + "|   |   +-- res/\n"
                        + "|   |   |   +-- layout/\n"
                        + "|   |   |   +-- drawable/\n"
                        + "|   |   |   +-- values/\n"
                        + "|   |   |\n"
                        + "|   |   +-- AndroidManifest.xml\n"
                        + "|   |\n"
                        + "|   +-- build.gradle.kts\n"
                        + "|\n"
                        + "+-- settings.gradle.kts";

        String codeExplanation =
                "This diagram illustrates a simplified "
                        + "Android project structure.\n\n"

                        + "MainActivity.java and other Java "
                        + "classes contain application logic.\n\n"

                        + "The res directory provides layouts "
                        + "and other application resources.\n\n"

                        + "AndroidManifest.xml declares "
                        + "application components.\n\n"

                        + "Gradle files define build "
                        + "configuration and dependencies.\n\n"

                        + "Android Studio may group directories "
                        + "differently in its Android view, "
                        + "and actual projects can contain "
                        + "additional folders and files.";

        String question =
                "Which Android project directory "
                        + "normally contains XML layouts, "
                        + "drawables, and value resources?";

        String[] options = {
                "app/build",
                "app/src/test",
                "app/src/main/res",
                "gradle/wrapper"
        };

        String answerExplanation =
                "app/src/main/res contains application "
                        + "resources, including layout XML files, "
                        + "drawable resources, and values "
                        + "such as strings and colors.";

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
    // LESSON 02
    // Activities and AndroidManifest
    // =====================================

    private static LessonContent activitiesAndManifest() {

        String summary =
                "Understand how Android Activities "
                        + "are declared and how AndroidManifest.xml "
                        + "describes application components.";

        String explanation =
                "AndroidManifest.xml is an important "
                        + "configuration file in an "
                        + "Android application.\n\n"

                        + "APPLICATION DECLARATIONS:\n"
                        + "The manifest describes application "
                        + "components such as Activities, "
                        + "Services, and Broadcast Receivers.\n\n"

                        + "ACTIVITY DECLARATIONS:\n"
                        + "Activities used by an application "
                        + "must be declared in the manifest.\n\n"

                        + "An activity declaration uses "
                        + "an <activity> element and "
                        + "the android:name attribute.\n\n"

                        + "LAUNCHER ACTIVITY:\n"
                        + "A launcher Activity typically "
                        + "uses an intent filter containing "
                        + "the MAIN action and "
                        + "the LAUNCHER category.\n\n"

                        + "EXPORTED ATTRIBUTE:\n"
                        + "android:exported determines whether "
                        + "the Activity can be started "
                        + "by components from other applications.\n\n"

                        + "For applications targeting Android 12 "
                        + "or later, an Activity containing "
                        + "an intent filter must explicitly "
                        + "declare android:exported.\n\n"

                        + "APPLICATION PERMISSIONS:\n"
                        + "The manifest can declare permissions "
                        + "required by the application, such as "
                        + "internet or location permissions.\n\n"

                        + "Some permissions also require "
                        + "runtime approval from the user.\n\n"

                        + "NAVIGATION:\n"
                        + "An explicit Intent identifies "
                        + "a specific component to open, "
                        + "such as another Activity "
                        + "inside the same application.";

        String takeaway =
                "AndroidManifest.xml declares application "
                        + "components and permissions. "
                        + "The launcher Activity uses an "
                        + "appropriate intent filter and "
                        + "must have a suitable exported setting.";

        String code =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                        + "<manifest\n"
                        + "    xmlns:android=\"http://schemas."
                        + "android.com/apk/res/android\">\n\n"

                        + "    <application\n"
                        + "        android:label=\"IT487 Learning Hub\">\n\n"

                        + "        <activity\n"
                        + "            android:name=\".MainActivity\"\n"
                        + "            android:exported=\"true\">\n\n"

                        + "            <intent-filter>\n"
                        + "                <action\n"
                        + "                    android:name=\"android.intent."
                        + "action.MAIN\" />\n\n"

                        + "                <category\n"
                        + "                    android:name=\"android.intent."
                        + "category.LAUNCHER\" />\n"
                        + "            </intent-filter>\n\n"

                        + "        </activity>\n"
                        + "    </application>\n"
                        + "</manifest>";

        String codeExplanation =
                "This example illustrates a simple "
                        + "Android manifest.\n\n"

                        + "The application element contains "
                        + "an Activity declaration.\n\n"

                        + "android:name identifies MainActivity.\n\n"

                        + "android:exported is true because "
                        + "the launcher must be able to "
                        + "start this Activity.\n\n"

                        + "MAIN and LAUNCHER identify "
                        + "an entry point that appears "
                        + "in the device launcher.\n\n"

                        + "This is a teaching example, not "
                        + "a replacement for your existing "
                        + "AndroidManifest.xml. A complete "
                        + "application may require additional "
                        + "component declarations and settings.";

        String question =
                "Which Android file declares "
                        + "Activities and other application "
                        + "components?";

        String[] options = {
                "strings.xml",
                "AndroidManifest.xml",
                "activity_main.xml",
                "colors.xml"
        };

        String answerExplanation =
                "AndroidManifest.xml declares "
                        + "application components, including "
                        + "Activities. Layout XML files "
                        + "describe user interfaces instead.";

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
    // LESSON 03
    // Resources and Build Files
    // =====================================

    private static LessonContent resourcesAndBuildFiles() {

        String summary =
                "Learn how Android resources "
                        + "are organized and how Gradle "
                        + "build files configure an application.";

        String explanation =
                "Android separates application "
                        + "logic from resources and "
                        + "build configuration.\n\n"

                        + "STRING RESOURCES:\n"
                        + "Text values can be stored in "
                        + "res/values/strings.xml instead "
                        + "of being repeated in layouts.\n\n"

                        + "A string can be referenced in XML "
                        + "using @string/resource_name.\n\n"

                        + "COLOR RESOURCES:\n"
                        + "Colors can be defined in "
                        + "res/values/colors.xml and "
                        + "referenced using @color/name.\n\n"

                        + "LAYOUT RESOURCES:\n"
                        + "XML layouts are commonly stored "
                        + "in res/layout and referenced "
                        + "using R.layout.layout_name.\n\n"

                        + "THE R CLASS:\n"
                        + "Android generates resource "
                        + "identifiers in the R class, "
                        + "allowing Java code to access "
                        + "resources such as layouts and IDs.\n\n"

                        + "GRADLE:\n"
                        + "Gradle is the build system "
                        + "used by Android Studio.\n\n"

                        + "BUILD.GRADLE.KTS:\n"
                        + "A Kotlin DSL Gradle build file "
                        + "can configure the application "
                        + "namespace, SDK settings, "
                        + "dependencies, and other "
                        + "build options.\n\n"

                        + "DEPENDENCIES:\n"
                        + "Dependencies provide libraries "
                        + "such as AndroidX and "
                        + "Material Components.\n\n"

                        + "BUILD PROCESS:\n"
                        + "Android Studio uses Gradle "
                        + "to compile source code, process "
                        + "resources, package the application, "
                        + "and prepare it for installation.";

        String takeaway =
                "Use Android resources to keep "
                        + "layouts, strings, and colors "
                        + "organized. Use Gradle build files "
                        + "to configure SDK versions, "
                        + "plugins, and dependencies.";

        String code =
                "// File: res/values/strings.xml\n\n"

                        + "<resources>\n"
                        + "    <string name=\"app_name\">"
                        + "IT487 Learning Hub</string>\n"
                        + "    <string name=\"welcome_message\">"
                        + "Welcome to Android</string>\n"
                        + "</resources>\n\n"

                        + "// File: res/layout/activity_main.xml\n"
                        + "// Example TextView attribute:\n\n"

                        + "android:text=\"@string/welcome_message\"\n\n"

                        + "// File: app/build.gradle.kts\n"
                        + "// Illustrative Gradle DSL excerpt:\n\n"

                        + "android {\n"
                        + "    namespace = \"com.example."
                        + "it487learninghub\"\n"
                        + "    compileSdk = 35\n\n"

                        + "    defaultConfig {\n"
                        + "        minSdk = 24\n"
                        + "        targetSdk = 35\n"
                        + "    }\n"
                        + "}";

        String codeExplanation =
                "This example shows three separate "
                        + "project file excerpts.\n\n"

                        + "The strings.xml resource stores "
                        + "reusable application text.\n\n"

                        + "A TextView can display the string "
                        + "using @string/welcome_message.\n\n"

                        + "The Gradle excerpt illustrates "
                        + "namespace and SDK configuration "
                        + "in Kotlin DSL.\n\n"

                        + "The SDK numbers are examples "
                        + "and are not instructions to "
                        + "change your current project.\n\n"

                        + "Each excerpt belongs in its "
                        + "corresponding file; the combined "
                        + "example is not intended to be "
                        + "pasted into one source file.";

        String question =
                "How can an Android XML layout "
                        + "reference a string defined in "
                        + "res/values/strings.xml?";

        String[] options = {
                "Using @string/resource_name",
                "Using @java/resource_name",
                "Using @gradle/resource_name",
                "Using @manifest/resource_name"
        };

        String answerExplanation =
                "Android XML layouts use the "
                        + "@string/ prefix to reference "
                        + "string resources, such as "
                        + "@string/welcome_message.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                0,
                answerExplanation
        );
    }
}
