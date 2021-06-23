package com.xiaowang.miniquiz

object Constants{
    fun getQuestions(): ArrayList<QuestionRepo>{
        val questionList = ArrayList<QuestionRepo>()

        val que1 = QuestionRepo(1, "cccc", listOf("aaa","ddd","eee","fff"), "bbb")
        questionList.add(que1)

        val que2 = QuestionRepo(2, "ccc2", listOf("aa2","dd2"), "bb2")
        questionList.add(que2)

        return questionList
    }
}