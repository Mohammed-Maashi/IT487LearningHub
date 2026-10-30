package com.example.it487learninghub;

public final class Module11Lessons {

    // Prevent creating instances of this class
    private Module11Lessons() {
    }

    // =====================================
    // GET MODULE 11 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return reactComponentLifecycle();

            case 2:
                return lifecycleAndSideEffects();

            case 3:
                return managingComponentUpdates();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // React Component Lifecycle
    // =====================================

    private static LessonContent reactComponentLifecycle() {

        String summary =
                "Understand the React component "
                        + "lifecycle, including mounting, "
                        + "updating, unmounting, and "
                        + "lifecycle behavior in "
                        + "function and class components.";

        String explanation =
                "React components change "
                        + "throughout their existence "
                        + "in an application.\n\n"

                        + "MOUNTING:\n"
                        + "Mounting occurs when "
                        + "a component is first "
                        + "added to the interface.\n\n"

                        + "For example, a lesson "
                        + "screen mounts when "
                        + "it first appears.\n\n"

                        + "UPDATING:\n"
                        + "An update occurs when "
                        + "React renders a component "
                        + "again because its props, "
                        + "state, or relevant "
                        + "Context has changed.\n\n"

                        + "UNMOUNTING:\n"
                        + "Unmounting occurs when "
                        + "React removes a component "
                        + "from the interface.\n\n"

                        + "For example, a conditional "
                        + "component may unmount "
                        + "when it is no longer needed.\n\n"

                        + "CLASS COMPONENTS:\n"
                        + "React class components "
                        + "have lifecycle methods "
                        + "such as componentDidMount(), "
                        + "componentDidUpdate(), and "
                        + "componentWillUnmount().\n\n"

                        + "COMPONENTDIDMOUNT:\n"
                        + "This method runs after "
                        + "a class component "
                        + "has mounted.\n\n"

                        + "COMPONENTDIDUPDATE:\n"
                        + "This method runs after "
                        + "a class component update "
                        + "has been committed.\n\n"

                        + "COMPONENTWILLUNMOUNT:\n"
                        + "This method allows a "
                        + "class component to "
                        + "clean up resources "
                        + "before unmounting.\n\n"

                        + "FUNCTION COMPONENTS:\n"
                        + "Modern React applications "
                        + "commonly use function "
                        + "components and Hooks.\n\n"

                        + "THE USEEFFECT HOOK:\n"
                        + "useEffect() is used to "
                        + "synchronize a component "
                        + "with external systems.\n\n"

                        + "Depending on its dependencies, "
                        + "an Effect can run after "
                        + "mounting and after "
                        + "relevant updates.\n\n"

                        + "EFFECT CLEANUP:\n"
                        + "An Effect can return "
                        + "a cleanup function "
                        + "to release resources.\n\n"

                        + "DEVELOPMENT MODE:\n"
                        + "React Strict Mode may "
                        + "run an additional "
                        + "Effect setup and cleanup "
                        + "cycle in development "
                        + "to help identify bugs.\n\n"

                        + "IMPORTANT:\n"
                        + "React component lifecycles "
                        + "are different from Android "
                        + "Activity lifecycle callbacks.";

        String takeaway =
                "React components mount, update, "
                        + "and unmount. Class components "
                        + "provide lifecycle methods, "
                        + "while function components "
                        + "use Hooks such as useEffect "
                        + "to synchronize with "
                        + "external systems.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React, { useEffect } "
                        + "from 'react';\n\n"

                        + "import { View, Text } "
                        + "from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    useEffect(() => {\n\n"

                        + "        console.log('Effect setup');\n\n"

                        + "        return () => {\n"
                        + "            console.log('Effect cleanup');\n"
                        + "        };\n\n"

                        + "    }, []);\n\n"

                        + "    return (\n"
                        + "        <View>\n"
                        + "            <Text>\n"
                        + "                React Component Lifecycle\n"
                        + "            </Text>\n"
                        + "        </View>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "This example creates "
                        + "a React Native "
                        + "function component.\n\n"

                        + "useEffect() registers "
                        + "an Effect with "
                        + "an empty dependency array.\n\n"

                        + "The Effect setup "
                        + "runs after the component "
                        + "is committed to "
                        + "the interface.\n\n"

                        + "The returned function "
                        + "is the cleanup function.\n\n"

                        + "Cleanup runs when "
                        + "the component unmounts.\n\n"

                        + "In development Strict Mode, "
                        + "React may also perform "
                        + "an extra setup and "
                        + "cleanup cycle.\n\n"

                        + "The console messages "
                        + "help demonstrate "
                        + "when the Effect "
                        + "setup and cleanup run.\n\n"

                        + "This is a React Native "
                        + "educational example, "
                        + "not Android Java code.";

        String question =
                "Which lifecycle method "
                        + "runs when a React "
                        + "class component is "
                        + "about to unmount?";

        String[] options = {
                "componentDidMount()",
                "componentDidUpdate()",
                "componentWillUnmount()",
                "useState()"
        };

        String answerExplanation =
                "componentWillUnmount() "
                        + "is a class component "
                        + "lifecycle method "
                        + "used for cleanup "
                        + "before unmounting.";

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
    // Lifecycle and Side Effects
    // =====================================

    private static LessonContent lifecycleAndSideEffects() {

        String summary =
                "Learn how useEffect manages "
                        + "side effects such as timers, "
                        + "subscriptions, and communication "
                        + "with external systems.";

        String explanation =
                "A side effect is an operation "
                        + "that interacts with something "
                        + "outside the component's "
                        + "rendering calculation.\n\n"

                        + "SIDE EFFECT EXAMPLES:\n"
                        + "Examples include timers, "
                        + "network requests, "
                        + "event subscriptions, "
                        + "and external connections.\n\n"

                        + "THE USEEFFECT HOOK:\n"
                        + "useEffect() helps synchronize "
                        + "a React component "
                        + "with external systems.\n\n"

                        + "EFFECT DEPENDENCIES:\n"
                        + "The dependency array "
                        + "determines when React "
                        + "needs to re-synchronize "
                        + "an Effect.\n\n"

                        + "EMPTY DEPENDENCY ARRAY:\n"
                        + "An empty dependency array "
                        + "means the Effect does not "
                        + "depend on changing "
                        + "reactive values.\n\n"

                        + "React normally sets it "
                        + "up after mounting "
                        + "and cleans it up "
                        + "during unmounting.\n\n"

                        + "DEVELOPMENT STRICT MODE:\n"
                        + "Strict Mode may run "
                        + "an extra setup-cleanup "
                        + "cycle during development.\n\n"

                        + "DEPENDENCIES WITH VALUES:\n"
                        + "An Effect runs again "
                        + "when one of its "
                        + "dependencies changes.\n\n"

                        + "Before the new setup, "
                        + "React runs cleanup "
                        + "for the previous setup.\n\n"

                        + "CLEANUP FUNCTIONS:\n"
                        + "Cleanup releases "
                        + "resources created "
                        + "by an Effect.\n\n"

                        + "TIMERS:\n"
                        + "A component can use "
                        + "setInterval() to "
                        + "perform a repeated action.\n\n"

                        + "The corresponding "
                        + "clearInterval() call "
                        + "stops that timer.\n\n"

                        + "SUBSCRIPTIONS:\n"
                        + "Subscriptions should "
                        + "be removed when "
                        + "they are no longer needed.\n\n"

                        + "NETWORK REQUESTS:\n"
                        + "Effects that fetch data "
                        + "should handle obsolete "
                        + "requests appropriately.\n\n"

                        + "For example, an "
                        + "AbortController may "
                        + "cancel a supported "
                        + "fetch request.\n\n"

                        + "AVOID UNNECESSARY EFFECTS:\n"
                        + "Not every calculation "
                        + "requires useEffect().\n\n"

                        + "Values derived entirely "
                        + "from props or state "
                        + "can often be calculated "
                        + "during rendering.\n\n"

                        + "RESOURCE SAFETY:\n"
                        + "A missing cleanup "
                        + "can leave timers "
                        + "or subscriptions active "
                        + "after a component "
                        + "has been removed.";

        String takeaway =
                "Use useEffect to synchronize "
                        + "with external systems. "
                        + "Declare dependencies "
                        + "and return cleanup "
                        + "functions for resources "
                        + "such as timers "
                        + "and subscriptions.";

        String code =
                "// React Native timer example\n"
                        + "// File: App.js\n\n"

                        + "import React, {\n"
                        + "    useEffect,\n"
                        + "    useState\n"
                        + "} from 'react';\n\n"

                        + "import { View, Text } "
                        + "from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    const [seconds, setSeconds] =\n"
                        + "        useState(0);\n\n"

                        + "    useEffect(() => {\n\n"

                        + "        const timer = setInterval(() => {\n"
                        + "            setSeconds(previous => previous + 1);\n"
                        + "        }, 1000);\n\n"

                        + "        return () => {\n"
                        + "            clearInterval(timer);\n"
                        + "        };\n\n"

                        + "    }, []);\n\n"

                        + "    return (\n"
                        + "        <View>\n"
                        + "            <Text>\n"
                        + "                Elapsed Time: {seconds} seconds\n"
                        + "            </Text>\n"
                        + "        </View>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "The example creates "
                        + "a timer using "
                        + "setInterval().\n\n"

                        + "useState(0) stores "
                        + "the elapsed time.\n\n"

                        + "Every second, the "
                        + "timer requests a "
                        + "state update.\n\n"

                        + "The Text component "
                        + "displays the updated "
                        + "number of seconds.\n\n"

                        + "The useEffect dependency "
                        + "array is empty because "
                        + "the Effect does not "
                        + "read changing values "
                        + "from the component.\n\n"

                        + "The cleanup function "
                        + "calls clearInterval() "
                        + "to stop the timer.\n\n"

                        + "This prevents the "
                        + "interval from continuing "
                        + "after the component "
                        + "has unmounted.\n\n"

                        + "In React Strict Mode "
                        + "development, setup and "
                        + "cleanup may run an "
                        + "additional time.";

        String question =
                "Which function should "
                        + "be used to clean up "
                        + "a timer created by "
                        + "setInterval()?";

        String[] options = {
                "setContentView()",
                "clearInterval()",
                "startActivity()",
                "JSON.parse()"
        };

        String answerExplanation =
                "clearInterval() stops "
                        + "a timer created "
                        + "by setInterval(). "
                        + "It should be called "
                        + "during Effect cleanup "
                        + "when the interval "
                        + "is no longer needed.";

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
    // Managing Component Updates
    // =====================================

    private static LessonContent
    managingComponentUpdates() {

        String summary =
                "Understand React component "
                        + "updates, re-rendering, "
                        + "memoization, and techniques "
                        + "for improving rendering "
                        + "performance.";

        String explanation =
                "React components can render "
                        + "again when state changes "
                        + "or their parent renders.\n\n"

                        + "RE-RENDERING:\n"
                        + "Re-rendering means React "
                        + "calls a component "
                        + "to calculate its "
                        + "next interface output.\n\n"

                        + "STATE CHANGES:\n"
                        + "Updating state may cause "
                        + "the component to render "
                        + "again with the new data.\n\n"

                        + "PARENT RENDERS:\n"
                        + "When a parent renders, "
                        + "React normally also "
                        + "renders its children.\n\n"

                        + "MEMOIZATION:\n"
                        + "Memoization allows "
                        + "an application to "
                        + "reuse previous results "
                        + "under appropriate "
                        + "conditions.\n\n"

                        + "REACT.MEMO:\n"
                        + "React.memo can skip "
                        + "some child component "
                        + "re-renders when "
                        + "its props have "
                        + "not changed.\n\n"

                        + "USEMEMO:\n"
                        + "useMemo caches "
                        + "a calculation result "
                        + "between renders while "
                        + "its dependencies "
                        + "remain unchanged.\n\n"

                        + "USECALLBACK:\n"
                        + "useCallback caches "
                        + "a function reference "
                        + "between renders while "
                        + "its dependencies "
                        + "remain unchanged.\n\n"

                        + "FUNCTIONAL STATE UPDATES:\n"
                        + "An updater function "
                        + "is useful when "
                        + "new state depends "
                        + "on previous state.\n\n"

                        + "For example:\n"
                        + "setCount(previous => previous + 1)\n\n"

                        + "IMMUTABLE DATA:\n"
                        + "Create new objects "
                        + "or arrays rather "
                        + "than directly changing "
                        + "existing state values.\n\n"

                        + "PERFORMANCE:\n"
                        + "Avoid unnecessary "
                        + "expensive calculations "
                        + "during rendering.\n\n"

                        + "Use profiling tools "
                        + "to identify actual "
                        + "performance problems.\n\n"

                        + "AVOID OVER-OPTIMIZATION:\n"
                        + "Memoization is not "
                        + "required for every "
                        + "component or function.\n\n"

                        + "Use it when there "
                        + "is a clear reason "
                        + "to avoid repeated work.\n\n"

                        + "REACT NATIVE:\n"
                        + "React Native applications "
                        + "can also benefit from "
                        + "careful component updates "
                        + "and efficient list rendering.";

        String takeaway =
                "React.memo, useMemo, "
                        + "and useCallback can "
                        + "reduce unnecessary work "
                        + "when used appropriately. "
                        + "Keep state updates "
                        + "immutable and measure "
                        + "performance before "
                        + "adding optimizations.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React, {\n"
                        + "    useCallback,\n"
                        + "    useState\n"
                        + "} from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    Pressable\n"
                        + "} from 'react-native';\n\n"

                        + "const LessonButton = React.memo(\n"
                        + "    function LessonButton({ onComplete }) {\n\n"

                        + "        return (\n"
                        + "            <Pressable onPress={onComplete}>\n"
                        + "                <Text>Complete Lesson</Text>\n"
                        + "            </Pressable>\n"
                        + "        );\n"
                        + "    }\n"
                        + ");\n\n"

                        + "export default function App() {\n\n"

                        + "    const [completed, setCompleted] =\n"
                        + "        useState(0);\n\n"

                        + "    const handleComplete = useCallback(() => {\n"
                        + "        setCompleted(previous => previous + 1);\n"
                        + "    }, []);\n\n"

                        + "    return (\n"
                        + "        <View>\n\n"

                        + "            <Text>\n"
                        + "                Completed: {completed}\n"
                        + "            </Text>\n\n"

                        + "            <LessonButton\n"
                        + "                onComplete={handleComplete}\n"
                        + "            />\n\n"

                        + "        </View>\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "This example demonstrates "
                        + "React.memo and "
                        + "useCallback together.\n\n"

                        + "The App component "
                        + "stores completed "
                        + "using useState.\n\n"

                        + "handleComplete uses "
                        + "a functional state "
                        + "update to increase "
                        + "the counter.\n\n"

                        + "useCallback keeps "
                        + "the function reference "
                        + "stable while its "
                        + "dependencies remain "
                        + "unchanged.\n\n"

                        + "LessonButton receives "
                        + "that function as "
                        + "an onComplete prop.\n\n"

                        + "React.memo can skip "
                        + "some LessonButton "
                        + "re-renders when "
                        + "the prop value "
                        + "does not change.\n\n"

                        + "The displayed counter "
                        + "still updates normally.\n\n"

                        + "This is a simple "
                        + "optimization example. "
                        + "For small components, "
                        + "memoization may provide "
                        + "little practical benefit.";

        String question =
                "Which React feature "
                        + "can help avoid "
                        + "some child component "
                        + "re-renders when "
                        + "its props are unchanged?";

        String[] options = {
                "SQLiteDatabase",
                "React.memo",
                "AndroidManifest",
                "Intent.ACTION_VIEW"
        };

        String answerExplanation =
                "React.memo can skip "
                        + "certain component "
                        + "re-renders when "
                        + "its props remain "
                        + "unchanged. It is "
                        + "a performance "
                        + "optimization rather "
                        + "than a requirement "
                        + "for every component.";

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
