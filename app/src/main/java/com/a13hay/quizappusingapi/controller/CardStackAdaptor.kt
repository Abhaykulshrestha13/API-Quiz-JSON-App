package com.a13hay.quizappusingapi.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.a13hay.quizappusingapi.R
import com.a13hay.quizappusingapi.model.QuizQuestion
import com.a13hay.quizappusingapi.view.CardStackViewHolder

class CardStackAdaptor(context:Context, questionName: ArrayList<QuizQuestion>) : RecyclerView.Adapter<CardStackViewHolder>() {
    var mContext:Context = context
    var mQuestionName: List<QuizQuestion> = questionName
     var mLayoutInflater:LayoutInflater = LayoutInflater.from(context)
    var finalScore = 0
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackViewHolder {
        var view:View = mLayoutInflater.inflate(R.layout.item_list,parent,false)
        return CardStackViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardStackViewHolder, position: Int) {
        holder.tvQuestion.text = mQuestionName[position].toString()
        holder.trueButton.setOnClickListener {
            Toast.makeText(mContext, "Tapped is true", Toast.LENGTH_SHORT).show()
            if (mQuestionName[position].trueAnswer) {
                Toast.makeText(mContext, "You have answered correctly", Toast.LENGTH_SHORT).show()
                finalScore += 10
                holder.score.text = finalScore.toString()
                holder.trueButton.isEnabled = false
            } else {
                Toast.makeText(mContext, "wrong,Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        holder.falseButton.setOnClickListener {
            Toast.makeText(mContext, "Tapped is false", Toast.LENGTH_SHORT).show()
            if (!mQuestionName[position].trueAnswer) {
                finalScore += 10
                holder.score.text = finalScore.toString()
                holder.trueButton.isEnabled = false
                Toast.makeText(mContext, "You have answered correctly", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(mContext, "wrong,Try Again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
       return mQuestionName.size
    }

}