package com.xiaowang.miniquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qustions)

        val questionList = Constants.getQuestions()
    }
}