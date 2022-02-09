package com.not.drunk

//QUESTION CONFIGURATION
const val MAX_NO_OF_QUESTIONS = 10
const val SCORE_INCREASE = 10
const val TIME_INTERVAL = 1000L
const val RESULT_THRESHOLD = 0.8
const val QUESTION_BATCH = 10

//SCREEN NAMES
const val QUESTION_TYPE_SUBJECTIVE = "SUBJECTIVE"
const val QUESTION_TYPE_MCQ = "MCQ"
const val SHOW_RESULT_SCREEN = "Result"
const val SHOW_SPLASH_SCREEN = "Splash_Screen"

//BUTTON LABELS
const val BUTTON_LABEL_NEXT = "Next"
const val BUTTON_LABEL_SUBMIT = "Submit"

//MCQ ANSWERS
const val MCQ_ANSWER_A = "A"
const val MCQ_ANSWER_B = "B"
const val MCQ_ANSWER_C = "C"
const val MCQ_ANSWER_D = "D"
const val MCQ_ANSWER_UNDEFINED = "UNDEFINED"

//RESULT SCREEN MESSAGE
const val RESULT_MESSAGE_ABOVE_OR_EQUAL_THRESHOLD = "You are too much drunk\nStop drinking immediately, get a cab and go home\n DO NOT DRINK AND DRIVE"
const val RESULT_MESSAGE_BELOW_THRESHOLD = "You should stop drinking\nGet a cab and go home\nDO NOT DRINK AND DRIVE"

const val QUESTION_JSON = "[ { \"Question\": \"What is the square root of 64?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"8\", \"QuestionTimer\": \"9000\", \"InputType\": 2 }, { \"Question\": \"What is the square of 18?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"324\", \"QuestionTimer\": \"9000\", \"InputType\": 2 }, { \"Question\": \"'OS' computer abbreviation usually means ?\", \"QuestionType\": \"MCQ\", \"Answer\": \"C\", \"QuestionTimer\": \"4000\", \"MCQOptionA\": \"Order of Significance\", \"MCQOptionB\": \"Open Software\", \"MCQOptionC\": \"Operating System\", \"MCQOptionD\": \"Optical Sensor\" }, { \"Question\": \"Which is the longest river in world\", \"QuestionType\": \"MCQ\", \"Answer\": \"B\", \"QuestionTimer\": \"4000\", \"MCQOptionA\": \"Amazon\", \"MCQOptionB\": \"Nile\", \"MCQOptionC\": \"Thames\", \"MCQOptionD\": \"Mula-Mutha\" }, { \"Question\": \"How many states does India have?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"29\", \"QuestionTimer\": \"9000\", \"InputType\": 2 }, { \"Question\": \"How many players are there in an Cricket?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"11\", \"QuestionTimer\": \"9000\", \"InputType\": 2 }, { \"Question\": \"Unscramble the word \\n effushl?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"SHUFFLE\", \"QuestionTimer\": \"9000\", \"InputType\": 1 }, { \"Question\": \"how many letters are in english alphabet?\", \"QuestionType\": \"SUBJECTIVE\", \"Answer\": \"26\", \"QuestionTimer\": \"9000\", \"InputType\": 2 }, { \"Question\": \"Light year is a unit of\", \"QuestionType\": \"MCQ\", \"Answer\": \"B\", \"QuestionTimer\": \"4000\", \"MCQOptionA\": \"Time\", \"MCQOptionB\": \"Distance\", \"MCQOptionC\": \"Light\", \"MCQOptionD\": \"Intensity of light\" }, { \"Question\": \"Which of the following is not MARVEL movie\", \"QuestionType\": \"MCQ\", \"Answer\": \"C\", \"QuestionTimer\": \"4000\", \"MCQOptionA\": \"AVENGERES\", \"MCQOptionB\": \"ANTMAN\", \"MCQOptionC\": \"BATMAN\", \"MCQOptionD\": \"IRONMAN\" } ]"
val QUOTES_LIST: List<String> =
    listOf("A drunk driver is very dangerous. So is a drunk backseat driver if he’s persuasiv – Demetri Martin",
        "Each drink you have before driving impairs your judgment, don’t drink and drive",
        "If you drink don’t drive. Don’t even putt.– Dean Martin",
        "Drunk driving is a killer disease ",
        "Drinking and driving: there are stupider things, but it’s a very short list ",
        "Alcohol is a make-you-stupid drug.– Beverly A. Potter",
        "Drinking and driving can destroy lives and families.–Valerie Mendrall",
        "Don’t drink and drive – stay alive ",
        "A woman drove me to drink. I don’t drink and drive.– Brian Spellman",
        "The one for the road may be two for the cemetery – Evan Esar",
        "I drive better when I am drunk because I do back seat driving.– Amit Abraham",
        "Baseball is like driving, it’s the one who gets home safely that count" ,
        "Drinking and driving is a gamble that you just can’t win ",
        "He that drinks fast, pays slow – Benjamin Franklin",
        "The best car safety device is a rear-view mirror with a cop in it.– Dudley Moore",
        "Drinking and driving kills someone every 48 minutes, don’t be a murderer ",
        "Their alcohol consumption levels haven’t dropped much, but their drunk driving has– James Lange",
        "A woman drove me to drink and I didn’t even have the decency to thank her.–W. C. Fields",
        "Allow life to thrive, don’t drink and drive ",
        "Alcohol may be man’s worst enemy, but the bible says love your enemy – Frank Sinatra",
        "Most of those who are driven to drink, make the trip in the driver’s seat.–Evan Esar",
        "Sober driving today. Alive tomorrow ",
        "People who insist on drinking before driving are putting the quart before the hearse.–Evan Esar",
        "Many a man who is drunk prefers to drive because he feels he is in no condition to walk.–Evan Esar",
        "I didn’t start MADD to deal with alcohol. I started MADD to deal with the issue of drunk driving.– Candy Lightner",
        "If you drink and drive, sooner or later, you’re gonna meet the Undertaker.– Vince McMahon",
        "I understand the severity of what I did and I take full responsibility for my actions – Tiger Woods")