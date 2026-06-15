package com.example.news_app

import android.app.Application
import com.example.news_app.di.AppContainer

class MyApplication: Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}