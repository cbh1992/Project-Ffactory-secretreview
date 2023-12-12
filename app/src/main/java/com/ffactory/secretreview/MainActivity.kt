package com.ffactory.secretreview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ffactory.secretreview.OptionPage.OptionPage
import com.ffactory.secretreview.ReviewPage.ItemDataClass
import com.ffactory.secretreview.ReviewPage.NewReview
import com.ffactory.secretreview.SearchPage.SearchPage
import com.ffactory.secretreview.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var idItems = mutableListOf<String>()
    private var loadItems = mutableListOf<ItemDataClass>()
    //private lateinit var adapter: MainRecyclerViewAdapter
    var firestore : FirebaseFirestore? = null
    val db = Firebase.firestore

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()
        binding.RecyclerView.adapter = MainRecyclerViewAdapter()
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)


//        //DB에서 받아오기
//        loadItems.clear()
//        idItems.clear()
//        //adapter.clearItem()
//        val docRef = db.collection("post")
//        docRef.get()
//            .addOnSuccessListener { result ->
//                for(document in result){
//                Log.d("테스트",document.id)
//                    idItems.add(document.id)
//                    }
//            }
//            .addOnFailureListener { exception ->
//                Log.d("테스트", "get failed with ", exception)
//            }


        //리사이클러뷰 부분
        //리사이클러뷰 테스트용 더미데이터
//        val recy = binding.RecyclerView
//        val itemList = ArrayList<ItemDataClass>()
//        itemList.add(ItemDataClass("1번 테스트","테스트 1-1", "1-2"))
//        itemList.add(ItemDataClass("2번 테스트","테스트 2-1", "2-2"))
//        itemList.add(ItemDataClass("3번 테스트","테스트 3-1", "3-2"))
//        itemList.add(ItemDataClass("4번 테스트","테스트 4-1", "4-2"))
//
//        val adapter = MainRecyclerViewAdapter(itemList)
//        adapter.notifyDataSetChanged()
//
//        recy.adapter = adapter
//        recy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
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
inner class MainRecyclerViewAdapter : RecyclerView.Adapter<ViewHolder>(){
    var items : ArrayList<ItemDataClass> = arrayListOf()

    init {
        firestore?.collection("post")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            // ArrayList 비워줌
            items.clear()

            for (snapshot in querySnapshot!!.documents) {
                var item = snapshot.toObject(ItemDataClass::class.java)
                items.add(item!!)
            }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var LayoutView = LayoutInflater.from(parent.context).inflate(R.layout.review_items, parent, false)
        return ViewHolder(LayoutView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = holder.itemView
        viewHolder.findViewById<TextView>(R.id.ItemName).text = items[position].name
        viewHolder.findViewById<TextView>(R.id.ItemTag).text = items[position].tags
        viewHolder.findViewById<TextView>(R.id.ItemAddress).text = items[position].add
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
    override fun getItemCount(): Int {
        return items.size
    }
}

}