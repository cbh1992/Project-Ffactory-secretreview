package com.ffactory.secretreview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ffactory.secretreview.OptionPage.OptionPage
import com.ffactory.secretreview.ReviewPage.ItemDataClass
import com.ffactory.secretreview.ReviewPage.MainRecyclerViewAdapter
import com.ffactory.secretreview.ReviewPage.NewReview
import com.ffactory.secretreview.SearchPage.SearchPage
import com.ffactory.secretreview.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val db = Firebase.firestore
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //DB에서 받아오기
        db.collection("post")
            .get()
            .addOnSuccessListener {
                Log.d("테스트","test")
            }

        //리사이클러뷰 부분
        //리사이클러뷰 테스트용 더미데이터
        val recy = binding.RecyclerView
        val itemList = ArrayList<ItemDataClass>()
        itemList.add(ItemDataClass("1번 테스트","테스트 1-1", "1-2"))
        itemList.add(ItemDataClass("2번 테스트","테스트 2-1", "2-2"))
        itemList.add(ItemDataClass("3번 테스트","테스트 3-1", "3-2"))
        itemList.add(ItemDataClass("4번 테스트","테스트 4-1", "4-2"))

        val adapter = MainRecyclerViewAdapter(itemList)
        adapter.notifyDataSetChanged()

        recy.adapter = adapter
        recy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //더미데이터 끝

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