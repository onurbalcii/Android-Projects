package com.onurbalci.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String userName;
    EditText nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
    }

    public void changeAct (View view) {

        userName = nameText.getText().toString();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("userInput", userName);
        startActivity(intent);

    }
}