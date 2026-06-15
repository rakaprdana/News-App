package com.example.news_app.data.repositories

import com.example.news_app.data.dto.NewsResponseDTO
import com.example.news_app.data.source.api.NewsServices
import com.example.news_app.domain.entities.Article
import com.example.news_app.domain.entities.NewsResponse
import com.example.news_app.domain.entities.Source
import com.example.news_app.domain.repository.NewsRepository

class NewsRepositoryImpl(val newsService: NewsServices) : NewsRepository {
    override suspend fun getTopHeadlines(
        category: String,
        apiKey: String
    ): NewsResponse {
        val responseDTO = newsService.getTopHeadlines(category, apiKey)
        return responseDTO.toNews()
    }

    private fun NewsResponseDTO.toNews(): NewsResponse{
        return NewsResponse(
            status = status,
            totalResults = totalResults,
            articles = articles.map{it.toArticle()}
        )
    }

    private fun NewsResponseDTO.ArticleDTO.toArticle(): Article{
        return Article(
                source = source.toSource(),
                author = author,
                title = title,
                description = description,
                url = url,
                urlToImage = urlToImage,
                publishedAt = publishedAt,
                content = content
                )
    }

    private fun NewsResponseDTO.ArticleDTO.SourceDTO.toSource(): Source{
        return Source(
            id = id,
            name= name
        )
    }


}