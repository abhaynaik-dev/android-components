package com.not.drunk.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.*
import com.not.drunk.*
import com.not.drunk.entity.Question
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random


class NODViewModel : ViewModel() {

    val screenNavigationObserver = MutableLiveData<Event<String>>()

    private var timer: CountDownTimer? = null
    private var quoteIndex: Int = 0

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentQuestionCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentQuestionCount

    private val _questionTimer = MutableLiveData(0)
    val questionTimer: LiveData<Int>
        get() = _questionTimer

    private val _currentQuestion = MutableLiveData<String>()
    val currentQuestion: LiveData<String>
        get() = _currentQuestion

    private val _buttonLabel = MutableLiveData<String>()
    val buttonLabel: LiveData<String>
        get() = _buttonLabel

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    private val _quote = MutableLiveData<String> ()
    val quote: LiveData<String>
        get() = _quote

    private val _inputType = MutableLiveData<Int> ()
    val inputType: LiveData<Int>
        get() = _inputType

    //MCQ Answers
    private val _answerA = MutableLiveData<String> ()
    val answerA: LiveData<String>
        get() = _answerA

    private val _answerB = MutableLiveData<String> ()
    val answerB: LiveData<String>
        get() = _answerB

    private val _answerC = MutableLiveData<String> ()
    val answerC: LiveData<String>
        get() = _answerC

    private val _answerD = MutableLiveData<String> ()
    val answerD: LiveData<String>
        get() = _answerD

    var playerAnswer = MutableLiveData<String>()

    // List of words used in the game
    private var questionList: MutableList<Question> = mutableListOf()
    private lateinit var correctAnswer: String

    init {
        updateQuoteValue()
        getPlayerQuestions()
    }

    //Methods exposed to UI level classes
    fun getIDOfNextScreen(questionType: String) = run {
        //val questionObj = questionList[currentWordCount.value!!]
        when (questionType) {
            QUESTION_TYPE_MCQ -> R.id.mcq_question
            QUESTION_TYPE_SUBJECTIVE -> R.id.subjective_question
            SHOW_RESULT_SCREEN -> R.id.result_screen
            SHOW_SPLASH_SCREEN -> R.id.reset_game
            else -> R.id.reset_game
        }
    }

    fun getNextQuestion(){
        //resetting question artifacts before showing to user
        timer?.cancel()
        _questionTimer.value = 0
        playerAnswer.value = ""
        if (currentWordCount.value?.equals(MAX_NO_OF_QUESTIONS) != true){
            updateQuoteValue()
            updateNextQuestion()
        }else if (currentWordCount.value?.equals(MAX_NO_OF_QUESTIONS) == true) {
            updateQuoteValue()
            showResult()
        }
    }

    fun resetScore(){
        timer?.cancel()
        _score.value = 0
        _currentQuestionCount.value = 0
        _questionTimer.value = 0
        _currentQuestion.value = ""
        _buttonLabel.value = ""
        screenNavigationObserver.value = Event(SHOW_SPLASH_SCREEN)
    }

    fun checkPlayerAnswer(){
        //Check the correct answer and player answer
        val playerAnswer = playerAnswer.value.toString().uppercase(Locale.getDefault())
        if ( correctAnswer.uppercase(Locale.getDefault()).equals(playerAnswer) ) {
            _score.value= _score.value?.plus(SCORE_INCREASE)
        }
        getNextQuestion()
    }

    private fun startTimer(time: Long){
        timer = object : CountDownTimer(time, TIME_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                val counter = millisUntilFinished.div(TIME_INTERVAL).toInt()
                _questionTimer.value = counter
            }

            override fun onFinish() {
                _questionTimer.value = 0
                getNextQuestion()
            }
        }.start()
    }


    private fun getPlayerQuestions(){
        viewModelScope.launch {
            questionList = JSONHelper.getQuestions()
            questionList.shuffle()
        }
    }

    private fun updateNextQuestion(){
        val question = questionList[currentWordCount.value!!]

        screenNavigationObserver.value = Event(question.QuestionType)

        _currentQuestion.value = question.Question
        _buttonLabel.value = when (currentWordCount.value) {
            MAX_NO_OF_QUESTIONS.dec() -> BUTTON_LABEL_SUBMIT
            else -> BUTTON_LABEL_NEXT
        }

        //assigning mcq options
        if(question.QuestionType.equals(QUESTION_TYPE_MCQ)){
            _answerA.value = question.MCQOptionA
            _answerB.value = question.MCQOptionB
            _answerC.value = question.MCQOptionC
            _answerD.value = question.MCQOptionD
        }else {
            _inputType.value = question.InputType
        }

        startTimer(question.QuestionTimer)
        _currentQuestionCount.value = _currentQuestionCount.value?.inc()

        correctAnswer = question.Answer
    }

    private fun showResult(){

        var result : Double?  = (_score.value?.toDouble()?.div(SCORE_INCREASE.times(MAX_NO_OF_QUESTIONS)))?.toDouble()
        result = kotlin.math.ceil(result!!)

        //Taken from documentation
        /*Compares this value with the specified value for order.
        Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
        or a positive number if it's greater than other.*/
        val isResultAboveThreshold = result.compareTo(RESULT_THRESHOLD) == -1

        _result.value = when (isResultAboveThreshold){
            true -> RESULT_MESSAGE_ABOVE_OR_EQUAL_THRESHOLD // Could not score above threshold, player is drunk
            false -> RESULT_MESSAGE_BELOW_THRESHOLD
        }

        screenNavigationObserver.value = Event(SHOW_RESULT_SCREEN)
    }

    private fun updateQuoteValue(){
        val tempIndex = Random.nextInt(0, QUOTES_LIST.size.dec())
        if (!quoteIndex.equals(tempIndex)){
            updateQuoteValue()
        }
        quoteIndex = tempIndex
        _quote.value = QUOTES_LIST.get(quoteIndex)
    }

}