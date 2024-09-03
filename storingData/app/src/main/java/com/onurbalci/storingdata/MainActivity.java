package com.onurbalci.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ageNumber;
    TextView resultText;
    SharedPreferences sharedPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageNumber = findViewById(R.id.ageNumber);
        resultText = findViewById(R.id.resultText);

        sharedPreferences = this.getSharedPreferences("com.onurbalci.storingdata" , Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge", 0);

        if (storedAge == 0){
            resultText.setText("Your age: ");
        }else {
            resultText.setText("Your age: " + storedAge);
        }
    }

    @SuppressLint("SetTextI18n")
    public void save (View view) {

        if (!ageNumber.getText().toString().matches("")){
            int userAge = Integer.parseInt(ageNumber.getText().toString());
            resultText.setText("Your age: " + userAge);

            sharedPreferences.edit().putInt("storedAge", userAge).apply();
        }
    }

    @SuppressLint("SetTextI18n")
    public void  delete (View view) {

        int storedData = sharedPreferences.getInt("storedAge" , 0);

        if (storedData != 0) {
            sharedPreferences.edit().remove("storedAge").apply();
            resultText.setText("Your age: ");
        }
    }
}