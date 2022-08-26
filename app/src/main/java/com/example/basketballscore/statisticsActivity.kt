package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        val counterThreeA = findViewById<TextView>(R.id.counterThreeA)
        val counterTwoA = findViewById<TextView>(R.id.counterTwoA)
        val counterFreeA = findViewById<TextView>(R.id.counterFreeA)

        val counterThreeB = findViewById<TextView>(R.id.counterThreeB)
        val counterTwoB = findViewById<TextView>(R.id.counterTwoB)
        val counterFreeB = findViewById<TextView>(R.id.counterFreeB)

        val winText = findViewById<TextView>(R.id.win)
        val back = findViewById<Button>(R.id.back)

        counterThreeA.text = intent.getIntExtra("threeA", 0).toString()
        counterTwoA.text = intent.getIntExtra("twoA", 0).toString()
        counterFreeA.text = intent.getIntExtra("freeA", 0).toString()
        counterThreeB.text = intent.getIntExtra("threeB", 0).toString()
        counterTwoB.text = intent.getIntExtra("twoB", 0).toString()
        counterFreeB.text = intent.getIntExtra("freeB", 0).toString()
        val check: Int = intent.getIntExtra("win", 0)
        if (check == 1) {
            winText.text = "Team A win"
        } else if (check == 2) {
            winText.text = "Team B win"
        } else {
            winText.text = " "
        }

        back.setOnClickListener {

            finish()
        }


    }
}