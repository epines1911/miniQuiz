package com.xiaowang.miniquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xiaowang.miniquiz.databinding.FragmentShowCorrectAnswerBinding

class ShowCorrectAnswer : Fragment() {
    private var _binding: FragmentShowCorrectAnswerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowCorrectAnswerBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_show_correct_answer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.buttonContinue.setOnClickListener {
            fragmentManager?.popBackStack()
        }

//        textViewAnswerCard.text = currentQuestion.question
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() : ShowCorrectAnswer {
            return ShowCorrectAnswer()
        }
    }
}