package com.kirti.vahanassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirti.vahanassignment.R

class WebsiteListAdapter(private val context: Context?, private var list: ArrayList<String>, private var onItemClickListener: OnItemClickListener) :
RecyclerView.Adapter<WebsiteListAdapter.WebsiteListViewHolder>() {

    inner class WebsiteListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val website: TextView = itemView.findViewById(R.id.list_item)
    }


        override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WebsiteListAdapter.WebsiteListViewHolder {
        return WebsiteListViewHolder(LayoutInflater.from(context).inflate(R.layout.website_list_model,parent,false))

    }

    override fun getItemCount(): Int {
       return list.size ?: 0
    }

    override fun onBindViewHolder(holder: WebsiteListAdapter.WebsiteListViewHolder, position: Int) {
        list.let {
            holder.website.text = list[position]
            holder.website.setOnClickListener {
                onItemClickListener.onItemClick(list[position])
            }

            }
        }
    }
interface OnItemClickListener {
    fun onItemClick(webUrl: String)
}