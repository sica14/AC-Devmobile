package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)

        val tvResult: TextView = findViewById(R.id.tvResult)
        val tvDescription: TextView = findViewById(R.id.tvDescription)
        val imgHero: ImageView = findViewById(R.id.imgHero)
        val btnShare: Button = findViewById(R.id.btnShare)
        val btnRestart: Button = findViewById(R.id.btnRestart)


        when {
            score <= 4 -> {
                tvResult.text = "Você é o Homem-Aranha!"
                tvDescription.text = "Ágil, inteligente e sempre pronto para ajudar."
                imgHero.setImageResource(R.drawable.homem_aranha)
            }
            score <= 6 -> {
                tvResult.text = "Você é o Homem de Ferro!"
                tvDescription.text = "Genial, tecnológico e com muito estilo."
                imgHero.setImageResource(R.drawable.homem_de_ferro)
            }
            else -> {
                tvResult.text = "Você é o Hulk!"
                tvDescription.text = "Forte, determinado e incrivelmente poderoso."
                imgHero.setImageResource(R.drawable.hulk)
            }
        }


        btnShare.setOnClickListener {
            val githubIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://github.com/sica14/AC-Devmobile")
            }
            startActivity(githubIntent)
        }

        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}