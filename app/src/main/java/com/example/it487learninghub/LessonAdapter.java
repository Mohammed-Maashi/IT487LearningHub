package com.example.it487learninghub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LessonAdapter
        extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {

    // Lesson data model
    public static class Lesson {

        public final int moduleId;
        public final int number;
        public final String title;
        public final boolean completed;

        public Lesson(int moduleId, int number,
                      String title, boolean completed) {

            this.moduleId = moduleId;
            this.number = number;
            this.title = title;
            this.completed = completed;
        }
    }

    // Listener for selecting a lesson
    public interface OnLessonClickListener {
        void onLessonClick(Lesson lesson);
    }

    private final List<Lesson> lessons = new ArrayList<>();
    private final OnLessonClickListener listener;

    public LessonAdapter(OnLessonClickListener listener) {
        this.listener = listener;
    }

    // Update the lesson list
    public void setLessons(List<Lesson> newLessons) {

        lessons.clear();
        lessons.addAll(newLessons);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_lesson, parent, false);

        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull LessonViewHolder holder, int position) {

        Lesson lesson = lessons.get(position);

        // Lesson number
        holder.tvNumber.setText(
                String.format(Locale.US, "%02d", lesson.number)
        );

        // Lesson title
        holder.tvTitle.setText(lesson.title);

        // Lesson completion status
        if (lesson.completed) {

            holder.tvStatus.setText("Completed");

            holder.tvStatus.setTextColor(
                    ContextCompat.getColor(
                            holder.itemView.getContext(),
                            R.color.success_green
                    )
            );

        } else {

            holder.tvStatus.setText("Not started");

            holder.tvStatus.setTextColor(
                    ContextCompat.getColor(
                            holder.itemView.getContext(),
                            R.color.text_secondary
                    )
            );
        }

        // Handle lesson selection
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onLessonClick(lesson);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    // ViewHolder links Java to XML
    static class LessonViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvNumber;
        TextView tvTitle;
        TextView tvStatus;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumber = itemView.findViewById(
                    R.id.tvLessonNumber
            );

            tvTitle = itemView.findViewById(
                    R.id.tvLessonTitle
            );

            tvStatus = itemView.findViewById(
                    R.id.tvLessonStatus
            );
        }
    }
}
