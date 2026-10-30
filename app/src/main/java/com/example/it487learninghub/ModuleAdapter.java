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

public class ModuleAdapter
        extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {

    // Data model for each learning module
    public static class Module {

        public final int number;
        public final String title;
        public final int lessonCount;
        public final String category;

        // Completed lessons loaded from SQLite
        public final int completedLessons;

        // Original constructor for compatibility
        public Module(
                int number,
                String title,
                int lessonCount,
                String category) {

            this(
                    number,
                    title,
                    lessonCount,
                    category,
                    0
            );
        }

        // Constructor including saved progress
        public Module(
                int number,
                String title,
                int lessonCount,
                String category,
                int completedLessons) {

            this.number = number;
            this.title = title;
            this.lessonCount = Math.max(0, lessonCount);
            this.category = category;

            this.completedLessons = Math.max(
                    0,
                    Math.min(completedLessons, this.lessonCount)
            );
        }

        // Calculate module completion percentage
        public int getProgressPercent() {

            if (lessonCount == 0) {
                return 0;
            }

            return (int) Math.round(
                    completedLessons * 100.0 / lessonCount
            );
        }

        // Check if the module has not been started
        public boolean isNotStarted() {

            return completedLessons == 0;
        }

        // Check if some lessons are completed
        public boolean isInProgress() {

            return completedLessons > 0
                    && completedLessons < lessonCount;
        }

        // Check if all lessons are completed
        public boolean isCompleted() {

            return lessonCount > 0
                    && completedLessons == lessonCount;
        }
    }

    // Callback when a module is selected
    public interface OnModuleClickListener {

        void onModuleClick(Module module);
    }

    private final List<Module> modules =
            new ArrayList<>();

    private final OnModuleClickListener listener;

    // Constructor
    public ModuleAdapter(OnModuleClickListener listener) {

        this.listener = listener;
    }

    // Update the displayed modules
    public void setModules(List<Module> newModules) {

        modules.clear();

        if (newModules != null) {
            modules.addAll(newModules);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_module,
                        parent,
                        false
                );

        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ModuleViewHolder holder,
            int position) {

        Module module = modules.get(position);

        // Display module number
        holder.tvNumber.setText(
                String.format(
                        Locale.US,
                        "%02d",
                        module.number
                )
        );

        // Display module title
        holder.tvTitle.setText(module.title);

        // Display lesson count
        holder.tvInfo.setText(
                String.format(
                        Locale.US,
                        "%d %s",
                        module.lessonCount,
                        module.lessonCount == 1
                                ? "Lesson"
                                : "Lessons"
                )
        );

        // Display real module status
        updateModuleStatus(holder, module);

        // Open module lessons when clicked
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onModuleClick(module);
            }
        });
    }

    // Update module status based on completion
    private void updateModuleStatus(
            ModuleViewHolder holder,
            Module module) {

        int statusColor;
        String statusText;

        if (module.isCompleted()) {

            // All lessons completed
            statusText = "Completed · 100%";

            statusColor = R.color.success_green;

        } else if (module.isInProgress()) {

            // Some lessons completed
            statusText = String.format(
                    Locale.US,
                    "In Progress · %d%%",
                    module.getProgressPercent()
            );

            statusColor = R.color.accent_purple;

        } else {

            // No completed lessons
            statusText = "Not started";

            statusColor = R.color.text_secondary;
        }

        // Update status text
        holder.tvStatus.setText(statusText);

        // Apply status color
        holder.tvStatus.setTextColor(
                ContextCompat.getColor(
                        holder.itemView.getContext(),
                        statusColor
                )
        );
    }

    @Override
    public int getItemCount() {

        return modules.size();
    }

    // ViewHolder connects Java with XML
    static class ModuleViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvNumber;
        TextView tvTitle;
        TextView tvInfo;
        TextView tvStatus;

        public ModuleViewHolder(
                @NonNull View itemView) {

            super(itemView);

            tvNumber = itemView.findViewById(
                    R.id.tvModuleNumber
            );

            tvTitle = itemView.findViewById(
                    R.id.tvModuleTitle
            );

            tvInfo = itemView.findViewById(
                    R.id.tvModuleInfo
            );

            tvStatus = itemView.findViewById(
                    R.id.tvModuleStatus
            );
        }
    }
}
