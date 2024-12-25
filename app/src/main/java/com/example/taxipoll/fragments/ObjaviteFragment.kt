package com.example.taxipoll.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.taxipoll.R

class ObjaviteFragment : Fragment() {

    private lateinit var odakleInput: EditText
    private lateinit var gdeInput: EditText
    private lateinit var vremeInput: EditText
    private lateinit var objaviBtn: Button

    companion object {
        val voznjeList = mutableListOf<String>() // Deljena lista sa VoznjeFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_objavite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicijalizacija UI komponenata
        odakleInput = view.findViewById(R.id.ObjaviOdakleTXT)
        gdeInput = view.findViewById(R.id.ObjaviKolikoTXT)
//        vremeInput = view.findViewById(R.id.timePicker)
        objaviBtn = view.findViewById(R.id.ObjaviBtn)

        objaviBtn.setOnClickListener {
            val odakle = odakleInput.text.toString()
            val gde = gdeInput.text.toString()
            val vreme = vremeInput.text.toString()

            if (odakle.isNotEmpty() && gde.isNotEmpty() && vreme.isNotEmpty()) {
                val novaVoznja = "$odakle → $gde u $vreme"
                voznjeList.add(novaVoznja) // Dodavanje voznje u listu

                // Navigacija nazad u VoznjeFragment
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
