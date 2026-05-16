package com.example.nammamela

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeatAdapter(
    private val seatList: List<Seat>,
    private val onSeatSelected: () -> Unit
) : RecyclerView.Adapter<SeatAdapter.SeatViewHolder>() {

    class SeatViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val seatText: TextView =
            view.findViewById(R.id.seatText)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeatViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_seat,
                parent,
                false
            )

        return SeatViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SeatViewHolder,
        position: Int
    ) {

        val seat = seatList[position]

        holder.seatText.text =
            seat.number.toString()

        if (seat.isBooked) {

            holder.itemView.setBackgroundColor(
                Color.RED
            )

            holder.itemView.isClickable = false

        } else {

            if (seat.isSelected) {

                holder.itemView.setBackgroundColor(
                    Color.YELLOW
                )

            } else {

                holder.itemView.setBackgroundColor(
                    Color.GREEN
                )
            }

            holder.itemView.setOnClickListener {

                seat.isSelected =
                    !seat.isSelected

                notifyItemChanged(position)

                onSeatSelected()
            }
        }
    }

    override fun getItemCount(): Int {
        return seatList.size
    }
}