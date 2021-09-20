package com.example.laruta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class TourismPlaceAdapter(
    private val mPlaces: ArrayList<TourismPlace>
) : RecyclerView.Adapter<TourismPlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_tourism_sites_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int
    ) {
        val (sitesName, sitesDescription, sitesScore,sitesPhoto) = mPlaces[position]
        holder.nameLabel.text = sitesName
        holder.descriptionlabel.text = sitesDescription
        holder.scorelabel.text = sitesScore
    }

    override fun getItemCount(): Int {
        return mPlaces.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameLabel: TextView = itemView.findViewById(R.id.Place_Name)
        var descriptionlabel: TextView = itemView.findViewById(R.id.Place_Description)
        var scorelabel: TextView = itemView.findViewById(R.id.Place_Score)
        var photolabel: ImageView = itemView.findViewById(R.id.Place_Photo)

    }
}
