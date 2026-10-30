package com.example.it487learninghub;

public final class Module04Lessons {

    private Module04Lessons() {
    }

    // Return lesson content by lesson number
    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return introductionToLayouts();

            case 2:
                return linearLayoutAndConstraintLayout();

            case 3:
                return materialDesignPrinciples();

            case 4:
                return cardViewAndComponents();

            case 5:
                return responsiveInterfaces();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Introduction to Android Layouts
    // =====================================

    private static LessonContent introductionToLayouts() {

        String summary =
                "Learn how Android layouts organize "
                        + "interface components and how XML "
                        + "defines the structure of a screen.";

        String explanation =
                "An Android layout defines how user "
                        + "interface elements are arranged "
                        + "on the screen.\n\n"

                        + "VIEWS AND VIEWGROUPS:\n"
                        + "A View is a basic interface element, "
                        + "such as TextView, Button, or EditText.\n\n"

                        + "A ViewGroup is a container that "
                        + "holds and arranges other views. "
                        + "Examples include LinearLayout, "
                        + "ConstraintLayout, and FrameLayout.\n\n"

                        + "XML LAYOUTS:\n"
                        + "Android interfaces are commonly "
                        + "described using XML files stored "
                        + "in res/layout.\n\n"

                        + "LAYOUT WIDTH AND HEIGHT:\n"
                        + "match_parent requests the available "
                        + "size provided by the parent.\n\n"

                        + "wrap_content sizes a view according "
                        + "to its content and layout rules.\n\n"

                        + "DIMENSION UNITS:\n"
                        + "dp is commonly used for layout "
                        + "dimensions, while sp is recommended "
                        + "for text sizes.\n\n"

                        + "SPACING:\n"
                        + "Padding adds space inside a view. "
                        + "Margins add space outside a view, "
                        + "subject to the parent layout rules.\n\n"

                        + "A well-structured layout helps "
                        + "create readable and maintainable "
                        + "Android interfaces.";

        String takeaway =
                "Views display interface elements, "
                        + "while ViewGroups organize them. "
                        + "Use XML layouts, dp for dimensions, "
                        + "sp for text, and appropriate padding "
                        + "and margins.";

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
                        + "        android:text=\"Welcome to Android\"\n"
                        + "        android:textSize=\"22sp\" />\n\n"

                        + "    <Button\n"
                        + "        android:layout_width=\"match_parent\"\n"
                        + "        android:layout_height=\"wrap_content\"\n"
                        + "        android:layout_marginTop=\"16dp\"\n"
                        + "        android:text=\"Start Learning\" />\n\n"

                        + "</LinearLayout>";

        String codeExplanation =
                "LinearLayout is the root ViewGroup.\n\n"

                        + "Its vertical orientation arranges "
                        + "the TextView and Button from top "
                        + "to bottom.\n\n"

                        + "The root padding adds internal space.\n\n"

                        + "The TextView uses wrap_content "
                        + "and displays text at 22sp.\n\n"

                        + "The Button uses match_parent "
                        + "for its width and has a top margin.";

        String question =
                "Which Android component acts as "
                        + "a container that arranges child views?";

        String[] options = {
                "Toast",
                "Intent",
                "ViewGroup",
                "Bundle"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                2,
                "A ViewGroup is a container for "
                        + "child views. Layout classes such "
                        + "as LinearLayout and ConstraintLayout "
                        + "are ViewGroups."
        );
    }

    // =====================================
    // LESSON 02
    // LinearLayout and ConstraintLayout
    // =====================================

    private static LessonContent linearLayoutAndConstraintLayout() {

        String summary =
                "Understand LinearLayout and "
                        + "ConstraintLayout in Android.";

        String explanation =
                "LinearLayout arranges child views "
                        + "in a single direction: horizontal "
                        + "or vertical.\n\n"

                        + "ConstraintLayout positions views "
                        + "using constraints relative to "
                        + "the parent or other views.\n\n"

                        + "Both help developers create "
                        + "organized Android interfaces.";

        String takeaway =
                "Use LinearLayout for straightforward "
                        + "rows and columns. Use ConstraintLayout "
                        + "for flexible positioning relationships "
                        + "between views.";

        String code =
                "<LinearLayout\n"
                        + "    xmlns:android="
                        + "\"http://schemas.android.com/"
                        + "apk/res/android\"\n"
                        + "    android:layout_width="
                        + "\"match_parent\"\n"
                        + "    android:layout_height="
                        + "\"wrap_content\"\n"
                        + "    android:orientation="
                        + "\"vertical\">\n\n"
                        + "    <TextView\n"
                        + "        android:layout_width="
                        + "\"wrap_content\"\n"
                        + "        android:layout_height="
                        + "\"wrap_content\"\n"
                        + "        android:text=\"Welcome\" />\n"
                        + "</LinearLayout>";

        String codeExplanation =
                "This example creates a vertical "
                        + "LinearLayout containing a TextView.";

        String practiceQuestion =
                "Which layout arranges its child views "
                        + "in a horizontal or vertical direction?";

        String[] options = {
                "FrameLayout",
                "LinearLayout",
                "ConstraintLayout",
                "GridLayout"
        };

        int correctAnswerIndex = 1;

        String answerExplanation =
                "LinearLayout arranges child views "
                        + "sequentially according to its "
                        + "orientation property.";

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
    // LESSON 03
    // Material Design Principles
    // =====================================

    private static LessonContent materialDesignPrinciples() {

        String summary =
                "Understand Material Design and how "
                        + "consistent colors, typography, "
                        + "spacing, and components improve "
                        + "the user experience.";

        String explanation =
                "Material Design is a design system "
                        + "that provides guidelines and "
                        + "components for building consistent "
                        + "digital interfaces.\n\n"

                        + "VISUAL HIERARCHY:\n"
                        + "A clear hierarchy helps users "
                        + "identify the most important "
                        + "information and actions.\n\n"

                        + "TYPOGRAPHY:\n"
                        + "Different text styles communicate "
                        + "headings, labels, and supporting "
                        + "information.\n\n"

                        + "COLORS AND THEMES:\n"
                        + "A consistent color scheme supports "
                        + "recognition, branding, and clarity. "
                        + "Colors should also provide "
                        + "sufficient contrast.\n\n"

                        + "SPACING:\n"
                        + "Consistent margins and padding "
                        + "help separate related elements "
                        + "and reduce visual clutter.\n\n"

                        + "MATERIAL COMPONENTS:\n"
                        + "Material Components for Android "
                        + "include MaterialButton, "
                        + "MaterialCardView, and text input "
                        + "components.\n\n"

                        + "ACCESSIBILITY:\n"
                        + "Interfaces should support readable "
                        + "text, meaningful labels, touch "
                        + "targets, and clear feedback.\n\n"

                        + "CONSISTENCY:\n"
                        + "Using the same design conventions "
                        + "throughout an app helps users "
                        + "understand its behavior.";

        String takeaway =
                "Material Design encourages clear "
                        + "hierarchy, consistent components, "
                        + "accessible interfaces, and "
                        + "meaningful interaction feedback.";

        String code =
                "<com.google.android.material.button."
                        + "MaterialButton\n"

                        + "    xmlns:android=\"http://schemas."
                        + "android.com/apk/res/android\"\n"

                        + "    xmlns:app=\"http://schemas."
                        + "android.com/apk/res-auto\"\n"

                        + "    android:layout_width=\"match_parent\"\n"
                        + "    android:layout_height=\"wrap_content\"\n"
                        + "    android:layout_margin=\"16dp\"\n"
                        + "    android:text=\"Continue Learning\"\n"
                        + "    android:textAllCaps=\"false\"\n"
                        + "    app:cornerRadius=\"16dp\" />";

        String codeExplanation =
                "This XML example defines a MaterialButton "
                        + "using the Material Components library.\n\n"

                        + "The button fills the available width, "
                        + "uses an external margin, and has "
                        + "rounded corners.\n\n"

                        + "textAllCaps is disabled so the "
                        + "button preserves its text casing.\n\n"

                        + "A compatible Material theme and "
                        + "the Material Components dependency "
                        + "are needed in the Android project.";

        String question =
                "What is an important goal of "
                        + "Material Design?";

        String[] options = {
                "Replacing SQLite databases",
                "Removing Android Activities",
                "Writing applications without XML",
                "Creating consistent and usable interfaces"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                3,
                "Material Design provides guidelines "
                        + "and components that help developers "
                        + "create consistent, usable, and "
                        + "accessible interfaces."
        );
    }

    // =====================================
    // LESSON 04
    // CardView and UI Components
    // =====================================

    private static LessonContent cardViewAndComponents() {

        String summary =
                "Learn how cards group related "
                        + "information and how reusable "
                        + "Android UI components create "
                        + "structured interfaces.";

        String explanation =
                "Android applications use interface "
                        + "components to display information "
                        + "and allow users to interact "
                        + "with the application.\n\n"

                        + "COMMON COMPONENTS:\n"
                        + "TextView displays text.\n"
                        + "Button triggers an action.\n"
                        + "EditText accepts user input.\n"
                        + "ImageView displays images.\n\n"

                        + "CARDVIEW:\n"
                        + "CardView is a container that can "
                        + "present related content in a "
                        + "card-shaped surface.\n\n"

                        + "MATERIALCARDVIEW:\n"
                        + "MaterialCardView extends the idea "
                        + "of a card by providing Material "
                        + "styling capabilities such as "
                        + "rounded corners and strokes.\n\n"

                        + "GROUPING CONTENT:\n"
                        + "A learning platform might display "
                        + "each module as a card containing "
                        + "a title, lesson count, and progress.\n\n"

                        + "REUSABILITY:\n"
                        + "Reusable layouts and RecyclerView "
                        + "adapters can help display many "
                        + "similar cards consistently.\n\n"

                        + "USER INTERACTION:\n"
                        + "Cards can respond to clicks, "
                        + "but interactive elements should "
                        + "provide clear feedback and "
                        + "meaningful accessibility labels.";

        String takeaway =
                "Cards organize related information. "
                        + "MaterialCardView supports styled "
                        + "surfaces, while reusable UI components "
                        + "improve consistency and maintainability.";

        String code =
                "<com.google.android.material.card."
                        + "MaterialCardView\n"

                        + "    xmlns:android=\"http://schemas."
                        + "android.com/apk/res/android\"\n"

                        + "    xmlns:app=\"http://schemas."
                        + "android.com/apk/res-auto\"\n"

                        + "    android:layout_width=\"match_parent\"\n"
                        + "    android:layout_height=\"wrap_content\"\n"
                        + "    android:layout_margin=\"16dp\"\n"
                        + "    app:cardCornerRadius=\"16dp\"\n"
                        + "    app:strokeWidth=\"1dp\">\n\n"

                        + "    <LinearLayout\n"
                        + "        android:layout_width=\"match_parent\"\n"
                        + "        android:layout_height=\"wrap_content\"\n"
                        + "        android:orientation=\"vertical\"\n"
                        + "        android:padding=\"16dp\">\n\n"

                        + "        <TextView\n"
                        + "            android:layout_width=\"wrap_content\"\n"
                        + "            android:layout_height=\"wrap_content\"\n"
                        + "            android:text=\"Activity Lifecycle\"\n"
                        + "            android:textStyle=\"bold\" />\n\n"

                        + "        <TextView\n"
                        + "            android:layout_width=\"wrap_content\"\n"
                        + "            android:layout_height=\"wrap_content\"\n"
                        + "            android:text=\"3 Lessons\" />\n\n"

                        + "    </LinearLayout>\n"

                        + "</com.google.android.material.card."
                        + "MaterialCardView>";

        String codeExplanation =
                "MaterialCardView creates the outer "
                        + "card surface.\n\n"

                        + "cardCornerRadius rounds the corners, "
                        + "and strokeWidth specifies the "
                        + "outline thickness.\n\n"

                        + "Inside the card, LinearLayout "
                        + "arranges two TextViews vertically.\n\n"

                        + "This pattern is useful when "
                        + "displaying courses, products, "
                        + "messages, or learning modules.\n\n"

                        + "Material Components and a compatible "
                        + "theme are required.";

        String question =
                "Which component is designed to display "
                        + "related content inside a Material-style "
                        + "card surface?";

        String[] options = {
                "MaterialCardView",
                "Toast",
                "Intent",
                "SQLiteOpenHelper"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                0,
                "MaterialCardView is a Material "
                        + "component that can group related "
                        + "views inside a styled card surface."
        );
    }

    // =====================================
    // LESSON 05
    // Responsive Android Interfaces
    // =====================================

    private static LessonContent responsiveInterfaces() {

        String summary =
                "Learn how to create Android interfaces "
                        + "that adapt to different screen sizes, "
                        + "orientations, and accessibility settings.";

        String explanation =
                "Android applications can run on "
                        + "phones, tablets, foldable devices, "
                        + "and displays with different sizes.\n\n"

                        + "RESPONSIVE DESIGN:\n"
                        + "A responsive interface adjusts "
                        + "its layout according to the "
                        + "available display space.\n\n"

                        + "FLEXIBLE DIMENSIONS:\n"
                        + "Using match_parent, wrap_content, "
                        + "and suitable layout constraints "
                        + "helps avoid unnecessary fixed "
                        + "pixel dimensions.\n\n"

                        + "RESOURCE QUALIFIERS:\n"
                        + "Android can select resources "
                        + "based on the device configuration.\n\n"

                        + "For example, values-sw600dp "
                        + "can contain dimension values "
                        + "for devices with a smallest "
                        + "available width of at least 600dp.\n\n"

                        + "SCREEN ORIENTATION:\n"
                        + "The available width and height "
                        + "may change when a device rotates. "
                        + "The interface should remain usable.\n\n"

                        + "SCROLLING:\n"
                        + "ScrollView and RecyclerView help "
                        + "present content that does not "
                        + "fit on one screen.\n\n"

                        + "ACCESSIBILITY:\n"
                        + "Text should remain readable "
                        + "when users increase the font size. "
                        + "Important controls should remain "
                        + "accessible without overlapping.\n\n"

                        + "TESTING:\n"
                        + "Developers should test on "
                        + "different screen sizes and "
                        + "orientations using Android Emulator.";

        String takeaway =
                "Use flexible layouts, appropriate "
                        + "dimension units, resource qualifiers, "
                        + "scrolling, and device testing to "
                        + "create responsive Android interfaces.";

        String code =
                "// res/values/dimens.xml\n\n"

                        + "<resources>\n"
                        + "    <dimen name=\"page_padding\">16dp</dimen>\n"
                        + "</resources>\n\n"

                        + "// res/values-sw600dp/dimens.xml\n\n"

                        + "<resources>\n"
                        + "    <dimen name=\"page_padding\">32dp</dimen>\n"
                        + "</resources>\n\n"

                        + "// Example layout attribute\n\n"

                        + "android:padding=\"@dimen/page_padding\"";

        String codeExplanation =
                "This example illustrates Android "
                        + "resource qualifiers.\n\n"

                        + "The default dimens.xml defines "
                        + "page_padding as 16dp.\n\n"

                        + "The values-sw600dp version defines "
                        + "the same resource as 32dp for "
                        + "configurations meeting the "
                        + "smallest-width requirement.\n\n"

                        + "The layout references the resource "
                        + "using @dimen/page_padding, allowing "
                        + "Android to select the appropriate value.\n\n"

                        + "The displayed example contains "
                        + "two separate resource files and "
                        + "a layout attribute. They must be "
                        + "placed in their corresponding "
                        + "project files.";

        String question =
                "What is the purpose of the Android "
                        + "resource directory values-sw600dp?";

        String[] options = {
                "To store SQLite database records",
                "To provide resources for configurations "
                        + "with a smallest width of at least 600dp",
                "To disable landscape orientation",
                "To replace Java Activities"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                "The sw600dp qualifier allows Android "
                        + "to select resources when the device "
                        + "configuration has a smallest "
                        + "available width of at least 600dp."
        );
    }
}
