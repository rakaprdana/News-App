package com.example.news_app.data.source.api

import com.example.news_app.data.dto.NewsResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("q") category: String = "business",
        @Query("apiKey") apiKey: String
    ): NewsResponseDTO
}