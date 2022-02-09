package com.not.drunk

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.not.drunk.entity.Question
import kotlinx.coroutines.coroutineScope

class JSONHelper {
    companion object {
        suspend fun getQuestions() = coroutineScope {
            val questionJsonArray = QUESTION_JSON
            /*https://medium.com/@hissain.khan/parsing-with-google-gson-library-in-android-kotlin-7920e26f5520#:~:text=%20Parsing%20between%20JSON%20and%20Kotlin%20Object%20with,nested%20hierarchy%20while%20parsing.%20Sometime%20you...%20More%20*/
            val sType = object : TypeToken<List<Question>>() { }.type
            Gson().fromJson<MutableList<Question>>(questionJsonArray, sType)
        }
    }

}