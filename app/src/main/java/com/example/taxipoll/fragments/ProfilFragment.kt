package com.example.taxipoll.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxipoll.viewModel.ProfilViewModel
import com.example.taxipoll.R

class ProfilFragment : Fragment() {

    companion object {
        fun newInstance() = ProfilFragment()
    }

    private val viewModel: ProfilViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }
}