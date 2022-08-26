package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counterA: Int = 0
    private var counterB: Int = 0
    private var statA = mutableListOf(0, 0, 0)
    private var statB = mutableListOf(0, 0, 0)

    private lateinit var counter_a: TextView
    private lateinit var counter_b: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter_a = findViewById<TextView>(R.id.counter_A)
        counter_b = findViewById<TextView>(R.id.counter_B)
        val three_point_A = findViewById<Button>(R.id.threePointA)
        val two_point_A = findViewById<Button>(R.id.twoPointA)
        val free_point_A = findViewById<Button>(R.id.freePointA)
        val three_point_B = findViewById<Button>(R.id.threePointB)
        val two_point_B = findViewById<Button>(R.id.twoPointB)
        val free_point_B = findViewById<Button>(R.id.freePointB)
        val end = findViewById<Button>(R.id.End)
        val statistics = findViewById<Button>(R.id.statistics)

        three_point_A.setOnClickListener {
            addPointsA(3, 0)

        }

        two_point_A.setOnClickListener {
            addPointsA(2, 1)
        }
        free_point_A.setOnClickListener {
            addPointsA(1, 2)

        }

        three_point_B.setOnClickListener {
            addPointsB(3, 0)

        }

        two_point_B.setOnClickListener {
            addPointsB(2, 1)

        }
        free_point_B.setOnClickListener {
            addPointsB(1, 2)
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

    private fun addPointsA(point: Int, pointType: Int) {
        counterA += point
        statA[pointType]++
        counter_a.text = counterA.toString()
    }

    private fun addPointsB(point: Int, pointType: Int) {
        counterB += point
        statB[pointType]++
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