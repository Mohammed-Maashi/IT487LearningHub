package com.example.it487learninghub;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    // Question screen components
    private TextView tvQuizHeaderSubtitle;
    private TextView tvQuestionCounter;
    private TextView tvQuizProgressPercent;
    private TextView tvQuizModule;
    private TextView tvQuizQuestion;
    private TextView tvQuizFeedback;

    // Result screen components
    private TextView tvResultScore;
    private TextView tvResultTitle;
    private TextView tvResultSummary;
    private TextView tvResultCorrect;
    private TextView tvResultIncorrect;

    private ProgressBar quizProgressBar;
    private ScrollView quizScroll;

    private View layoutQuizQuestion;
    private View layoutQuizResult;

    private Button btnQuizAction;

    // Answer option cards
    private final MaterialCardView[] optionCards =
            new MaterialCardView[4];

    private final TextView[] optionTexts =
            new TextView[4];

    // Questions for the current attempt
    private final List<QuizQuestion> questions =
            new ArrayList<>();

    // SQLite database
    private LearningDatabaseHelper databaseHelper;

    // Selected module
    private int moduleId = 5;
    private String moduleTitle = "Activity Lifecycle";

    // Quiz state
    private int currentQuestionIndex = 0;
    private int selectedAnswerIndex = -1;
    private int correctAnswers = 0;

    private boolean answerChecked = false;
    private boolean showingResult = false;

    // Database ID of the saved attempt
    // -1 means this attempt has not been saved
    private long savedAttemptId = -1;

    private static final int WRONG_COLOR =
            Color.rgb(251, 113, 133);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        // Handle Android system bars
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

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
        receiveModuleData();

        // Initialize SQLite
        databaseHelper = new LearningDatabaseHelper(
                getApplicationContext()
        );

        setupOptionListeners();
        setupActionButton();
        setupBackNavigation();

        // Restore an existing quiz after screen recreation
        if (savedInstanceState != null
                && restoreQuizState(savedInstanceState)) {

            tvQuizHeaderSubtitle.setText(moduleTitle);

            if (showingResult) {
                showResult();
            } else {
                displayQuestion();
            }

        } else {

            startNewQuiz();
        }
    }

    // Connect Java variables with XML
    private void initializeViews() {

        tvQuizHeaderSubtitle = findViewById(
                R.id.tvQuizHeaderSubtitle
        );

        tvQuestionCounter = findViewById(
                R.id.tvQuestionCounter
        );

        tvQuizProgressPercent = findViewById(
                R.id.tvQuizProgressPercent
        );

        tvQuizModule = findViewById(
                R.id.tvQuizModule
        );

        tvQuizQuestion = findViewById(
                R.id.tvQuizQuestion
        );

        tvQuizFeedback = findViewById(
                R.id.tvQuizFeedback
        );

        tvResultScore = findViewById(
                R.id.tvResultScore
        );

        tvResultTitle = findViewById(
                R.id.tvResultTitle
        );

        tvResultSummary = findViewById(
                R.id.tvResultSummary
        );

        tvResultCorrect = findViewById(
                R.id.tvResultCorrect
        );

        tvResultIncorrect = findViewById(
                R.id.tvResultIncorrect
        );

        quizProgressBar = findViewById(
                R.id.quizProgressBar
        );

        quizScroll = findViewById(
                R.id.quizScroll
        );

        layoutQuizQuestion = findViewById(
                R.id.layoutQuizQuestion
        );

        layoutQuizResult = findViewById(
                R.id.layoutQuizResult
        );

        btnQuizAction = findViewById(
                R.id.btnQuizAction
        );

        optionCards[0] = findViewById(
                R.id.optionCard0
        );

        optionCards[1] = findViewById(
                R.id.optionCard1
        );

        optionCards[2] = findViewById(
                R.id.optionCard2
        );

        optionCards[3] = findViewById(
                R.id.optionCard3
        );

        optionTexts[0] = findViewById(
                R.id.optionText0
        );

        optionTexts[1] = findViewById(
                R.id.optionText1
        );

        optionTexts[2] = findViewById(
                R.id.optionText2
        );

        optionTexts[3] = findViewById(
                R.id.optionText3
        );
    }

    // Receive the selected module
    private void receiveModuleData() {

        moduleId = getIntent().getIntExtra(
                "module_id",
                5
        );

        String receivedTitle =
                getIntent().getStringExtra(
                        "module_title"
                );

        if (receivedTitle != null
                && !receivedTitle.trim().isEmpty()) {

            moduleTitle = receivedTitle;

        } else if (moduleId == 4) {

            moduleTitle = "Layouts and Material Design";

        } else if (moduleId == 5) {

            moduleTitle = "Activity Lifecycle";

        } else {

            moduleTitle = "Module " + moduleId;
        }

        tvQuizHeaderSubtitle.setText(moduleTitle);
    }

    // Start a new quiz attempt
    private void startNewQuiz() {

        questions.clear();

        questions.addAll(
                QuizQuestionRepository.getRandomQuestions(
                        moduleId
                )
        );

        if (questions.isEmpty()) {

            new AlertDialog.Builder(this)
                    .setTitle("Quiz Not Available")
                    .setMessage(
                            "This module does not have enough "
                                    + "questions yet."
                    )
                    .setPositiveButton(
                            "OK",
                            (dialog, which) -> finish()
                    )
                    .setCancelable(false)
                    .show();

            return;
        }

        currentQuestionIndex = 0;
        selectedAnswerIndex = -1;
        correctAnswers = 0;

        answerChecked = false;
        showingResult = false;

        // A new quiz must create a new database record
        savedAttemptId = -1;

        displayQuestion();
    }

    // Display the current question
    private void displayQuestion() {

        if (questions.isEmpty()
                || currentQuestionIndex < 0
                || currentQuestionIndex >= questions.size()) {
            return;
        }

        showingResult = false;

        layoutQuizQuestion.setVisibility(View.VISIBLE);
        layoutQuizResult.setVisibility(View.GONE);

        QuizQuestion question =
                questions.get(currentQuestionIndex);

        int questionNumber = currentQuestionIndex + 1;
        int totalQuestions = questions.size();

        int progressPercent = (int) Math.round(
                questionNumber * 100.0 / totalQuestions
        );

        tvQuestionCounter.setText(
                String.format(
                        Locale.US,
                        "Question %d of %d",
                        questionNumber,
                        totalQuestions
                )
        );

        tvQuizProgressPercent.setText(
                String.format(
                        Locale.US,
                        "%d%%",
                        progressPercent
                )
        );

        quizProgressBar.setProgress(progressPercent);

        tvQuizModule.setText(
                moduleTitle.toUpperCase(Locale.US)
        );

        tvQuizQuestion.setText(
                question.getQuestionText()
        );

        String[] options = question.getOptions();

        for (int i = 0; i < 4; i++) {
            optionTexts[i].setText(options[i]);
        }

        if (answerChecked) {

            showAnswerFeedback();

            btnQuizAction.setText(
                    currentQuestionIndex == questions.size() - 1
                            ? "See Results"
                            : "Next Question"
            );

            btnQuizAction.setEnabled(true);

        } else {

            tvQuizFeedback.setVisibility(View.GONE);

            btnQuizAction.setText("Check Answer");

            btnQuizAction.setEnabled(
                    selectedAnswerIndex >= 0
            );
        }

        updateOptionAppearance();

        quizScroll.post(() ->
                quizScroll.scrollTo(0, 0)
        );
    }

    // Handle answer selection
    private void setupOptionListeners() {

        for (int i = 0; i < optionCards.length; i++) {

            final int optionIndex = i;

            optionCards[i].setOnClickListener(v -> {

                if (answerChecked || showingResult) {
                    return;
                }

                selectedAnswerIndex = optionIndex;

                updateOptionAppearance();

                btnQuizAction.setEnabled(true);
            });
        }
    }

    // Highlight selected and corrected answers
    private void updateOptionAppearance() {

        if (questions.isEmpty()) {
            return;
        }

        int normalStroke = getAppColor(
                R.color.divider_dark
        );

        int selectedStroke = getAppColor(
                R.color.primary_blue
        );

        int correctStroke = getAppColor(
                R.color.success_green
        );

        int normalBackground = getAppColor(
                R.color.surface_dark
        );

        int highlightedBackground = getAppColor(
                R.color.card_dark
        );

        int correctIndex = -1;

        if (answerChecked) {

            correctIndex = questions
                    .get(currentQuestionIndex)
                    .getCorrectAnswerIndex();
        }

        for (int i = 0; i < 4; i++) {

            MaterialCardView card = optionCards[i];

            int strokeColor = normalStroke;
            int backgroundColor = normalBackground;
            int strokeWidth = dp(1);

            if (answerChecked) {

                if (i == correctIndex) {

                    strokeColor = correctStroke;
                    backgroundColor = highlightedBackground;
                    strokeWidth = dp(2);

                } else if (i == selectedAnswerIndex) {

                    strokeColor = WRONG_COLOR;
                    backgroundColor = highlightedBackground;
                    strokeWidth = dp(2);
                }

            } else if (i == selectedAnswerIndex) {

                strokeColor = selectedStroke;
                backgroundColor = highlightedBackground;
                strokeWidth = dp(2);
            }

            card.setStrokeColor(strokeColor);
            card.setStrokeWidth(strokeWidth);
            card.setCardBackgroundColor(backgroundColor);
        }
    }

    // Handle Check Answer / Next / Try Again
    private void setupActionButton() {

        btnQuizAction.setOnClickListener(v -> {

            if (showingResult) {

                // Retry saving if a previous database write failed
                if (savedAttemptId == -1
                        && !saveCompletedAttempt()) {
                    return;
                }

                startNewQuiz();
                return;
            }

            if (!answerChecked) {

                checkAnswer();

            } else {

                moveToNextQuestion();
            }
        });
    }

    // Check the selected answer
    private void checkAnswer() {

        if (selectedAnswerIndex < 0
                || answerChecked
                || questions.isEmpty()) {

            Toast.makeText(
                    this,
                    "Please select an answer",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        QuizQuestion question =
                questions.get(currentQuestionIndex);

        if (question.isCorrect(selectedAnswerIndex)) {
            correctAnswers++;
        }

        answerChecked = true;

        showAnswerFeedback();
        updateOptionAppearance();

        btnQuizAction.setText(
                currentQuestionIndex == questions.size() - 1
                        ? "See Results"
                        : "Next Question"
        );
    }

    // Display answer feedback
    private void showAnswerFeedback() {

        QuizQuestion question =
                questions.get(currentQuestionIndex);

        boolean correct = question.isCorrect(
                selectedAnswerIndex
        );

        String heading = correct
                ? "Correct Answer!"
                : "Incorrect Answer";

        String message = heading
                + "\n\nCorrect answer: "
                + question.getCorrectAnswer()
                + "\n\n"
                + question.getExplanation();

        tvQuizFeedback.setText(message);

        tvQuizFeedback.setTextColor(
                correct
                        ? getAppColor(R.color.success_green)
                        : WRONG_COLOR
        );

        tvQuizFeedback.setVisibility(View.VISIBLE);
    }

    // Move to the next question
    private void moveToNextQuestion() {

        if (!answerChecked) {
            return;
        }

        if (currentQuestionIndex
                == questions.size() - 1) {

            showResult();
            return;
        }

        currentQuestionIndex++;

        selectedAnswerIndex = -1;
        answerChecked = false;

        displayQuestion();
    }

    // Show the final result
    private void showResult() {

        if (questions.isEmpty()) {
            return;
        }

        showingResult = true;

        layoutQuizQuestion.setVisibility(View.GONE);
        layoutQuizResult.setVisibility(View.VISIBLE);

        int totalQuestions = questions.size();

        int incorrectAnswers =
                totalQuestions - correctAnswers;

        int scorePercent = (int) Math.round(
                correctAnswers * 100.0 / totalQuestions
        );

        tvResultScore.setText(
                String.format(
                        Locale.US,
                        "%d%%",
                        scorePercent
                )
        );

        tvResultCorrect.setText(
                String.valueOf(correctAnswers)
        );

        tvResultIncorrect.setText(
                String.valueOf(incorrectAnswers)
        );

        tvResultSummary.setText(
                String.format(
                        Locale.US,
                        "You answered %d out of %d questions correctly.",
                        correctAnswers,
                        totalQuestions
                )
        );

        if (scorePercent >= 90) {

            tvResultTitle.setText("Outstanding Work!");

        } else if (scorePercent >= 70) {

            tvResultTitle.setText("Great Work!");

        } else if (scorePercent >= 50) {

            tvResultTitle.setText("Good Effort!");

        } else {

            tvResultTitle.setText("Keep Practicing!");
        }

        btnQuizAction.setText("Try Again");
        btnQuizAction.setEnabled(true);

        // Save the result only if it has not been saved
        if (savedAttemptId == -1) {
            saveCompletedAttempt();
        }

        quizScroll.post(() ->
                quizScroll.scrollTo(0, 0)
        );
    }

    // =====================================
    // SAVE QUIZ RESULT TO SQLITE
    // =====================================

    private boolean saveCompletedAttempt() {

        // Prevent duplicate records
        if (savedAttemptId > 0) {
            return true;
        }

        if (databaseHelper == null
                || questions.isEmpty()
                || !showingResult
                || !answerChecked
                || currentQuestionIndex != questions.size() - 1) {

            return false;
        }

        // Save the completed attempt
        long newAttemptId =
                databaseHelper.insertQuizAttempt(
                        moduleId,
                        correctAnswers,
                        questions.size()
                );

        if (newAttemptId > 0) {

            // Remember the saved record ID
            savedAttemptId = newAttemptId;

            return true;
        }

        Toast.makeText(
                this,
                "Unable to save quiz result",
                Toast.LENGTH_SHORT
        ).show();

        return false;
    }

    // =====================================
    // BACK NAVIGATION
    // =====================================

    private void setupBackNavigation() {

        findViewById(R.id.btnQuizBack).setOnClickListener(
                v -> confirmExit()
        );

        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {
                        confirmExit();
                    }
                }
        );
    }

    private void confirmExit() {

        if (showingResult || questions.isEmpty()) {
            finish();
            return;
        }

        new AlertDialog.Builder(this)
                .setTitle("Exit Quiz?")
                .setMessage(
                        "Your current quiz answers will be lost "
                                + "if you leave this screen."
                )
                .setNegativeButton("Cancel", null)
                .setPositiveButton(
                        "Exit",
                        (dialog, which) -> finish()
                )
                .show();
    }

    // =====================================
    // SAVE ACTIVITY STATE
    // =====================================

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("module_id", moduleId);

        outState.putString(
                "module_title",
                moduleTitle
        );

        outState.putInt(
                "current_index",
                currentQuestionIndex
        );

        outState.putInt(
                "selected_index",
                selectedAnswerIndex
        );

        outState.putInt(
                "correct_answers",
                correctAnswers
        );

        outState.putBoolean(
                "answer_checked",
                answerChecked
        );

        outState.putBoolean(
                "showing_result",
                showingResult
        );

        // Preserve the saved database record ID
        outState.putLong(
                "saved_attempt_id",
                savedAttemptId
        );

        ArrayList<String> savedQuestions =
                new ArrayList<>();

        for (QuizQuestion question : questions) {

            savedQuestions.add(
                    question.getQuestionText()
            );

            String[] options = question.getOptions();

            for (String option : options) {
                savedQuestions.add(option);
            }

            savedQuestions.add(
                    String.valueOf(
                            question.getCorrectAnswerIndex()
                    )
            );

            savedQuestions.add(
                    question.getExplanation()
            );
        }

        outState.putStringArrayList(
                "saved_questions",
                savedQuestions
        );
    }

    // =====================================
    // RESTORE ACTIVITY STATE
    // =====================================

    private boolean restoreQuizState(Bundle state) {

        ArrayList<String> savedQuestions =
                state.getStringArrayList(
                        "saved_questions"
                );

        if (savedQuestions == null
                || savedQuestions.isEmpty()
                || savedQuestions.size() % 7 != 0) {

            return false;
        }

        int restoredModuleId = state.getInt(
                "module_id",
                moduleId
        );

        List<QuizQuestion> restored =
                new ArrayList<>();

        try {

            for (int i = 0;
                 i < savedQuestions.size();
                 i += 7) {

                String[] options = {
                        savedQuestions.get(i + 1),
                        savedQuestions.get(i + 2),
                        savedQuestions.get(i + 3),
                        savedQuestions.get(i + 4)
                };

                restored.add(
                        new QuizQuestion(
                                restoredModuleId,
                                savedQuestions.get(i),
                                options,
                                Integer.parseInt(
                                        savedQuestions.get(i + 5)
                                ),
                                savedQuestions.get(i + 6)
                        )
                );
            }

        } catch (IllegalArgumentException ex) {

            return false;
        }

        int restoredIndex = state.getInt(
                "current_index",
                0
        );

        int restoredSelected = state.getInt(
                "selected_index",
                -1
        );

        int restoredCorrect = state.getInt(
                "correct_answers",
                0
        );

        boolean restoredChecked = state.getBoolean(
                "answer_checked",
                false
        );

        boolean restoredResult = state.getBoolean(
                "showing_result",
                false
        );

        if (restoredIndex < 0
                || restoredIndex >= restored.size()
                || restoredSelected < -1
                || restoredSelected > 3
                || restoredCorrect < 0
                || restoredCorrect > restored.size()
                || (restoredChecked && restoredSelected == -1)) {

            return false;
        }

        questions.clear();
        questions.addAll(restored);

        moduleId = restoredModuleId;

        moduleTitle = state.getString(
                "module_title",
                moduleTitle
        );

        currentQuestionIndex = restoredIndex;
        selectedAnswerIndex = restoredSelected;
        correctAnswers = restoredCorrect;

        answerChecked = restoredChecked;
        showingResult = restoredResult;

        // Avoid saving the same attempt after rotation
        savedAttemptId = state.getLong(
                "saved_attempt_id",
                -1
        );

        return true;
    }

    // Read application colors
    private int getAppColor(int colorId) {

        return ContextCompat.getColor(
                this,
                colorId
        );
    }

    // Convert dp to pixels
    private int dp(float value) {

        return (int) (
                value
                        * getResources()
                        .getDisplayMetrics()
                        .density
                        + 0.5f
        );
    }

    // Close database helper
    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}
