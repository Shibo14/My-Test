package khan.uz.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    var score = 0
    private lateinit var scoreText: TextView
    private lateinit var resultBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        scoreText = findViewById(R.id.countResult)
        resultBtn = findViewById(R.id.resultBtn)
        val n = intent.getIntExtra("count", 0)

        scoreText.text = n.toString()
       val s = score+n

        resultBtn.setOnClickListener {

            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("score", s)
            startActivity(i)
            finish()
        }


    }
}