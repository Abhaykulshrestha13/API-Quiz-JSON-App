package com.a13hay.quizappusingapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a13hay.quizappusingapi.controller.CardStackAdaptor
import com.a13hay.quizappusingapi.model.QuizManager
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView

class MainActivity : AppCompatActivity() {
    lateinit var mQuizManager:QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mQuizManager = QuizManager(this)
        mQuizManager.getQuizQuestions(this)
        var quizQuestions:ArrayList<String> = ArrayList()
        quizQuestions.add("Abhay")
        quizQuestions.add("Yash")
    }
}