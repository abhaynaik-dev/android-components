package com.not.drunk.entity

data class Question(
    var Question : String,
    var QuestionType : String,
    var Answer : String,
    var QuestionTimer : Long,
    var MCQOptionA : String,
    var MCQOptionB : String,
    var MCQOptionC : String,
    var MCQOptionD : String,
    var InputType : Int = 2
)
