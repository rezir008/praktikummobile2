package com.tes.modul4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.modul4.databinding.FragmentKucingBinding

class KucingFragment : Fragment() {
    private lateinit var adapter: KucingAdapter
    private var list: ArrayList<Kucing> = arrayListOf()
    private var _binding: FragmentKucingBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKucingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = KucingAdapter(list)
        _binding = FragmentKucingBinding.bind(view)

        list.addAll(Data.listDtKucing)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvKucing.setHasFixedSize(true)
        binding.rvKucing.layoutManager = LinearLayoutManager(activity)
        binding.rvKucing.adapter = adapter
        val kucingAdapter = adapter
        // Notice ItemOnClickListener RecyckerList
        kucingAdapter.setOnItemClickCallback(object :  KucingAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kucing) {
                showSelectedKuliner(data)
            }
        })
    }
    private fun showSelectedKuliner(kucing: Kucing) {
        Toast.makeText(context, "Anda memilih " + kucing.name, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}