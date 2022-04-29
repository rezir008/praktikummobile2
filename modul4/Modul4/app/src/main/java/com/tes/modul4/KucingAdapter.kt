package com.tes.modul4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tes.modul4.databinding.ItemRowBinding

class KucingAdapter (val listKucing: ArrayList<Kucing>) : RecyclerView.Adapter<KucingAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    lateinit var mcontext: Context
    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kucing: Kucing) {
            with(binding){
                nameAnimal.text = kucing.name
            }
            //or
            //binding.nameAnimal.text = kucing.name
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
        holder.bind(listKucing[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKucing[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listKucing.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Kucing)
    }
}