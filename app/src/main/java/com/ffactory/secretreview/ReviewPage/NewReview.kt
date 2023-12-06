package com.ffactory.secretreview.ReviewPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding

class NewReview : AppCompatActivity() {
    private lateinit var binding : ActivityNewReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityNewReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}