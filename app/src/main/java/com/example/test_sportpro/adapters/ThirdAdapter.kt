package com.example.test_sportpro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.databinding.ThirdListItemBinding

class ThirdAdapter(private val names: List<String>) :  RecyclerView.Adapter<ThirdAdapter.SportsmanViewHolder>() {

    inner class SportsmanViewHolder(val binding: ThirdListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

//    private val differCallback = object : DiffUtil.ItemCallback<Sport>() {
//        override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsmanViewHolder {
        return SportsmanViewHolder(
            ThirdListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsmanViewHolder, position: Int) {
        val sportsman = names[position]
        holder.itemView.apply {
            holder.binding.name.text = sportsman

//            Glide.with(this)
//                    .load()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(holder.binding.image)
//            holder.binding.name.text =
//            holder.binding.age.text =
//            holder.binding.weight.text =
//            holder.binding.work.text =
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
        return names.size
    }
}