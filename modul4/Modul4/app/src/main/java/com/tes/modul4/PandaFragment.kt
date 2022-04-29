package com.tes.modul4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.modul4.databinding.FragmentPandaBinding

class PandaFragment : Fragment() {
    private lateinit var adapter: PandaAdapter
    private var list: ArrayList<Panda> = arrayListOf()
    private var _binding: FragmentPandaBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPandaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PandaAdapter(list)
        _binding = FragmentPandaBinding.bind(view)

        list.addAll(Data.listDtPanda)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvPanda.setHasFixedSize(true)
        binding.rvPanda.layoutManager = LinearLayoutManager(activity)
        binding.rvPanda.adapter = adapter
        val pandaAdapter = adapter
        // Notice ItemOnClickListener RecyckerList
        pandaAdapter.setOnItemClickCallback(object :  PandaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Panda) {
                showSelectedKuliner(data)
            }
        })
    }
    private fun showSelectedKuliner(panda: Panda) {
        Toast.makeText(context, "Anda memilih " + panda.name, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}