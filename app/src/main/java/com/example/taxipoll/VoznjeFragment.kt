package com.example.taxipoll

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taxipoll.adapter.VoznjeAdapter

class VoznjeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VoznjeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_voznje, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.svevoznjeR)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = VoznjeAdapter(ObjaviteFragment.voznjeList)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged() // Osvežavanje RecyclerView podataka
    }
}