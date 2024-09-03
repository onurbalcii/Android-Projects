package com.onurbalci.mathexamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {

    TextView number1Text;
    TextView number2Text;
    TextView operatorText;
    TextView resultText;
    EditText answerText;

    int result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        operatorText = findViewById(R.id.operatorText);
        resultText = findViewById(R.id.resultText);

        answerText = findViewById(R.id.answerText);

    }

    public void generate (View view) {

        int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        int randomOperator = ThreadLocalRandom.current().nextInt(1, 3 + 1 );

        String operator = "";

        switch (randomOperator) {

            case 1: operator = "+";
                break;

            case 2: operator = "-";
                break;

            case 3: operator = "*";
                break;
        }

        operatorText.setText(operator);
        number1Text.setText(String.valueOf(randomNumber1));
        number2Text.setText(String.valueOf(randomNumber2));

        result = 0;

        switch (operator) {

            case "+": result = randomNumber1 + randomNumber2;
            break;

            case "-": result = randomNumber1 - randomNumber2;
            break;

            case "*": result = randomNumber1 * randomNumber2;
            break;
        }
    }

    public void check (View view) {

        String userInput = answerText.getText().toString();

        if (userInput.isEmpty()){

            resultText.setText("Enter Number!");

        } else {

            int userAnswer = Integer.parseInt(userInput);

            if (userAnswer == result){
                resultText.setText("Correct!");
            } else {
                resultText.setText("Incorrect!");
            }
        }
    }
}