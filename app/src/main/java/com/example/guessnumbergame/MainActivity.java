package com.example.guessnumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber () {

        Random rand = new Random();

        randomNumber = rand.nextInt(100) + 1;
    }

    public void guessNum (View view) {

        EditText userGuess = (EditText) findViewById(R.id.editText);

        int guessValue = Integer.parseInt((userGuess.getText().toString()));
        Log.i("guess", userGuess.getText().toString());
        Log.i("info", Integer.toString(randomNumber));

        String messages ;

        if (guessValue > randomNumber) {
            if (guessValue - randomNumber > 10){
                messages = "too high!";
            }else {
                messages = "high";
            }

        } else if (guessValue < randomNumber) {
            if (guessValue - randomNumber < -10 ){
                messages = "too low!";
            }else {
                messages = "low";
            }
        } else {
            messages = "you got it right!";
        }
        Toast.makeText(this, messages, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
