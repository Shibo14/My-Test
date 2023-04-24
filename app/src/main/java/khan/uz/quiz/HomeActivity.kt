package khan.uz.quiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import khan.uz.quiz.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var scoreCount = 0
    private lateinit var score: TextView
    private lateinit var history: CardView
    private lateinit var mathematics: CardView
    private lateinit var game: Button
    private lateinit var sharedPreferences: SharedPreferences
    private var n: Int = 0
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        sharedPreferences = getSharedPreferences("myShP", MODE_PRIVATE)
        score = findViewById(R.id.score)
        history = findViewById(R.id.history)
        mathematics = findViewById(R.id.mathematics)
        progressBar = findViewById(R.id.progressBar)
        progressBar.max = 999
        n = intent.getIntExtra("score", 0)


        mathematics.setOnClickListener { openInfo(0) }
        history.setOnClickListener { openInfo(1) }

        // Raqam o'qish
        val savedInt = sharedPreferences.getInt("key_int", 0)

        // Raqamga boshqa raqam qo'shish

        val newInt = savedInt + n

        // Raqamni saqlash
        val editor = sharedPreferences.edit()
        editor.putInt("key_int", newInt)
        editor.apply()




        score.text = sharedPreferences.getInt("key_int", scoreCount).toString()
        progressBar.progress = newInt




    }

    private fun openInfo(position: Int) {
        val i = Intent(this, MainActivity::class.java)
        i.putExtra("position", position)
        startActivity(i)

    }

    override fun onStart() {

        super.onStart()
    }

}