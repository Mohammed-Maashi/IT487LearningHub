package com.example.it487learninghub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ModuleProgressAdapter extends
        RecyclerView.Adapter<ModuleProgressAdapter.ProgressViewHolder> {

    // Data model for module progress
    public static class ModuleProgress {

        public final int moduleId;
        public final String title;
        public final int completedLessons;
        public final int totalLessons;

        public ModuleProgress(
                int moduleId,
                String title,
                int completedLessons,
                int totalLessons) {

            this.moduleId = moduleId;
            this.title = title;
            this.totalLessons = Math.max(0, totalLessons);

            this.completedLessons = Math.max(
                    0,
                    Math.min(completedLessons, this.totalLessons)
            );
        }

        // Calculate the completion percentage
        public int getProgressPercent() {

            if (totalLessons == 0) {
                return 0;
            }

            return (int) Math.round(
                    completedLessons * 100.0 / totalLessons
            );
        }
    }

    // Callback for opening a module
    public interface OnModuleClickListener {
        void onModuleClick(ModuleProgress module);
    }

    private final List<ModuleProgress> modules =
            new ArrayList<>();

    private final OnModuleClickListener listener;

    public ModuleProgressAdapter(
            OnModuleClickListener listener) {

        this.listener = listener;
    }

    // Update the displayed module progress
    public void setModules(List<ModuleProgress> newModules) {

        modules.clear();
        modules.addAll(newModules);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_module_progress,
                        parent,
                        false
                );

        return new ProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ProgressViewHolder holder,
            int position) {

        ModuleProgress module = modules.get(position);

        int percent = module.getProgressPercent();

        // Display module title
        holder.tvTitle.setText(module.title);

        // Display progress percentage
        holder.tvPercent.setText(
                String.format(
                        Locale.US,
                        "%d%%",
                        percent
                )
        );

        // Update progress bar
        holder.progressBar.setProgress(percent);

        // Display completed lessons count
        holder.tvCount.setText(
                String.format(
                        Locale.US,
                        "%d of %d lessons completed",
                        module.completedLessons,
                        module.totalLessons
                )
        );

        // Open selected module when clicked
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onModuleClick(module);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    // ViewHolder connects Java with XML
    static class ProgressViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvPercent;
        TextView tvCount;
        ProgressBar progressBar;

        public ProgressViewHolder(
                @NonNull View itemView) {

            super(itemView);

            tvTitle = itemView.findViewById(
                    R.id.tvProgressModuleTitle
            );

            tvPercent = itemView.findViewById(
                    R.id.tvProgressModulePercent
            );

            tvCount = itemView.findViewById(
                    R.id.tvProgressModuleCount
            );

            progressBar = itemView.findViewById(
                    R.id.progressBarModuleItem
            );
        }
    }
}
