package com.example.news_app.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.entities.NewsResponse
import com.example.news_app.domain.usecase.GetTopHeadlinesUseCase
import kotlinx.coroutines.launch


class NewsListViewModel(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {

    private val _newsList = MutableLiveData<NewsResponse>()
    val newList: LiveData<NewsResponse> = _newsList
    private val apiKey = "155c93d449764055bf9f26304482b952"
    fun fetchTopHeadline(category: String) {
        viewModelScope.launch {
            try {
                val newsResponse = getTopHeadlinesUseCase.invoke(category, apiKey)
                _newsList.value = newsResponse
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}
