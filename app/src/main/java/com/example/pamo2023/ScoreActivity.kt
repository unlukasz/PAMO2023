package com.example.pamo2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pamo2023.R
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import android.view.View
import android.widget.*
import com.example.pamo2023.Main2Activity
import com.example.pamo2023.GraphActivity
import com.example.pamo2023.QuizActivity
import com.example.pamo2023.Questions
import com.example.pamo2023.ScoreActivity
import com.example.pamo2023.MainActivity

class ScoreActivity : AppCompatActivity() {
    val final_score: TextView = findViewById(R.id.final_score) as TextView
    var QuizButton: Button? = null
    var MainButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        QuizButton = findViewById(R.id.QuizButton)
        MainButton = findViewById(R.id.MainButton)
        val score = intent.getIntExtra("scoreQuiz", 0)
        final_score.setText("Wynik to $score na 9.")
    }

    fun quizGame(view: View?) {
        val intent = Intent(this@ScoreActivity, QuizActivity::class.java)
        startActivity(intent)
    }

    fun BackToMain(view: View?) {
        val intent = Intent(this@ScoreActivity, MainActivity::class.java)
        startActivity(intent)
    }
}