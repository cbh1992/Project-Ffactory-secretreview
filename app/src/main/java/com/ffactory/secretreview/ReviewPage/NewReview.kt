package com.ffactory.secretreview.ReviewPage

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewReview : AppCompatActivity() {
    private lateinit var binding : ActivityNewReviewBinding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityNewReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.NewRating.setOnRatingBarChangeListener { ratingBar, rating, fromUser -> binding.NewScore.text = rating.toString() }

        //테스트구역
        binding.NewWritten.setOnClickListener {
            val name = binding.NewName.text.toString()
            var score = binding.NewScore.text.toString()
            if(score == "Score"){
                score = "0.0"
            }
            val tags = binding.NewTag.text.toString()
            val review = binding.NewReview.text.toString()
            var add: String? = null
            if(binding.NewNoMap.isChecked) {
            add = "null"
        } else{
            add = "Location"
        }
            val time : LocalDateTime? = LocalDateTime.now()
            val formatterTime = DateTimeFormatter.ISO_LOCAL_TIME
            val formattedTime = time?.format(formatterTime)
            val formatterDate = DateTimeFormatter.ISO_DATE
            val formattedDate = time?.format(formatterDate)


            val testup = hashMapOf(
                "name" to name,
                "score" to score,
                "tags" to tags,
                "review" to review,
                "location" to add,
                "time" to "$formattedDate  /  $formattedTime"
            )
            db.collection("post")
                .add(testup)
                .addOnSuccessListener { result ->
                    Toast.makeText(this,"성공",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener { error ->
                    Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show()
                }
        }

        //취소버튼 누르면 종료
        binding.NewCancel.setOnClickListener {
            finish()
        }
    }
}