package khan.uz.quiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    var score = 2
    private lateinit var scoreText: TextView
    private lateinit var resultBtn: Button
  //  private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        scoreText = findViewById(R.id.countResult)
        resultBtn = findViewById(R.id.resultBtn)
        //sharedPreferences = getSharedPreferences("myShP", Context.MODE_PRIVATE)

        val n = intent.getIntExtra("count", 0)
        scoreText.text = n.toString()




        resultBtn.setOnClickListener {

            val i = Intent(this, HomeActivity::class.java)

            i.putExtra("score", n)
            startActivity(i)
            finish()
        }


    }
}