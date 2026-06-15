package com.example.news_app.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.example.news_app.domain.entities.Article

class DiffUtillCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(
        oldItem: Article,
        newItem: Article
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: Article,
        newItem: Article
    ): Boolean {
        return oldItem == newItem
    }
}