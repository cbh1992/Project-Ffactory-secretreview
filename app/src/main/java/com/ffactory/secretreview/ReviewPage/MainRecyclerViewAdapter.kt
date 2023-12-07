package com.ffactory.secretreview.ReviewPage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ffactory.secretreview.R
import com.ffactory.secretreview.ReviewPage.ItemDataClass
import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
import com.ffactory.secretreview.databinding.ReviewItemsBinding

class MainRecyclerViewAdapter(val itemList: ArrayList<ItemDataClass>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    var review = mutableListOf<ItemDataClass>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = itemList[position].name
        holder.tv_add.text = itemList[position].add
        holder.tv_tags.text = itemList[position].tags
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val tv_name = itemView.findViewById<TextView>(R.id.ItemName)
        val tv_add = itemView.findViewById<TextView>(R.id.ItemAddress)
        val tv_tags = itemView.findViewById<TextView>(R.id.ItemTag)
    }
}