package com.xiaowang.miniquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_qustions.*

class Questions : AppCompatActivity() {

    // TODO: 2021/6/23 define the max value of progressBar
    // TODO: 2021/6/23 change border color of answer1,2,3 and 4

    private var mCurrentPosition = 1
    private var mQuestionsList: ArrayList<QuestionRepo>? = null
    private var mSelectedOptionPosition = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qustions)

        //为啥要在这getQuestion，这行为啥不能写在fun里？
        mQuestionsList = Constants.getQuestions()

        setQuestion()





    }

    private fun setQuestion(){
        val currentQuestion = mQuestionsList!![mCurrentPosition-1]

        progressBar.progress = mCurrentPosition
        textViewQueText.text = currentQuestion.question
        textViewAnswer1.text = currentQuestion.answers[0]
        textViewAnswer2.text = currentQuestion.answers[1]
        textViewAnswer3.text = currentQuestion.answers[2]
        textViewAnswer4.text = currentQuestion.answers[3]
    }

    private fun setDefaultForm(){
        textViewAnswer1.setTextColor()
        textViewAnswer2.setTextColor()
        textViewAnswer3.setTextColor()
        textViewAnswer4.setTextColor()
    }
}