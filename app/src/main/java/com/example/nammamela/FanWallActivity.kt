package com.example.nammamela

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FanWallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fan_wall)

        val reviewInput =
            findViewById<EditText>(R.id.reviewEditText)

        val postBtn =
            findViewById<Button>(R.id.postReviewBtn)

        val reviewList =
            findViewById<ListView>(R.id.reviewListView)

        val fanMessages = mutableListOf(

            "Ramesh: Amazing performance 🔥",

            "Suhas: Background music was awesome!",

            "Kiran: Best village drama experience ❤️"
        )

        val adapter = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            fanMessages
        ) {

            override fun getView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {

                val view =
                    super.getView(
                        position,
                        convertView,
                        parent
                    )

                val text =
                    view.findViewById<TextView>(
                        android.R.id.text1
                    )

                text.setTextColor(Color.WHITE)

                text.textSize = 18f

                return view
            }
        }

        reviewList.adapter = adapter

        reviewList.setBackgroundColor(Color.BLACK)

        postBtn.setOnClickListener {

            val newReview =
                reviewInput.text.toString()

            if (newReview.isNotEmpty()) {

                fanMessages.add(
                    "Fan: $newReview"
                )

                adapter.notifyDataSetChanged()

                reviewInput.text.clear()
            }
        }
    }
}