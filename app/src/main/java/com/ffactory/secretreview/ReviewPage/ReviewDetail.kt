package com.ffactory.secretreview.ReviewPage

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ffactory.secretreview.R
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
import com.ffactory.secretreview.databinding.ActivityReviewDetailBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ReviewDetail : AppCompatActivity() {
    val db = Firebase.firestore
    private lateinit var binding :ActivityReviewDetailBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityReviewDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.DetailBackButton.setOnClickListener {
                finish()
            }

            binding.DetailTitle.text = intent.getStringExtra("name")
            binding.DetailTags.text = intent.getStringExtra("tag")
            binding.DetailReview.text = intent.getStringExtra("Text")
            binding.DetailLocation.text = intent.getStringExtra("Location")
            binding.DetailScoreText.text = intent.getStringExtra("Score")
            val rating : String = binding.DetailScoreText.text.toString()
            val star : Double = rating.toDouble()
            binding.DetailScore.rating = star.toFloat()
            binding.TestBox.text = intent.getStringExtra("UID")

            //삭제하기
            binding.DetailDelete.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                    .setTitle("삭제 확인")
                    .setPositiveButton("확인",
                        DialogInterface.OnClickListener{ dialog, which ->
                            db.collection("post").document("")
                                .delete()
                                .addOnSuccessListener { Log.d("삭제 성공", "DocumentSnapshot successfully deleted!") }
                                .addOnFailureListener { e -> Log.w("삭제 실패", "Error deleting document", e) }
                            Toast.makeText(this, "확인", Toast.LENGTH_SHORT).show()
                            finish()
                        })
                    .setNegativeButton("취소",
                        DialogInterface.OnClickListener { dialog, which ->
                        })
                builder.show()
            }

            //수정하기
            binding.DetailFix.setOnClickListener {

            }
    }
}