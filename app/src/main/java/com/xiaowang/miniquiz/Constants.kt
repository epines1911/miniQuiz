package com.xiaowang.miniquiz

object Constants{
    fun getQuestions(): ArrayList<QuestionRepo>{
        val questionList = ArrayList<QuestionRepo>()

        val que1 = QuestionRepo(1, "execrate",
            listOf("流放","隔离","固执的","痛恨"),
            "痛恨")
        questionList.add(que1)

        val que2 = QuestionRepo(2, "obliterate",
            listOf("消除","支持","恶搞","使衰竭"),
            "消除")
        questionList.add(que2)

        val que3 = QuestionRepo(3, "burlesque",
            listOf("恶搞","理由","推测","贬低"),
            "恶搞")
        questionList.add(que3)

        val que4 = QuestionRepo(4, "paraphernalia",
            listOf("吹牛的人","生动有趣的","大量装备","非传统的"),
            "大量装备")
        questionList.add(que4)

        val que5 = QuestionRepo(5, "dense",
            listOf("避免正面回答","和谐一致的","粗制滥造的","难以理解的"),
            "难以理解的")
        questionList.add(que5)

        return questionList
    }
}