package com.alarmservise.myappkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView


    private  val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)

        questionTextView = findViewById(R.id.question_text_view)



        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            quizViewModel.moveToText()
            updateQuestion()
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
            quizViewModel.moveToText()
            updateQuestion()
        }

        nextButton.setOnClickListener {
            quizViewModel.moveToText()
            updateQuestion()
        }
        prevButton.setOnClickListener {
            quizViewModel.movePrevToText()
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResIdb= if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResIdb, Toast.LENGTH_SHORT).show()
    }
}
