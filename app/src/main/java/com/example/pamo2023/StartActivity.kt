package com.example.pamo2023

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import com.example.pamo2023.R
import android.widget.CompoundButton
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import android.os.Handler
import com.example.pamo2023.Main2Activity
import com.example.pamo2023.GraphActivity
import com.example.pamo2023.QuizActivity
import com.example.pamo2023.Questions
import android.widget.Toast
import com.example.pamo2023.ScoreActivity
import com.example.pamo2023.MainActivity

class StartActivity : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}