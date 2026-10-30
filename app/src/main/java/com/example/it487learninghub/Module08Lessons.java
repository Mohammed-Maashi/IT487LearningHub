package com.example.it487learninghub;

public final class Module08Lessons {

    // Prevent creating instances of this class
    private Module08Lessons() {
    }

    // =====================================
    // GET MODULE 08 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return reactFundamentals();

            case 2:
                return introducingReactNative();

            case 3:
                return reactVsReactNative();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // React Fundamentals
    // =====================================

    private static LessonContent reactFundamentals() {

        String summary =
                "Learn the fundamental concepts of React, "
                        + "including components, JSX, props, "
                        + "state, and event handling.";

        String explanation =
                "React is a JavaScript library "
                        + "for building user interfaces.\n\n"

                        + "COMPONENT-BASED ARCHITECTURE:\n"
                        + "React applications are built "
                        + "using reusable components.\n\n"

                        + "A component represents "
                        + "a portion of the interface, "
                        + "such as a button, card, "
                        + "navigation bar, or page.\n\n"

                        + "FUNCTION COMPONENTS:\n"
                        + "Modern React applications "
                        + "commonly use JavaScript "
                        + "functions to define components.\n\n"

                        + "A function component returns "
                        + "a description of the interface "
                        + "that should be displayed.\n\n"

                        + "JSX:\n"
                        + "JSX is a syntax extension "
                        + "that allows markup-like "
                        + "expressions inside JavaScript.\n\n"

                        + "JSX makes component structures "
                        + "easier to describe and read.\n\n"

                        + "PROPS:\n"
                        + "Props are values supplied "
                        + "to a component by its parent.\n\n"

                        + "For example, a LessonCard "
                        + "component might receive "
                        + "a title and a description "
                        + "through props.\n\n"

                        + "STATE:\n"
                        + "State represents information "
                        + "that can change while "
                        + "a component is being used.\n\n"

                        + "A counter, selected tab, "
                        + "or search input can be "
                        + "managed through state.\n\n"

                        + "USESTATE HOOK:\n"
                        + "The useState Hook allows "
                        + "a function component "
                        + "to manage local state.\n\n"

                        + "When a state update occurs, "
                        + "React can render the component "
                        + "again with updated information.\n\n"

                        + "EVENT HANDLING:\n"
                        + "React supports event handlers "
                        + "such as onClick for responding "
                        + "to user interactions on the web.\n\n"

                        + "DECLARATIVE UI:\n"
                        + "Developers describe how the "
                        + "interface should appear "
                        + "for the current state. "
                        + "React manages the updates.";

        String takeaway =
                "React builds interfaces from "
                        + "reusable components. JSX "
                        + "describes their structure, "
                        + "props pass values between "
                        + "components, and useState "
                        + "manages local state.";

        String code =
                "import React, { useState } "
                        + "from 'react';\n\n"

                        + "export default function Counter() {\n\n"

                        + "    const [count, setCount] = useState(0);\n\n"

                        + "    return (\n"
                        + "        <div>\n"
                        + "            <h2>Count: {count}</h2>\n\n"

                        + "            <button\n"
                        + "                onClick={() =>\n"
                        + "                    setCount(previous => previous + 1)\n"
                        + "                }\n"
                        + "            >\n"
                        + "                Increase\n"
                        + "            </button>\n"
                        + "        </div>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "This example creates a "
                        + "React function component "
                        + "named Counter.\n\n"

                        + "useState(0) initializes "
                        + "the count with zero.\n\n"

                        + "The count variable contains "
                        + "the current state value.\n\n"

                        + "setCount() updates the state.\n\n"

                        + "The JSX expression {count} "
                        + "displays the current number.\n\n"

                        + "When the button is clicked, "
                        + "the onClick event handler "
                        + "increments the counter.\n\n"

                        + "React then updates the "
                        + "displayed value.\n\n"

                        + "This is a React web example "
                        + "written in JavaScript and JSX. "
                        + "It is not Java code and "
                        + "is not intended to be pasted "
                        + "into Android Studio.";

        String question =
                "Which React Hook is commonly "
                        + "used to manage local state "
                        + "inside a function component?";

        String[] options = {
                "useState",
                "useNavigateOnly",
                "setContentView",
                "findViewById"
        };

        String answerExplanation =
                "useState is a React Hook "
                        + "that allows function components "
                        + "to store state and request "
                        + "updates through a setter function.";

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
    // Introducing React Native
    // =====================================

    private static LessonContent introducingReactNative() {

        String summary =
                "Discover how React Native "
                        + "uses React concepts to build "
                        + "applications for Android "
                        + "and iOS devices.";

        String explanation =
                "React Native is a framework "
                        + "for building native mobile "
                        + "applications using JavaScript "
                        + "or TypeScript and React.\n\n"

                        + "REACT CONCEPTS:\n"
                        + "React Native uses familiar "
                        + "React concepts such as "
                        + "components, props, "
                        + "state, and Hooks.\n\n"

                        + "MOBILE COMPONENTS:\n"
                        + "React Native provides "
                        + "components that map "
                        + "to native platform views.\n\n"

                        + "VIEW:\n"
                        + "View is a fundamental "
                        + "container component "
                        + "used to group and "
                        + "arrange interface elements.\n\n"

                        + "TEXT:\n"
                        + "Text displays text "
                        + "inside a React Native app.\n\n"

                        + "PRESSABLE:\n"
                        + "Pressable detects "
                        + "press interactions "
                        + "and can trigger actions.\n\n"

                        + "TEXTINPUT:\n"
                        + "TextInput allows users "
                        + "to enter text.\n\n"

                        + "SCROLLVIEW:\n"
                        + "ScrollView displays "
                        + "scrollable content.\n\n"

                        + "FLATLIST:\n"
                        + "FlatList is designed "
                        + "to render scrollable "
                        + "lists efficiently, "
                        + "especially when the "
                        + "collection is large.\n\n"

                        + "STYLING:\n"
                        + "React Native styles "
                        + "use JavaScript objects "
                        + "instead of traditional "
                        + "browser CSS stylesheets.\n\n"

                        + "StyleSheet.create() "
                        + "is commonly used "
                        + "to organize styles.\n\n"

                        + "LAYOUT:\n"
                        + "React Native primarily "
                        + "uses Flexbox to "
                        + "arrange interface elements.\n\n"

                        + "PLATFORM APIS:\n"
                        + "React Native applications "
                        + "can interact with supported "
                        + "native platform capabilities "
                        + "through appropriate APIs "
                        + "and native modules.\n\n"

                        + "EXPO:\n"
                        + "Expo provides tools "
                        + "and services that simplify "
                        + "many React Native "
                        + "development workflows.\n\n"

                        + "DEVELOPMENT:\n"
                        + "Developers can write "
                        + "React Native components "
                        + "and test their applications "
                        + "using suitable development "
                        + "tools and devices.";

        String takeaway =
                "React Native uses React "
                        + "concepts to create mobile "
                        + "interfaces through components "
                        + "such as View, Text, "
                        + "Pressable, and TextInput.";

        String code =
                "import React, { useState } from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Pressable,\n"
                        + "    StyleSheet\n"
                        + "} from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    const [count, setCount] = useState(0);\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.heading}>\n"
                        + "                Count: {count}\n"
                        + "            </Text>\n\n"

                        + "            <Pressable\n"
                        + "                style={styles.button}\n"
                        + "                onPress={() =>\n"
                        + "                    setCount(previous => previous + 1)\n"
                        + "                }\n"
                        + "            >\n"
                        + "                <Text style={styles.buttonText}>\n"
                        + "                    Increase\n"
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
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    heading: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 24,\n"
                        + "        marginBottom: 20\n"
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
                "This example creates a "
                        + "simple React Native "
                        + "counter application.\n\n"

                        + "The App component "
                        + "uses the useState Hook "
                        + "to manage the counter.\n\n"

                        + "View acts as the "
                        + "main interface container.\n\n"

                        + "Text displays the "
                        + "current counter value.\n\n"

                        + "Pressable responds "
                        + "to the user's touch "
                        + "through onPress.\n\n"

                        + "When the user presses "
                        + "Increase, the counter "
                        + "state is updated.\n\n"

                        + "StyleSheet.create() "
                        + "defines the interface "
                        + "colors, spacing, "
                        + "alignment, and typography.\n\n"

                        + "This is JavaScript and JSX "
                        + "for a React Native project. "
                        + "It is educational content "
                        + "displayed by the learning app, "
                        + "not Java code to insert "
                        + "into an Android Activity.";

        String question =
                "Which React Native component "
                        + "is commonly used as "
                        + "a general-purpose container "
                        + "for other interface elements?";

        String[] options = {
                "div",
                "LinearLayout",
                "View",
                "AndroidManifest"
        };

        String answerExplanation =
                "View is a fundamental "
                        + "React Native component "
                        + "used to group and "
                        + "arrange interface elements. "
                        + "Unlike React web development, "
                        + "React Native does not "
                        + "normally use HTML div elements.";

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
    // React vs React Native
    // =====================================

    private static LessonContent reactVsReactNative() {

        String summary =
                "Compare React and React Native "
                        + "in terms of purpose, "
                        + "components, rendering, "
                        + "styling, and development tools.";

        String explanation =
                "React and React Native "
                        + "share several programming "
                        + "concepts, but they target "
                        + "different environments.\n\n"

                        + "REACT:\n"
                        + "React is a JavaScript "
                        + "library for building "
                        + "user interfaces.\n\n"

                        + "When used with React DOM, "
                        + "it can render applications "
                        + "for web browsers.\n\n"

                        + "REACT NATIVE:\n"
                        + "React Native is a framework "
                        + "for building applications "
                        + "that use native mobile "
                        + "platform views.\n\n"

                        + "TARGET PLATFORMS:\n"
                        + "React with React DOM "
                        + "commonly targets the web.\n\n"

                        + "React Native commonly "
                        + "targets Android and iOS.\n\n"

                        + "INTERFACE COMPONENTS:\n"
                        + "React web applications "
                        + "can use HTML elements "
                        + "such as div, h1, "
                        + "p, and button.\n\n"

                        + "React Native applications "
                        + "use components such as "
                        + "View, Text, "
                        + "Pressable, and TextInput.\n\n"

                        + "RENDERING:\n"
                        + "React DOM updates "
                        + "the browser's DOM.\n\n"

                        + "React Native renders "
                        + "through its native "
                        + "platform integration.\n\n"

                        + "STYLING:\n"
                        + "React web applications "
                        + "can use CSS stylesheets "
                        + "and other web styling tools.\n\n"

                        + "React Native typically "
                        + "uses JavaScript style objects "
                        + "and StyleSheet.create().\n\n"

                        + "EVENT HANDLING:\n"
                        + "React web applications "
                        + "commonly use onClick "
                        + "for button interactions.\n\n"

                        + "React Native often "
                        + "uses onPress with "
                        + "Pressable components.\n\n"

                        + "SHARED CONCEPTS:\n"
                        + "Both use React components, "
                        + "props, state, Hooks, "
                        + "and declarative interfaces.\n\n"

                        + "CODE REUSE:\n"
                        + "Some business logic "
                        + "and state management "
                        + "can be shared between "
                        + "React and React Native.\n\n"

                        + "However, platform-specific "
                        + "interface components "
                        + "may require separate code.\n\n"

                        + "IMPORTANT DISTINCTION:\n"
                        + "React Native does not "
                        + "simply display a website "
                        + "inside a WebView by default. "
                        + "It uses native platform "
                        + "components for its UI.";

        String takeaway =
                "React web applications "
                        + "use browser technologies "
                        + "such as HTML and CSS. "
                        + "React Native uses native "
                        + "mobile components, while "
                        + "sharing React concepts "
                        + "such as components, "
                        + "props, state, and Hooks.";

        String code =
                "// REACT WEB EXAMPLE\n"
                        + "// File: Welcome.jsx\n\n"

                        + "import React from 'react';\n\n"

                        + "export default function Welcome() {\n"
                        + "    return <h1>Hello, Student!</h1>;\n"
                        + "}\n\n"

                        + "// =============================\n\n"

                        + "// REACT NATIVE EXAMPLE\n"
                        + "// File: Welcome.js\n\n"

                        + "import React from 'react';\n"
                        + "import { Text } from 'react-native';\n\n"

                        + "export default function Welcome() {\n"
                        + "    return <Text>Hello, Student!</Text>;\n"
                        + "}";

        String codeExplanation =
                "The first example is "
                        + "a React web component.\n\n"

                        + "It displays a heading "
                        + "using the HTML h1 element.\n\n"

                        + "The second example "
                        + "is a React Native "
                        + "mobile component.\n\n"

                        + "It displays text "
                        + "using the React Native "
                        + "Text component.\n\n"

                        + "Both are function components "
                        + "that return JSX.\n\n"

                        + "However, each uses "
                        + "interface components "
                        + "appropriate for its platform.\n\n"

                        + "The examples belong "
                        + "in separate projects "
                        + "or files. They should "
                        + "not be combined into "
                        + "one JavaScript file.";

        String question =
                "Which statement correctly "
                        + "describes a key difference "
                        + "between React web "
                        + "and React Native?";

        String[] options = {
                "React Native requires HTML div elements",
                "React web cannot use components",
                "React Native cannot use state",
                "React Native uses mobile UI components such as View and Text"
        };

        String answerExplanation =
                "React Native provides "
                        + "mobile interface components "
                        + "such as View and Text. "
                        + "React web applications "
                        + "typically use browser "
                        + "elements such as div "
                        + "and h1 through React DOM.";

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
