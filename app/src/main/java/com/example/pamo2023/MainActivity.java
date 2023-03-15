package com.example.pamo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    TextView resultText;
    String calculation, BMIresult;
    Button calculateBMIButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultText = findViewById(R.id.resultText);

        calculateBMIButton = findViewById((R.id.calculateBMIButton));
        calculateBMIButton.setEnabled(false);

        weight.addTextChangedListener(textwatcher);
        height.addTextChangedListener(textwatcher);
    }

    private TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String x = weight.getText().toString();
            String y = height.getText().toString();

            if(!x.isEmpty() && !y.isEmpty()){
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
        String x = weight.getText().toString();
        String y = height.getText().toString();

        closeKeyboard();

        float weightValue = Float.parseFloat(x);
        float heightValue = Float.parseFloat(y) / 100;

        float bmi = weightValue / (heightValue * heightValue);

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

        calculation = "Wynik:\t" + bmi + "\n" + BMIresult;

        resultText.setText(calculation);
    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}