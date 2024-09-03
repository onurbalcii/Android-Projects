package com.onurbalci.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Double number1;
    Double number2;
    EditText numText1;
    EditText numText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numText1 = findViewById(R.id.numText1);
        numText2 = findViewById(R.id.numText2);
    }

    public void sum(View view){

        String input1 = numText1.getText().toString();
        String input2 = numText2.getText().toString();

        if(input1.isEmpty() || input2.isEmpty()) {

            String result = ("Enter Value!");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + result);
            startActivity(intent);

        }else {
            number1 = Double.parseDouble(input1);
            number2 = Double.parseDouble(input2);

            Double result = number1 + number2;
            String resultText = Double.toString(result);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + resultText);
            startActivity(intent);
        }
    }

    public void sub(View view){

        String input1 = numText1.getText().toString();
        String input2 = numText2.getText().toString();

        if(input1.isEmpty() || input2.isEmpty()) {

            String result = ("Enter Value!");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + result);
            startActivity(intent);

        }else {
            number1 = Double.parseDouble(input1);
            number2 = Double.parseDouble(input2);

            Double result = number1 - number2;
            String resultText = Double.toString(result);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + resultText);
            startActivity(intent);
        }
    }

    public void multi(View view){

        String input1 = numText1.getText().toString();
        String input2 = numText2.getText().toString();

        if(input1.isEmpty() || input2.isEmpty()) {

            String result = ("Enter Value!");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + result);
            startActivity(intent);

        }else {
            number1 = Double.parseDouble(input1);
            number2 = Double.parseDouble(input2);

            Double result = number1 * number2;
            String resultText = Double.toString(result);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + resultText);
            startActivity(intent);
        }
    }

    public void div(View view){

        String input1 = numText1.getText().toString();
        String input2 = numText2.getText().toString();

        if(input1.isEmpty() || input2.isEmpty()) {

            String result = ("Enter Value!");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result","Result: " + result);
            startActivity(intent);

        }else {
            number1 = Double.parseDouble(input1);
            number2 = Double.parseDouble(input2);

            Double result = number1 / number2;
            String resultText = Double.toString(result);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result", "Result: " + resultText);
            startActivity(intent);
        }
    }

    public void result(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}