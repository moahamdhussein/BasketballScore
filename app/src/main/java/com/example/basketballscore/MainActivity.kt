package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counterA: Int = 0
    var counterB: Int = 0
    var statA = mutableListOf(0, 0, 0)
    var statB = mutableListOf(0, 0, 0)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counter_a = findViewById<TextView>(R.id.counter_A)
        val counter_b = findViewById<TextView>(R.id.counter_B)
        val three_point_A = findViewById<Button>(R.id.threePointA)
        val two_point_A = findViewById<Button>(R.id.twoPointA)
        val free_point_A = findViewById<Button>(R.id.freePointA)
        val three_point_B = findViewById<Button>(R.id.threePointB)
        val two_point_B = findViewById<Button>(R.id.twoPointB)
        val free_point_B = findViewById<Button>(R.id.freePointB)
        val end = findViewById<Button>(R.id.End)
        val statistics = findViewById<Button>(R.id.statistics)

        three_point_A.setOnClickListener {
            counterA += 3
            statA[0]++
            counter_a.text = counterA.toString()

        }

        two_point_A.setOnClickListener {
            counterA += 2
            statA[1]++
            counter_a.text = counterA.toString()
        }
        free_point_A.setOnClickListener {
            counterA++
            statA[2]++
            counter_a.text = counterA.toString()

        }

        three_point_B.setOnClickListener {
            counterB += 3
            statB[0]++
            counter_b.text = counterB.toString()

        }

        two_point_B.setOnClickListener {
            counterB += 2
            statB[1]++
            counter_b.text = counterB.toString()

        }
        free_point_B.setOnClickListener {
            counterB++
            statB[2]++
            counter_b.text = counterB.toString()
        }

        statistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            secondScreen("stat", intent)


        }
        end.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            secondScreen("end", intent)

        }

    }

    override fun onResume() {
        super.onResume()
        val counter_a = findViewById<TextView>(R.id.counter_A)
        val counter_b = findViewById<TextView>(R.id.counter_B)
        counter_a.text = counterA.toString()
        counter_b.text = counterB.toString()

    }

    private fun secondScreen(type: String, intent: Intent) {
        if (type == "end") {
            winner(intent)
            start(intent)
            counterA = 0
            counterB = 0
            statA = mutableListOf<Int>(0, 0, 0)
            statB = mutableListOf<Int>(0, 0, 0)
        } else if (type == "stat") {
            start(intent)
        }
    }

    private fun start(intent: Intent) {
        intent.putExtra("threeA", statA[0])
        intent.putExtra("twoA", statA[1])
        intent.putExtra("freeA", statA[2])
        intent.putExtra("threeB", statB[0])
        intent.putExtra("twoB", statB[1])
        intent.putExtra("freeB", statB[2])
        startActivity(intent)
    }

    private fun winner(intent: Intent) {
        if (counterA > counterB) {
            intent.putExtra("win", 1)
        } else {
            intent.putExtra("win", 2)

        }
    }
}