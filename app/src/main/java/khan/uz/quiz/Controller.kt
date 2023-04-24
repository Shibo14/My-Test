package khan.uz.quiz

import java.util.Collections

class Controller {

    private val myTest: ArrayList<TestData> = ArrayList()
    private var currentPosition = 0
    var correctCount:Int = 0
        private set
    var wrongCount = 0
        private set

    fun mathematics() {

        myTest.add(TestData("13 - 10 = ?", "5", "4", "HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type .", "1", "3"))
        myTest.add(TestData("10 + 13 = ?", "5", "23", "20", "10", "23"))
        myTest.add(TestData("6 / 6 = ?", "5", "7", "2", "1", "1"))

        myTest.add(TestData("1 * 10 = ?", "HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type Reset Input Type Button.", "7", "2", "10", "10"))

    }   fun history() {


        myTest.add(TestData("HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type Reset Input Type Button.\"", "?", "7", "2", "10", "10"))
        myTest.add(TestData("@ ?", "HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type Reset Input Type Button.", "7", "2", "10", "10"))
        myTest.add(TestData("1 * 10 = ?", "HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type Reset Input Type Button.", "7", "2", "10", "10"))
        myTest.add(TestData("=========", "5", "4", "HTML Input Types · Input Type Text · Input Type Password · Input Type Submit · Input Type .", "1", "3"))
        myTest.add(TestData("*****", "5", "23", "20", "10", "23"))

    }

    fun shuffle() = myTest.shuffle()
    fun getNextQuestion(): TestData = myTest[currentPosition]

    fun check(userAnswers: String) {
        val currentTest = myTest[currentPosition]
        if (userAnswers == currentTest.answers) correctCount++ else wrongCount++
        currentPosition++
    }


    fun increaseTestPosition() {
        wrongCount++
        currentPosition++
    }
}