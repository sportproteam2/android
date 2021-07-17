package com.example.test_sportpro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.databinding.SportListItemBinding
import com.example.test_sportpro.databinding.ThirdListItemBinding

class AgeCategoriesAdapter (private val categories: List<String>) :  RecyclerView.Adapter<AgeCategoriesAdapter.CategoriesViewHolder>() {

    inner class CategoriesViewHolder(val binding: SportListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            SportListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]
        holder.itemView.apply {
            holder.binding.txtName.text = category
//
//            setOnClickListener {
//                onItemClickListener?.let { it(sport) }
//            }
        }
    }
//
//    private var onItemClickListener: ((Sport) -> Unit)? = null
//
//    fun setOnItemClickListener(listener: (Sport) -> Unit) {
//        onItemClickListener = listener
//    }

    override fun getItemCount(): Int {
        return categories.size
    }
}