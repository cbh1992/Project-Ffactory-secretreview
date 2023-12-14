package com.ffactory.secretreview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ffactory.secretreview.OptionPage.OptionPage
import com.ffactory.secretreview.ReviewPage.ItemDataClass
import com.ffactory.secretreview.ReviewPage.NewReview
import com.ffactory.secretreview.ReviewPage.ReviewDetail
import com.ffactory.secretreview.SearchPage.SearchPage
import com.ffactory.secretreview.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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
inner class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var items : ArrayList<ItemDataClass> = arrayListOf()
    init {
        firestore?.collection("post")?.
        addSnapshotListener { querySnapshot, firebaseFirestoreException ->
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
        viewHolder.findViewById<TextView>(R.id.ItemLocation).text = items[position].location
        viewHolder.findViewById<TextView>(R.id.ItemScore).text = items[position].score
        viewHolder.findViewById<TextView>(R.id.ItemText).text = items[position].text
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                binding
                val detailName : TextView = itemView.findViewById(R.id.ItemName)
                val detailTag : TextView = itemView.findViewById(R.id.ItemTag)
                val detailLocation : TextView = itemView.findViewById(R.id.ItemLocation)
                val detailScore : TextView = itemView.findViewById(R.id.ItemScore)
                val detailText : TextView = itemView.findViewById(R.id.ItemText)
                val tossToDetail = Intent(this@MainActivity,ReviewDetail::class.java)
                tossToDetail.putExtra("name", detailName.text.toString())
                tossToDetail.putExtra("tag", detailTag.text.toString())
                tossToDetail.putExtra("Location", detailLocation.text.toString())
                tossToDetail.putExtra("Score", detailScore.text.toString())
                tossToDetail.putExtra("Text", detailText.text.toString())
                startActivity(tossToDetail)
            }
        }
        }
    override fun getItemCount(): Int {
        return items.size
        }
    }
}