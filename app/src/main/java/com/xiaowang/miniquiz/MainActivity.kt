package com.xiaowang.miniquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xiaowang.miniquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonQuiz.setOnClickListener {
            val intentQuiz = Intent(this, Questions::class.java)
            startActivity(intentQuiz)
            finish()
        }

        binding.buttonFlashCard.setOnClickListener {
            Toast.makeText(this, "Sorry, it hasn't been finished :)", Toast.LENGTH_SHORT).show()
        }
    }
}