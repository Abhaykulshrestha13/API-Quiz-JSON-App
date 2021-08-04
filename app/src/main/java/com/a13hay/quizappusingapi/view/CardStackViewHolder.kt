package com.a13hay.quizappusingapi.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a13hay.quizappusingapi.R

class CardStackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvQuestion:TextView = itemView.findViewById(R.id.tv_question)
    var trueButton:ImageView = itemView.findViewById(R.id.true_button)
    var falseButton:ImageView = itemView.findViewById(R.id.false_button)
    var score:TextView = itemView.findViewById(R.id.score)
}