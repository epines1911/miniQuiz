package com.xiaowang.miniquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_show_correct_answer.*

class ShowCorrectAnswer : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_correct_answer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonContinue.setOnClickListener {
            fragmentManager?.popBackStack();
        }

//        textViewAnswerCard.text = currentQuestion.question
    }

    companion object {
        fun newInstance() : ShowCorrectAnswer {
            return ShowCorrectAnswer()
        }
    }
}