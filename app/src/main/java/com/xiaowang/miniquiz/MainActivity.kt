package com.xiaowang.miniquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonQuiz.setOnClickListener {
            val intentQuiz = Intent(this, Questions::class.java)
            startActivity(intentQuiz)
            finish()
        }

        buttonFlashCard.setOnClickListener {
            Toast.makeText(this, "在做了", Toast.LENGTH_SHORT).show()
        }
    }
}