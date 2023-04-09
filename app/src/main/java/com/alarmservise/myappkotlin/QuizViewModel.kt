package com.alarmservise.myappkotlin

import android.util.Log
import androidx.lifecycle.ViewModel

const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {

    var currentIndex = 0

    private val questionBank = listOf(
        Qutstion(R.string.question_australia, true),
        Qutstion(R.string.question_oceans, true),
        Qutstion(R.string.question_mideast, false),
        Qutstion(R.string.question_africa, false),
        Qutstion(R.string.question_americas, true),
        Qutstion(R.string.question_asia, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToText(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun movePrevToText(){
        if (currentIndex > 0) {
        currentIndex = (currentIndex - 1 ) % questionBank.size
    } else
        currentIndex = 0
    }


}