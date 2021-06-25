package com.xiaowang.miniquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_show_correct_answer.*

class ShowCorrectHint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_correct_hint)

        textViewAnswerCard.text = intent.getStringExtra("answer_text")

        buttonContinue.setOnClickListener {
            val intentBackToQuiz = Intent(this, Questions::class.java)
            startActivity(intentBackToQuiz)
            finish()
        }

    }
}