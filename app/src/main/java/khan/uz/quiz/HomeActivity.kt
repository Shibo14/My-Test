package khan.uz.quiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    var scoreCount = 0
    private lateinit var score: TextView
    private lateinit var game: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        score = findViewById(R.id.score)
        game = findViewById(R.id.game)
        val sharedPreferences = getSharedPreferences("myShP", Context.MODE_PRIVATE)



        val n = intent.getIntExtra("score", 0)
        var s = scoreCount+n
        val editor = sharedPreferences.edit()
        editor.putInt("scores", s)


        val savedInt = sharedPreferences.getInt("scores", 0)
        editor.apply()
        score.text = savedInt.toString()


        game.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }

}