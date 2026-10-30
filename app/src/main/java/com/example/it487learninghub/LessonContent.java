package com.example.it487learninghub;

public class LessonContent {

    // Learn section
    private final String summary;
    private final String explanation;
    private final String keyTakeaway;

    // Code section
    private final String codeExample;
    private final String codeExplanation;

    // Practice section
    private final String practiceQuestion;
    private final String[] practiceOptions;
    private final int correctAnswerIndex;
    private final String answerExplanation;

    // Constructor
    public LessonContent(
            String summary,
            String explanation,
            String keyTakeaway,
            String codeExample,
            String codeExplanation,
            String practiceQuestion,
            String[] practiceOptions,
            int correctAnswerIndex,
            String answerExplanation) {

        // Validate essential learning content
        if (isBlank(summary)
                || isBlank(explanation)
                || isBlank(keyTakeaway)) {

            throw new IllegalArgumentException(
                    "Lesson explanation is required"
            );
        }

        // Validate practice question
        if (isBlank(practiceQuestion)) {

            throw new IllegalArgumentException(
                    "Practice question is required"
            );
        }

        // Each practice question must have 4 options
        if (practiceOptions == null
                || practiceOptions.length != 4) {

            throw new IllegalArgumentException(
                    "Practice must have four options"
            );
        }

        // Validate each answer option
        for (String option : practiceOptions) {

            if (isBlank(option)) {

                throw new IllegalArgumentException(
                        "Practice options cannot be empty"
                );
            }
        }

        // Validate correct answer index
        if (correctAnswerIndex < 0
                || correctAnswerIndex > 3) {

            throw new IllegalArgumentException(
                    "Correct answer index must be 0 to 3"
            );
        }

        // Save Learn content
        this.summary = summary;
        this.explanation = explanation;
        this.keyTakeaway = keyTakeaway;

        // Save Code content
        this.codeExample = codeExample == null
                ? ""
                : codeExample;

        this.codeExplanation = codeExplanation == null
                ? ""
                : codeExplanation;

        // Save Practice content
        this.practiceQuestion = practiceQuestion;

        this.practiceOptions = practiceOptions.clone();

        this.correctAnswerIndex = correctAnswerIndex;

        this.answerExplanation =
                answerExplanation == null
                        ? ""
                        : answerExplanation;
    }

    // Check for missing text
    private static boolean isBlank(String text) {

        return text == null
                || text.trim().isEmpty();
    }

    // =====================================
    // LEARN CONTENT
    // =====================================

    public String getSummary() {
        return summary;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getKeyTakeaway() {
        return keyTakeaway;
    }

    // =====================================
    // CODE CONTENT
    // =====================================

    public String getCodeExample() {
        return codeExample;
    }

    public String getCodeExplanation() {
        return codeExplanation;
    }

    public boolean hasCodeExample() {

        return !codeExample.trim().isEmpty();
    }

    // =====================================
    // PRACTICE CONTENT
    // =====================================

    public String getPracticeQuestion() {
        return practiceQuestion;
    }

    public String[] getPracticeOptions() {

        // Return a copy to protect original data
        return practiceOptions.clone();
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String getAnswerExplanation() {
        return answerExplanation;
    }

    // Check a selected answer
    public boolean isCorrectAnswer(int selectedIndex) {

        return selectedIndex == correctAnswerIndex;
    }
}
