//package com.ffactory.secretreview.ReviewPage
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.ffactory.secretreview.R
//import com.ffactory.secretreview.databinding.ReviewItemsBinding
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//import java.util.ArrayList
//
//class MainRecyclerViewAdapter(private val context: ArrayList<ItemDataClass>) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    var review = mutableListOf<ItemDataClass>()
//    val db = Firebase.firestore
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val view = ReviewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return InnerClassHolder(view)
//    }
//    fun clearItem() {
//        review.clear()
//        notifyDataSetChanged()
//    }
//    override fun getItemCount() = review.size
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        (holder as InnerClassHolder).switch(position)
//    }
//    inner class InnerClassHolder(val binding: ReviewItemsBinding):
//        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
//        var detailPage = binding.root
//        init {
//            detailPage.setOnClickListener(this)
//        }
//        fun switch(pos: Int){
//            val fullid = review[pos].name
//            binding.ItemName.text = review[pos].name
//            binding.ItemAddress.text = review[pos].add
//            binding.ItemTag.text = review[pos].tags
//        }
//
//        override fun onClick(v: View?) {
//            TODO("Not yet implemented")
//        }
//    }
//
//
////      더미데이터용 뷰홀더
////    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
////        val tv_name = itemView.findViewById<TextView>(R.id.ItemName)
////        val tv_add = itemView.findViewById<TextView>(R.id.ItemAddress)
////        val tv_tags = itemView.findViewById<TextView>(R.id.ItemTag)
////    }
//}