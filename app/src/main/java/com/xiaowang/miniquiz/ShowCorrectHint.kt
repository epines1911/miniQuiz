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
            val intentBack = Intent()
//            intentBack.putExtra("data_return", "NEXT")
            setResult(2, intentBack)
            finish()
            // 太傻了，我想点击这个continue按钮就直接下一题，而不是回到题目页再点“下一题”
        }
    }
}