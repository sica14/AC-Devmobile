package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val rgQuestion1: RadioGroup = findViewById(R.id.rgQuestion1)
        val rgQuestion2: RadioGroup = findViewById(R.id.rgQuestion2)
        val rgQuestion3: RadioGroup = findViewById(R.id.rgQuestion3)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val answer1 = rgQuestion1.checkedRadioButtonId
            val answer2 = rgQuestion2.checkedRadioButtonId
            val answer3 = rgQuestion3.checkedRadioButtonId

            if (answer1 == R.id.rbQ1Option1) score += 1
            else if (answer1 == R.id.rbQ1Option2) score += 2
            else if (answer1 == R.id.rbQ1Option3) score += 3

            if (answer2 == R.id.rbQ2Option1) score += 1
            else if (answer2 == R.id.rbQ2Option2) score += 2
            else if (answer2 == R.id.rbQ2Option3) score += 3

            if (answer3 == R.id.rbQ3Option1) score += 1
            else if (answer3 == R.id.rbQ3Option2) score += 2
            else if (answer3 == R.id.rbQ3Option3) score += 3

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }
    }
}