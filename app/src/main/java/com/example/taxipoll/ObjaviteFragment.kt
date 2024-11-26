package com.example.taxipoll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.taxipoll.R.id.fragment_container
import com.example.taxipoll.R.layout.fragment_objavite

class ObjaviFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_objavite, container, false)
    }

    /* Unutar funkcije pa pokrecem negde
    val btnUpotrebiLokaciju = view?.findViewById<Button>(R.id.ObjaviLokacijaBtn)

    // Postavi klik listener na dugme
    btnUpotrebiLokaciju?.setOnClickListener {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, UpotrebiFragment()) // Navigacija na UpotrebiFragment
            .addToBackStack("ObjaviFragment") // Dodaj u back stack
            .commit()
    }
    */





}

