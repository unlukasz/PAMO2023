package com.example.pamo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height, age;
    TextView resultText, gender;
    String calculation, BMIresult, PPMresult;
    Button calculateBMIButton, GraphButton, QuizButton;
    Switch genderSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        resultText = findViewById(R.id.resultText);
        gender = findViewById(R.id.gender);

        calculateBMIButton = findViewById((R.id.calculateBMIButton));
        calculateBMIButton.setEnabled(false);

        GraphButton = findViewById((R.id.GraphButton));
        QuizButton = findViewById((R.id.QuizButton));

        weight.addTextChangedListener(textwatcher);
        height.addTextChangedListener(textwatcher);
        age.addTextChangedListener(textwatcher);

        genderSwitch = findViewById(R.id.genderSwitch);

        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(genderSwitch.isChecked()){
                    gender.setText("Kobieta");
                }else{
                    gender.setText("Mężczyzna");
                }
            }
        });
    }

    private TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String x = weight.getText().toString();
            String y = height.getText().toString();
            String z = age.getText().toString();

            if(!x.isEmpty() && !y.isEmpty() && !z.isEmpty()){
                calculateBMIButton.setEnabled(true);
            }else{
                calculateBMIButton.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void calculateBMI(View view) {
        if(genderSwitch.isChecked()){
            gender.setText("Kobieta");
        }else{
            gender.setText("Mężczyzna");
        }

        String x = weight.getText().toString();
        String y = height.getText().toString();
        String z = age.getText().toString();

        closeKeyboard();

        float weightValue = Float.parseFloat(x);
        float heightValue = Float.parseFloat(y);
        float heightValueBMI = Float.parseFloat(y) / 100;
        float ageValue = Float.parseFloat(z);

        float bmi = weightValue / (heightValueBMI * heightValueBMI);

        if (bmi < 16) {
            BMIresult = "Wygłodzenie";
            resultText.setTextColor(Color.RED);
        } else if (bmi < 17) {
            BMIresult = "Wychudzenie";
            resultText.setTextColor(Color.RED);
        } else if (bmi < 18.5) {
            BMIresult = "Niedowaga";
            resultText.setTextColor(Color.rgb(255,127,80));
        } else if (bmi < 25) {
            BMIresult = "Waga prawidłowa";
            resultText.setTextColor(Color.GREEN);
        } else if (bmi < 29) {
            BMIresult = "Nadwaga";
            resultText.setTextColor(Color.rgb(255,127,80));
        } else if (bmi < 35) {
            BMIresult = "1 stopień otyłości";
            resultText.setTextColor(Color.RED);
        } else if (bmi < 40) {
            BMIresult = "2 stopień otyłości";
            resultText.setTextColor(Color.RED);
        } else {
            BMIresult = "Otyłość skrajna";
            resultText.setTextColor(Color.RED);
        }

        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("resultBMIVariable", BMIresult);
        intent.putExtra("scoreBMIVariable", bmi);
        if(genderSwitch.isChecked()){
            //Female
            float ppm = 655.1f + (9.563f * weightValue) + (1.85f * heightValue) - (4.676f * ageValue);
            intent.putExtra("scorePPMVariable", ppm);
        }else{
            //Male
            float ppm = 65.5f + (13.75f * weightValue) + (5.003f * heightValue) - (6.775f * ageValue);
            intent.putExtra("scorePPMVariable", ppm);
        }
        startActivity(intent);

        calculation = "Wynik:\t" + bmi + "\n" + BMIresult;
        //resultText.setVisibility(View.VISIBLE);
        resultText.setText(calculation);
    }

    public void graphShow(View view){
        closeKeyboard();
        Intent intent = new Intent(MainActivity.this,GraphActivity.class);
        startActivity(intent);
    }

    public void quizGame(View view){
        closeKeyboard();
        Intent intent = new Intent(MainActivity.this,QuizActivity.class);
        startActivity(intent);
    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}