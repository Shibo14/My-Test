package khan.uz.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val radios: ArrayList<RadioButton> = ArrayList()
    private val variants: ArrayList<TextView> = ArrayList()
    private lateinit var btnNext: Button
    private lateinit var btnSkip: Button
    private lateinit var question: TextView
    private lateinit var textCount1: TextView
    private lateinit var textCount2: TextView

    private var count = 0
    private val controller: Controller = Controller()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initViews()

        loadData()
    }

    private fun initViews() {

        btnNext = findViewById(R.id.next)
        btnSkip = findViewById(R.id.skip)

        question = findViewById(R.id.question)
        textCount1 = findViewById(R.id.textAns)
        textCount2 = findViewById(R.id.countAns)

        radios.add(findViewById(R.id.radioButton1))
        radios.add(findViewById(R.id.radioButton2))
        radios.add(findViewById(R.id.radioButton3))
        radios.add(findViewById(R.id.radioButton4))

        variants.add(findViewById(R.id.textView1))
        variants.add(findViewById(R.id.textView2))
        variants.add(findViewById(R.id.textView3))
        variants.add(findViewById(R.id.textView4))

        setClickEvent()
    }

    private fun loadData() {
        val position = intent.getIntExtra("position", 0)
        when (position) {
            0 -> {
                funMathematics()
            }
            1 -> {
                funHistory()
            }

        }
    }

    private fun funHistory() {
        controller.shuffle()
        controller.history()
        showTestData(controller.getNextQuestion())
    }

    private fun funMathematics() {
        controller.shuffle()
        controller.mathematics()
        showTestData(controller.getNextQuestion())

    }

    private fun setClickEvent() {
        radios.forEach { radio ->
            radio.setOnClickListener {
                clearActions()
                radio.isChecked = true
                btnNext.isEnabled = true
            }
        }
        btnNext.setOnClickListener {
            val radio = radios.find { it.isChecked }
            val position = radios.indexOf(radio)
            if (position == -1) return@setOnClickListener

            controller.check(variants[position].text.toString())
            showTestData(controller.getNextQuestion())

        }
        btnSkip.setOnClickListener {
            controller.increaseTestPosition()
            showTestData(controller.getNextQuestion())

        }
    }

    private fun showTestData(testData: TestData) {

        if (count <= 2) {
            clearActions()
            count++
            question.text = testData.question
            variants[0].text = testData.variant1
            variants[1].text = testData.variant2
            variants[2].text = testData.variant3
            variants[3].text = testData.variant4
            textCount1.text = "$count / 10"
            textCount2.text = "$count question"
        } else {
            val i = Intent(this, ResultActivity::class.java)
            i.putExtra("count", controller.correctCount)
            startActivity(i)
            finish()
        }


    }


    private fun clearActions() {
        clearRadios()
        btnNext.isEnabled = false
    }


    private fun clearRadios() {
        for (radio in radios) {
            radio.isChecked = false
        }

    }
}