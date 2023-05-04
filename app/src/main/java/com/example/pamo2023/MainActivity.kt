package com.example.pamo2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pamo2023.R
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.pamo2023.Main2Activity
import com.example.pamo2023.GraphActivity
import com.example.pamo2023.QuizActivity
import com.example.pamo2023.Questions
import com.example.pamo2023.ScoreActivity
import com.example.pamo2023.MainActivity

class MainActivity : AppCompatActivity() {
    val weight: EditText = findViewById(R.id.weight)
    var height: EditText = findViewById(R.id.height)
    var age: EditText = findViewById(R.id.age)
    var resultText: TextView? = null
    var gender: TextView = findViewById(R.id.gender)
    var calculation: String? = null
    var BMIresult: String? = null
    var PPMresult: String? = null
    var calculateBMIButton: Button = findViewById(R.id.calculateBMIButton)
    var GraphButton: Button? = null
    var QuizButton: Button? = null
    val genderSwitch: Switch = findViewById(R.id.genderSwitch)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.resultText)
        calculateBMIButton.setEnabled(false)
        GraphButton = findViewById(R.id.GraphButton)
        QuizButton = findViewById(R.id.QuizButton)
        weight.addTextChangedListener(textwatcher)
        height.addTextChangedListener(textwatcher)
        age.addTextChangedListener(textwatcher)
        genderSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            if (genderSwitch.isChecked()) {
                gender.setText("Kobieta")
            } else {
                gender.setText("Mężczyzna")
            }
        })
    }

    private val textwatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            val x = weight!!.text.toString()
            val y = height!!.text.toString()
            val z = age!!.text.toString()
            if (!x.isEmpty() && !y.isEmpty() && !z.isEmpty()) {
                calculateBMIButton!!.isEnabled = true
            } else {
                calculateBMIButton!!.isEnabled = false
            }
        }

        override fun afterTextChanged(editable: Editable) {}
    }

    fun calculateBMI(view: View?) {
        if (genderSwitch!!.isChecked) {
            gender!!.text = "Kobieta"
        } else {
            gender!!.text = "Mężczyzna"
        }
        val x = weight!!.text.toString()
        val y = height!!.text.toString()
        val z = age!!.text.toString()
        closeKeyboard()
        val weightValue = x.toFloat()
        val heightValue = y.toFloat()
        val heightValueBMI = y.toFloat() / 100
        val ageValue = z.toFloat()
        val bmi = weightValue / (heightValueBMI * heightValueBMI)
        if (bmi < 16) {
            BMIresult = "Wygłodzenie"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 17) {
            BMIresult = "Wychudzenie"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 18.5) {
            BMIresult = "Niedowaga"
            resultText!!.setTextColor(Color.rgb(255, 127, 80))
        } else if (bmi < 25) {
            BMIresult = "Waga prawidłowa"
            resultText!!.setTextColor(Color.GREEN)
        } else if (bmi < 29) {
            BMIresult = "Nadwaga"
            resultText!!.setTextColor(Color.rgb(255, 127, 80))
        } else if (bmi < 35) {
            BMIresult = "1 stopień otyłości"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 40) {
            BMIresult = "2 stopień otyłości"
            resultText!!.setTextColor(Color.RED)
        } else {
            BMIresult = "Otyłość skrajna"
            resultText!!.setTextColor(Color.RED)
        }
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        intent.putExtra("resultBMIVariable", BMIresult)
        intent.putExtra("scoreBMIVariable", bmi)
        if (genderSwitch!!.isChecked) {
            //Female
            val ppm = 655.1f + 9.563f * weightValue + 1.85f * heightValue - 4.676f * ageValue
            intent.putExtra("scorePPMVariable", ppm)
        } else {
            //Male
            val ppm = 65.5f + 13.75f * weightValue + 5.003f * heightValue - 6.775f * ageValue
            intent.putExtra("scorePPMVariable", ppm)
        }
        startActivity(intent)
        calculation = "Wynik:\t$bmi\n$BMIresult"
        //resultText.setVisibility(View.VISIBLE);
        resultText!!.text = calculation
    }

    fun graphShow(view: View?) {
        closeKeyboard()
        val intent = Intent(this@MainActivity, GraphActivity::class.java)
        startActivity(intent)
    }

    fun quizGame(view: View?) {
        closeKeyboard()
        val intent = Intent(this@MainActivity, QuizActivity::class.java)
        startActivity(intent)
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}