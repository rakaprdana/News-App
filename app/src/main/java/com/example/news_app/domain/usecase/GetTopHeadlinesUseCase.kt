package com.example.news_app.domain.usecase

import com.example.news_app.domain.entities.NewsResponse
import com.example.news_app.domain.repository.NewsRepository

class GetTopHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(category: String, apiKey: String): NewsResponse{
        return newsRepository.getTopHeadlines(category, apiKey)
    }
}