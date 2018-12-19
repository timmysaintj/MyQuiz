package com.example.tim.myquiz;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Number of correct answers
    int correctAnswer;

    /**
     * When the correct answer is selected.
     * This will add 1 to the score.
     */
    private int scoreIncrement() {
        correctAnswer = ++correctAnswer;
        return (correctAnswer);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This is what happens when the submit button is clicked.
    public void submitScore(View view) {
        EditText editName = findViewById(R.id.edit_name);
        String name = editName.getText().toString();

        /*
         * Called questions methods from below.
         * i.e. question1, question2 and so on.
         */
        question1(); //Correct answer is 2 buckets.
        question2(); //Correct answers are Denver Broncos, Cleveland Browns and LA Raiders
        question3(); //Correct answer is A South African BBQ.
        question4(); //Correct answer is Thai.
        question5(); //Correct answers are Johnny Depp and Blaire Dunlop (young Willy Wonka)
        question6(); //Correct answer is Burma.
        question7(); //Correct answers are Mr.Magoo and Thurston Howell III (Gilligan's Island)
        question8(); //Correct answer is Michael Crichton.
        question9(); //Correct answer is Bangkok.
        question10(); // Correct answers are The Iliad and The odyssey.
        bonusQuestion(); //Correct answer is: if a woodchuck could chuck wood?

        /*
         * Displays the results to the screen
         * This pulls from the createQuizResults method, then displays it to the screen
         * from the displayResults method at the bottom.
         */
        String quizResults = createQuizResults(name, correctAnswer);

        //This will disable the quiz results button to avoid excess counting.
        Button endOfQuizButton = findViewById(R.id.submit_button);
        endOfQuizButton.setEnabled(false);
    }

    //This will reset the endOfQuizButton in case you have to make changes
    public void resetQuizButton(View view) {
        Button resetEndOfQuizButton = findViewById(R.id.submit_button);
        resetEndOfQuizButton.setEnabled(true);

        correctAnswer = 0;
    }

    /**
     * Creates a summary of results to be displayed to the screen
     *
     * @param name          person taking the quiz
     * @param correctAnswer the count of correct answers
     * @return the results and score of the quiz
     */
    private String createQuizResults(String name, int correctAnswer) {
        String quizResults = name + correctAnswer;

        // This will send a message at the end of the quiz depending on how many the user got correct.
        if (correctAnswer <= 3) {
            Toast toast = Toast.makeText(getApplicationContext(), "Sorry " + name + "\n" + "You need to study up on your useless information."
                    + "\n" + "Your score is " + correctAnswer + " out of 11", Toast.LENGTH_LONG);
            toast.show();

        } else if (correctAnswer <= 7) {
            Toast toast = Toast.makeText(getApplicationContext(), "Good try " + name + "\n" + "You must study a little more." + "\n" + "Your score is "
                    + correctAnswer + " out of 11", Toast.LENGTH_LONG);
            toast.show();

        } else if (correctAnswer <= 11) {
            Toast toast = Toast.makeText(getApplicationContext(), "Awesome job " + name + "\n" + "You are a master of useless information."
                    + "\n" + "Your score is " + correctAnswer + " out of 11", Toast.LENGTH_LONG);
            toast.show();
        }
        return quizResults;
    }

    /**
     * This method will score the correct answer for question #1.
     * Then send the called questions from the submitScore method in the called questions methods,
     * as will all of the following questions.
     */
    public void question1() {
        RadioGroup question1Answers = findViewById(R.id.radio_group_q1);
        switch (question1Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q1_a2:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score 1 correct for each correct choice for question #2.
     */
    public void question2() {
        CheckBox broncosCheckBox = findViewById(R.id.q2_answer_broncos_cb);

        CheckBox oaklandCheckBox = findViewById(R.id.q2_answer_ok_raiders_cb);

        CheckBox titansCheckBox = findViewById(R.id.q2_answer_titans_cb);

        CheckBox raidersCheckBox = findViewById(R.id.q2_answer_la_raiders_cb);

        CheckBox brownsCheckBox = findViewById(R.id.q2_answer_browns_cb);

        if (broncosCheckBox.isChecked() && !oaklandCheckBox.isChecked() && !titansCheckBox.isChecked() && raidersCheckBox.isChecked()
                && brownsCheckBox.isChecked()) {
            scoreIncrement();
        }
    }

    /**
     * This method will score the correct answer for question #3.
     */
    public void question3() {
        RadioGroup question3Answers = findViewById(R.id.radio_group_q3);
        switch (question3Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q3_a3:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score the correct answer for question #4.
     */
    public void question4() {
        RadioGroup question4Answers = findViewById(R.id.radio_group_q4);
        switch (question4Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q4_a4:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score 1 correct for each correct choice for question #5.
     */
    public void question5() {
        CheckBox johnnyDeppCheckBox = findViewById(R.id.q5_answer_johnny_depp_cb);

        CheckBox blaireDunlopCheckBox = findViewById(R.id.q5_answer_blaire_dunlop_cb);

        CheckBox highmoreCheckBox = findViewById(R.id.q5_answer_freddie_highmore_cb);

        CheckBox morrisCheckBox = findViewById(R.id.q5_answer_david_morris_cb);

        if (johnnyDeppCheckBox.isChecked() && blaireDunlopCheckBox.isChecked() && !highmoreCheckBox.isChecked()
                && !morrisCheckBox.isChecked()) {
            scoreIncrement();
        }
    }

    /**
     * This method will score the correct answer for question #6.
     */
    public void question6() {
        RadioGroup question6Answers = findViewById(R.id.radio_group_q6);
        switch (question6Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q6_a4:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score 1 correct for each correct choice for question #7.
     */
    public void question7() {
        CheckBox magooCheckBox = findViewById(R.id.q7_answer_mr_magoo_cb);

        CheckBox munsterCheckBox = findViewById(R.id.q7_answer_grandpa_munster_cb);

        CheckBox thurstonHowellCheckBox = findViewById(R.id.q7_answer_thurston_howell_cb);

        CheckBox yogiCheckBox = findViewById(R.id.q7_answer_yogi_bear_cb);

        if (magooCheckBox.isChecked() && !munsterCheckBox.isChecked() && thurstonHowellCheckBox.isChecked()
                && !yogiCheckBox.isChecked()) {
            scoreIncrement();
        }
    }

    /**
     * This method will score the correct answer for question #8.
     */
    public void question8() {
        RadioGroup question8Answers = findViewById(R.id.radio_group_q8);
        switch (question8Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q8_a4:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score the correct answer for question #9.
     */
    public void question9() {
        RadioGroup question9Answers = findViewById(R.id.radio_group_q9);
        switch (question9Answers.getCheckedRadioButtonId()) {
            case R.id.radio_q9_a1:
                scoreIncrement();
                break;
        }
    }

    /**
     * This method will score 1 correct for each correct choice for question #10.
     */
    public void question10() {
        CheckBox iliadCheckBox = findViewById(R.id.q10_answer_iliad_cb);

        CheckBox nostioCheckBox = findViewById(R.id.q10_answer_nostoi_cb);

        CheckBox odysseyCheckBox = findViewById(R.id.q10_answer_odyssey_cb);

        CheckBox cypriaCheckBox = findViewById(R.id.q10_answer_cypria_cb);

        if (iliadCheckBox.isChecked() && !nostioCheckBox.isChecked() && odysseyCheckBox.isChecked()
                && !cypriaCheckBox.isChecked()) {
            scoreIncrement();
        }

    }

    /**
     * This method will validate the edit text field for the bonus question. If it is typed
     * exactly, then it will score 1 point.
     */
    public void bonusQuestion() {
        EditText bonusQuestion = findViewById(R.id.bonus_question_et);
        String answer = bonusQuestion.getText().toString().trim();
        if (answer.contentEquals("if a woodchuck could chuck wood?")) {
            scoreIncrement();
        }
    }
}
