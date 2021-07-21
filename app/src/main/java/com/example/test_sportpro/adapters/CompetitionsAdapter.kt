package com.example.test_sportpro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.databinding.CompetitionsListItemBinding

class CompetitionsAdapter (private val names: List<String>) :  RecyclerView.Adapter<CompetitionsAdapter.CompetitionViewHolder>() {

    inner class CompetitionViewHolder(val binding: CompetitionsListItemBinding) : RecyclerView.ViewHolder(
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
                CompetitionsListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val competition = names[position]
        holder.itemView.apply {
            holder.binding.title.text = competition

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