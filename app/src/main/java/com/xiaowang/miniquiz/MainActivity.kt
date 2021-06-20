package com.xiaowang.miniquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.QuoteSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val buttonQuiz: Button = findViewById(R.id.buttonQuiz)
    private val editTextName: EditText = findViewById(R.id.editTextName)
    private val buttonFlashCard: Button = findViewById(R.id.buttonFlashCard)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        buttonQuiz.setOnClickListener {
            if (editTextName.text.isEmpty()){
                Toast.makeText(this, "请输入一个昵称", Toast.LENGTH_SHORT).show()
            }else{
                val intentQuiz = Intent(this, Questions::class.java)
                startActivity(intentQuiz)
                finish()
            }
        }

        buttonFlashCard.setOnClickListener {
            Toast.makeText(this, "在做了", Toast.LENGTH_SHORT).show()
        }
    }
}