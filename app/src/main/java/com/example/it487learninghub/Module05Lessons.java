package com.example.it487learninghub;

public final class Module05Lessons {

    // Prevent creating instances of this class
    private Module05Lessons() {
    }

    // Return the lesson requested from Module 05
    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {
            case 1:
                return getIntroductionToActivitiesLesson();

            case 2:
                return getActivityLifecycleMethodsLesson();

            case 3:
                return getHandlingLifecycleChangesLesson();

            default:
                return null;
        }
    }

    // =====================================
    // MODULE 05 - LESSON 01
    // Introduction to Activities
    // =====================================

    private static LessonContent
    getIntroductionToActivitiesLesson() {

        String summary =
                "Learn what an Android Activity is, "
                        + "how it displays a user interface, "
                        + "and how Activities work together "
                        + "inside an application.";

        String explanation =
                "An Activity is an Android application "
                        + "component that provides an entry point "
                        + "for user interaction. An Activity "
                        + "typically manages a screen or a major "
                        + "part of the application's interface.\n\n"

                        + "For example, a learning application "
                        + "might use MainActivity to display "
                        + "its home dashboard and another "
                        + "Activity to display lesson details.\n\n"

                        + "ACTIVITY CLASS:\n"
                        + "In a Java Android project, an Activity "
                        + "can extend AppCompatActivity. This "
                        + "provides compatibility features and "
                        + "support for modern Android interfaces.\n\n"

                        + "ONCREATE METHOD:\n"
                        + "The onCreate() method is called when "
                        + "an Activity is being created. "
                        + "Developers commonly use it to "
                        + "initialize components, prepare data, "
                        + "and display the interface.\n\n"

                        + "SETCONTENTVIEW:\n"
                        + "The setContentView() method connects "
                        + "an Activity to a layout resource, "
                        + "such as activity_main.xml.\n\n"

                        + "NAVIGATION:\n"
                        + "An explicit Intent can be used to "
                        + "start another Activity inside the "
                        + "same application. The target Activity "
                        + "must be declared in the app manifest.\n\n"

                        + "A single Android application can "
                        + "contain multiple Activities, each "
                        + "responsible for its own user "
                        + "interaction and lifecycle.";

        String takeaway =
                "An Activity manages an entry point "
                        + "for user interaction. "
                        + "onCreate() commonly initializes "
                        + "the Activity, setContentView() "
                        + "displays its layout, and an Intent "
                        + "can start another Activity.";

        String code =
                "public class MainActivity "
                        + "extends AppCompatActivity {\n\n"

                        + "    @Override\n"
                        + "    protected void onCreate(\n"
                        + "            Bundle savedInstanceState) {\n\n"

                        + "        super.onCreate(savedInstanceState);\n\n"

                        + "        setContentView(\n"
                        + "                R.layout.activity_main\n"
                        + "        );\n"
                        + "    }\n\n"

                        + "    private void openDetails() {\n\n"

                        + "        Intent intent = new Intent(\n"
                        + "                this,\n"
                        + "                DetailsActivity.class\n"
                        + "        );\n\n"

                        + "        startActivity(intent);\n"
                        + "    }\n"
                        + "}";

        String codeExplanation =
                "This example illustrates the basic "
                        + "structure of an Android Activity.\n\n"

                        + "MainActivity extends AppCompatActivity.\n\n"

                        + "onCreate() calls the parent "
                        + "implementation and displays "
                        + "activity_main.xml using setContentView().\n\n"

                        + "The openDetails() method creates "
                        + "an explicit Intent and starts "
                        + "DetailsActivity.\n\n"

                        + "For a complete project, the required "
                        + "Java imports and a declared "
                        + "DetailsActivity must also exist.";

        String practiceQuestion =
                "Which Android method is commonly used "
                        + "to connect an Activity with its "
                        + "XML layout?";

        String[] options = {
                "findViewById()",
                "setContentView()",
                "finish()",
                "startActivity()"
        };

        int correctAnswerIndex = 1;

        String answerExplanation =
                "setContentView() sets the Activity's "
                        + "interface using a layout resource. "
                        + "For example, "
                        + "setContentView(R.layout.activity_main) "
                        + "displays the layout defined in "
                        + "activity_main.xml.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                practiceQuestion,
                options,
                correctAnswerIndex,
                answerExplanation
        );
    }

    // =====================================
    // MODULE 05 - LESSON 02
    // Activity Lifecycle Methods
    // =====================================

    private static LessonContent
    getActivityLifecycleMethodsLesson() {

        String summary =
                "Explore the main lifecycle callbacks "
                        + "used by Android Activities.";

        String explanation =
                "An Android Activity moves through "
                        + "different lifecycle states.\n\n"

                        + "onCreate() initializes the Activity "
                        + "and its interface.\n\n"

                        + "onStart() is called when the Activity "
                        + "becomes visible.\n\n"

                        + "onResume() is called when the Activity "
                        + "enters the foreground and is ready "
                        + "for user interaction.\n\n"

                        + "onPause() occurs when the Activity "
                        + "loses focus, while onStop() occurs "
                        + "when it is no longer visible.";

        String takeaway =
                "Lifecycle callbacks allow developers "
                        + "to manage resources and respond "
                        + "to changes in Activity state.";

        String code =
                "@Override\n"
                        + "protected void onCreate("
                        + "Bundle savedInstanceState) {\n"

                        + "    super.onCreate(savedInstanceState);\n"

                        + "    setContentView("
                        + "R.layout.activity_main);\n"

                        + "}\n\n"

                        + "@Override\n"

                        + "protected void onResume() {\n"

                        + "    super.onResume();\n"

                        + "}";

        String codeExplanation =
                "The onCreate() callback initializes "
                        + "the Activity. The onResume() "
                        + "callback runs when it enters "
                        + "the foreground.";

        String practiceQuestion =
                "Which callback is called when an Activity "
                        + "enters the foreground and becomes "
                        + "ready for user interaction?";

        String[] options = {
                "onCreate()",
                "onStart()",
                "onResume()",
                "onStop()"
        };

        int correctAnswerIndex = 2;

        String answerExplanation =
                "onResume() runs when an Activity "
                        + "enters the foreground and "
                        + "is ready for interaction.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                practiceQuestion,
                options,
                correctAnswerIndex,
                answerExplanation
        );
    }

    // =====================================
    // MODULE 05 - LESSON 03
    // Handling Lifecycle Changes
    // =====================================

    private static LessonContent
    getHandlingLifecycleChangesLesson() {

        String summary =
                "Learn how Android Activities respond "
                        + "to configuration changes, preserve "
                        + "temporary interface state, and "
                        + "restore data after recreation.";

        String explanation =
                "Android Activities can change state "
                        + "when the user rotates the device, "
                        + "switches applications, or navigates "
                        + "between screens.\n\n"

                        + "CONFIGURATION CHANGES:\n"
                        + "A screen rotation is a common "
                        + "configuration change. By default, "
                        + "Android typically destroys and "
                        + "recreates the Activity so it can "
                        + "load resources for the new "
                        + "configuration.\n\n"

                        + "TEMPORARY UI STATE:\n"
                        + "Suppose the user has increased a "
                        + "counter to 5. If the Activity is "
                        + "recreated, the value could be lost "
                        + "unless the application restores it.\n\n"

                        + "ONSAVEINSTANCESTATE:\n"
                        + "The onSaveInstanceState() callback "
                        + "allows an Activity to save small "
                        + "pieces of temporary UI state "
                        + "inside a Bundle.\n\n"

                        + "RESTORING STATE:\n"
                        + "When saved state is available, "
                        + "onCreate() can read values from "
                        + "savedInstanceState. An Activity can "
                        + "also restore state in "
                        + "onRestoreInstanceState().\n\n"

                        + "LONG-TERM DATA:\n"
                        + "A Bundle is not a replacement for "
                        + "persistent storage. Important "
                        + "information, such as completed "
                        + "lessons, saved notes, or quiz results, "
                        + "should be stored using persistent "
                        + "solutions such as SQLite.\n\n"

                        + "VIEWMODEL:\n"
                        + "A ViewModel can keep UI-related "
                        + "data available across configuration "
                        + "changes, while saved instance state "
                        + "helps restore small values when "
                        + "an Activity is recreated.\n\n"

                        + "LIFECYCLE SAFETY:\n"
                        + "Developers should manage resources "
                        + "according to lifecycle events. "
                        + "They must not depend on onDestroy() "
                        + "being called in every situation, "
                        + "because Android may terminate "
                        + "an application's process.";

        String takeaway =
                "Use savedInstanceState for small "
                        + "temporary UI values, consider "
                        + "ViewModel for UI state across "
                        + "configuration changes, and use "
                        + "persistent storage such as SQLite "
                        + "for information that must remain "
                        + "available after restarting the app.";

        String code =
                "private int counter = 0;\n\n"

                        + "@Override\n"
                        + "protected void onCreate(\n"
                        + "        Bundle savedInstanceState) {\n\n"

                        + "    super.onCreate(savedInstanceState);\n"

                        + "    setContentView(\n"
                        + "            R.layout.activity_main\n"
                        + "    );\n\n"

                        + "    if (savedInstanceState != null) {\n"

                        + "        counter = savedInstanceState.getInt(\n"
                        + "                \"counter\",\n"
                        + "                0\n"
                        + "        );\n"

                        + "    }\n"
                        + "}\n\n"

                        + "@Override\n"
                        + "protected void onSaveInstanceState(\n"
                        + "        Bundle outState) {\n\n"

                        + "    outState.putInt(\n"
                        + "            \"counter\",\n"
                        + "            counter\n"
                        + "    );\n\n"

                        + "    super.onSaveInstanceState(outState);\n"
                        + "}";

        String codeExplanation =
                "This example shows lifecycle state "
                        + "preservation inside an Activity.\n\n"

                        + "The counter variable stores "
                        + "a temporary integer value.\n\n"

                        + "Before certain Activity recreation "
                        + "events, onSaveInstanceState() saves "
                        + "the counter inside a Bundle.\n\n"

                        + "When the Activity is recreated, "
                        + "onCreate() checks whether saved "
                        + "state is available and restores "
                        + "the previous counter value.\n\n"

                        + "The example is an Activity code "
                        + "excerpt. It assumes the surrounding "
                        + "Activity class and necessary "
                        + "Android imports already exist.";

        String practiceQuestion =
                "Which Android mechanism is designed "
                        + "to preserve small temporary UI "
                        + "values when an Activity is recreated?";

        String[] options = {
                "An Intent filter",
                "The AndroidManifest.xml file",
                "A layout margin",
                "The savedInstanceState Bundle"
        };

        int correctAnswerIndex = 3;

        String answerExplanation =
                "The savedInstanceState Bundle can "
                        + "store small temporary values "
                        + "through onSaveInstanceState(). "
                        + "These values can then be restored "
                        + "when the Activity is recreated. "
                        + "Permanent application data should "
                        + "be stored separately.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                practiceQuestion,
                options,
                correctAnswerIndex,
                answerExplanation
        );
    }
}
