package com.example.test_sportpro.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test_sportpro.databinding.CompetitionsListItemBinding
import com.example.test_sportpro.models.EventsItem
import com.example.test_sportpro.models.Sport
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class CompetitionsAdapter () :  RecyclerView.Adapter<CompetitionsAdapter.CompetitionViewHolder>() {

    inner class CompetitionViewHolder(val binding: CompetitionsListItemBinding) : RecyclerView.ViewHolder(
            binding.root
    )

    private val differCallback = object : DiffUtil.ItemCallback<EventsItem>() {
        override fun areItemsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
                CompetitionsListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDateStr(strDate: String?): String? {
        return OffsetDateTime.parse(strDate)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val competition = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                    .load(competition.photo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.image)
            holder.binding.title.text = competition.description
            holder.binding.endDate.text = formatDateStr(competition.date)
            holder.binding.category.text = competition.sport.name

            setOnClickListener {
                onItemClickListener?.let { it(competition) }
            }
        }
    }

    private var onItemClickListener: ((EventsItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (EventsItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}