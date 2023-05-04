package com.example.pamo2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    TextView final_score;
    Button QuizButton, MainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final_score = findViewById(R.id.final_score);
        QuizButton = findViewById(R.id.QuizButton);
        MainButton = findViewById(R.id.MainButton);

        int score = getIntent().getIntExtra("scoreQuiz", 0);

        final_score.setText("Wynik to "+score+" na 9.");
    }
    public void quizGame(View view){
        Intent intent = new Intent(ScoreActivity.this,QuizActivity.class);
        startActivity(intent);
    }
    public void BackToMain(View view){
        Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
        startActivity(intent);
    }

}