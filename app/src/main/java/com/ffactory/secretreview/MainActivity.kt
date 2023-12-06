package com.ffactory.secretreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ffactory.secretreview.OptionPage.OptionPage
import com.ffactory.secretreview.ReviewPage.NewReview
import com.ffactory.secretreview.SearchPage.SearchPage
import com.ffactory.secretreview.databinding.ActivityMainBinding

//피그마 링크 : https://www.figma.com/file/efKZcR1tdaAokOwT6aZ5vC/secretreview?type=whiteboard&node-id=0-1&t=YEI08CCyD8qXPBR6-0

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러뷰 부분


        //FAB 액티비티 전환부분
        val New = binding.NewButton
        val Search = binding.SearchButton
        val Option = binding.OptionButton
        New.setOnClickListener {
            val new = Intent(this, NewReview::class.java)
            startActivity(new)
        }
        Search.setOnClickListener {
            val search = Intent(this, SearchPage::class.java)
            startActivity(search)
        }
        Option.setOnClickListener {
            val option = Intent(this, OptionPage::class.java)
            startActivity(option)
        }
    }
}