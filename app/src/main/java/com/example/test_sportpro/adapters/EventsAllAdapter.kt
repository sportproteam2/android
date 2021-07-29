package com.example.test_sportpro.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test_sportpro.databinding.EventsListItemBinding
import com.example.test_sportpro.models.EventsItem
import java.text.SimpleDateFormat
import java.util.*


class EventsAllAdapter : RecyclerView.Adapter<EventsAllAdapter.EventViewHolder>() {

    inner class EventViewHolder(val binding: EventsListItemBinding) :
            RecyclerView.ViewHolder(binding.root)




    private val differCallback = object : DiffUtil.ItemCallback<EventsItem>() {
        override fun areItemsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

        return EventViewHolder(
            EventsListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false


            )
        )
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDateStr(strDate: String): String {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS")
        val targetFormat = SimpleDateFormat("dd.MM.yyyy")

        val date : Date = originalFormat.parse(strDate)
        return targetFormat.format(date)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                .load(event.photo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.binding.IBAllCom)

            holder.binding.tvTitle.text = event.name
            holder.binding.tvEndDate.text = formatDateStr(event.dateofend)
            holder.binding.tvTypeOfSport.text = event.sport.name

            setOnClickListener {
                onItemClickListener?.let { it(event) }
            }
        }
    }


    private  var onItemClickListener: ((EventsItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (EventsItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}