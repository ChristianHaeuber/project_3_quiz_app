package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Boolean checkQuestion1Answer() {
        Boolean question1Correct;
        RadioButton q1_answer = (RadioButton) findViewById(R.id.q1_true_radio);
        Boolean q1Answer = q1_answer.isChecked();
        if (q1Answer) {
            question1Correct = Boolean.TRUE;
        } else {
            question1Correct = Boolean.FALSE;
        }
        return question1Correct;
    }

    public Boolean checkQuestion2Answer() {

        // Correct response is checkbox2 and checkbox 4 checked and
        // checkbox1 and checkbox3 not checked

        Boolean question2Correct;
        // Check to see if first checkbox is checked
        CheckBox q2_checkbox_1 = (CheckBox) findViewById(R.id.q2_checkbox_1);
        Boolean q2Checkbox1 = q2_checkbox_1.isChecked();

        // Check to see if second checkbox is checked
        CheckBox q2_checkbox_2 = (CheckBox) findViewById(R.id.q2_checkbox_2);
        Boolean q2Checkbox2 = q2_checkbox_2.isChecked();

        // Check to see if third checkbox is checked
        CheckBox q2_checkbox_3 = (CheckBox) findViewById(R.id.q2_checkbox_3);
        Boolean q2Checkbox3 = q2_checkbox_3.isChecked();

        // Check to see if fourth checkbox is checked
        CheckBox q2_checkbox_4 = (CheckBox) findViewById(R.id.q2_checkbox_4);
        Boolean q2Checkbox4 = q2_checkbox_4.isChecked();

        if (!q2Checkbox1 && q2Checkbox2 && !q2Checkbox3 && q2Checkbox4) {
            question2Correct = Boolean.TRUE;
        } else {
            question2Correct = Boolean.FALSE;
        }
        return question2Correct;
    }

    public Boolean checkQuestion3Answer() {
        Boolean question3Correct;
        RadioButton q3_answer = (RadioButton) findViewById(R.id.q3_false_radio);
        Boolean q3Answer = q3_answer.isChecked();
        if (q3Answer) {
            question3Correct = Boolean.TRUE;
        } else {
            question3Correct = Boolean.FALSE;
        }
        return question3Correct;
    }

    public Boolean checkQuestion4Answer() {
        Boolean question4Correct;
        String correctAnswer1 = "FDR";
        String correctAnswer2 = "Franklin Deleanor Roosevelt";
        String correctAnswer3a = "Roosevelt";
        String correctAnswer3b = "F";
        String correctAnswer4 = "Franklin Roosevelt";

        EditText q4_answer = (EditText) findViewById(R.id.q4_editText);
        String q4Answer = q4_answer.getText().toString();

        if (q4Answer.toLowerCase().contains(correctAnswer1.toLowerCase())) {
            question4Correct = Boolean.TRUE;
        } else if (q4Answer.toLowerCase().contains(correctAnswer2.toLowerCase())) {
            question4Correct = Boolean.TRUE;
        } else if (q4Answer.toLowerCase().contains(correctAnswer3a.toLowerCase()) &&
                q4Answer.toLowerCase().contains(correctAnswer3b.toLowerCase())) {
            question4Correct = Boolean.TRUE;
        } else if (q4Answer.toLowerCase().contains(correctAnswer4.toLowerCase())) {
            question4Correct = Boolean.TRUE;
        } else {
            question4Correct = Boolean.FALSE;
        }
        return question4Correct;
    }

    public void submitAnswers(View view) {
        int correctAnswers = 0;
        Boolean q1AnsCorrect;
        Boolean q2AnsCorrect;
        Boolean q3AnsCorrect;
        Boolean q4AnsCorrect;

        q1AnsCorrect = checkQuestion1Answer();
        q2AnsCorrect = checkQuestion2Answer();
        q3AnsCorrect = checkQuestion3Answer();
        q4AnsCorrect = checkQuestion4Answer();

        if (q1AnsCorrect) {
            correctAnswers += 1;
        }
        if (q2AnsCorrect) {
            correctAnswers += 1;
        }
        if (q3AnsCorrect) {
            correctAnswers += 1;
        }
        if (q4AnsCorrect) {
            correctAnswers += 1;
        }
        String toastString = "You answered " + correctAnswers + " correctly out of 4.";
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
    }
}
