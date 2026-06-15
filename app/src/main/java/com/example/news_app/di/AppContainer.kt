package com.example.news_app.di

import com.example.news_app.AppViewModelFactory
import com.example.news_app.data.repositories.NewsRepositoryImpl
import com.example.news_app.data.source.api.NewsServices
import com.example.news_app.data.source.api.RetrofitClient
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.domain.usecase.GetTopHeadlinesUseCase

class AppContainer {
    private val retrofit = RetrofitClient.retrofit

    private val newsService: NewsServices by lazy {
        retrofit.create(NewsServices::class.java)
    }

    val newsRepository: NewsRepository by lazy {
        NewsRepositoryImpl(newsService)
    }

    val getTopHeadlinesUseCase: GetTopHeadlinesUseCase by lazy {
        GetTopHeadlinesUseCase(newsRepository)
    }

    fun provideViewModelFactor(): AppViewModelFactory{
        return AppViewModelFactory().apply {
            //Register View Model in Here
        }
    }

}