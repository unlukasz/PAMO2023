package com.example.pamo2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1, button2, button3;
    private Questions question= new Questions();
    TextView score_text, question_text;
    private String answer;
    private int questionlength=question.questions.length;
    Random random;
    int score, count;
    int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        random = new Random();
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        shuffle(intArray);
        count = 0;
        score = 0;
        intArray = Arrays.copyOf(intArray, intArray.length + 1);
        intArray[intArray.length - 1] = 22;

        question_text=(TextView)findViewById(R.id.questions);
        NextQuestion(intArray[count]);

        score_text=(TextView)findViewById(R.id.score_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:
                if (button1.getText()==answer){
                    Toast.makeText(this,"Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show();
                    ScoreCount();
                    NextQuestion(intArray[count]);
                }else{
                    Toast.makeText(this,"Odpowiedź błędna!", Toast.LENGTH_LONG).show();
                    NextQuestion(intArray[count]);
                }
                break;
            case R.id.button2:
                if (button2.getText()==answer){
                    Toast.makeText(this,"Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show();
                    ScoreCount();
                    NextQuestion(intArray[count]);
                }else{
                    Toast.makeText(this,"Odpowiedź błędna!", Toast.LENGTH_LONG).show();
                    NextQuestion(intArray[count]);
                }
                break;
            case R.id.button3:
                if (button3.getText()==answer){
                    Toast.makeText(this,"Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show();
                    ScoreCount();
                    NextQuestion(intArray[count]);
                }else{
                    Toast.makeText(this,"Odpowiedź błędna!", Toast.LENGTH_LONG).show();
                    NextQuestion(intArray[count]);
                }
                break;
        }
    }

    private void NextQuestion(int x) {
        if(x == 22){
            QuizEnd();
        }
        question_text.setText(question.getQuestion(x));
        Random r = new Random();
        int randomNumber = r.nextInt(3);
        if(randomNumber==1){
            button1.setText(question.getchoice1(x));
            button2.setText(question.getchoice2(x));
            button3.setText(question.getchoice3(x));
        }else if(randomNumber==2){
            button1.setText(question.getchoice2(x));
            button2.setText(question.getchoice3(x));
            button3.setText(question.getchoice1(x));
        }else{
            button1.setText(question.getchoice3(x));
            button2.setText(question.getchoice2(x));
            button3.setText(question.getchoice1(x));
        }
        answer=question.getCorrectAnswer(x);
        count++;
    }

    private void ScoreCount(){
        score++;
        score_text.setText("Wynik: "+score);
    }

    private void QuizEnd(){
        Intent intent = new Intent(QuizActivity.this,ScoreActivity.class);
        intent.putExtra("scoreQuiz", score);
        startActivity(intent);
    }

    void shuffle(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
