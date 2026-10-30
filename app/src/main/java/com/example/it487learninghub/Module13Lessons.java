package com.example.it487learninghub;

public final class Module13Lessons {

    // Prevent creating instances
    private Module13Lessons() {
    }

    // =====================================
    // GET MODULE 13 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return flexboxLayoutFundamentals();

            case 2:
                return stylingWithReactNative();

            case 3:
                return rowsColumnsAndFlexibleGrids();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Flexbox Layout Fundamentals
    // =====================================

    private static LessonContent flexboxLayoutFundamentals() {

        String summary =
                "Understand the Flexbox layout system "
                        + "in React Native, including direction, "
                        + "alignment, spacing, and flexible sizing.";

        String explanation =
                "Flexbox is the primary layout system "
                        + "used to organize React Native "
                        + "interface components.\n\n"

                        + "WHAT IS FLEXBOX?\n"
                        + "Flexbox arranges child components "
                        + "along a main axis and a cross axis.\n\n"

                        + "FLEXDIRECTION:\n"
                        + "The flexDirection property controls "
                        + "the direction of child components.\n\n"

                        + "Common values include:\n"
                        + "column, row, column-reverse, "
                        + "and row-reverse.\n\n"

                        + "REACT NATIVE DEFAULT:\n"
                        + "React Native uses column as "
                        + "the default flexDirection.\n\n"

                        + "This differs from the default "
                        + "row direction commonly used "
                        + "by Flexbox on the web.\n\n"

                        + "MAIN AXIS:\n"
                        + "The main axis follows "
                        + "the flexDirection.\n\n"

                        + "When flexDirection is column, "
                        + "the main axis is vertical.\n\n"

                        + "When flexDirection is row, "
                        + "the main axis is horizontal.\n\n"

                        + "JUSTIFYCONTENT:\n"
                        + "justifyContent controls alignment "
                        + "and distribution along "
                        + "the main axis.\n\n"

                        + "Common values include "
                        + "flex-start, center, flex-end, "
                        + "space-between, and space-around.\n\n"

                        + "ALIGNITEMS:\n"
                        + "alignItems controls how children "
                        + "are aligned along the cross axis.\n\n"

                        + "Common values include "
                        + "flex-start, center, flex-end, "
                        + "and stretch.\n\n"

                        + "FLEX PROPERTY:\n"
                        + "The flex property controls "
                        + "how a component grows "
                        + "or shrinks within "
                        + "the available space.\n\n"

                        + "For example, flex: 1 "
                        + "can make a component expand "
                        + "to occupy available space "
                        + "along the main axis.\n\n"

                        + "NESTED LAYOUTS:\n"
                        + "Developers can combine "
                        + "row and column containers "
                        + "to create complex layouts.\n\n"

                        + "RESPONSIVE DESIGN:\n"
                        + "Flexbox helps interfaces adapt "
                        + "to different screen sizes "
                        + "without manually positioning "
                        + "every element.";

        String takeaway =
                "Flexbox organizes components "
                        + "using flexDirection, justifyContent, "
                        + "alignItems, and flex. "
                        + "React Native uses column "
                        + "as its default direction.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    StyleSheet\n"
                        + "} from 'react-native';\n\n"

                        + "export default function App() {\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                Flexbox Basics\n"
                        + "            </Text>\n\n"

                        + "            <View style={styles.row}>\n\n"

                        + "                <View style={styles.box}>\n"
                        + "                    <Text style={styles.text}>\n"
                        + "                        Box A\n"
                        + "                    </Text>\n"
                        + "                </View>\n\n"

                        + "                <View style={styles.box}>\n"
                        + "                    <Text style={styles.text}>\n"
                        + "                        Box B\n"
                        + "                    </Text>\n"
                        + "                </View>\n\n"

                        + "            </View>\n"
                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n\n"

                        + "    container: {\n"
                        + "        flex: 1,\n"
                        + "        justifyContent: 'center',\n"
                        + "        padding: 20,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    title: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 24,\n"
                        + "        marginBottom: 20\n"
                        + "    },\n\n"

                        + "    row: {\n"
                        + "        flexDirection: 'row',\n"
                        + "        justifyContent: 'space-between',\n"
                        + "        alignItems: 'center'\n"
                        + "    },\n\n"

                        + "    box: {\n"
                        + "        width: 100,\n"
                        + "        height: 80,\n"
                        + "        borderRadius: 12,\n"
                        + "        backgroundColor: '#728BFF',\n"
                        + "        justifyContent: 'center',\n"
                        + "        alignItems: 'center'\n"
                        + "    },\n\n"

                        + "    text: {\n"
                        + "        color: '#FFFFFF',\n"
                        + "        fontWeight: 'bold'\n"
                        + "    }\n"
                        + "});";

        String codeExplanation =
                "The example uses React Native "
                        + "View components to build "
                        + "a Flexbox interface.\n\n"

                        + "The main container uses flex: 1 "
                        + "to occupy available space.\n\n"

                        + "Its justifyContent property "
                        + "centers the content vertically "
                        + "because the default direction "
                        + "is column.\n\n"

                        + "The inner row uses "
                        + "flexDirection: 'row' "
                        + "to arrange two boxes "
                        + "horizontally.\n\n"

                        + "space-between distributes "
                        + "the available horizontal "
                        + "space between the boxes.\n\n"

                        + "alignItems: 'center' aligns "
                        + "the boxes along the cross axis.\n\n"

                        + "Each box centers its text "
                        + "using justifyContent "
                        + "and alignItems.\n\n"

                        + "This example demonstrates "
                        + "Flexbox layout principles "
                        + "inside a React Native app.";

        String question =
                "What is the default value "
                        + "of flexDirection in React Native?";

        String[] options = {
                "row",
                "column",
                "row-reverse",
                "absolute"
        };

        String answerExplanation =
                "React Native uses column "
                        + "as the default flexDirection. "
                        + "Children are therefore "
                        + "arranged vertically "
                        + "unless another direction "
                        + "is specified.";

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
    // Styling with React Native
    // =====================================

    private static LessonContent stylingWithReactNative() {

        String summary =
                "Learn how to style React Native "
                        + "components using StyleSheet, "
                        + "colors, spacing, typography, "
                        + "and dynamic style combinations.";

        String explanation =
                "React Native uses JavaScript "
                        + "style objects to define "
                        + "the appearance of components.\n\n"

                        + "STYLING SYSTEM:\n"
                        + "Most React Native components "
                        + "accept a style prop.\n\n"

                        + "Styles can control "
                        + "colors, dimensions, "
                        + "spacing, and alignment.\n\n"

                        + "STYLESHEET.CREATE:\n"
                        + "StyleSheet.create() provides "
                        + "a convenient way to organize "
                        + "named style definitions.\n\n"

                        + "CAMELCASE PROPERTIES:\n"
                        + "React Native uses "
                        + "JavaScript-style property names.\n\n"

                        + "For example, backgroundColor "
                        + "is used instead of "
                        + "background-color.\n\n"

                        + "COLORS:\n"
                        + "Colors can be defined "
                        + "using hexadecimal values "
                        + "such as #728BFF.\n\n"

                        + "TYPOGRAPHY:\n"
                        + "Text components support "
                        + "properties such as "
                        + "fontSize, fontWeight, "
                        + "and color.\n\n"

                        + "SPACING:\n"
                        + "Padding controls the space "
                        + "inside a component.\n\n"

                        + "Margin controls spacing "
                        + "outside a component.\n\n"

                        + "DIMENSIONS:\n"
                        + "Many layout properties "
                        + "use unitless numeric values "
                        + "representing logical pixels.\n\n"

                        + "Percentage dimensions "
                        + "can also be used "
                        + "when supported.\n\n"

                        + "BORDERS:\n"
                        + "borderWidth, borderColor, "
                        + "and borderRadius can "
                        + "style component boundaries.\n\n"

                        + "STYLE ARRAYS:\n"
                        + "React Native accepts "
                        + "arrays of styles.\n\n"

                        + "Later styles in the array "
                        + "can override conflicting "
                        + "properties from earlier styles.\n\n"

                        + "DYNAMIC STYLES:\n"
                        + "Styles can change depending "
                        + "on component props "
                        + "or state.\n\n"

                        + "For example, a selected "
                        + "button may use a different "
                        + "background color.\n\n"

                        + "DARK INTERFACES:\n"
                        + "A dark application theme "
                        + "often uses dark surfaces "
                        + "and light text.\n\n"

                        + "CONSISTENCY:\n"
                        + "Reusable styles help "
                        + "maintain a consistent "
                        + "design across screens.";

        String takeaway =
                "React Native uses the "
                        + "style prop and JavaScript "
                        + "style objects. "
                        + "StyleSheet.create() organizes "
                        + "styles, while style arrays "
                        + "support conditional appearance.";

        String code =
                "// React Native example\n"
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

                        + "    const [selected, setSelected] =\n"
                        + "        useState(false);\n\n"

                        + "    return (\n"
                        + "        <View style={styles.container}>\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                Styling Demo\n"
                        + "            </Text>\n\n"

                        + "            <Pressable\n"
                        + "                onPress={() =>\n"
                        + "                    setSelected(previous => !previous)\n"
                        + "                }\n"
                        + "                style={[\n"
                        + "                    styles.button,\n"
                        + "                    selected && styles.selectedButton\n"
                        + "                ]}\n"
                        + "            >\n\n"

                        + "                <Text style={styles.buttonText}>\n"
                        + "                    {selected\n"
                        + "                        ? 'Selected'\n"
                        + "                        : 'Tap to Select'}\n"
                        + "                </Text>\n\n"

                        + "            </Pressable>\n"
                        + "        </View>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n\n"

                        + "    container: {\n"
                        + "        flex: 1,\n"
                        + "        justifyContent: 'center',\n"
                        + "        padding: 24,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    title: {\n"
                        + "        fontSize: 24,\n"
                        + "        fontWeight: 'bold',\n"
                        + "        color: '#F8FAFC',\n"
                        + "        marginBottom: 20\n"
                        + "    },\n\n"

                        + "    button: {\n"
                        + "        backgroundColor: '#728BFF',\n"
                        + "        padding: 16,\n"
                        + "        borderRadius: 12,\n"
                        + "        alignItems: 'center'\n"
                        + "    },\n\n"

                        + "    selectedButton: {\n"
                        + "        backgroundColor: '#36D6B3'\n"
                        + "    },\n\n"

                        + "    buttonText: {\n"
                        + "        color: '#0B1020',\n"
                        + "        fontWeight: 'bold'\n"
                        + "    }\n"
                        + "});";

        String codeExplanation =
                "The example creates "
                        + "a button with "
                        + "a dynamic appearance.\n\n"

                        + "useState(false) stores "
                        + "whether the button "
                        + "is selected.\n\n"

                        + "The Pressable component "
                        + "handles user interaction.\n\n"

                        + "When pressed, setSelected() "
                        + "reverses the current "
                        + "selected value.\n\n"

                        + "The style array always "
                        + "includes styles.button.\n\n"

                        + "When selected is true, "
                        + "styles.selectedButton "
                        + "overrides the background "
                        + "color of the button.\n\n"

                        + "The button label changes "
                        + "between Tap to Select "
                        + "and Selected.\n\n"

                        + "This demonstrates how "
                        + "state and styles work "
                        + "together in React Native.";

        String question =
                "Which React Native API "
                        + "is commonly used to organize "
                        + "named style definitions?";

        String[] options = {
                "SQLiteOpenHelper",
                "Intent.createChooser()",
                "StyleSheet.create()",
                "AndroidManifest.xml"
        };

        String answerExplanation =
                "StyleSheet.create() is used "
                        + "to organize React Native "
                        + "style definitions. "
                        + "Components can apply them "
                        + "through the style prop.";

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
    // Rows, Columns and Flexible Grids
    // =====================================

    private static LessonContent
    rowsColumnsAndFlexibleGrids() {

        String summary =
                "Learn how to combine Flexbox rows, "
                        + "columns, wrapping, and responsive "
                        + "dimensions to create flexible "
                        + "React Native grid layouts.";

        String explanation =
                "Responsive layouts adjust "
                        + "their appearance according "
                        + "to the available screen space.\n\n"

                        + "ROWS:\n"
                        + "A row layout uses "
                        + "flexDirection: 'row' "
                        + "to arrange children "
                        + "horizontally.\n\n"

                        + "COLUMNS:\n"
                        + "A column layout uses "
                        + "flexDirection: 'column' "
                        + "to arrange children "
                        + "vertically.\n\n"

                        + "NESTED FLEXBOX:\n"
                        + "Rows can contain columns "
                        + "and columns can contain rows.\n\n"

                        + "This allows developers "
                        + "to build dashboards "
                        + "and card-based screens.\n\n"

                        + "FLEXWRAP:\n"
                        + "The flexWrap property "
                        + "controls whether children "
                        + "can move onto additional "
                        + "lines when space is limited.\n\n"

                        + "flexWrap: 'wrap' allows "
                        + "items to wrap onto "
                        + "new rows in a "
                        + "horizontal layout.\n\n"

                        + "PERCENTAGE WIDTH:\n"
                        + "A component can use "
                        + "a percentage width "
                        + "such as '48%'.\n\n"

                        + "This can help place "
                        + "two cards side by side.\n\n"

                        + "SCREEN DIMENSIONS:\n"
                        + "React Native provides "
                        + "the useWindowDimensions "
                        + "Hook to read the "
                        + "available window size.\n\n"

                        + "RESPONSIVE COLUMNS:\n"
                        + "An application can "
                        + "display two columns "
                        + "on narrower screens "
                        + "and three columns "
                        + "on wider screens.\n\n"

                        + "SCROLLABLE CONTENT:\n"
                        + "ScrollView can display "
                        + "content that is larger "
                        + "than the visible area.\n\n"

                        + "LARGE DATA COLLECTIONS:\n"
                        + "FlatList is often better "
                        + "than manually rendering "
                        + "a large number of cards "
                        + "inside a ScrollView.\n\n"

                        + "FLATLIST COLUMNS:\n"
                        + "FlatList supports "
                        + "numColumns for "
                        + "multi-column layouts.\n\n"

                        + "RESPONSIVE TESTING:\n"
                        + "Layouts should be tested "
                        + "on screens with different "
                        + "widths and orientations.\n\n"

                        + "DESIGN GOAL:\n"
                        + "A flexible grid should "
                        + "maintain readable text, "
                        + "usable spacing, "
                        + "and consistent card sizes.";

        String takeaway =
                "Combine flexDirection, flexWrap, "
                        + "percentage widths, and "
                        + "window dimensions to build "
                        + "responsive grids. "
                        + "Use FlatList for large "
                        + "collections of items.";

        String code =
                "// React Native example\n"
                        + "// File: App.js\n\n"

                        + "import React from 'react';\n\n"

                        + "import {\n"
                        + "    View,\n"
                        + "    Text,\n"
                        + "    ScrollView,\n"
                        + "    StyleSheet,\n"
                        + "    useWindowDimensions\n"
                        + "} from 'react-native';\n\n"

                        + "const lessons = [\n"
                        + "    { id: 1, title: 'Flexbox' },\n"
                        + "    { id: 2, title: 'Styling' },\n"
                        + "    { id: 3, title: 'Components' },\n"
                        + "    { id: 4, title: 'Navigation' },\n"
                        + "    { id: 5, title: 'State' },\n"
                        + "    { id: 6, title: 'Context' }\n"
                        + "];\n\n"

                        + "export default function App() {\n\n"

                        + "    const { width } = useWindowDimensions();\n\n"

                        + "    const columns = width >= 600 ? 3 : 2;\n\n"

                        + "    const cardWidth =\n"
                        + "        columns === 3 ? '31%' : '48%';\n\n"

                        + "    return (\n"
                        + "        <ScrollView\n"
                        + "            style={styles.screen}\n"
                        + "            contentContainerStyle={styles.content}\n"
                        + "        >\n\n"

                        + "            <Text style={styles.title}>\n"
                        + "                Learning Modules\n"
                        + "            </Text>\n\n"

                        + "            <View style={styles.grid}>\n\n"

                        + "                {lessons.map(lesson => (\n\n"

                        + "                    <View\n"
                        + "                        key={lesson.id}\n"
                        + "                        style={[\n"
                        + "                            styles.card,\n"
                        + "                            { width: cardWidth }\n"
                        + "                        ]}\n"
                        + "                    >\n\n"

                        + "                        <Text style={styles.cardText}>\n"
                        + "                            {lesson.title}\n"
                        + "                        </Text>\n\n"

                        + "                    </View>\n\n"

                        + "                ))}\n\n"

                        + "            </View>\n"
                        + "        </ScrollView>\n"
                        + "    );\n"
                        + "}\n\n"

                        + "const styles = StyleSheet.create({\n\n"

                        + "    screen: {\n"
                        + "        flex: 1,\n"
                        + "        backgroundColor: '#0B1020'\n"
                        + "    },\n\n"

                        + "    content: {\n"
                        + "        padding: 20\n"
                        + "    },\n\n"

                        + "    title: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 24,\n"
                        + "        fontWeight: 'bold',\n"
                        + "        marginBottom: 20\n"
                        + "    },\n\n"

                        + "    grid: {\n"
                        + "        flexDirection: 'row',\n"
                        + "        flexWrap: 'wrap',\n"
                        + "        justifyContent: 'space-between'\n"
                        + "    },\n\n"

                        + "    card: {\n"
                        + "        minHeight: 100,\n"
                        + "        padding: 12,\n"
                        + "        marginBottom: 12,\n"
                        + "        borderRadius: 12,\n"
                        + "        backgroundColor: '#192743',\n"
                        + "        justifyContent: 'center',\n"
                        + "        alignItems: 'center'\n"
                        + "    },\n\n"

                        + "    cardText: {\n"
                        + "        color: '#F8FAFC',\n"
                        + "        fontSize: 15,\n"
                        + "        fontWeight: 'bold',\n"
                        + "        textAlign: 'center'\n"
                        + "    }\n"
                        + "});";

        String codeExplanation =
                "The example displays "
                        + "six learning cards "
                        + "in a responsive grid.\n\n"

                        + "useWindowDimensions() "
                        + "provides the current "
                        + "window width.\n\n"

                        + "When the width is "
                        + "at least 600 logical pixels, "
                        + "the layout displays "
                        + "three columns.\n\n"

                        + "Otherwise, it uses "
                        + "two columns.\n\n"

                        + "Each card receives "
                        + "a percentage width "
                        + "based on the column count.\n\n"

                        + "The grid uses "
                        + "flexDirection: 'row' "
                        + "to arrange cards "
                        + "horizontally.\n\n"

                        + "flexWrap: 'wrap' allows "
                        + "additional cards "
                        + "to move to a new row.\n\n"

                        + "The map() method "
                        + "creates one card "
                        + "for each lesson.\n\n"

                        + "The lesson ID "
                        + "provides a stable key.\n\n"

                        + "ScrollView allows "
                        + "the screen to scroll "
                        + "when necessary.\n\n"

                        + "For much larger data "
                        + "collections, FlatList "
                        + "would generally be "
                        + "a better choice.";

        String question =
                "Which Flexbox property "
                        + "allows child components "
                        + "to move onto additional "
                        + "rows when there "
                        + "is not enough space?";

        String[] options = {
                "flexWrap: 'wrap'",
                "fontWeight: 'bold'",
                "backgroundColor",
                "borderRadius"
        };

        String answerExplanation =
                "flexWrap: 'wrap' allows "
                        + "items inside a Flexbox "
                        + "container to move "
                        + "onto additional lines "
                        + "when the available "
                        + "space is insufficient.";

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
