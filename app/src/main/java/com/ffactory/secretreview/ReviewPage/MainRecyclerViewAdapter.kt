//package com.ffactory.secretreview.ReviewPage
//
//import android.app.Person
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.annotation.RequiresApi
//import androidx.recyclerview.widget.RecyclerView
//import com.ffactory.secretreview.R
//import com.ffactory.secretreview.ReviewPage.ItemDataClass
//import com.ffactory.secretreview.databinding.ActivityNewReviewBinding
//import com.ffactory.secretreview.databinding.ReviewItemsBinding
//import com.google.firebase.firestore.FirebaseFirestore
//
//@RequiresApi(Build.VERSION_CODES.P)
//class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    var firestore : FirebaseFirestore? = null
//    var review : ArrayList<ItemDataClass> = arrayListOf()
//    init {
//        firestore = FirebaseFirestore.getInstance()
//        firestore?.collection("post")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
//            // ArrayList 비워줌
//            review.clear()
//
//            for (snapshot in querySnapshot!!.documents) {
//                var item = snapshot.toObject(Person::class.java)
//                review.add(item!!)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//}