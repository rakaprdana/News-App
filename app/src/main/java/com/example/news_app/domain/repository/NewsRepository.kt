package com.example.news_app.domain.repository

import com.example.news_app.domain.entities.NewsResponse

interface NewsRepository {
    suspend fun getTopHeadlines(category: String, apiKey: String): NewsResponse
}