package com.example.quizapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, marksText;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private Button deleteButton, nextButton;
    private int currentQuestionIndex = 0;
    private int marks = 0;

    private String[] questionsArray = {
            "Who is the first President of the United States?",
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who painted the Mona Lisa?",
            "What is the tallest mountain in the world?"
    };

    private String[] optionsArray = {
            "John Adams,George Washington,Abraham Lincoln,Thomas Jefferson",
            "London,Paris,Berlin,Madrid",
            "Jupiter,Mercury,Venus,Mars",
            "Leonardo da Vinci,Vincent van Gogh,Michelangelo,Pablo Picasso",
            "Mount Kilimanjaro,K2,Mount Everest,Mauna Kea"
    };

    private String[] answersArray = {
            "George Washington",
            "Paris",
            "Mars",
            "Leonardo da Vinci",
            "Mount Everest"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        deleteButton = findViewById(R.id.deleteButton);
        nextButton = findViewById(R.id.nextButton);
        marksText = findViewById(R.id.marks);

        displayQuestion();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                showResult();

            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsRadioGroup.clearCheck();
                deleteButton.setEnabled(true);
                submitButton.setEnabled(true);
                nextButton.setEnabled(true);

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (currentQuestionIndex == questionsArray.length-1){
                    nextButton.setEnabled(false);
                }else  if (currentQuestionIndex == questionsArray.length){
                    showResult();
                }

            }
        });
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionsArray.length) {
            questionTextView.setText(questionsArray[currentQuestionIndex]);

            String[] options = optionsArray[currentQuestionIndex].split(",");
            optionsRadioGroup.removeAllViews();
            for (String option : options) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(option);
                optionsRadioGroup.addView(radioButton);
            }
            deleteButton.setEnabled(true);
            submitButton.setEnabled(true);
            nextButton.setEnabled(true);
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            String correctAnswer = answersArray[currentQuestionIndex];
            if (selectedAnswer.equals(correctAnswer)) {
                marks++;
            }
            currentQuestionIndex++;
            displayQuestion();
        }
    }

    private void showResult() {
        questionTextView.setText("Quiz Completed");
        optionsRadioGroup.removeAllViews();
        submitButton.setEnabled(false);
        deleteButton.setEnabled(false);
        nextButton.setEnabled(false);
        Toast.makeText(this, "Your score is " + marks + "/" + questionsArray.length, Toast.LENGTH_LONG).show();
        marksText.setText(marks + "/" + questionsArray.length);
    }
}




