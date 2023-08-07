package com.login.guessnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etGuessNumber;

    TextView txtGuessNumber;

    Button btnGuess, btnHelpMe, btnResetGame;

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuessNumber = findViewById(R.id.etGuessNumber);
        txtGuessNumber = findViewById(R.id.txtGuessNumber);
        btnGuess = findViewById(R.id.btnGuess);
        btnHelpMe = findViewById(R.id.btnHelpMe);
        btnResetGame = findViewById(R.id.btnResetGame);

        generateRandomNumber();

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        btnHelpMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomNumber();
            }
        });

        btnResetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private void checkGuess() {
        String guessText = etGuessNumber.getText().toString();
        if(!guessText.isEmpty()) {
            int guessNumber = Integer.parseInt(guessText);
            if(guessNumber == randomNumber) {
                txtGuessNumber.setText("Bạn đã chiến thắng!");
            } else if (guessNumber < randomNumber) {
                txtGuessNumber.setText("Bạn hãy nhập số lớn hơn.");
            } else {
                txtGuessNumber.setText("Bạn hãy nhập số nhỏ hơn.");
            }
        }
    }

    private void showRandomNumber() {
        txtGuessNumber.setText("Số bạn cần tìm là: " + randomNumber);
    }

    private void resetGame() {
        etGuessNumber.setText("");
        txtGuessNumber.setText("");
        generateRandomNumber();
    }

}