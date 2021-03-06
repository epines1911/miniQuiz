package com.xiaowang.miniquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.xiaowang.miniquiz.databinding.ActivityQustionsBinding
import java.util.*
import kotlin.collections.ArrayList

class Questions : AppCompatActivity() {

    var mCurrentPosition = 1
    var mQuestionsList: ArrayList<QuestionRepo>? = null
    private lateinit var binding:ActivityQustionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQustionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //为啥要在这getQuestion，这行为啥不能写在fun里？
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        val tvList = listOf<TextView>(
            binding.textViewAnswer1,
            binding.textViewAnswer2,
            binding.textViewAnswer3,
            binding.textViewAnswer4
        )

        for (tv in tvList) {
            tv.setOnClickListener {
                if ( tv.text == setQuestion().correctAnswer){
                    setRightForm(tv)
                    nextQuestion()
                }else{
                    setWrongForm(tv)
                    showCorrectAnswer()

//                *准备尝试使用fragment，没完成
//                val showCorrectAnswer = ShowCorrectAnswer.newInstance()
//                this.supportFragmentManager.beginTransaction().apply {
//                    add(this@Questions.taskId, showCorrectAnswer)
//                    this.addToBackStack(null)
//                    commit()
//                }
                }
            }
        }
    }

    private fun setQuestion(): QuestionRepo {
        val currentQuestion = mQuestionsList!![mCurrentPosition-1]
        binding.progressBar.progress = mCurrentPosition
        binding.textViewQueText.text = currentQuestion.question
        binding.textViewAnswer1.text = currentQuestion.answers[0]
        binding.textViewAnswer2.text = currentQuestion.answers[1]
        binding.textViewAnswer3.text = currentQuestion.answers[2]
        binding.textViewAnswer4.text = currentQuestion.answers[3]
        return currentQuestion
    }

    private fun setDefaultForm(){
        binding.textViewAnswer1.setTextColor(Color.parseColor("#8a000000"))
        binding.textViewAnswer2.setTextColor(Color.parseColor("#8a000000"))
        binding.textViewAnswer3.setTextColor(Color.parseColor("#8a000000"))
        binding.textViewAnswer4.setTextColor(Color.parseColor("#8a000000"))

        binding.textViewAnswer1.setBackgroundColor(Color.WHITE)
        binding.textViewAnswer2.setBackgroundColor(Color.WHITE)
        binding.textViewAnswer3.setBackgroundColor(Color.WHITE)
        binding.textViewAnswer4.setBackgroundColor(Color.WHITE)
    }

    private fun setRightForm(tv:TextView){
        tv.setTextColor(Color.WHITE)
        tv.setBackgroundColor(Color.parseColor("#FF7ADBE1"))
    }

    private fun setWrongForm(tv:TextView){
        tv.setTextColor(Color.WHITE)
        tv.setBackgroundColor(Color.parseColor("#FFFF9966"))
    }

    private fun showCorrectAnswer(){
        val intentShowHint = Intent(this, ShowCorrectHint::class.java)
        val currentQuestion = mQuestionsList!![mCurrentPosition-1]
        val answerText = currentQuestion.correctAnswer
        intentShowHint.putExtra("answer_text", answerText)
        startActivityForResult(intentShowHint, 1)
    }

    private fun nextQuestion(){
        if ( mCurrentPosition >= mQuestionsList!!.size) {
            val intentFinish = Intent(this@Questions, Finish::class.java)
            startActivity(intentFinish)
            finish()
        } else {
            mCurrentPosition++
            setDefaultForm()
            setQuestion()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 2) {
            nextQuestion()
        }
    }
}