package com.example.it487learninghub;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class QuizSelectionDialogFragment extends DialogFragment {

    private static final String ARG_MODULE_TITLES = "module_titles";

    public QuizSelectionDialogFragment() {
        // Required empty constructor
    }

    public static QuizSelectionDialogFragment newInstance(
            String[] moduleTitles) {

        QuizSelectionDialogFragment fragment =
                new QuizSelectionDialogFragment();

        Bundle args = new Bundle();
        args.putStringArray(ARG_MODULE_TITLES, moduleTitles);
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String[] moduleTitles = requireArguments()
                .getStringArray(ARG_MODULE_TITLES);

        if (moduleTitles == null || moduleTitles.length == 0) {
            return new AlertDialog.Builder(requireContext())
                    .setTitle("No Quizzes Available")
                    .setMessage("There are no modules to display.")
                    .setPositiveButton("OK", null)
                    .create();
        }

        String[] quizOptions = new String[moduleTitles.length];

        for (int i = 0; i < moduleTitles.length; i++) {
            quizOptions[i] = String.format(
                    java.util.Locale.US,
                    "Module %02d - %s",
                    i + 1,
                    moduleTitles[i]
            );
        }

        return new AlertDialog.Builder(requireContext())
                .setTitle("Choose a Quiz")
                .setItems(quizOptions, (dialog, which) -> {

                    int moduleId = which + 1;
                    String moduleTitle = moduleTitles[which];

                    if (!QuizQuestionRepository.isModuleReady(moduleId)) {

                        new AlertDialog.Builder(requireContext())
                                .setTitle("Quiz Not Available")
                                .setMessage(
                                        "This module does not have enough questions yet."
                                )
                                .setPositiveButton("OK", null)
                                .show();

                        return;
                    }

                    Intent intent = new Intent(
                            requireContext(),
                            QuizActivity.class
                    );

                    intent.putExtra("module_id", moduleId);
                    intent.putExtra("module_title", moduleTitle);

                    Toast.makeText(
                            requireContext(),
                            "Opening " + moduleTitle + " Quiz",
                            Toast.LENGTH_SHORT
                    ).show();

                    startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, which) ->
                        dialog.dismiss()
                )
                .create();
    }
}
