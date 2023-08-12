package com.login.guessnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etGuessNumber, etGuessNumber2;

    TextView txtGuessNumber;

    Button btnGuess, btnHelpMe, btnResetGame;

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuessNumber = findViewById(R.id.etGuessNumber);
        etGuessNumber2 = findViewById(R.id.etGuessNumber2);
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
        randomNumber = random.nextInt(1001);
    }

    private void checkGuess() {
        String guessText1 = etGuessNumber.getText().toString();
        String guessText2 = etGuessNumber2.getText().toString();

        if (guessText1.isEmpty() || guessText2.isEmpty()) {
            txtGuessNumber.setText("Hãy nhập cả hai số đoán.");
            return; // Kết thúc hàm
        }

        int guessNumber1 = Integer.parseInt(guessText1);
        int guessNumber2 = Integer.parseInt(guessText2);

        if (guessNumber1 > 1000 || guessNumber2 > 1000) {
            txtGuessNumber.setText("Hãy nhập số từ 0 - 1000.");
            return; // Kết thúc hàm
        }

        if (guessNumber1 == randomNumber && guessNumber2 == randomNumber) {
            txtGuessNumber.setText("Cả hai người chơi đã chiến thắng!");
        } else if (guessNumber1 == randomNumber) {
            txtGuessNumber.setText("Người chơi 1 đã chiến thắng!");
        } else if (guessNumber2 == randomNumber) {
            txtGuessNumber.setText("Người chơi 2 đã chiến thắng!");
        } else {
            txtGuessNumber.setText("Cả hai người chơi chưa đoán đúng.");
        }
    }

    private void showRandomNumber() {
        txtGuessNumber.setText("Số bạn cần tìm là: " + randomNumber);
    }

    private void resetGame() {
        etGuessNumber.setText("");
        etGuessNumber2.setText("");
        txtGuessNumber.setText("");
        generateRandomNumber();
    }

}