package com.example.taxipoll.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxipoll.R

class KontaktAdapter(private val kontaktList: List<String>) : RecyclerView.Adapter<KontaktAdapter.KontaktViewHolder>() {

    inner class KontaktViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val kontaktTextView: TextView = itemView.findViewById(R.id.tvNaslovVoznje)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontaktViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_kontakt, parent, false)
        return KontaktViewHolder(view)
    }

    override fun onBindViewHolder(holder: KontaktViewHolder, position: Int) {
        holder.kontaktTextView.text = kontaktList[position]
    }

    override fun getItemCount(): Int = kontaktList.size
}
