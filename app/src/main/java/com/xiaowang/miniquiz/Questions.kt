package com.xiaowang.miniquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView

class Questions : AppCompatActivity() {

//    private val progressBar: ProgressBar = findViewById(R.id.progressBar)
//    private val questionTextView: TextView = findViewById(R.id.textViewQueText)
//    private val answer1: TextView = findViewById(R.id.textViewAnswer1)
//    private val answer2: TextView = findViewById(R.id.textViewAnswer2)
//    private val answer3: TextView = findViewById(R.id.textViewAnswer3)
//    private val answer4: TextView = findViewById(R.id.textViewAnswer4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qustions)

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val questionTextView: TextView = findViewById(R.id.textViewQueText)
        val answer1: TextView = findViewById(R.id.textViewAnswer1)
        val answer2: TextView = findViewById(R.id.textViewAnswer2)
        val answer3: TextView = findViewById(R.id.textViewAnswer3)
        val answer4: TextView = findViewById(R.id.textViewAnswer4)

        val questionList = Constants.getQuestions()

        val currentPosition = 1
        val currentQuestion: QuestionRepo = questionList[currentPosition-1]
        progressBar.progress = currentPosition
        questionTextView.text = currentQuestion.question
        answer1.text = currentQuestion.answers[0]
        answer2.text = currentQuestion.answers[1]
        answer3.text = currentQuestion.answers[2]
        answer4.text = currentQuestion.answers[3]



    }
}