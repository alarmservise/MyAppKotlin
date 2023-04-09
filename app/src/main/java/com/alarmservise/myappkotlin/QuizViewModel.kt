package com.alarmservise.myappkotlin

import androidx.lifecycle.ViewModel

const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {

    var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
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