package com.mintic.myaddressbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class PoisAdapter(
    private val mPois: ArrayList<Poi>
) : RecyclerView.Adapter<PoisAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (thePoiName, thePoiValoration, thePoiDescription) = mPois[position]
        holder.nameLabel.text = thePoiName
        holder.puntuationLabel.text = thePoiValoration
        holder.descriptionLabel.text = thePoiDescription
    }

    override fun getItemCount(): Int {
        return mPois.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLabel: TextView = itemView.findViewById(R.id.tvPoiName)
        var puntuationLabel: TextView = itemView.findViewById(R.id.tvPoiPuntuation)
        var descriptionLabel: TextView = itemView.findViewById(R.id.tvPoiDescription)
    }
}
