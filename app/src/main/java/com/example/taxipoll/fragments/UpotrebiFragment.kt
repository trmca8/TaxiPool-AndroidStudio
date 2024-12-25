package com.example.taxipoll.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.taxipoll.R

class UpotrebiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upotrebi, container, false)

        // Pronalazak elemenata
        val tvAdresa: EditText = view.findViewById(R.id.tvAdresa)
        val ivClose: ImageView = view.findViewById(R.id.ivClose)
        val btnProslediLokaciju: ImageView = view.findViewById(R.id.btnProslediLokaciju)

        // Funkcionalnost za ivClose - brisanje teksta
        ivClose.setOnClickListener {
            tvAdresa.text.clear() // Brisanje teksta iz EditText-a
        }

        // Funkcionalnost za btnProslediLokaciju - navigacija na ObjaviteFragment
        btnProslediLokaciju.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ObjaviteFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
