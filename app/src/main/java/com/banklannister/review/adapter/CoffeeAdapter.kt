package com.banklannister.review.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banklannister.review.databinding.ListItemBinding
import com.banklannister.review.model.Coffee
import com.bumptech.glide.Glide

class CoffeeAdapter(val coffeeList: List<Coffee>) :
    RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coffee: Coffee) {

            binding.apply {
                tvTitle.text = coffee.title
                tvDesc.text = coffee.content
                Glide.with(imageThumb).load(coffee.thumbnail).into(imageThumb)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = coffeeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coffeeList[position])
    }
}