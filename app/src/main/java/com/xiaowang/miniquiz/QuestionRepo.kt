package com.xiaowang.miniquiz

data class QuestionRepo(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswers: String

) {
}