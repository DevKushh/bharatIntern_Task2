package com.example.generalquizz;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView questionText,result;
    private RadioButton[] radioButtonOptions;
    private Button submitButton;
    private Quiz quiz;
    int count=0;

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        questionText = findViewById(R.id.questionBox);
        radioButtonOptions = new RadioButton[4]; // Assuming you have 4 options
        radioButtonOptions[0] = findViewById(R.id.option1RadioButton);
        radioButtonOptions[1] = findViewById(R.id.option2RadioButton);
        radioButtonOptions[2] = findViewById(R.id.option3RadioButton);
        radioButtonOptions[3] = findViewById(R.id.option4RadioButton);
        submitButton = findViewById(R.id.submitButton);
        result=findViewById(R.id.resultBox);
        quiz = new Quiz();

        loadQuestion(currentQuestionIndex);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void loadQuestion(int index) {
        if (index < quiz.questions.length) {
            questionText.setText(quiz.questions[index]);

            for (int i = 0; i < 4; i++) {
                radioButtonOptions[i].setText(quiz.options[index][i]);
            }
        }
    }

    private void checkAnswer() {
        int selectedAnswer = -1;
        for (int i = 0; i < 4; i++) {
            if (radioButtonOptions[i].isChecked()) {
                selectedAnswer = i;
                break;
            }
        }

        if (selectedAnswer == -1) {
            // User didn't select an answer
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedAnswer == quiz.correctAnswers[currentQuestionIndex]) {
            // Correct answer
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            count=count+1;
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        // Move to the next question
        currentQuestionIndex++;
        if (currentQuestionIndex < quiz.questions.length) {
            loadQuestion(currentQuestionIndex);
            clearSelection();
        } else {
            // End of the quiz
            Toast.makeText(this, "Quiz finished", Toast.LENGTH_SHORT).show();
            String str="\nYou have given ' "+count+" ' correct Answers ";
            result.setText(str);
            // You can implement further actions here
        }
    }

    private void clearSelection() {
        for (RadioButton radioButton : radioButtonOptions) {
            radioButton.setChecked(false);
        }
    }
}