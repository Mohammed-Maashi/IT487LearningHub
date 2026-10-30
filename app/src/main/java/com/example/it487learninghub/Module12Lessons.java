package com.example.it487learninghub;

public final class Module12Lessons {

    // Prevent creating instances of this class
    private Module12Lessons() {
    }

    // =====================================
    // GET MODULE 12 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return settingUpReactNative();

            case 2:
                return creatingProjectsWithExpo();

            case 3:
                return testingWithExpoSnack();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Setting Up React Native
    // =====================================

    private static LessonContent settingUpReactNative() {

        String summary =
                "Learn how to prepare a development "
                        + "environment for React Native, "
                        + "including Node.js, development "
                        + "tools, emulators, and Expo.";

        String explanation =
                "React Native allows developers "
                        + "to create applications for "
                        + "Android and iOS using React "
                        + "and JavaScript or TypeScript.\n\n"

                        + "DEVELOPMENT ENVIRONMENT:\n"
                        + "Before building a mobile app, "
                        + "developers must prepare "
                        + "the required development tools.\n\n"

                        + "NODE.JS:\n"
                        + "Node.js provides the JavaScript "
                        + "runtime used by many React Native "
                        + "development tools.\n\n"

                        + "The Node.js LTS release is "
                        + "generally a suitable choice, "
                        + "subject to the requirements "
                        + "of the selected Expo SDK.\n\n"

                        + "NPM:\n"
                        + "npm is commonly installed "
                        + "alongside Node.js and helps "
                        + "manage project dependencies.\n\n"

                        + "CODE EDITOR:\n"
                        + "Visual Studio Code can be used "
                        + "to write JavaScript, TypeScript, "
                        + "and React Native components.\n\n"

                        + "ANDROID STUDIO:\n"
                        + "Android Studio provides "
                        + "Android development tools "
                        + "and an Android Emulator.\n\n"

                        + "An emulator allows a developer "
                        + "to test a mobile application "
                        + "without using a physical device.\n\n"

                        + "IOS DEVELOPMENT:\n"
                        + "On a compatible Mac, Xcode "
                        + "provides tools for building "
                        + "and testing iOS applications.\n\n"

                        + "EXPO:\n"
                        + "Expo provides development "
                        + "tools and services for "
                        + "React Native applications.\n\n"

                        + "Developers can create "
                        + "a project using "
                        + "create-expo-app.\n\n"

                        + "EXPO GO:\n"
                        + "Expo Go can run compatible "
                        + "Expo applications on "
                        + "supported physical devices.\n\n"

                        + "Applications requiring "
                        + "custom native code may need "
                        + "a development build instead.\n\n"

                        + "METRO:\n"
                        + "Metro is the JavaScript bundler "
                        + "commonly used by React Native.\n\n"

                        + "It prepares JavaScript modules "
                        + "for the running application.\n\n"

                        + "VERIFYING THE ENVIRONMENT:\n"
                        + "Developers should verify "
                        + "that Node.js and npm are "
                        + "installed before creating "
                        + "a new project.\n\n"

                        + "DEVICE TESTING:\n"
                        + "A React Native application "
                        + "can be tested using "
                        + "a compatible emulator, "
                        + "simulator, or physical device.";

        String takeaway =
                "A React Native development "
                        + "environment commonly includes "
                        + "Node.js, npm, a code editor, "
                        + "and a suitable testing device. "
                        + "Expo simplifies project setup "
                        + "and development workflows.";

        String code =
                "# Terminal commands\n"
                        + "# Check installed tools\n\n"

                        + "node --version\n"
                        + "npm --version\n\n"

                        + "# Create a new Expo project\n"
                        + "# using the blank template\n\n"

                        + "npx create-expo-app@latest IT487Demo "
                        + "--template blank\n\n"

                        + "# Open the project directory\n\n"

                        + "cd IT487Demo\n\n"

                        + "# Start the development server\n\n"

                        + "npx expo start";

        String codeExplanation =
                "The node --version command "
                        + "checks the installed "
                        + "Node.js version.\n\n"

                        + "The npm --version command "
                        + "checks the available "
                        + "npm version.\n\n"

                        + "npx create-expo-app@latest "
                        + "creates a new Expo project.\n\n"

                        + "The --template blank option "
                        + "selects a minimal project "
                        + "template suitable for "
                        + "a beginner example.\n\n"

                        + "cd IT487Demo changes "
                        + "the terminal's working "
                        + "directory to the project.\n\n"

                        + "npx expo start starts "
                        + "the Expo development server.\n\n"

                        + "The terminal then provides "
                        + "instructions for opening "
                        + "the application on a "
                        + "supported device or emulator.\n\n"

                        + "These commands are intended "
                        + "for a computer terminal. "
                        + "They are displayed as "
                        + "educational material in "
                        + "IT487 Learning Hub and are "
                        + "not executed by this app.";

        String question =
                "Which tool provides the "
                        + "JavaScript runtime commonly "
                        + "needed by React Native "
                        + "development tools?";

        String[] options = {
                "SQLite",
                "Node.js",
                "AndroidManifest.xml",
                "ConstraintLayout"
        };

        String answerExplanation =
                "Node.js provides the JavaScript "
                        + "runtime used by tools "
                        + "such as npm and Expo CLI. "
                        + "It is commonly required "
                        + "during React Native "
                        + "project development.";

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
    // Creating Projects with Expo
    // =====================================

    private static LessonContent creatingProjectsWithExpo() {

        String summary =
                "Learn how to create an Expo "
                        + "application, understand "
                        + "its basic files, and "
                        + "build an interactive "
                        + "React Native interface.";

        String explanation =
                "Expo is a framework and "
                        + "development platform "
                        + "built around React Native.\n\n"

                        + "WHY USE EXPO:\n"
                        + "Expo simplifies many "
                        + "common mobile development "
                        + "tasks, including project "
                        + "creation and testing.\n\n"

                        + "PROJECT CREATION:\n"
                        + "A new project can be "
                        + "created using the "
                        + "create-expo-app command.\n\n"

                        + "PROJECT TEMPLATES:\n"
                        + "Expo supports different "
                        + "project templates.\n\n"

                        + "Templates determine "
                        + "the initial project "
                        + "structure and installed "
                        + "development features.\n\n"

                        + "BLANK TEMPLATE:\n"
                        + "The blank JavaScript "
                        + "template provides "
                        + "a minimal starting point "
                        + "for learning React Native.\n\n"

                        + "APP.JS:\n"
                        + "In a blank JavaScript "
                        + "project, App.js typically "
                        + "defines the application's "
                        + "main interface component.\n\n"

                        + "OTHER PROJECT STRUCTURES:\n"
                        + "Projects using Expo Router "
                        + "organize screens with "
                        + "file-based routes instead "
                        + "of relying only on App.js.\n\n"

                        + "PACKAGE.JSON:\n"
                        + "package.json lists "
                        + "project dependencies, "
                        + "scripts, and metadata.\n\n"

                        + "APP CONFIGURATION:\n"
                        + "app.json or another "
                        + "supported configuration "
                        + "file stores application "
                        + "settings such as its name.\n\n"

                        + "COMPONENTS:\n"
                        + "React Native applications "
                        + "use components such as "
                        + "View, Text, and Pressable.\n\n"

                        + "STATE:\n"
                        + "The useState Hook can "
                        + "manage changing values "
                        + "within an interactive "
                        + "component.\n\n"

                        + "STYLES:\n"
                        + "StyleSheet.create() "
                        + "organizes style definitions "
                        + "for mobile components.\n\n"

                        + "STARTING THE PROJECT:\n"
                        + "The npx expo start command "
                        + "starts the development server.\n\n"

                        + "FAST REFRESH:\n"
                        + "Fast Refresh can update "
                        + "a running application "
                        + "after many source "
                        + "code changes.\n\n"

                        + "DEVELOPMENT BUILDS:\n"
                        + "More advanced applications "
                        + "may require development "
                        + "builds to include "
                        + "custom native modules.\n\n"

                        + "PRACTICAL GOAL:\n"
                        + "A beginner Expo project "
                        + "should demonstrate "
                        + "a working interface "
                        + "and user interaction.";

        String takeaway =
                "create-expo-app creates "
                        + "a React Native project. "
                        + "A blank template provides "
                        + "a simple starting point, "
                        + "and Expo development tools "
                        + "help developers run "
                        + "and test their applications.";

        String code =
                "// Expo blank JavaScript project\n"
                        + "// File: App.js\n\n"

                        + "import React, { useState } "
                        + "from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Pressable,\n"
                        + "    StyleSheet\n"
                        + "} from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    const [lessons, setLessons] = "
                        + "useState(0);\n\n"

                        + "    const addLesson = () => {\n"
                        + "        setLessons(previous => previous + 1);\n"
                        + "    };\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                My Learning App\n"
                        + "            </Text>\n\n"

                        + "            <Text style={styles.info}>\n"
                        + "                Lessons completed: {lessons}\n"
                        + "            </Text>\n\n"

                        + "            <Pressable\n"
                        + "                style={styles.button}\n"
                        + "                onPress={addLesson}\n"
                        + "            >\n"
                        + "                <Text style={styles.buttonText}>\n"
                        + "                    Complete Lesson\n"
                        + "                </Text>\n"
                        + "            </Pressable>\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n\n"

                        + "    container: {\n"
                        + "        flex: 1,\n"
                        + "        justifyContent: 'center',\n"
                        + "        alignItems: 'center',\n"
                        + "        padding: 24,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    title: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 26,\n"
                        + "        fontWeight: 'bold',\n"
                        + "        marginBottom: 16\n"
                        + "    },\n\n"

                        + "    info: {\n"
                        + "        color: '#AAB8CF',\n"
                        + "        fontSize: 17,\n"
                        + "        marginBottom: 24\n"
                        + "    },\n\n"

                        + "    button: {\n"
                        + "        backgroundColor: '#728BFF',\n"
                        + "        padding: 16,\n"
                        + "        borderRadius: 12\n"
                        + "    },\n\n"

                        + "    buttonText: {\n"
                        + "        color: '#FFFFFF',\n"
                        + "        fontWeight: 'bold'\n"
                        + "    }\n"
                        + "});";

        String codeExplanation =
                "This example defines "
                        + "the main component "
                        + "of a simple Expo app.\n\n"

                        + "App is a React "
                        + "function component.\n\n"

                        + "useState(0) creates "
                        + "a local counter "
                        + "for completed lessons.\n\n"

                        + "View provides the "
                        + "main layout container.\n\n"

                        + "Text displays "
                        + "the app title "
                        + "and lesson count.\n\n"

                        + "Pressable responds "
                        + "to user interaction "
                        + "through onPress.\n\n"

                        + "The addLesson function "
                        + "updates the counter "
                        + "using its previous value.\n\n"

                        + "StyleSheet.create() "
                        + "defines colors, "
                        + "spacing, and alignment.\n\n"

                        + "This example is "
                        + "compatible with "
                        + "a suitable Expo blank "
                        + "JavaScript project.\n\n"

                        + "The counter is "
                        + "temporary local state. "
                        + "It does not save "
                        + "lesson progress "
                        + "to a database.";

        String question =
                "Which command is commonly "
                        + "used to start the "
                        + "development server "
                        + "inside an Expo project?";

        String[] options = {
                "gradle clean",
                "sqlite3 start",
                "npx expo start",
                "javac App.js"
        };

        String answerExplanation =
                "npx expo start starts "
                        + "the Expo development server "
                        + "for the current project. "
                        + "It provides options for "
                        + "running the application "
                        + "on supported devices.";

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
    // Testing with Expo Snack
    // =====================================

    private static LessonContent testingWithExpoSnack() {

        String summary =
                "Discover how Expo Snack "
                        + "can be used to write, "
                        + "preview, test, and share "
                        + "small React Native examples "
                        + "through a web browser.";

        String explanation =
                "Expo Snack is an online "
                        + "environment for creating "
                        + "and experimenting with "
                        + "React Native applications.\n\n"

                        + "BROWSER-BASED DEVELOPMENT:\n"
                        + "Snack allows developers "
                        + "to edit React Native "
                        + "code using a browser.\n\n"

                        + "QUICK EXPERIMENTS:\n"
                        + "Snack is useful for "
                        + "learning components, "
                        + "testing interface ideas, "
                        + "and sharing examples.\n\n"

                        + "GETTING STARTED:\n"
                        + "Open snack.expo.dev "
                        + "in a web browser.\n\n"

                        + "APP.JS:\n"
                        + "A typical Snack "
                        + "provides an App.js "
                        + "file containing the "
                        + "main React Native "
                        + "component.\n\n"

                        + "LIVE PREVIEW:\n"
                        + "Snack can display "
                        + "the running interface "
                        + "through supported "
                        + "web or device previews.\n\n"

                        + "PHYSICAL DEVICE TESTING:\n"
                        + "A compatible device "
                        + "and Expo Go can be "
                        + "used to open supported "
                        + "Snack projects.\n\n"

                        + "QR CODE:\n"
                        + "When the option is "
                        + "available, a QR code "
                        + "can help open "
                        + "the project on "
                        + "a physical device.\n\n"

                        + "WEB PREVIEW:\n"
                        + "Web previews are useful "
                        + "for quick experiments "
                        + "but do not reproduce "
                        + "every native behavior.\n\n"

                        + "PLATFORM DIFFERENCES:\n"
                        + "Android, iOS, and web "
                        + "can behave differently "
                        + "for certain features.\n\n"

                        + "DEPENDENCIES:\n"
                        + "Snack supports many "
                        + "commonly used "
                        + "JavaScript packages "
                        + "and compatible "
                        + "Expo modules.\n\n"

                        + "LIMITATIONS:\n"
                        + "Snack is not a replacement "
                        + "for every local development "
                        + "or native build workflow.\n\n"

                        + "Applications needing "
                        + "custom native code "
                        + "may require a "
                        + "development build "
                        + "or a local project.\n\n"

                        + "SHARING PROJECTS:\n"
                        + "A saved Snack can "
                        + "be shared using "
                        + "its generated link.\n\n"

                        + "TESTING STRATEGY:\n"
                        + "Developers should test "
                        + "button interactions, "
                        + "layout behavior, and "
                        + "text updates.\n\n"

                        + "ERROR CHECKING:\n"
                        + "Syntax errors and "
                        + "runtime messages "
                        + "can help identify "
                        + "problems in the code.\n\n"

                        + "PRACTICAL BENEFIT:\n"
                        + "Snack helps students "
                        + "experiment with "
                        + "React Native without "
                        + "first building "
                        + "a complete native "
                        + "development environment.";

        String takeaway =
                "Expo Snack offers "
                        + "a convenient browser-based "
                        + "environment for small "
                        + "React Native projects. "
                        + "It supports interactive "
                        + "experiments, previews, "
                        + "and project sharing.";

        String code =
                "// Expo Snack example\n"
                        + "// File: App.js\n\n"

                        + "import React, { useState } "
                        + "from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Button,\n"
                        + "    StyleSheet\n"
                        + "} from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    const [message, setMessage] = "
                        + "useState('Ready to learn');\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                IT487 Snack Demo\n"
                        + "            </Text>\n\n"

                        + "            <Text style={styles.message}>\n"
                        + "                {message}\n"
                        + "            </Text>\n\n"

                        + "            <Button\n"
                        + "                title=\"Start Learning\"\n"
                        + "                onPress={() =>\n"
                        + "                    setMessage('Learning started!')\n"
                        + "                }\n"
                        + "            />\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n\n"

                        + "    container: {\n"
                        + "        flex: 1,\n"
                        + "        justifyContent: 'center',\n"
                        + "        alignItems: 'center',\n"
                        + "        padding: 20,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    title: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 24,\n"
                        + "        fontWeight: 'bold',\n"
                        + "        marginBottom: 20\n"
                        + "    },\n\n"

                        + "    message: {\n"
                        + "        color: '#AAB8CF',\n"
                        + "        fontSize: 18,\n"
                        + "        marginBottom: 20\n"
                        + "    }\n"
                        + "});";

        String codeExplanation =
                "This example can be "
                        + "used in a compatible "
                        + "Expo Snack project.\n\n"

                        + "App is the main "
                        + "React Native component.\n\n"

                        + "useState() manages "
                        + "the message displayed "
                        + "on the screen.\n\n"

                        + "Initially, the message "
                        + "is Ready to learn.\n\n"

                        + "The Button component "
                        + "provides a press action.\n\n"

                        + "When Start Learning "
                        + "is pressed, setMessage() "
                        + "updates the state.\n\n"

                        + "The displayed message "
                        + "changes to "
                        + "Learning started!\n\n"

                        + "StyleSheet.create() "
                        + "defines the layout "
                        + "and text appearance.\n\n"

                        + "To experiment, students "
                        + "can open Expo Snack, "
                        + "replace its App.js "
                        + "example with this "
                        + "JavaScript code, and "
                        + "use an available preview.\n\n"

                        + "This code is displayed "
                        + "inside IT487 Learning Hub "
                        + "for educational purposes. "
                        + "It does not run directly "
                        + "inside the Android Java app.";

        String question =
                "What is the main advantage "
                        + "of Expo Snack for "
                        + "students learning "
                        + "React Native?";

        String[] options = {
                "It allows quick React Native experiments in a browser",
                "It replaces JavaScript with SQL",
                "It automatically publishes every app",
                "It removes the need for all device testing"
        };

        String answerExplanation =
                "Expo Snack allows students "
                        + "to write and preview "
                        + "small React Native "
                        + "projects through a browser. "
                        + "It is useful for learning, "
                        + "testing simple ideas, "
                        + "and sharing examples.";

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
