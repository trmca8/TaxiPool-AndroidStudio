package com.example.taxipoll.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxipoll.R

class VoznjeAdapter(private val voznjeList: List<String>) : RecyclerView.Adapter<VoznjeAdapter.VoznjaViewHolder>() {

    inner class VoznjaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val voznjaTextView: TextView = itemView.findViewById(R.id.CardVoznjaTXT)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoznjaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_voznja, parent, false)
        return VoznjaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoznjaViewHolder, position: Int) {
        holder.voznjaTextView.text = voznjeList[position]
    }

    override fun getItemCount(): Int = voznjeList.size
}