package com.xiaowang.miniquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_qustions.*

class Questions : AppCompatActivity() {

    // TODO: 2021/6/23 define the max value of progressBar

    var mCurrentPosition = 1
    var mQuestionsList: ArrayList<QuestionRepo>? = null
    private var mSelectedOptionPosition = 0

//    var currentQuestion = mQuestionsList!![mCurrentPosition-1]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qustions)

        //为啥要在这getQuestion，这行为啥不能写在fun里？
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        val currentQuestion = mQuestionsList!![mCurrentPosition-1]

        textViewAnswer1.setOnClickListener {
            if (textViewAnswer1.text == currentQuestion.correctAnswer){
                setRightForm(textViewAnswer1)
            }else{
                setWrongForm(textViewAnswer1)

                showCorrectAnswer()

//                val showCorrectAnswer = ShowCorrectAnswer.newInstance()
//                this.supportFragmentManager.beginTransaction().apply {
//                    add(this@Questions.taskId, showCorrectAnswer)
//                    this.addToBackStack(null)
//                    commit()
//                }
            }
        }

        buttonNext.setOnClickListener {
            if ( mCurrentPosition >= mQuestionsList!!.size) {
                val intentFinish = Intent(this, Finish::class.java)
                startActivity(intentFinish)
                finish()
            } else {
                mCurrentPosition++
                setDefaultForm()
                setQuestion()
            }
        }




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
        textViewAnswer1.setTextColor(Color.parseColor("#FF3700B3"))
        textViewAnswer2.setTextColor(Color.parseColor("#FF3700B3"))
        textViewAnswer3.setTextColor(Color.parseColor("#FF3700B3"))
        textViewAnswer4.setTextColor(Color.parseColor("#FF3700B3"))

        textViewAnswer1.setBackgroundColor(Color.WHITE)
        textViewAnswer2.setBackgroundColor(Color.WHITE)
        textViewAnswer3.setBackgroundColor(Color.WHITE)
        textViewAnswer4.setBackgroundColor(Color.WHITE)
    }

    private fun setRightForm(tv:TextView){
        tv.setTextColor(Color.WHITE)
        tv.setBackgroundColor(Color.parseColor("#FF018786"))
    }

    private fun setWrongForm(tv:TextView){
        tv.setTextColor(Color.WHITE)
        tv.setBackgroundColor(Color.parseColor("#FFFF9966"))
    }

    private fun showCorrectAnswer(){
        val intentShowHint = Intent(this, ShowCorrectHint::class.java)
        val currentQuestion = mQuestionsList!![mCurrentPosition-1]
        val answerText = currentQuestion.question
        intentShowHint.putExtra("answer_text", answerText)
        startActivity(intentShowHint)
    }

    private fun showSmile(){
        TODO()//一个弹出的对话框一样的，提示做对了，参见Quizlet，可能大概得用fragment
    }
}