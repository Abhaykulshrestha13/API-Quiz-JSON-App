package com.a13hay.quizappusingapi.model

import android.app.Activity
import android.content.Context
import android.util.Log
import com.a13hay.quizappusingapi.R
import com.a13hay.quizappusingapi.controller.CardStackAdaptor
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.company.myapplication.VolleySingleton
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class QuizManager(context: Context) {
    var mRequestQueue:RequestQueue = VolleySingleton.getInstance().requestQueue
    var mContext = context
    var url = "https://opentdb.com/api.php?amount=20&type=boolean"
    lateinit var quizQuestions:ArrayList<QuizQuestion>
    lateinit var cardStackView:CardStackView
    fun getQuizQuestions(activity: Activity) {
        quizQuestions = ArrayList()
        var quesJasonObjectRequest: JsonObjectRequest =
            JsonObjectRequest(Request.Method.GET, url, null,
                {
                    try{
                        var result:JSONArray =it.getJSONArray("results")
                        Log.i("TAG",it.toString() + "")
                        for(index in 0 until result.length()) {
                            var questionJsonObject: JSONObject =
                                result.getJSONObject(index)
                                var questionText:String = questionJsonObject.getString("question")
                                var boolean:Boolean = questionJsonObject.getBoolean("correct_answer")
                                var myQuestion = QuizQuestion(questionText,boolean)
                            Log.i("Question", "$questionText - $boolean **** ")
                                quizQuestions.add(myQuestion)
                        }
                        cardStackView = activity.findViewById(R.id.card_stack_view)
                        cardStackView.layoutManager = CardStackLayoutManager(mContext)
                        cardStackView.adapter = CardStackAdaptor(mContext,quizQuestions)
                    }catch (e:JSONException){
                        e.printStackTrace()
                    }
                },
                {

                }
            )
        mRequestQueue.add(quesJasonObjectRequest)
    }
}