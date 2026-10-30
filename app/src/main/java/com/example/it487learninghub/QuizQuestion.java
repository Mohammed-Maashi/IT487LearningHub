package com.example.it487learninghub;

public class QuizQuestion {

    // Module associated with this question
    private final int moduleId;

    // Question text
    private final String questionText;

    // Four possible answers
    private final String[] options;

    // Index of the correct answer (0 to 3)
    private final int correctAnswerIndex;

    // Explanation displayed after answering
    private final String explanation;

    // Constructor
    public QuizQuestion(
            int moduleId,
            String questionText,
            String[] options,
            int correctAnswerIndex,
            String explanation) {

        if (moduleId < 1 || moduleId > 14) {
            throw new IllegalArgumentException(
                    "Invalid module ID"
            );
        }

        if (questionText == null
                || questionText.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Question text cannot be empty"
            );
        }

        if (options == null || options.length != 4) {
            throw new IllegalArgumentException(
                    "Each question must have four options"
            );
        }

        for (String option : options) {
            if (option == null || option.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Answer options cannot be empty"
                );
            }
        }

        if (correctAnswerIndex < 0
                || correctAnswerIndex > 3) {

            throw new IllegalArgumentException(
                    "Correct answer index must be 0 to 3"
            );
        }

        this.moduleId = moduleId;
        this.questionText = questionText;
        this.options = options.clone();
        this.correctAnswerIndex = correctAnswerIndex;

        this.explanation = explanation == null
                ? ""
                : explanation;
    }

    // Get the module ID
    public int getModuleId() {
        return moduleId;
    }

    // Get the question text
    public String getQuestionText() {
        return questionText;
    }

    // Get the four answer options
    public String[] getOptions() {
        return options.clone();
    }

    // Get the correct answer index
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Get the correct answer text
    public String getCorrectAnswer() {
        return options[correctAnswerIndex];
    }

    // Get explanation
    public String getExplanation() {
        return explanation;
    }

    // Check whether the selected answer is correct
    public boolean isCorrect(int selectedIndex) {

        return selectedIndex == correctAnswerIndex;
    }
}
