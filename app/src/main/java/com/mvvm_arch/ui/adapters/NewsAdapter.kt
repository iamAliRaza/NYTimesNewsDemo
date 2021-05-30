package com.mvvm_arch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm_arch.data.model.NewsData
import com.mvvm_arch.databinding.ListItemBinding

class NewsAdapter(private val callback: (NewsData) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val newsList: ArrayList<NewsData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount() = newsList.size

    fun updateItems(photosList: List<NewsData>) {
        newsList.clear()
        newsList.addAll(photosList)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    callback(newsList[adapterPosition])
                }
            }
        }

        fun bind(data: NewsData) {

            binding.apply {
                mainText.text = data.title
                lowText.text = data._abstract
                date.text = data.pDate
            }
        }

    }
}