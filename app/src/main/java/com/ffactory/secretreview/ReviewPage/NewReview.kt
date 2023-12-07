package com.ffactory.secretreview.ReviewPage

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class NewReview : AppCompatActivity() {
    private lateinit var binding : ActivityNewReviewBinding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityNewReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //파이어스토어 테스트구역
        binding.NewWritten.setOnClickListener {
            val user = hashMapOf(
                "first" to "Ada",
                "last" to "Lovelace",
                "born" to 1815
            )
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }
}