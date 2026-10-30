package com.example.it487learninghub;

public final class Module06Lessons {

    // Prevent creating repository instances
    private Module06Lessons() {
    }

    // =====================================
    // GET MODULE 06 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {

            case 1:
                return dialogsAndDialogFragment();

            case 2:
                return toastAndUserFeedback();

            case 3:
                return recyclerViewAdapterAndViewHolder();

            case 4:
                return efficientListsAndInteraction();

            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Dialogs and DialogFragment
    // =====================================

    private static LessonContent
    dialogsAndDialogFragment() {

        String summary =
                "Learn how Android dialogs communicate "
                        + "important information, request user "
                        + "decisions, and support interaction "
                        + "through DialogFragment.";

        String explanation =
                "A dialog is a small interface window "
                        + "that appears above the current screen "
                        + "to communicate with the user.\n\n"

                        + "WHY USE DIALOGS:\n"
                        + "Dialogs are useful for confirmations, "
                        + "warnings, and decisions that require "
                        + "the user's attention.\n\n"

                        + "ALERTDIALOG:\n"
                        + "AlertDialog can display a title, "
                        + "message, and action buttons.\n\n"

                        + "For example, an application can "
                        + "ask the user to confirm before "
                        + "deleting a saved note.\n\n"

                        + "DIALOG BUTTONS:\n"
                        + "A dialog may contain positive, "
                        + "negative, or neutral buttons.\n\n"

                        + "The positive button normally "
                        + "confirms an action. The negative "
                        + "button often cancels it.\n\n"

                        + "DIALOGFRAGMENT:\n"
                        + "DialogFragment is a Fragment "
                        + "designed to display a dialog.\n\n"

                        + "It integrates with FragmentManager "
                        + "and helps manage dialog behavior "
                        + "during Activity lifecycle changes.\n\n"

                        + "FRAGMENT MANAGER:\n"
                        + "FragmentManager manages the "
                        + "Fragments associated with "
                        + "an Activity.\n\n"

                        + "A DialogFragment can be displayed "
                        + "using its show() method.\n\n"

                        + "GOOD DESIGN:\n"
                        + "Dialogs should have clear messages "
                        + "and meaningful action labels.\n\n"

                        + "Avoid showing unnecessary dialogs "
                        + "that interrupt the user "
                        + "without a useful reason.";

        String takeaway =
                "Use AlertDialog for confirmation "
                        + "and decision-making interfaces. "
                        + "DialogFragment provides a "
                        + "lifecycle-aware way to present "
                        + "dialogs through FragmentManager.";

        String code =
                "// Example: ConfirmDialogFragment.java\n\n"

                        + "public class ConfirmDialogFragment\n"
                        + "        extends DialogFragment {\n\n"

                        + "    @NonNull\n"
                        + "    @Override\n"
                        + "    public Dialog onCreateDialog(\n"
                        + "            @Nullable Bundle savedInstanceState) {\n\n"

                        + "        return new AlertDialog.Builder(\n"
                        + "                requireContext()\n"
                        + "        )\n"
                        + "        .setTitle(\"Delete Note\")\n"
                        + "        .setMessage(\n"
                        + "                \"Are you sure you want "
                        + "to delete this note?\"\n"
                        + "        )\n"
                        + "        .setPositiveButton(\n"
                        + "                \"Delete\",\n"
                        + "                (dialog, which) -> {\n"
                        + "                    // Handle confirmed deletion\n"
                        + "                }\n"
                        + "        )\n"
                        + "        .setNegativeButton(\"Cancel\", null)\n"
                        + "        .create();\n"
                        + "    }\n"
                        + "}\n\n"

                        + "// Activity excerpt:\n\n"

                        + "new ConfirmDialogFragment().show(\n"
                        + "        getSupportFragmentManager(),\n"
                        + "        \"confirm_delete\"\n"
                        + ");";

        String codeExplanation =
                "ConfirmDialogFragment extends "
                        + "the AndroidX DialogFragment class.\n\n"

                        + "onCreateDialog() returns an "
                        + "AlertDialog with a title, "
                        + "message, and two buttons.\n\n"

                        + "Delete represents the "
                        + "confirmation action. The actual "
                        + "deletion logic would be implemented "
                        + "separately.\n\n"

                        + "Cancel dismisses the dialog.\n\n"

                        + "getSupportFragmentManager() "
                        + "provides a FragmentManager "
                        + "for displaying the dialog.\n\n"

                        + "The example is illustrative. "
                        + "The Fragment class and Activity "
                        + "excerpt belong in separate files "
                        + "and require suitable AndroidX imports.";

        String question =
                "Which AndroidX component is "
                        + "specifically designed to display "
                        + "a dialog using FragmentManager?";

        String[] options = {
                "RecyclerView",
                "DialogFragment",
                "SQLiteOpenHelper",
                "TextWatcher"
        };

        String answerExplanation =
                "DialogFragment is a Fragment "
                        + "that displays dialog content "
                        + "and integrates with FragmentManager.";

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
    // Toast and User Feedback
    // =====================================

    private static LessonContent toastAndUserFeedback() {

        String summary =
                "Understand how Android applications "
                        + "provide feedback using Toast, "
                        + "Snackbar, and other interface "
                        + "messages.";

        String explanation =
                "User feedback communicates the "
                        + "results of actions and helps "
                        + "users understand what happened.\n\n"

                        + "TOAST MESSAGES:\n"
                        + "A Toast displays a brief "
                        + "informational message.\n\n"

                        + "For example, an application "
                        + "might show a Toast after "
                        + "successfully copying code.\n\n"

                        + "TOAST DURATION:\n"
                        + "Toast.LENGTH_SHORT and "
                        + "Toast.LENGTH_LONG control "
                        + "the requested display duration.\n\n"

                        + "TOAST LIMITATIONS:\n"
                        + "Toast messages are temporary "
                        + "and should not be the only way "
                        + "to communicate critical information.\n\n"

                        + "SNACKBAR:\n"
                        + "Snackbar displays a brief message "
                        + "associated with an application "
                        + "interface.\n\n"

                        + "Unlike a basic Toast, Snackbar "
                        + "can include an optional action, "
                        + "such as Undo.\n\n"

                        + "INLINE FEEDBACK:\n"
                        + "Validation messages can appear "
                        + "near input fields to explain "
                        + "what users need to correct.\n\n"

                        + "PROGRESS FEEDBACK:\n"
                        + "Progress indicators show "
                        + "the status of operations "
                        + "such as downloads or uploads.\n\n"

                        + "ACCESSIBILITY:\n"
                        + "Feedback should be understandable "
                        + "without relying only on color.\n\n"

                        + "GOOD PRACTICE:\n"
                        + "Provide clear and timely feedback "
                        + "when an action succeeds, fails, "
                        + "or requires attention.";

        String takeaway =
                "Use Toast for simple temporary "
                        + "messages and Snackbar for brief "
                        + "interface feedback that may "
                        + "include an action. Use inline "
                        + "messages for errors that require "
                        + "the user's attention.";

        String code =
                "// Toast example inside an Activity\n\n"

                        + "Toast.makeText(\n"
                        + "        this,\n"
                        + "        \"Lesson bookmarked\",\n"
                        + "        Toast.LENGTH_SHORT\n"
                        + ").show();\n\n"

                        + "// Snackbar example inside an Activity\n\n"

                        + "Snackbar.make(\n"
                        + "        findViewById(android.R.id.content),\n"
                        + "        \"Note saved successfully\",\n"
                        + "        Snackbar.LENGTH_LONG\n"
                        + ").show();";

        String codeExplanation =
                "Toast.makeText() creates "
                        + "a temporary message.\n\n"

                        + "The Activity context is passed "
                        + "as the first argument.\n\n"

                        + "Toast.LENGTH_SHORT specifies "
                        + "the requested duration.\n\n"

                        + "The show() method displays "
                        + "the message.\n\n"

                        + "Snackbar.make() creates "
                        + "a message associated with "
                        + "the supplied View.\n\n"

                        + "The example assumes it runs "
                        + "inside an Activity and that "
                        + "the Material Components library "
                        + "is available for Snackbar.";

        String question =
                "Which Android UI component "
                        + "can display a brief message "
                        + "with an optional action "
                        + "such as Undo?";

        String[] options = {
                "Snackbar",
                "Intent",
                "ViewHolder",
                "SQLiteDatabase"
        };

        String answerExplanation =
                "Snackbar is designed for brief "
                        + "interface messages and can "
                        + "provide an optional action button.";

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
    // LESSON 03
    // RecyclerView, Adapter and ViewHolder
    // =====================================

    private static LessonContent
    recyclerViewAdapterAndViewHolder() {

        String summary =
                "Learn how RecyclerView displays "
                        + "lists efficiently through "
                        + "LayoutManager, Adapter, "
                        + "and ViewHolder.";

        String explanation =
                "RecyclerView is an AndroidX "
                        + "component for displaying "
                        + "scrollable collections of items.\n\n"

                        + "RECYCLERVIEW:\n"
                        + "RecyclerView provides the "
                        + "container for a list of items.\n\n"

                        + "LAYOUTMANAGER:\n"
                        + "LayoutManager controls how "
                        + "the items are arranged.\n\n"

                        + "LinearLayoutManager displays "
                        + "items in a vertical or "
                        + "horizontal list.\n\n"

                        + "GridLayoutManager can display "
                        + "items in a grid.\n\n"

                        + "ADAPTER:\n"
                        + "An Adapter connects a data "
                        + "collection with the views "
                        + "displayed by RecyclerView.\n\n"

                        + "ONCREATEVIEWHOLDER:\n"
                        + "This method creates a ViewHolder "
                        + "when RecyclerView needs a new "
                        + "item View.\n\n"

                        + "ONBINDVIEWHOLDER:\n"
                        + "This method binds data from "
                        + "a specific list position "
                        + "to a ViewHolder.\n\n"

                        + "GETITEMCOUNT:\n"
                        + "This method reports the number "
                        + "of items in the collection.\n\n"

                        + "VIEWHOLDER:\n"
                        + "A ViewHolder stores references "
                        + "to the Views belonging "
                        + "to one list item.\n\n"

                        + "RECYCLING:\n"
                        + "RecyclerView reuses item Views "
                        + "when possible instead of "
                        + "recreating every View.\n\n"

                        + "PRACTICAL EXAMPLE:\n"
                        + "In a learning application, "
                        + "RecyclerView can display "
                        + "a list of modules or lessons.";

        String takeaway =
                "RecyclerView manages the list, "
                        + "LayoutManager arranges items, "
                        + "Adapter binds data, and "
                        + "ViewHolder holds item Views "
                        + "for efficient reuse.";

        String code =
                "// Example adapter class\n\n"

                        + "public class SimpleTitleAdapter extends\n"
                        + "        RecyclerView.Adapter<"
                        + "SimpleTitleAdapter.TitleHolder> {\n\n"

                        + "    private final List<String> titles;\n\n"

                        + "    public SimpleTitleAdapter(\n"
                        + "            List<String> titles) {\n"
                        + "        this.titles = titles;\n"
                        + "    }\n\n"

                        + "    @NonNull\n"
                        + "    @Override\n"
                        + "    public TitleHolder onCreateViewHolder(\n"
                        + "            @NonNull ViewGroup parent,\n"
                        + "            int viewType) {\n\n"

                        + "        View view = LayoutInflater\n"
                        + "                .from(parent.getContext())\n"
                        + "                .inflate(\n"
                        + "                    android.R.layout.simple_list_item_1,\n"
                        + "                    parent,\n"
                        + "                    false\n"
                        + "                );\n\n"

                        + "        return new TitleHolder(view);\n"
                        + "    }\n\n"

                        + "    @Override\n"
                        + "    public void onBindViewHolder(\n"
                        + "            @NonNull TitleHolder holder,\n"
                        + "            int position) {\n\n"

                        + "        holder.title.setText(\n"
                        + "                titles.get(position)\n"
                        + "        );\n"
                        + "    }\n\n"

                        + "    @Override\n"
                        + "    public int getItemCount() {\n"
                        + "        return titles.size();\n"
                        + "    }\n\n"

                        + "    static class TitleHolder extends\n"
                        + "            RecyclerView.ViewHolder {\n\n"

                        + "        final TextView title;\n\n"

                        + "        TitleHolder(@NonNull View itemView) {\n"
                        + "            super(itemView);\n"
                        + "            title = itemView.findViewById(\n"
                        + "                    android.R.id.text1\n"
                        + "            );\n"
                        + "        }\n"
                        + "    }\n"
                        + "}";

        String codeExplanation =
                "SimpleTitleAdapter demonstrates "
                        + "a basic RecyclerView Adapter.\n\n"

                        + "The titles list contains "
                        + "the items being displayed.\n\n"

                        + "onCreateViewHolder() inflates "
                        + "Android's built-in simple "
                        + "text item layout.\n\n"

                        + "onBindViewHolder() displays "
                        + "the item text for a given position.\n\n"

                        + "getItemCount() returns "
                        + "the number of titles.\n\n"

                        + "TitleHolder stores the TextView "
                        + "reference for each item.\n\n"

                        + "A complete screen must also "
                        + "assign a LayoutManager and "
                        + "set this Adapter on RecyclerView. "
                        + "The example requires the "
                        + "appropriate AndroidX and "
                        + "Java imports.";

        String question =
                "Which RecyclerView method "
                        + "binds data to an existing "
                        + "ViewHolder?";

        String[] options = {
                "onCreate()",
                "setContentView()",
                "onBindViewHolder()",
                "onDestroy()"
        };

        String answerExplanation =
                "onBindViewHolder() updates "
                        + "a ViewHolder with the "
                        + "data for an item position.";

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
    // LESSON 04
    // Efficient Lists and User Interaction
    // =====================================

    private static LessonContent
    efficientListsAndInteraction() {

        String summary =
                "Learn how to update RecyclerView "
                        + "items efficiently, handle "
                        + "click events safely, "
                        + "and keep lists responsive.";

        String explanation =
                "RecyclerView can display "
                        + "large collections efficiently "
                        + "by reusing item Views.\n\n"

                        + "EFFICIENT UPDATES:\n"
                        + "When one item changes, "
                        + "notifyItemChanged() can notify "
                        + "RecyclerView about that item.\n\n"

                        + "For an inserted item, "
                        + "notifyItemInserted() reports "
                        + "its insertion position.\n\n"

                        + "For a removed item, "
                        + "notifyItemRemoved() reports "
                        + "the removal position.\n\n"

                        + "FULL DATASET UPDATES:\n"
                        + "notifyDataSetChanged() requests "
                        + "a general list refresh and "
                        + "is less specific than "
                        + "item-level notifications.\n\n"

                        + "DIFFUTIL:\n"
                        + "DiffUtil calculates differences "
                        + "between old and new data lists "
                        + "and supports efficient updates.\n\n"

                        + "CLICK LISTENERS:\n"
                        + "An item View can register "
                        + "an OnClickListener to respond "
                        + "when the user taps it.\n\n"

                        + "ADAPTER POSITIONS:\n"
                        + "Item positions may change "
                        + "when the list is updated.\n\n"

                        + "getBindingAdapterPosition() "
                        + "returns the current binding "
                        + "adapter position, or "
                        + "RecyclerView.NO_POSITION "
                        + "when it is unavailable.\n\n"

                        + "SMOOTH USER EXPERIENCE:\n"
                        + "Avoid expensive operations "
                        + "inside onBindViewHolder().\n\n"

                        + "Load and process data outside "
                        + "the binding method when possible.\n\n"

                        + "USEFUL INTERACTIONS:\n"
                        + "Lists can support searching, "
                        + "filtering, item selection, "
                        + "and navigation to details.\n\n"

                        + "ACCESSIBILITY:\n"
                        + "List items should contain "
                        + "clear labels and provide "
                        + "adequate touch targets.";

        String takeaway =
                "Use item-level notifications "
                        + "or DiffUtil for efficient "
                        + "list updates. Handle clicks "
                        + "using current adapter positions "
                        + "and avoid unnecessary work "
                        + "during item binding.";

        String code =
                "// Example methods inside an Adapter\n"
                        + "// Using its titles list and TitleHolder\n\n"

                        + "public void updateTitle(\n"
                        + "        int position,\n"
                        + "        String newTitle) {\n\n"

                        + "    if (position < 0 ||\n"
                        + "            position >= titles.size()) {\n"
                        + "        return;\n"
                        + "    }\n\n"

                        + "    titles.set(position, newTitle);\n"
                        + "    notifyItemChanged(position);\n"
                        + "}\n\n"

                        + "@Override\n"
                        + "public void onBindViewHolder(\n"
                        + "        @NonNull TitleHolder holder,\n"
                        + "        int position) {\n\n"

                        + "    holder.title.setText(\n"
                        + "            titles.get(position)\n"
                        + "    );\n\n"

                        + "    holder.itemView.setOnClickListener(view -> {\n"

                        + "        int currentPosition =\n"
                        + "                holder.getBindingAdapterPosition();\n\n"

                        + "        if (currentPosition !=\n"
                        + "                RecyclerView.NO_POSITION) {\n\n"

                        + "            Toast.makeText(\n"
                        + "                    view.getContext(),\n"
                        + "                    \"Selected: \" +\n"
                        + "                    titles.get(currentPosition),\n"
                        + "                    Toast.LENGTH_SHORT\n"
                        + "            ).show();\n"
                        + "        }\n"
                        + "    });\n"
                        + "}";

        String codeExplanation =
                "This example illustrates "
                        + "efficient item updates "
                        + "and safe click handling.\n\n"

                        + "updateTitle() validates "
                        + "the position before "
                        + "modifying the list.\n\n"

                        + "notifyItemChanged() tells "
                        + "RecyclerView that one "
                        + "item has changed.\n\n"

                        + "onBindViewHolder() displays "
                        + "the current item title "
                        + "and registers a click listener.\n\n"

                        + "getBindingAdapterPosition() "
                        + "obtains the current item "
                        + "position when the click occurs.\n\n"

                        + "RecyclerView.NO_POSITION "
                        + "is checked to avoid "
                        + "using an invalid position.\n\n"

                        + "This is a code excerpt "
                        + "designed to be placed inside "
                        + "a compatible Adapter class. "
                        + "It is not a standalone "
                        + "Java class.";

        String question =
                "Which RecyclerView constant "
                        + "indicates that a valid "
                        + "adapter position is unavailable?";

        String[] options = {
                "RecyclerView.NO_POSITION",
                "RecyclerView.GONE",
                "RecyclerView.STOPPED",
                "RecyclerView.EMPTY_POSITION"
        };

        String answerExplanation =
                "RecyclerView.NO_POSITION indicates "
                        + "that the ViewHolder currently "
                        + "has no valid adapter position. "
                        + "Click handlers should check "
                        + "for this value before "
                        + "accessing list items.";

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
