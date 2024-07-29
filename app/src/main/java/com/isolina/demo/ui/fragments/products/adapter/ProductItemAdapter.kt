package com.isolina.demo.ui.fragments.products.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isolina.demo.databinding.ItemProductBinding
import com.isolina.demo.domain.models.Product

class ProductItemAdapter(private val onClickListener: (Product) -> Unit) :
    ListAdapter<Product, ProductItemAdapter.ViewHolder>(DiffutilCallbackStore) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
        holder.itemView.setOnClickListener { onClickListener(product) }
    }

    class ViewHolder(private val binding: ItemProductBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.name.text = product.name
            binding.date.text = product.getDate()
            product.links.patch.small?.let {
                Glide.with(context).load(it).centerCrop().into(binding.image)
            }
            val color = if (product.success) Color.parseColor("#b3f0e1") else Color.parseColor("#f0b3b7")
            binding.background.setBackgroundColor(color)
        }
    }

}


private object DiffutilCallbackStore: DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}