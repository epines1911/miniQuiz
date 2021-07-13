package com.xiaowang.miniquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaowang.miniquiz.databinding.ActivityShowCorrectHintBinding

class ShowCorrectHint : AppCompatActivity() {
    private lateinit var binding: ActivityShowCorrectHintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowCorrectHintBinding.inflate(layoutInflater)
//        val view = binding.root
        setContentView(binding.root)

        binding.textViewAnswerCard.text = intent.getStringExtra("answer_text")

        binding.buttonContinue.setOnClickListener {
            val intentBack = Intent()
//            intentBack.putExtra("data_return", "NEXT")
            setResult(2, intentBack)
            finish()
            // 太傻了，我想点击这个continue按钮就直接下一题，而不是回到题目页再点“下一题”
        }
    }
}