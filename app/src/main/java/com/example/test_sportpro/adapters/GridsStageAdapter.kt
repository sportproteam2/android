package com.example.test_sportpro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.databinding.GridListItemBinding
import com.example.test_sportpro.databinding.SportListItemBinding
import com.example.test_sportpro.databinding.ThirdListItemBinding

class GridsStageAdapter (private val stages: List<String>) :  RecyclerView.Adapter<GridsStageAdapter.StagesViewHolder>() {

    inner class StagesViewHolder(val binding: GridListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StagesViewHolder {
        return StagesViewHolder(
            GridListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StagesViewHolder, position: Int) {
        val stage = stages[position]
        holder.itemView.apply {
            holder.binding.stage.text = stage
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
        return stages.size
    }
}