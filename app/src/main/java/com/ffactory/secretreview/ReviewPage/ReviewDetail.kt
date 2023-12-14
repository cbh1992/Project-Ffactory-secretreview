package com.ffactory.secretreview.ReviewPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ffactory.secretreview.R
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
import com.ffactory.secretreview.databinding.ActivityReviewDetailBinding

class ReviewDetail : AppCompatActivity() {
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
            //binding.DetailScore.rating = intent.getFloatExtra("Score")

    }
}