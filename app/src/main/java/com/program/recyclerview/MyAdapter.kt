package com.program.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(
    private var newsArrayList: ArrayList<News>,
    private var context: Activity
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        myListener = listener
    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // populate items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    // how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    class MyViewHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        val hTitle: TextView = itemView.findViewById(R.id.headingTitle)
        val hImage: ShapeableImageView = itemView.findViewById(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener?.onItemClick(adapterPosition)
            }
        }
    }
}
