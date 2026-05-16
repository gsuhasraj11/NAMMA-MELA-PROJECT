package com.example.nammamela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ShowListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_list)

        val show1Btn =
            findViewById<Button>(R.id.show1Btn)

        val show2Btn =
            findViewById<Button>(R.id.show2Btn)

        val show3Btn =
            findViewById<Button>(R.id.show3Btn)

        val fanWallBtn =
            findViewById<Button>(R.id.fanWallBtn)

        show1Btn.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            intent.putExtra("title", "Kantara Nataka")
            intent.putExtra("time", "7:00 PM")

            startActivity(intent)
        }

        show2Btn.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            intent.putExtra("title", "Veera Simha Drama")
            intent.putExtra("time", "8:30 PM")

            startActivity(intent)
        }

        show3Btn.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            intent.putExtra("title", "Mahabharata Live")
            intent.putExtra("time", "9:00 PM")

            startActivity(intent)
        }

        fanWallBtn.setOnClickListener {

            val intent =
                Intent(this, FanWallActivity::class.java)

            startActivity(intent)
        }
    }
}