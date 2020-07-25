package com.example.techugo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.techugo.R
import com.example.techugo.model.Cupons

class OfferAdapter(
    private val arrayList: ArrayList<Cupons>
    , private val context: Context

) : RecyclerView.Adapter<OfferAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            LayoutInflater.from(context).inflate(R.layout.offer_list_item, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val offer = arrayList[position]
        holder.title.text = offer.title
        holder.description.text = offer.description
        holder.price.text = offer.price.toString()
    }

    class CustomViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var title: TextView = itemLayoutView.findViewById(R.id.title)
        var description: TextView = itemLayoutView.findViewById(R.id.description)
        var price: TextView = itemLayoutView.findViewById(R.id.price)
    }

}

