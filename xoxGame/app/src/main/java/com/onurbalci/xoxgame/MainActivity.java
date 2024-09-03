package com.onurbalci.xoxgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount = 0;
    private TextView playerTurnTextView; // TextView'i sınıf düzeyinde tanımla

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTurnTextView = findViewById(R.id.playerTurnTextView);
        playerTurnTextView.setText("Player 1's Turn (X)");

        // XOX Grid Buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + (i + 1) + (j + 1);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
            ((Button) v).setBackgroundResource(R.drawable.button_style);
            ((Button) v).setTextColor(getResources().getColor(R.color.buttonXColor));
            playerTurnTextView.setText("Player 2's Turn (O)");
        } else {
            ((Button) v).setText("O");
            ((Button) v).setBackgroundResource(R.drawable.button_style);
            ((Button) v).setTextColor(getResources().getColor(R.color.buttonOColor));
            playerTurnTextView.setText("Player 1's Turn (X)");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {
                return true; // Row win
            }
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {
            return true; // Diagonal win
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {
            return true; // Diagonal win
        }

        return false;
    }

    private void player1Wins() {
        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void player2Wins() {
        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        player1Turn = true;
        roundCount = 0;
    }
}
