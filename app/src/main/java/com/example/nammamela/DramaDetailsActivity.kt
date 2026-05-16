package com.example.nammamela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DramaDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_drama_details)

        val posterImage =
            findViewById<ImageView>(R.id.posterImage)

        val titleText =
            findViewById<TextView>(R.id.detailsTitle)

        val timeText =
            findViewById<TextView>(R.id.detailsTime)

        val venueText =
            findViewById<TextView>(R.id.detailsVenue)

        val descriptionText =
            findViewById<TextView>(R.id.detailsDescription)

        val castText =
            findViewById<TextView>(R.id.castText)

        val bookBtn =
            findViewById<Button>(R.id.bookTicketsBtn)

        val castBtn =
            findViewById<Button>(R.id.castBtn)

        val showName =
            intent.getStringExtra("SHOW_NAME")

        val showTime =
            intent.getStringExtra("SHOW_TIME")

        val showVenue =
            intent.getStringExtra("SHOW_VENUE")

        titleText.text = showName

        timeText.text =
            "Time: $showTime"

        venueText.text =
            "Venue: $showVenue"

        descriptionText.text =
            "Experience a grand live village drama performance filled with action, emotion, music and culture."

        castText.text =
            "Lead Actor: Ravi Kumar"

        if (showName == "Kantara Nataka") {

            posterImage.setImageResource(
                R.drawable.poster1
            )

        } else if (showName == "Veera Simha Drama") {

            posterImage.setImageResource(
                R.drawable.poster2
            )

        } else {

            posterImage.setImageResource(
                R.drawable.poster3
            )
        }

        castBtn.setOnClickListener {

            val intent =
                Intent(this, CastActivity::class.java)

            startActivity(intent)
        }

        bookBtn.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            intent.putExtra(
                "SHOW_NAME",
                showName
            )

            intent.putExtra(
                "SHOW_TIME",
                showTime
            )

            startActivity(intent)
        }
    }
}