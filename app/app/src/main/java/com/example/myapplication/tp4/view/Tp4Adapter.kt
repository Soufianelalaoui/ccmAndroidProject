package com.example.myapplication.tp4.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.tp4.view.Tp4QuoteViewHolder
import com.example.myapplication.tp4.model.Tp4Ui
import com.example.myapplication.databinding.ItemTp4Binding

val diffUtils = object : DiffUtil.ItemCallback<Tp4Ui>() {
    override fun areItemsTheSame(oldItem: Tp4Ui, newItem: Tp4Ui): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: Tp4Ui, newItem: Tp4Ui): Boolean {
        return oldItem == newItem
    }
}

class Tp4QuoteViewHolder(
    val binding: ItemTp4Binding
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: Tp4Ui


    fun bind(Tp4Ui: Tp4Ui) {
        ui = Tp4Ui
        /*Glide.with(itemView.context)
            .load(Tp4Ui.city)
            .into(binding.itemTp4Icon)*/


        binding.itemTp4Icon.text = Tp4Ui.city
        binding.itemTp4Quote.text = Tp4Ui.full_address
    }
}

class Tp4Adapter : ListAdapter<Tp4Ui, Tp4QuoteViewHolder>(diffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tp4QuoteViewHolder {
        return Tp4QuoteViewHolder(
            ItemTp4Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: Tp4QuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

