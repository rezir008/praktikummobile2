package com.tes.modul4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tes.modul4.databinding.ItemRowBinding

class PandaAdapter (val listPanda: ArrayList<Panda>) : RecyclerView.Adapter<PandaAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    lateinit var mcontext: Context
    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(panda: Panda) {
            with(binding){
                nameAnimal.text = panda.name
            }
            //or
            //binding.nameAnimal.text = panda.name
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
        holder.bind(listPanda[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPanda[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listPanda.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Panda)
    }
}