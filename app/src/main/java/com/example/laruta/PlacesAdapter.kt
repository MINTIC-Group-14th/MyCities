package com.example.laruta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.ArrayList

class PlacesAdapter(
    private val mPlaces: ArrayList<Place>
) : RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.place_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (namePlace, descriptionPlace, ratingPlace, photoPlaceUrl) = mPlaces[position]
        holder.nameLabel.text = namePlace
        holder.descripLabel.text = descriptionPlace
        holder.ratingLabel.text = ratingPlace
        Picasso.get().load(photoPlaceUrl).into(holder.imageLabel)
    }

    override fun getItemCount(): Int {
        return mPlaces.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLabel: TextView = itemView.findViewById(R.id.textview_name_place)
        var descripLabel: TextView = itemView.findViewById(R.id.textview_description)
        var ratingLabel: TextView = itemView.findViewById(R.id.textview_rating)
        var imageLabel: ImageView = itemView.findViewById(R.id.imageview_image)
    }

}