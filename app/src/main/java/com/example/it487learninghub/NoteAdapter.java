package com.example.it487learninghub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteAdapter
        extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    // Listener for editing and deleting notes
    public interface OnNoteActionListener {

        void onEditNote(LearningDatabaseHelper.Note note);

        void onDeleteNote(LearningDatabaseHelper.Note note);
    }

    private final List<LearningDatabaseHelper.Note> notes =
            new ArrayList<>();

    private final OnNoteActionListener listener;

    // Constructor
    public NoteAdapter(OnNoteActionListener listener) {
        this.listener = listener;
    }

    // Update notes displayed in RecyclerView
    public void setNotes(
            List<LearningDatabaseHelper.Note> newNotes) {

        notes.clear();

        if (newNotes != null) {
            notes.addAll(newNotes);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_note,
                        parent,
                        false
                );

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull NoteViewHolder holder,
            int position) {

        LearningDatabaseHelper.Note note =
                notes.get(position);

        // Display note title
        holder.tvNoteTitle.setText(note.title);

        // Display note content preview
        if (note.content == null
                || note.content.trim().isEmpty()) {

            holder.tvNoteContent.setVisibility(View.GONE);

        } else {

            holder.tvNoteContent.setVisibility(View.VISIBLE);
            holder.tvNoteContent.setText(note.content);
        }

        // Display last updated date
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "dd MMM yyyy",
                        Locale.US
                );

        String formattedDate = dateFormat.format(
                new Date(note.updatedAt)
        );

        holder.tvNoteDate.setText(formattedDate);

        // Edit button
        holder.btnEditNote.setOnClickListener(v -> {

            if (listener != null) {
                listener.onEditNote(note);
            }
        });

        // Delete button
        holder.btnDeleteNote.setOnClickListener(v -> {

            if (listener != null) {
                listener.onDeleteNote(note);
            }
        });

        // Tap anywhere on the note to edit it
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onEditNote(note);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    // ViewHolder connects Java with item_note.xml
    static class NoteViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvNoteTitle;
        TextView tvNoteContent;
        TextView tvNoteDate;
        TextView btnEditNote;
        TextView btnDeleteNote;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNoteTitle = itemView.findViewById(
                    R.id.tvNoteTitle
            );

            tvNoteContent = itemView.findViewById(
                    R.id.tvNoteContent
            );

            tvNoteDate = itemView.findViewById(
                    R.id.tvNoteDate
            );

            btnEditNote = itemView.findViewById(
                    R.id.btnEditNote
            );

            btnDeleteNote = itemView.findViewById(
                    R.id.btnDeleteNote
            );
        }
    }
}
