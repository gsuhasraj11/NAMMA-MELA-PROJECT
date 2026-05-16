package com.example.nammamela

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var selectedSeatsText: TextView
    private lateinit var confirmBtn: Button
    private lateinit var castBtn: Button

    private val seatList = mutableListOf<Seat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        selectedSeatsText = findViewById(R.id.selectedSeatsText)
        confirmBtn = findViewById(R.id.confirmBtn)
        castBtn = findViewById(R.id.castBtn)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("BOOKED_SEATS", MODE_PRIVATE)

        for (i in 1..30) {

            val isBooked =
                sharedPreferences.getBoolean(i.toString(), false)

            seatList.add(
                Seat(
                    number = i,
                    isBooked = isBooked,
                    isSelected = false
                )
            )
        }

        recyclerView.layoutManager =
            GridLayoutManager(this, 4)

        val adapter = SeatAdapter(
            seatList
        ) {

            val selectedCount =
                seatList.count {
                    it.isSelected && !it.isBooked
                }

            selectedSeatsText.text =
                "Selected Seats: $selectedCount"
        }

        recyclerView.adapter = adapter

        confirmBtn.setOnClickListener {

            val selectedSeats =
                seatList.filter {
                    it.isSelected && !it.isBooked
                }

            if (selectedSeats.isEmpty()) {

                selectedSeatsText.text =
                    "Please select seats"

                return@setOnClickListener
            }

            val editor = sharedPreferences.edit()

            for (seat in selectedSeats) {

                editor.putBoolean(
                    seat.number.toString(),
                    true
                )

                seat.isBooked = true
                seat.isSelected = false
            }

            editor.apply()

            startActivity(
                Intent(
                    this,
                    BookingSuccessActivity::class.java
                )
            )
        }

        castBtn.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CastActivity::class.java
                )
            )
        }
    }
}