package com.tes.modul4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.modul4.databinding.FragmentKelinciBinding

class KelinciFragment : Fragment() {
    private lateinit var adapter: KelinciAdapter
    private var list: ArrayList<Kelinci> = arrayListOf()
    private var _binding: FragmentKelinciBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKelinciBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = KelinciAdapter(list)
        _binding = FragmentKelinciBinding.bind(view)

        list.addAll(Data.listDtKelinci)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvKelinci.setHasFixedSize(true)
        binding.rvKelinci.layoutManager = LinearLayoutManager(activity)
        binding.rvKelinci.adapter = adapter
        val kelinciAdapter = adapter
        // Notice ItemOnClickListener RecyckerList
        kelinciAdapter.setOnItemClickCallback(object :  KelinciAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kelinci) {
                showSelectedKuliner(data)
            }
        })
    }
    private fun showSelectedKuliner(kelinci: Kelinci) {
        Toast.makeText(context, "Anda memilih " + kelinci.name, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}