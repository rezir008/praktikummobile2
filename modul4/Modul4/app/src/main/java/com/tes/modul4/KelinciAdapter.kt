package com.tes.modul4

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tes.modul4.databinding.ItemRowBinding

class KelinciAdapter (val listKelinci: ArrayList<Kelinci>) : RecyclerView.Adapter<KelinciAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    lateinit var mcontext: Context
    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kelinci: Kelinci) {
            with(binding){
                nameAnimal.text = kelinci.name
            }
            //or
            //binding.nameAnimal.text = kelinci.name
        }
    }


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mcontext = parent.context
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listKelinci[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKelinci[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listKelinci.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Kelinci)
    }
}