package com.ffactory.secretreview.SearchPage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ffactory.secretreview.ReviewPage.ItemDataClass
import com.ffactory.secretreview.databinding.ReviewItemsBinding

class MainRecyclerViewAdapter(private val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var review = mutableListOf<ItemDataClass>()
    val intent =Intent()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ReviewItemsBinding.inflate(
            LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}