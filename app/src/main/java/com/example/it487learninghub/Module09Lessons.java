package com.example.it487learninghub;

public final class Module09Lessons {

    // Prevent creating instances
    private Module09Lessons() {
    }

    // =====================================
    // GET MODULE 09 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return understandingJSX();

            case 2:
                return renderingElementsAndLists();

            case 3:
                return conditionalRendering();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Understanding JSX
    // =====================================

    private static LessonContent understandingJSX() {

        String summary =
                "Understand JSX syntax, expressions, "
                        + "components, attributes, and "
                        + "how JSX is used in React "
                        + "and React Native.";

        String explanation =
                "JSX stands for JavaScript XML.\n\n"

                        + "It is a JavaScript syntax extension "
                        + "that allows developers to describe "
                        + "user interfaces using markup-like "
                        + "expressions.\n\n"

                        + "WHY JSX IS USEFUL:\n"
                        + "JSX combines interface descriptions "
                        + "with JavaScript logic in "
                        + "React components.\n\n"

                        + "JSX EXPRESSIONS:\n"
                        + "Curly braces allow JavaScript "
                        + "expressions inside JSX.\n\n"

                        + "For example, {studentName} "
                        + "displays the value of "
                        + "a JavaScript variable.\n\n"

                        + "COMPONENT STRUCTURE:\n"
                        + "A React function component "
                        + "returns JSX that describes "
                        + "what should appear on screen.\n\n"

                        + "JSX RULES:\n"
                        + "Elements must be properly closed. "
                        + "Multiple adjacent elements must "
                        + "be wrapped in a common parent "
                        + "or React Fragment.\n\n"

                        + "JSX ATTRIBUTES:\n"
                        + "Attributes configure "
                        + "elements and components.\n\n"

                        + "In React web development, "
                        + "className commonly replaces "
                        + "the HTML class attribute.\n\n"

                        + "JAVASCRIPT EXPRESSIONS:\n"
                        + "JSX can display variables, "
                        + "perform calculations, and "
                        + "evaluate conditional expressions.\n\n"

                        + "REACT NATIVE JSX:\n"
                        + "React Native uses JSX too, "
                        + "but with mobile components "
                        + "such as View and Text instead "
                        + "of HTML elements like div and h1.\n\n"

                        + "IMPORTANT DISTINCTION:\n"
                        + "JSX is transformed by development "
                        + "tools into JavaScript operations. "
                        + "Browsers and native platforms "
                        + "do not interpret JSX source "
                        + "directly as a standalone language.";

        String takeaway =
                "JSX describes React interfaces "
                        + "using markup-like syntax. "
                        + "Curly braces insert JavaScript "
                        + "expressions, and components "
                        + "must follow JSX structure rules.";

        String code =
                "// React web example\n"
                        + "// File: StudentCard.jsx\n\n"

                        + "import React from 'react';\n\n"

                        + "export default function StudentCard() {\n\n"

                        + "    const studentName = 'Mohammed';\n"
                        + "    const completedLessons = 5;\n\n"

                        + "    return (\n"
                        + "        <div>\n"
                        + "            <h2>Welcome, {studentName}</h2>\n\n"

                        + "            <p>\n"
                        + "                Completed lessons: "
                        + "{completedLessons}\n"
                        + "            </p>\n\n"

                        + "            <p>\n"
                        + "                Next goal: "
                        + "{completedLessons + 1} lessons\n"
                        + "            </p>\n"
                        + "        </div>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "StudentCard is a React "
                        + "function component.\n\n"

                        + "The studentName variable "
                        + "contains a String.\n\n"

                        + "completedLessons contains "
                        + "a numeric value.\n\n"

                        + "JSX curly braces display "
                        + "the variables inside "
                        + "the interface.\n\n"

                        + "The expression "
                        + "{completedLessons + 1} "
                        + "calculates the next goal.\n\n"

                        + "The div element wraps "
                        + "the other elements into "
                        + "one parent element.\n\n"

                        + "This is a React web "
                        + "example written in "
                        + "JavaScript and JSX. "
                        + "It is intended for "
                        + "a React project, not "
                        + "an Android Java Activity.";

        String question =
                "Which JSX syntax is used "
                        + "to insert a JavaScript "
                        + "expression into an element?";

        String[] options = {
                "Square brackets []",
                "Curly braces {}",
                "Double backslashes",
                "The SQL SELECT keyword"
        };

        String answerExplanation =
                "JSX uses curly braces {} "
                        + "to evaluate JavaScript "
                        + "expressions and display "
                        + "their results in the interface.";

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
    // Rendering Elements and Lists
    // =====================================

    private static LessonContent
    renderingElementsAndLists() {

        String summary =
                "Learn how React renders elements, "
                        + "displays collections with map(), "
                        + "and uses keys to identify list items.";

        String explanation =
                "Rendering is the process "
                        + "through which React determines "
                        + "what the user interface "
                        + "should display.\n\n"

                        + "REACT ELEMENTS:\n"
                        + "React elements describe "
                        + "pieces of the interface.\n\n"

                        + "COMPONENT RENDERING:\n"
                        + "React calls component functions "
                        + "to determine their output.\n\n"

                        + "When props or state change, "
                        + "React can render components "
                        + "again and update the interface.\n\n"

                        + "RENDERING LISTS:\n"
                        + "Applications often display "
                        + "collections such as lessons, "
                        + "students, or products.\n\n"

                        + "THE MAP METHOD:\n"
                        + "JavaScript's map() method "
                        + "creates a new array by "
                        + "transforming each original item.\n\n"

                        + "In React, map() can transform "
                        + "an array into JSX elements.\n\n"

                        + "KEYS:\n"
                        + "Each item in a rendered list "
                        + "should have a stable, unique "
                        + "key among its siblings.\n\n"

                        + "Keys help React identify "
                        + "items when the list changes.\n\n"

                        + "STABLE IDENTIFIERS:\n"
                        + "A database ID is often "
                        + "a suitable key.\n\n"

                        + "Using an array index as "
                        + "a key can cause problems "
                        + "when items are inserted, "
                        + "removed, or reordered.\n\n"

                        + "REACT FRAGMENTS:\n"
                        + "Fragments group elements "
                        + "without adding an extra "
                        + "DOM element.\n\n"

                        + "REACT NATIVE LISTS:\n"
                        + "React Native supports "
                        + "rendering collections "
                        + "through map() as well.\n\n"

                        + "For larger mobile lists, "
                        + "FlatList is commonly "
                        + "preferred because it "
                        + "renders list content "
                        + "more efficiently.\n\n"

                        + "UI UPDATES:\n"
                        + "When application state "
                        + "changes, React compares "
                        + "rendering results and "
                        + "updates the relevant "
                        + "interface elements.";

        String takeaway =
                "React renders UI from "
                        + "components and state. "
                        + "Use map() to display "
                        + "collections, and assign "
                        + "stable keys to list items.";

        String code =
                "// React web example\n"
                        + "// File: LessonList.jsx\n\n"

                        + "import React from 'react';\n\n"

                        + "export default function LessonList() {\n\n"

                        + "    const lessons = [\n"
                        + "        {\n"
                        + "            id: 101,\n"
                        + "            title: 'Understanding JSX'\n"
                        + "        },\n"
                        + "        {\n"
                        + "            id: 102,\n"
                        + "            title: 'Rendering Lists'\n"
                        + "        },\n"
                        + "        {\n"
                        + "            id: 103,\n"
                        + "            title: 'Conditional Rendering'\n"
                        + "        }\n"
                        + "    ];\n\n"

                        + "    return (\n"
                        + "        <div>\n"
                        + "            <h2>My Lessons</h2>\n\n"

                        + "            <ul>\n"
                        + "                {lessons.map(lesson => (\n"
                        + "                    <li key={lesson.id}>\n"
                        + "                        {lesson.title}\n"
                        + "                    </li>\n"
                        + "                ))}\n"
                        + "            </ul>\n"
                        + "        </div>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "The lessons array contains "
                        + "three objects.\n\n"

                        + "Each object has an id "
                        + "and a title.\n\n"

                        + "The map() method visits "
                        + "each object and returns "
                        + "a list item.\n\n"

                        + "The li element represents "
                        + "one displayed lesson.\n\n"

                        + "key={lesson.id} gives "
                        + "React a stable identifier "
                        + "for the list item.\n\n"

                        + "The lesson.title expression "
                        + "displays the lesson name.\n\n"

                        + "This example uses HTML "
                        + "elements for React web. "
                        + "A React Native implementation "
                        + "would use mobile components "
                        + "such as Text and FlatList.";

        String question =
                "Why should rendered React "
                        + "list items have stable "
                        + "and unique keys?";

        String[] options = {
                "To connect directly to SQLite",
                "To automatically install React Native",
                "To help React identify items when lists change",
                "To replace all component props"
        };

        String answerExplanation =
                "Keys help React identify "
                        + "which list items correspond "
                        + "to one another across renders. "
                        + "Stable identifiers improve "
                        + "correctness when collections "
                        + "are updated or reordered.";

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
    // Conditional Rendering
    // =====================================

    private static LessonContent conditionalRendering() {

        String summary =
                "Understand how React and "
                        + "React Native display different "
                        + "interface elements according "
                        + "to conditions and application state.";

        String explanation =
                "Conditional rendering means "
                        + "displaying different UI "
                        + "content depending on "
                        + "a condition.\n\n"

                        + "WHY IT MATTERS:\n"
                        + "Applications often need "
                        + "to display different messages "
                        + "depending on user actions "
                        + "or stored information.\n\n"

                        + "For example, a learning "
                        + "application may show "
                        + "Completed when a lesson "
                        + "has been finished.\n\n"

                        + "IF STATEMENTS:\n"
                        + "A component can use "
                        + "an if statement to "
                        + "return different JSX.\n\n"

                        + "TERNARY OPERATOR:\n"
                        + "The JavaScript ternary "
                        + "operator has this form:\n\n"

                        + "condition ? valueIfTrue : valueIfFalse\n\n"

                        + "It can select one of "
                        + "two JSX expressions.\n\n"

                        + "LOGICAL AND:\n"
                        + "The && operator can "
                        + "conditionally include "
                        + "content when the "
                        + "condition is true.\n\n"

                        + "A boolean expression "
                        + "is usually best for "
                        + "this pattern.\n\n"

                        + "For example, when using "
                        + "an array length as a "
                        + "condition, compare it "
                        + "with zero explicitly "
                        + "to avoid accidentally "
                        + "rendering the number 0.\n\n"

                        + "NULL RENDERING:\n"
                        + "A React component can "
                        + "return null when "
                        + "nothing should be displayed.\n\n"

                        + "STATE AND CONDITIONS:\n"
                        + "React state can determine "
                        + "which part of a component "
                        + "is visible.\n\n"

                        + "REACT NATIVE:\n"
                        + "React Native supports "
                        + "conditional JSX using "
                        + "the same JavaScript "
                        + "control-flow techniques.\n\n"

                        + "The returned interface "
                        + "uses native mobile "
                        + "components such as "
                        + "View and Text.\n\n"

                        + "GOOD PRACTICE:\n"
                        + "Use clear conditions "
                        + "and avoid deeply nested "
                        + "ternary expressions "
                        + "that are difficult "
                        + "to understand.";

        String takeaway =
                "Conditional rendering allows "
                        + "React interfaces to respond "
                        + "to changing data and state. "
                        + "Use if statements, ternary "
                        + "expressions, or logical "
                        + "conditions appropriately.";

        String code =
                "// React Native example\n"
                        + "// File: LessonStatus.js\n\n"

                        + "import React from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    StyleSheet\n"
                        + "} from 'react-native';\n\n"

                        + "export default function LessonStatus({ completed }) {\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                Lesson Status\n"
                        + "            </Text>\n\n"

                        + "            {completed ? (\n"
                        + "                <Text style={styles.success}>\n"
                        + "                    Completed\n"
                        + "                </Text>\n"
                        + "            ) : (\n"
                        + "                <Text style={styles.pending}>\n"
                        + "                    Not Started\n"
                        + "                </Text>\n"
                        + "            )}\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n"

                        + "    container: {\n"
                        + "        padding: 16,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n"

                        + "    title: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 20,\n"
                        + "        marginBottom: 12\n"
                        + "    },\n"

                        + "    success: {\n"
                        + "        color: '#36D6B3'\n"
                        + "    },\n"

                        + "    pending: {\n"
                        + "        color: '#AAB8CF'\n"
                        + "    }\n"

                        + "});";

        String codeExplanation =
                "LessonStatus is a React "
                        + "Native function component.\n\n"

                        + "It receives a completed "
                        + "boolean through props.\n\n"

                        + "The ternary expression "
                        + "checks the value "
                        + "of completed.\n\n"

                        + "When completed is true, "
                        + "the component displays "
                        + "Completed in green.\n\n"

                        + "Otherwise, it displays "
                        + "Not Started.\n\n"

                        + "StyleSheet.create() defines "
                        + "the colors and spacing.\n\n"

                        + "The parent component "
                        + "could use:\n\n"

                        + "<LessonStatus completed={true} />\n\n"

                        + "This example demonstrates "
                        + "conditional React Native "
                        + "rendering and does not "
                        + "modify the Android Java "
                        + "application itself.";

        String question =
                "Which JavaScript operator "
                        + "can choose between "
                        + "two JSX expressions "
                        + "based on a condition?";

        String[] options = {
                "The SQL LIKE operator",
                "The assignment operator =",
                "The Java extends keyword",
                "The ternary operator ? :"
        };

        String answerExplanation =
                "The ternary operator "
                        + "uses the syntax "
                        + "condition ? trueValue : falseValue "
                        + "to select between "
                        + "two expressions, "
                        + "including JSX elements.";

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
