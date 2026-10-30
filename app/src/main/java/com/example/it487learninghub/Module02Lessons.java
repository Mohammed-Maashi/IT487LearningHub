package com.example.it487learninghub;

public final class Module02Lessons {

    // Prevent creating objects of this class
    private Module02Lessons() {
    }

    // =====================================
    // GET MODULE 02 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return introductionToAndroid();

            case 2:
                return javaEssentials();

            case 3:
                return xmlInAndroid();

            case 4:
                return androidDevelopmentEnvironment();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Introduction to Android
    // =====================================

    private static LessonContent introductionToAndroid() {

        String summary =
                "Discover the Android platform, "
                        + "its application components, "
                        + "and the foundations of "
                        + "Android application development.";

        String explanation =
                "Android is an operating system "
                        + "used on smartphones, tablets, "
                        + "and many other devices.\n\n"

                        + "ANDROID APPLICATIONS:\n"
                        + "Android applications allow users "
                        + "to perform tasks such as messaging, "
                        + "learning, shopping, and navigation.\n\n"

                        + "APPLICATION COMPONENTS:\n"
                        + "Android provides several important "
                        + "application components.\n\n"

                        + "Activities provide entry points "
                        + "for user interaction.\n\n"

                        + "Services support certain operations "
                        + "that can continue without "
                        + "a visible interface.\n\n"

                        + "Broadcast Receivers respond "
                        + "to broadcast messages.\n\n"

                        + "Content Providers manage and "
                        + "share structured application data "
                        + "through defined interfaces.\n\n"

                        + "JAVA AND KOTLIN:\n"
                        + "Android applications can be "
                        + "developed using Java or Kotlin. "
                        + "Both can interact with "
                        + "Android framework APIs.\n\n"

                        + "USER INTERFACES:\n"
                        + "In a traditional Android Views "
                        + "application, XML can define "
                        + "the interface while Java "
                        + "implements application behavior.\n\n"

                        + "ANDROID SDK:\n"
                        + "The Android Software Development Kit "
                        + "provides tools and APIs needed "
                        + "to build Android applications.\n\n"

                        + "ANDROID STUDIO:\n"
                        + "Android Studio is the official "
                        + "integrated development environment "
                        + "used for Android development.\n\n"

                        + "APPLICATION TESTING:\n"
                        + "Developers can test applications "
                        + "using an Android Emulator "
                        + "or a physical Android device.";

        String takeaway =
                "Android development combines "
                        + "application components, "
                        + "programming languages, "
                        + "user interfaces, SDK tools, "
                        + "and application testing.";

        String code =
                "public class MainActivity\n"
                        + "        extends AppCompatActivity {\n\n"

                        + "    @Override\n"
                        + "    protected void onCreate(\n"
                        + "            Bundle savedInstanceState) {\n\n"

                        + "        super.onCreate(savedInstanceState);\n\n"

                        + "        setContentView(\n"
                        + "                R.layout.activity_main\n"
                        + "        );\n"

                        + "    }\n"
                        + "}";

        String codeExplanation =
                "This Java example shows the "
                        + "basic structure of an "
                        + "Android Activity.\n\n"

                        + "MainActivity extends "
                        + "AppCompatActivity.\n\n"

                        + "The onCreate() callback initializes "
                        + "the Activity when it is created.\n\n"

                        + "setContentView() loads an "
                        + "XML layout resource.\n\n"

                        + "This is an Activity excerpt. "
                        + "A complete project also needs "
                        + "the necessary imports, layout "
                        + "resource, and manifest declaration.";

        String question =
                "Which Android component commonly "
                        + "provides an entry point "
                        + "for user interaction?";

        String[] options = {
                "Activity",
                "Gradle Wrapper",
                "Drawable Resource",
                "SQLite Cursor"
        };

        String answerExplanation =
                "An Activity is an application "
                        + "component that provides "
                        + "an entry point for users "
                        + "to interact with an Android app.";

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

    // =====================================
    // LESSON 02
    // Java Essentials for Android
    // =====================================

    private static LessonContent javaEssentials() {

        String summary =
                "Understand Java variables, "
                        + "data types, conditions, methods, "
                        + "classes, and objects used "
                        + "in Android development.";

        String explanation =
                "Java is an object-oriented "
                        + "programming language supported "
                        + "by the Android development tools.\n\n"

                        + "VARIABLES:\n"
                        + "Variables store values used "
                        + "during program execution.\n\n"

                        + "For example, int score = 80 "
                        + "stores an integer value.\n\n"

                        + "DATA TYPES:\n"
                        + "Common Java types include "
                        + "int, double, boolean, char, "
                        + "and String.\n\n"

                        + "CONDITIONAL STATEMENTS:\n"
                        + "if and else statements allow "
                        + "a program to make decisions "
                        + "based on conditions.\n\n"

                        + "LOOPS:\n"
                        + "for and while loops repeat "
                        + "operations while certain "
                        + "conditions are satisfied.\n\n"

                        + "METHODS:\n"
                        + "Methods group reusable logic "
                        + "and may receive parameters "
                        + "or return a value.\n\n"

                        + "CLASSES AND OBJECTS:\n"
                        + "A class defines a type that "
                        + "can contain fields and methods.\n\n"

                        + "An object is an instance "
                        + "of a class.\n\n"

                        + "INHERITANCE:\n"
                        + "Java supports inheritance "
                        + "using the extends keyword.\n\n"

                        + "For example, MainActivity can "
                        + "extend AppCompatActivity.\n\n"

                        + "EVENT HANDLING:\n"
                        + "Android Java code can respond "
                        + "to user actions through "
                        + "listeners and callbacks.\n\n"

                        + "STRING COMPARISON:\n"
                        + "Use equals() to compare "
                        + "the contents of two Strings, "
                        + "instead of relying on ==.";

        String takeaway =
                "Java fundamentals such as variables, "
                        + "conditions, loops, methods, "
                        + "classes, and inheritance "
                        + "form the foundation of "
                        + "Android application logic.";

        String code =
                "public class StudentProgress {\n\n"

                        + "    private int score;\n\n"

                        + "    public StudentProgress(int score) {\n"
                        + "        this.score = score;\n"
                        + "    }\n\n"

                        + "    public boolean hasPassed() {\n"
                        + "        return score >= 60;\n"
                        + "    }\n\n"

                        + "    public String getStatus() {\n\n"

                        + "        if (hasPassed()) {\n"
                        + "            return \"Passed\";\n"
                        + "        } else {\n"
                        + "            return \"Needs Practice\";\n"
                        + "        }\n"
                        + "    }\n"
                        + "}";

        String codeExplanation =
                "StudentProgress is a Java class "
                        + "that represents a student's score.\n\n"

                        + "The constructor receives the score "
                        + "and stores it in a private field.\n\n"

                        + "hasPassed() returns true when "
                        + "the score is at least 60.\n\n"

                        + "getStatus() uses an if/else "
                        + "statement to return a message.\n\n"

                        + "This example demonstrates "
                        + "encapsulation, methods, "
                        + "boolean values, and conditions.";

        String question =
                "Which Java data type stores "
                        + "a value that is either "
                        + "true or false?";

        String[] options = {
                "int",
                "String",
                "boolean",
                "double"
        };

        String answerExplanation =
                "The boolean data type "
                        + "stores one of two values: "
                        + "true or false.";

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
    // XML in Android Applications
    // =====================================

    private static LessonContent xmlInAndroid() {

        String summary =
                "Learn how XML describes Android "
                        + "user interfaces and how "
                        + "Java code interacts with "
                        + "interface components.";

        String explanation =
                "XML stands for Extensible "
                        + "Markup Language.\n\n"

                        + "ANDROID XML LAYOUTS:\n"
                        + "Traditional Android Views "
                        + "applications often use XML "
                        + "to describe the structure "
                        + "of their user interfaces.\n\n"

                        + "XML ELEMENTS:\n"
                        + "Elements represent interface "
                        + "components such as LinearLayout, "
                        + "TextView, Button, and EditText.\n\n"

                        + "XML ATTRIBUTES:\n"
                        + "Attributes define component "
                        + "properties such as width, "
                        + "height, text, and orientation.\n\n"

                        + "LAYOUT WIDTH:\n"
                        + "match_parent requests available "
                        + "space from the parent.\n\n"

                        + "wrap_content sizes a view "
                        + "according to its content "
                        + "and layout rules.\n\n"

                        + "LAYOUT ORIENTATION:\n"
                        + "A LinearLayout can arrange "
                        + "child views horizontally "
                        + "or vertically.\n\n"

                        + "RESOURCE IDENTIFIERS:\n"
                        + "android:id assigns a resource "
                        + "identifier to a View.\n\n"

                        + "CONNECTING XML AND JAVA:\n"
                        + "Java code can reference "
                        + "a View using findViewById().\n\n"

                        + "For example, a Button defined "
                        + "in XML can be connected "
                        + "to a Java click listener.\n\n"

                        + "XML NAMESPACES:\n"
                        + "The xmlns:android declaration "
                        + "defines the namespace used "
                        + "for Android attributes.";

        String takeaway =
                "XML defines interface structure "
                        + "and attributes, while Java "
                        + "can control behavior through "
                        + "View references and listeners.";

        String code =
                "<LinearLayout\n"
                        + "    xmlns:android=\"http://schemas."
                        + "android.com/apk/res/android\"\n"

                        + "    android:layout_width=\"match_parent\"\n"
                        + "    android:layout_height=\"match_parent\"\n"
                        + "    android:orientation=\"vertical\"\n"
                        + "    android:padding=\"16dp\">\n\n"

                        + "    <TextView\n"
                        + "        android:layout_width=\"wrap_content\"\n"
                        + "        android:layout_height=\"wrap_content\"\n"
                        + "        android:text=\"Welcome!\" />\n\n"

                        + "    <Button\n"
                        + "        android:id=\"@+id/btnContinue\"\n"
                        + "        android:layout_width=\"match_parent\"\n"
                        + "        android:layout_height=\"wrap_content\"\n"
                        + "        android:text=\"Continue\" />\n\n"

                        + "</LinearLayout>";

        String codeExplanation =
                "This XML layout contains "
                        + "a vertical LinearLayout, "
                        + "a TextView, and a Button.\n\n"

                        + "The orientation attribute "
                        + "places the child views "
                        + "from top to bottom.\n\n"

                        + "The Button has the ID "
                        + "btnContinue.\n\n"

                        + "Java can access the Button "
                        + "after the layout is loaded "
                        + "using findViewById("
                        + "R.id.btnContinue).\n\n"

                        + "The example illustrates "
                        + "the interface structure; "
                        + "the click behavior would "
                        + "be implemented separately "
                        + "in Java.";

        String question =
                "Which XML attribute makes "
                        + "a LinearLayout arrange "
                        + "its child views vertically?";

        String[] options = {
                "android:text=\"vertical\"",
                "android:orientation=\"vertical\"",
                "android:id=\"vertical\"",
                "android:visibility=\"vertical\""
        };

        String answerExplanation =
                "android:orientation=\"vertical\" "
                        + "instructs a LinearLayout "
                        + "to arrange its children "
                        + "in a vertical direction.";

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
    // LESSON 04
    // Android Development Environment
    // =====================================

    private static LessonContent
    androidDevelopmentEnvironment() {

        String summary =
                "Understand the main tools "
                        + "used to develop, build, "
                        + "run, and debug "
                        + "Android applications.";

        String explanation =
                "Android development requires "
                        + "a development environment "
                        + "with tools for writing code, "
                        + "building applications, "
                        + "and testing them.\n\n"

                        + "ANDROID STUDIO:\n"
                        + "Android Studio provides "
                        + "a code editor, visual "
                        + "layout tools, debugging "
                        + "features, and Gradle support.\n\n"

                        + "ANDROID SDK:\n"
                        + "The Android SDK provides "
                        + "platform APIs and tools "
                        + "needed to build "
                        + "Android applications.\n\n"

                        + "SDK MANAGER:\n"
                        + "SDK Manager allows "
                        + "developers to install "
                        + "Android SDK platforms "
                        + "and development tools.\n\n"

                        + "DEVICE MANAGER:\n"
                        + "Device Manager helps "
                        + "developers create and "
                        + "manage Android Virtual Devices.\n\n"

                        + "ANDROID EMULATOR:\n"
                        + "The emulator simulates "
                        + "an Android device "
                        + "on a development computer.\n\n"

                        + "GRADLE:\n"
                        + "Gradle automates application "
                        + "building, dependency management, "
                        + "and packaging.\n\n"

                        + "DEBUGGING:\n"
                        + "Developers can set breakpoints "
                        + "and inspect program execution "
                        + "using the debugger.\n\n"

                        + "LOGCAT:\n"
                        + "Logcat displays logs "
                        + "from Android applications "
                        + "and the system.\n\n"

                        + "ADB:\n"
                        + "Android Debug Bridge, or adb, "
                        + "allows developers to communicate "
                        + "with connected Android devices "
                        + "and emulators.\n\n"

                        + "TESTING WORKFLOW:\n"
                        + "A common workflow is to write "
                        + "code, build the application, "
                        + "run it on a device, inspect "
                        + "errors, and repeat.";

        String takeaway =
                "Android Studio, Android SDK, "
                        + "Gradle, Emulator, Logcat, "
                        + "and adb are essential "
                        + "tools for developing "
                        + "and testing Android apps.";

        String code =
                "# Run from the Android project root\n\n"

                        + "# Build the debug APK\n"
                        + "./gradlew assembleDebug\n\n"

                        + "# List connected devices\n"
                        + "adb devices\n\n"

                        + "# View the debug APK location\n"
                        + "app/build/outputs/apk/debug/app-debug.apk";

        String codeExplanation =
                "This example shows common "
                        + "Android development commands.\n\n"

                        + "./gradlew assembleDebug "
                        + "uses the Gradle Wrapper "
                        + "to build a debug APK.\n\n"

                        + "adb devices displays "
                        + "connected devices "
                        + "and emulators.\n\n"

                        + "The final line shows "
                        + "a common debug APK "
                        + "output path; it is "
                        + "not a terminal command.\n\n"

                        + "These examples assume "
                        + "the development tools "
                        + "are installed and "
                        + "configured correctly.\n\n"

                        + "On macOS, the Gradle command "
                        + "is normally executed "
                        + "from the Android "
                        + "project root directory.";

        String question =
                "Which Android Studio tool "
                        + "is used to create and manage "
                        + "Android Virtual Devices?";

        String[] options = {
                "Logcat",
                "Database Inspector",
                "Device Manager",
                "Layout Inspector"
        };

        String answerExplanation =
                "Device Manager allows "
                        + "developers to create, "
                        + "configure, and manage "
                        + "Android Virtual Devices "
                        + "used by the emulator.";

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
}
