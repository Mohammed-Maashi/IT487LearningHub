package com.example.it487learninghub;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class NotesActivity extends AppCompatActivity {

    // Interface components
    private RecyclerView recyclerNotes;
    private EditText editSearchNotes;
    private TextView tvNotesCount;
    private LinearLayout layoutEmptyNotes;

    // Adapter
    private NoteAdapter noteAdapter;

    // SQLite database
    private LearningDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);

        // Handle Android system bars
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets bars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            bars.left,
                            bars.top,
                            bars.right,
                            bars.bottom
                    );

                    return insets;
                }
        );

        initializeViews();

        // Initialize SQLite
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        setupRecyclerView();
        setupSearch();
        setupAddNoteButton();
        setupNavigation();

        // Display saved notes
        refreshNotes();
    }

    // Connect Java with XML
    private void initializeViews() {

        recyclerNotes = findViewById(
                R.id.recyclerNotes
        );

        editSearchNotes = findViewById(
                R.id.editSearchNotes
        );

        tvNotesCount = findViewById(
                R.id.tvNotesCount
        );

        layoutEmptyNotes = findViewById(
                R.id.layoutEmptyNotes
        );
    }

    // Configure RecyclerView
    private void setupRecyclerView() {

        recyclerNotes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        noteAdapter = new NoteAdapter(
                new NoteAdapter.OnNoteActionListener() {

                    @Override
                    public void onEditNote(
                            LearningDatabaseHelper.Note note) {

                        showNoteDialog(note);
                    }

                    @Override
                    public void onDeleteNote(
                            LearningDatabaseHelper.Note note) {

                        showDeleteConfirmation(note);
                    }
                }
        );

        recyclerNotes.setAdapter(noteAdapter);
    }

    // Search notes while typing
    private void setupSearch() {

        editSearchNotes.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after) {
                    }

                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count) {

                        refreshNotes();
                    }

                    @Override
                    public void afterTextChanged(
                            Editable s) {
                    }
                }
        );
    }

    // New Note button
    private void setupAddNoteButton() {

        findViewById(R.id.btnAddNote)
                .setOnClickListener(v -> {

                    showNoteDialog(null);
                });
    }

    // Open dialog for creating or editing a note
    private void showNoteDialog(
            LearningDatabaseHelper.Note existingNote) {

        boolean isEditing = existingNote != null;

        // Dialog layout
        LinearLayout container = new LinearLayout(this);

        container.setOrientation(
                LinearLayout.VERTICAL
        );

        container.setPadding(
                dp(20),
                dp(20),
                dp(20),
                dp(12)
        );

        // Dialog heading
        TextView heading = new TextView(this);

        heading.setText(
                isEditing ? "Edit Note" : "New Note"
        );

        heading.setTextSize(22);
        heading.setTypeface(null, Typeface.BOLD);

        heading.setTextColor(
                getAppColor(R.color.text_primary)
        );

        container.addView(heading);

        // Title label
        TextView titleLabel = createFieldLabel("Title");

        LinearLayout.LayoutParams titleLabelParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        titleLabelParams.topMargin = dp(20);

        container.addView(
                titleLabel,
                titleLabelParams
        );

        // Title input
        EditText editTitle = new EditText(this);

        editTitle.setHint("Enter note title");

        editTitle.setSingleLine(true);

        editTitle.setInputType(
                InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        );

        styleEditText(editTitle);

        container.addView(
                editTitle,
                createInputParams()
        );

        // Content label
        TextView contentLabel =
                createFieldLabel("Content");

        LinearLayout.LayoutParams contentLabelParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        contentLabelParams.topMargin = dp(18);

        container.addView(
                contentLabel,
                contentLabelParams
        );

        // Content input
        EditText editContent = new EditText(this);

        editContent.setHint(
                "Write your learning notes here..."
        );

        editContent.setInputType(
                InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_FLAG_MULTI_LINE
                        | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        );

        editContent.setGravity(
                Gravity.TOP | Gravity.START
        );

        editContent.setMinLines(4);
        editContent.setMaxLines(8);

        styleEditText(editContent);

        container.addView(
                editContent,
                createInputParams()
        );

        // Populate existing content when editing
        if (isEditing) {

            editTitle.setText(existingNote.title);

            editContent.setText(existingNote.content);

            editTitle.setSelection(
                    editTitle.length()
            );
        }

        // Allow scrolling on smaller screens
        ScrollView scrollView = new ScrollView(this);

        scrollView.setFillViewport(false);
        scrollView.addView(container);

        // Create dialog
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setView(scrollView)
                        .setPositiveButton("Save", null)
                        .setNegativeButton("Cancel", null)
                        .create();

        dialog.show();

        // Apply Dark Premium appearance
        Window window = dialog.getWindow();

        if (window != null) {

            GradientDrawable background =
                    new GradientDrawable();

            background.setColor(
                    getAppColor(R.color.surface_dark)
            );

            background.setCornerRadius(dp(20));

            window.setBackgroundDrawable(background);
        }

        dialog.getButton(
                AlertDialog.BUTTON_POSITIVE
        ).setTextColor(
                getAppColor(R.color.primary_blue)
        );

        dialog.getButton(
                AlertDialog.BUTTON_NEGATIVE
        ).setTextColor(
                getAppColor(R.color.text_secondary)
        );

        // Override Save behavior to validate before closing
        dialog.getButton(
                AlertDialog.BUTTON_POSITIVE
        ).setOnClickListener(v -> {

            String title = editTitle.getText()
                    .toString()
                    .trim();

            String content = editContent.getText()
                    .toString()
                    .trim();

            // Validate note title
            if (title.isEmpty()) {

                editTitle.setError(
                        "Note title is required"
                );

                editTitle.requestFocus();

                return;
            }

            boolean success;

            // Update an existing note
            if (isEditing) {

                success = databaseHelper.updateNote(
                        existingNote.id,
                        title,
                        content
                );

            } else {

                // Insert a new note
                long newNoteId =
                        databaseHelper.insertNote(
                                title,
                                content
                        );

                success = newNoteId != -1;
            }

            if (success) {

                Toast.makeText(
                        NotesActivity.this,
                        isEditing
                                ? "Note updated successfully"
                                : "Note saved successfully",
                        Toast.LENGTH_SHORT
                ).show();

                refreshNotes();

                dialog.dismiss();

            } else {

                Toast.makeText(
                        NotesActivity.this,
                        "Unable to save note",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    // Create a field label
    private TextView createFieldLabel(String text) {

        TextView label = new TextView(this);

        label.setText(text);

        label.setTextSize(14);

        label.setTypeface(
                null,
                Typeface.BOLD
        );

        label.setTextColor(
                getAppColor(R.color.text_primary)
        );

        return label;
    }

    // Apply input appearance
    private void styleEditText(EditText editText) {

        editText.setTextColor(
                getAppColor(R.color.text_primary)
        );

        editText.setHintTextColor(
                getAppColor(R.color.text_secondary)
        );

        editText.setTextSize(15);

        editText.setBackgroundTintList(
                ColorStateList.valueOf(
                        getAppColor(R.color.primary_blue)
                )
        );

        editText.setPadding(
                dp(8),
                dp(12),
                dp(8),
                dp(12)
        );
    }

    // Layout parameters for inputs
    private LinearLayout.LayoutParams createInputParams() {

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.topMargin = dp(6);

        return params;
    }

    // Confirm before deleting a note
    private void showDeleteConfirmation(
            LearningDatabaseHelper.Note note) {

        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Delete Note")
                        .setMessage(
                                "Are you sure you want to delete \""
                                        + note.title
                                        + "\"? This action cannot be undone."
                        )
                        .setNegativeButton(
                                "Cancel",
                                (d, which) -> d.dismiss()
                        )
                        .setPositiveButton(
                                "Delete",
                                (d, which) -> {

                                    boolean deleted =
                                            databaseHelper.deleteNote(
                                                    note.id
                                            );

                                    if (deleted) {

                                        Toast.makeText(
                                                this,
                                                "Note deleted successfully",
                                                Toast.LENGTH_SHORT
                                        ).show();

                                        refreshNotes();

                                    } else {

                                        Toast.makeText(
                                                this,
                                                "Unable to delete note",
                                                Toast.LENGTH_SHORT
                                        ).show();
                                    }
                                }
                        )
                        .create();

        dialog.show();

        dialog.getButton(
                AlertDialog.BUTTON_POSITIVE
        ).setTextColor(
                android.graphics.Color.rgb(
                        251, 113, 133
                )
        );
    }

    // Load notes from SQLite
    private void refreshNotes() {

        if (databaseHelper == null
                || noteAdapter == null) {
            return;
        }

        String searchText = editSearchNotes
                .getText()
                .toString()
                .trim();

        List<LearningDatabaseHelper.Note> notes =
                databaseHelper.searchNotes(searchText);

        // Update RecyclerView
        noteAdapter.setNotes(notes);

        int visibleCount = notes.size();

        // Update note count
        tvNotesCount.setText(
                String.format(
                        Locale.US,
                        "%d %s",
                        visibleCount,
                        visibleCount == 1
                                ? "note"
                                : "notes"
                )
        );

        // Display empty state
        if (notes.isEmpty()) {

            recyclerNotes.setVisibility(View.GONE);
            layoutEmptyNotes.setVisibility(View.VISIBLE);

            // Existing XML contains:
            // icon, title, and description
            TextView emptyTitle =
                    (TextView) layoutEmptyNotes.getChildAt(1);

            TextView emptyDescription =
                    (TextView) layoutEmptyNotes.getChildAt(2);

            if (databaseHelper.getNotesCount() == 0) {

                emptyTitle.setText("No notes yet");

                emptyDescription.setText(
                        "Start by adding your first learning note."
                );

            } else {

                emptyTitle.setText("No matching notes");

                emptyDescription.setText(
                        "Try a different search term."
                );
            }

        } else {

            layoutEmptyNotes.setVisibility(View.GONE);
            recyclerNotes.setVisibility(View.VISIBLE);
        }
    }

    // Bottom navigation
    private void setupNavigation() {

        // Home
        findViewById(R.id.navHome).setOnClickListener(
                v -> openScreen(MainActivity.class)
        );

        // Explore
        findViewById(R.id.navExplore).setOnClickListener(
                v -> openScreen(ExploreActivity.class)
        );

        // Current Notes tab
        findViewById(R.id.navNotes).setOnClickListener(
                v -> recyclerNotes.scrollToPosition(0)
        );

        // Progress
        findViewById(R.id.navProgress).setOnClickListener(
                v -> openScreen(ProgressActivity.class)
        );
    }

    // Navigate between app screens
    private void openScreen(Class<?> targetActivity) {

        Intent intent = new Intent(
                NotesActivity.this,
                targetActivity
        );

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP
        );

        startActivity(intent);
        finish();
    }

    // Refresh saved notes when screen becomes active
    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null
                && noteAdapter != null) {

            refreshNotes();
        }
    }

    // Convert dp to pixels
    private int dp(float value) {

        return (int) (
                value * getResources()
                        .getDisplayMetrics()
                        .density + 0.5f
        );
    }

    // Read application colors
    private int getAppColor(int colorId) {

        return ContextCompat.getColor(
                this,
                colorId
        );
    }

    // Release SQLite resources
    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
