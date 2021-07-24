package com.example.test_sportpro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.databinding.SportsmenListItemBinding

class GridsSportsmenAdapter(private val sportsmen: List<String>) :  RecyclerView.Adapter<GridsSportsmenAdapter.StagesViewHolder>() {

    inner class StagesViewHolder(val binding: SportsmenListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StagesViewHolder {
        return StagesViewHolder(
            SportsmenListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StagesViewHolder, position: Int) {
        val sportsman = sportsmen[position]
        holder.itemView.apply {
            holder.binding.name.text = sportsman
            holder.binding.name2.text = sportsman
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
        return sportsmen.size
    }
}