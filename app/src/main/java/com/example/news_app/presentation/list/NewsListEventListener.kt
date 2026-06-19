package com.example.news_app.presentation.list

import com.example.news_app.domain.entities.Article

interface NewsListEventListener {
    fun onItemClicked(article: Article)
}