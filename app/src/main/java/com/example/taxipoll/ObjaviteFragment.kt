package com.example.taxipoll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class ObjaviteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_objavite, container, false)

        // Pronalaženje elemenata
        val objaviBtn: Button = view.findViewById(R.id.ObjaviBtn)
        val objaviLokacijaBtn: Button = view.findViewById(R.id.ObjaviLokacijaBtn)

        // Funkcionalnost za dugme "Objavi vožnju"
        objaviBtn.setOnClickListener {
            // Navigacija na VoznjeFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, VoznjeFragment())
                .addToBackStack(null)
                .commit()
        }

        // Funkcionalnost za dugme "Upotrebi moju lokaciju"
        objaviLokacijaBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, UpotrebiFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
