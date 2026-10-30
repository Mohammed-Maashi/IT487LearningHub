package com.example.it487learninghub;

public final class Module10Lessons {

    // Prevent creating repository instances
    private Module10Lessons() {
    }

    // =====================================
    // GET MODULE 10 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return componentProps();

            case 2:
                return stateAndStateUpdates();

            case 3:
                return workingWithContext();

            case 4:
                return propsVsStateVsContext();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Component Props
    // =====================================

    private static LessonContent componentProps() {

        String summary =
                "Understand how React components "
                        + "receive data through props "
                        + "and use them to build reusable "
                        + "user interfaces.";

        String explanation =
                "Props is short for properties.\n\n"

                        + "In React and React Native, "
                        + "props allow a parent component "
                        + "to pass information to "
                        + "a child component.\n\n"

                        + "COMPONENT COMMUNICATION:\n"
                        + "A parent component can supply "
                        + "values such as a title, "
                        + "description, or lesson number "
                        + "to a child component.\n\n"

                        + "REUSABLE COMPONENTS:\n"
                        + "Props make it possible to reuse "
                        + "the same component with "
                        + "different information.\n\n"

                        + "For example, one LessonCard "
                        + "component can display many "
                        + "different lessons.\n\n"

                        + "READ-ONLY PROPS:\n"
                        + "Props are read-only from "
                        + "the receiving component's "
                        + "perspective.\n\n"

                        + "A child component should "
                        + "not directly modify "
                        + "the props it receives.\n\n"

                        + "ONE-WAY DATA FLOW:\n"
                        + "React follows a "
                        + "one-way data flow model.\n\n"

                        + "Information is passed "
                        + "from parent components "
                        + "to their children "
                        + "through props.\n\n"

                        + "DESTRUCTURING:\n"
                        + "JavaScript destructuring "
                        + "can extract individual "
                        + "prop values from "
                        + "the props object.\n\n"

                        + "DEFAULT VALUES:\n"
                        + "Components can define "
                        + "default parameter values "
                        + "when optional props "
                        + "are not provided.\n\n"

                        + "FUNCTION PROPS:\n"
                        + "Props can also contain "
                        + "functions, allowing a "
                        + "child component to "
                        + "notify its parent "
                        + "about user actions.\n\n"

                        + "PRACTICAL EXAMPLE:\n"
                        + "A learning application "
                        + "could provide lessonTitle "
                        + "and lessonDuration props "
                        + "to a LessonCard component.";

        String takeaway =
                "Props pass data from "
                        + "parent components to "
                        + "child components. "
                        + "They support reuse and "
                        + "should be treated as "
                        + "read-only inputs.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React from 'react';\n"
                        + "import { View, Text } from 'react-native';\n\n"

                        + "function LessonCard({ title, duration }) {\n\n"

                        + "    return (\n"
                        + "        <View>\n"
                        + "            <Text>{title}</Text>\n"
                        + "            <Text>{duration} minutes</Text>\n"
                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "export default function App() {\n\n"

                        + "    return (\n"
                        + "        <View>\n\n"

                        + "            <LessonCard\n"
                        + "                title=\"React Fundamentals\"\n"
                        + "                duration={15}\n"
                        + "            />\n\n"

                        + "            <LessonCard\n"
                        + "                title=\"Component Props\"\n"
                        + "                duration={20}\n"
                        + "            />\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "The App component renders "
                        + "two LessonCard components.\n\n"

                        + "Each LessonCard receives "
                        + "a different title "
                        + "and duration through props.\n\n"

                        + "JavaScript destructuring "
                        + "extracts the title "
                        + "and duration values.\n\n"

                        + "The Text components "
                        + "display those values.\n\n"

                        + "The same LessonCard "
                        + "implementation works "
                        + "for multiple lessons.\n\n"

                        + "This is React Native "
                        + "JavaScript and JSX. "
                        + "It is educational content, "
                        + "not code to paste into "
                        + "an Android Java Activity.";

        String question =
                "What is the main purpose "
                        + "of props in React?";

        String[] options = {
                "To create SQLite tables",
                "To pass data from parent to child components",
                "To replace every state variable",
                "To install Android SDK packages"
        };

        String answerExplanation =
                "Props allow parent components "
                        + "to provide data and "
                        + "callbacks to child components. "
                        + "This supports reusable "
                        + "component design.";

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
    // State and State Updates
    // =====================================

    private static LessonContent stateAndStateUpdates() {

        String summary =
                "Learn how React state stores "
                        + "changing component information "
                        + "and how state updates "
                        + "refresh the user interface.";

        String explanation =
                "State represents information "
                        + "that a component remembers "
                        + "between renders.\n\n"

                        + "WHY STATE IS IMPORTANT:\n"
                        + "Interactive applications "
                        + "need to respond when "
                        + "data changes.\n\n"

                        + "Examples include a counter, "
                        + "search text, selected tab, "
                        + "or quiz answer.\n\n"

                        + "THE USESTATE HOOK:\n"
                        + "useState() allows a "
                        + "React function component "
                        + "to manage local state.\n\n"

                        + "INITIAL STATE:\n"
                        + "The argument supplied "
                        + "to useState() determines "
                        + "the initial value.\n\n"

                        + "For example, useState(0) "
                        + "initializes a counter "
                        + "with the value zero.\n\n"

                        + "STATE SETTER:\n"
                        + "useState() returns "
                        + "the current value "
                        + "and a setter function.\n\n"

                        + "The setter requests "
                        + "a state update.\n\n"

                        + "RE-RENDERING:\n"
                        + "When state changes, "
                        + "React can render "
                        + "the component again "
                        + "using the new value.\n\n"

                        + "FUNCTIONAL UPDATES:\n"
                        + "If the next state depends "
                        + "on the previous state, "
                        + "an updater function "
                        + "is recommended.\n\n"

                        + "For example:\n"
                        + "setCount(previous => previous + 1)\n\n"

                        + "IMMUTABILITY:\n"
                        + "State objects and arrays "
                        + "should not be mutated "
                        + "directly.\n\n"

                        + "Instead, create updated "
                        + "objects or arrays "
                        + "when changing state.\n\n"

                        + "ASYNCHRONOUS BEHAVIOR:\n"
                        + "State setters request "
                        + "updates rather than "
                        + "immediately modifying "
                        + "the state variable "
                        + "in running code.\n\n"

                        + "LOCAL STATE:\n"
                        + "State declared in a "
                        + "component normally belongs "
                        + "to that component instance.\n\n"

                        + "PERSISTENCE:\n"
                        + "React state alone does "
                        + "not provide permanent "
                        + "data storage. "
                        + "Persistent data requires "
                        + "a suitable storage solution.";

        String takeaway =
                "Use useState() to manage "
                        + "changing component data. "
                        + "Update state through "
                        + "its setter, and use "
                        + "functional updates when "
                        + "the next value depends "
                        + "on the previous value.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React, { useState } from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Pressable\n"
                        + "} from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    const [completed, setCompleted] =\n"
                        + "        useState(0);\n\n"

                        + "    const completeLesson = () => {\n"
                        + "        setCompleted(previous => previous + 1);\n"
                        + "    };\n\n"

                        + "    const resetProgress = () => {\n"
                        + "        setCompleted(0);\n"
                        + "    };\n\n"

                        + "    return (\n"
                        + "        <View>\n\n"

                        + "            <Text>\n"
                        + "                Completed Lessons: {completed}\n"
                        + "            </Text>\n\n"

                        + "            <Pressable onPress={completeLesson}>\n"
                        + "                <Text>Complete Lesson</Text>\n"
                        + "            </Pressable>\n\n"

                        + "            <Pressable onPress={resetProgress}>\n"
                        + "                <Text>Reset</Text>\n"
                        + "            </Pressable>\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "The component uses "
                        + "useState(0) to initialize "
                        + "the completed counter.\n\n"

                        + "The completed variable "
                        + "contains the current value.\n\n"

                        + "setCompleted() requests "
                        + "state changes.\n\n"

                        + "The completeLesson() function "
                        + "increases the counter "
                        + "using its previous value.\n\n"

                        + "The resetProgress() function "
                        + "sets the counter to zero.\n\n"

                        + "Pressable components "
                        + "handle touch interactions "
                        + "through onPress.\n\n"

                        + "The visible counter changes "
                        + "when React renders "
                        + "the updated state.\n\n"

                        + "This example demonstrates "
                        + "temporary component state. "
                        + "It does not save progress "
                        + "to SQLite and does not "
                        + "reset any data in "
                        + "IT487 Learning Hub.";

        String question =
                "Which approach is recommended "
                        + "when the next React state "
                        + "value depends on "
                        + "the previous value?";

        String[] options = {
                "Modify the state variable directly",
                "Use an Intent",
                "Pass an updater function to the state setter",
                "Edit AndroidManifest.xml"
        };

        String answerExplanation =
                "An updater function receives "
                        + "the previous state and "
                        + "calculates the next value. "
                        + "For example, "
                        + "setCount(previous => previous + 1).";

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
    // Working with Context
    // =====================================

    private static LessonContent workingWithContext() {

        String summary =
                "Understand how React Context "
                        + "shares information across "
                        + "components without passing "
                        + "props through every level.";

        String explanation =
                "React Context allows components "
                        + "to access shared values "
                        + "from an ancestor component.\n\n"

                        + "PROP DRILLING:\n"
                        + "Prop drilling occurs when "
                        + "data is passed through "
                        + "multiple intermediate "
                        + "components even though "
                        + "those components do "
                        + "not need the data.\n\n"

                        + "WHY CONTEXT HELPS:\n"
                        + "Context can reduce "
                        + "unnecessary intermediate "
                        + "prop passing.\n\n"

                        + "COMMON CONTEXT VALUES:\n"
                        + "Context is useful for "
                        + "a theme, selected language, "
                        + "or application-level "
                        + "configuration.\n\n"

                        + "CREATECONTEXT:\n"
                        + "createContext() creates "
                        + "a Context object.\n\n"

                        + "PROVIDER:\n"
                        + "A Context provider supplies "
                        + "a value to components "
                        + "within its subtree.\n\n"

                        + "USECONTEXT:\n"
                        + "useContext() reads the "
                        + "value of the nearest "
                        + "matching provider above "
                        + "the component.\n\n"

                        + "DEFAULT VALUE:\n"
                        + "createContext() accepts "
                        + "a default value that "
                        + "is used when no matching "
                        + "provider exists above "
                        + "the consuming component.\n\n"

                        + "CONTEXT UPDATES:\n"
                        + "When the provider value "
                        + "changes, components that "
                        + "consume that Context "
                        + "may re-render.\n\n"

                        + "CONTEXT AND STATE:\n"
                        + "Context does not replace "
                        + "the useState Hook.\n\n"

                        + "An application can combine "
                        + "useState with Context "
                        + "to share changing values.\n\n"

                        + "PERFORMANCE:\n"
                        + "Context should be used "
                        + "where shared values "
                        + "are genuinely useful. "
                        + "Not every component "
                        + "value needs Context.\n\n"

                        + "IMPORTANT DISTINCTION:\n"
                        + "Context shares information "
                        + "within the React component "
                        + "tree. It is not a "
                        + "permanent database.";

        String takeaway =
                "Use createContext() to create "
                        + "shared Context, a provider "
                        + "to supply its value, "
                        + "and useContext() "
                        + "to access that value "
                        + "from descendant components.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React, {\n"
                        + "    createContext,\n"
                        + "    useContext\n"
                        + "} from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text\n"
                        + "} from 'react-native';\n\n"

                        + "const ThemeContext = createContext('light');\n\n"

                        + "function ThemeInfo() {\n\n"

                        + "    const theme = useContext(ThemeContext);\n\n"

                        + "    return (\n"
                        + "        <Text>Current Theme: {theme}</Text>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "export default function App() {\n\n"

                        + "    return (\n"
                        + "        <ThemeContext.Provider value=\"dark\">\n\n"

                        + "            <View>\n"
                        + "                <ThemeInfo />\n"
                        + "            </View>\n\n"

                        + "        </ThemeContext.Provider>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "createContext('light') "
                        + "creates a Context "
                        + "with a default value.\n\n"

                        + "ThemeContext.Provider "
                        + "supplies the value dark "
                        + "to its descendants.\n\n"

                        + "ThemeInfo calls "
                        + "useContext(ThemeContext) "
                        + "to read the value.\n\n"

                        + "The displayed text becomes "
                        + "Current Theme: dark.\n\n"

                        + "ThemeInfo does not "
                        + "receive a theme prop "
                        + "directly from App.\n\n"

                        + "Context provides access "
                        + "to that shared value "
                        + "through the provider.\n\n"

                        + "This is a simplified "
                        + "React Native example. "
                        + "A complete theme system "
                        + "would also apply "
                        + "appropriate UI styles.";

        String question =
                "Which React Hook allows "
                        + "a component to read "
                        + "a shared Context value?";

        String[] options = {
                "useState",
                "useContext",
                "useDatabase",
                "useActivity"
        };

        String answerExplanation =
                "useContext() allows "
                        + "a component to read "
                        + "the value supplied "
                        + "by the nearest matching "
                        + "Context provider.";

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
    // Props vs State vs Context
    // =====================================

    private static LessonContent
    propsVsStateVsContext() {

        String summary =
                "Compare props, state, and Context "
                        + "to understand when each "
                        + "should be used in "
                        + "React and React Native.";

        String explanation =
                "Props, state, and Context "
                        + "all help React components "
                        + "work with information, "
                        + "but each has a "
                        + "different responsibility.\n\n"

                        + "PROPS:\n"
                        + "Props are inputs "
                        + "received by a component.\n\n"

                        + "They are provided "
                        + "by the parent and "
                        + "should not be "
                        + "modified directly "
                        + "by the child.\n\n"

                        + "Example: A LessonCard "
                        + "receives a lessonTitle prop.\n\n"

                        + "STATE:\n"
                        + "State contains information "
                        + "that a component remembers "
                        + "between renders.\n\n"

                        + "The component updates "
                        + "state using a setter "
                        + "or another supported "
                        + "state management mechanism.\n\n"

                        + "Example: A counter tracks "
                        + "the number of completed "
                        + "practice questions.\n\n"

                        + "CONTEXT:\n"
                        + "Context makes a value "
                        + "available to descendant "
                        + "components without "
                        + "passing it through "
                        + "every intermediate level.\n\n"

                        + "Example: Multiple "
                        + "screens can access "
                        + "a shared theme setting.\n\n"

                        + "DATA DIRECTION:\n"
                        + "Props flow from "
                        + "parent to child.\n\n"

                        + "State is managed "
                        + "by the component "
                        + "or state owner.\n\n"

                        + "Context values are "
                        + "supplied by a provider "
                        + "and read by descendants.\n\n"

                        + "WHEN TO USE PROPS:\n"
                        + "Use props when "
                        + "one component needs "
                        + "to provide information "
                        + "to another component.\n\n"

                        + "WHEN TO USE STATE:\n"
                        + "Use state for "
                        + "information that changes "
                        + "because of user actions "
                        + "or other application events.\n\n"

                        + "WHEN TO USE CONTEXT:\n"
                        + "Use Context when "
                        + "several descendant components "
                        + "need access to "
                        + "the same shared value.\n\n"

                        + "COMBINING ALL THREE:\n"
                        + "A component can receive "
                        + "a student name through props, "
                        + "manage a local counter "
                        + "through state, and "
                        + "read a course name "
                        + "through Context.\n\n"

                        + "PERSISTENCE:\n"
                        + "None of these mechanisms "
                        + "is automatically a "
                        + "persistent database. "
                        + "Important saved information "
                        + "requires a suitable "
                        + "storage solution.";

        String takeaway =
                "Props receive component inputs. "
                        + "State manages changing data. "
                        + "Context shares values across "
                        + "a component subtree. "
                        + "Use each according "
                        + "to its responsibility.";

        String code =
                "// React Native example\n"
                        + "// Props + State + Context\n\n"

                        + "import React, {\n"
                        + "    createContext,\n"
                        + "    useContext,\n"
                        + "    useState\n"
                        + "} from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Pressable\n"
                        + "} from 'react-native';\n\n"

                        + "const CourseContext = createContext('Unknown');\n\n"

                        + "function StudentProgress({ studentName }) {\n\n"

                        + "    // CONTEXT: shared course name\n"
                        + "    const course = useContext(CourseContext);\n\n"

                        + "    // STATE: local completed count\n"
                        + "    const [completed, setCompleted] =\n"
                        + "        useState(0);\n\n"

                        + "    return (\n"
                        + "        <View>\n\n"

                        + "            <Text>Student: {studentName}</Text>\n"
                        + "            <Text>Course: {course}</Text>\n"
                        + "            <Text>Completed: {completed}</Text>\n\n"

                        + "            <Pressable\n"
                        + "                onPress={() =>\n"
                        + "                    setCompleted(previous => previous + 1)\n"
                        + "                }\n"
                        + "            >\n"
                        + "                <Text>Complete Another</Text>\n"
                        + "            </Pressable>\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "export default function App() {\n\n"

                        + "    return (\n"
                        + "        <CourseContext.Provider value=\"IT487\">\n\n"

                        + "            <StudentProgress\n"
                        + "                studentName=\"Student\"\n"
                        + "            />\n\n"

                        + "        </CourseContext.Provider>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "This example demonstrates "
                        + "props, state, and Context "
                        + "inside one React Native app.\n\n"

                        + "PROPS:\n"
                        + "StudentProgress receives "
                        + "studentName from App.\n\n"

                        + "STATE:\n"
                        + "The completed variable "
                        + "is managed using useState.\n\n"

                        + "Pressing Complete Another "
                        + "increases the local "
                        + "completed counter.\n\n"

                        + "CONTEXT:\n"
                        + "CourseContext.Provider "
                        + "supplies the value IT487.\n\n"

                        + "StudentProgress reads "
                        + "that value using useContext.\n\n"

                        + "The application combines "
                        + "these mechanisms without "
                        + "assigning the same "
                        + "responsibility to each.\n\n"

                        + "This example does not "
                        + "modify the actual "
                        + "IT487 Learning Hub "
                        + "database or its "
                        + "stored lesson progress.";

        String question =
                "Which statement correctly "
                        + "describes props, state, "
                        + "and Context in React?";

        String[] options = {
                "Props are a database and Context replaces JavaScript",
                "State must always be passed from the parent",
                "Context automatically saves all data permanently",
                "Props receive inputs, state manages changing data, and Context shares values"
        };

        String answerExplanation =
                "Props provide component inputs, "
                        + "state manages changing values, "
                        + "and Context allows "
                        + "descendant components "
                        + "to access shared information "
                        + "from a provider.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                3,
                answerExplanation
        );
    }
}
