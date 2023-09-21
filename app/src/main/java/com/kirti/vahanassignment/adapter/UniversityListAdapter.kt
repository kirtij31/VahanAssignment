package com.kirti.vahanassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirti.vahanassignment.R
import com.kirti.vahanassignment.models.UniversityModel


class UniversityAdapter(private val context: Context?, private var list: ArrayList<UniversityModel>?, private val clickHandler: ClickHandler) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    inner class UniversityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val universityName : TextView = itemView.findViewById(R.id.university_name)
        val universityCountry : TextView = itemView.findViewById(R.id.university_country)
        val universityWebsite : TextView = itemView.findViewById(R.id.university_website    )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            LayoutInflater.from(context).inflate(R.layout.university_model, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val university = list?.get(position)
        if (university != null) {
            holder.universityName.text=university.name
            holder.universityCountry.text = university.country
            holder.universityWebsite.text = university.webPages[0]
            holder.universityWebsite.setOnClickListener {
                clickHandler.openWebsite(university.webPages[0])
            }
        }
    }
}

interface ClickHandler{
     fun openWebsite(url:String)
}