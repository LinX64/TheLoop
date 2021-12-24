package com.client.theloop.di

import com.client.theloop.ui.adapters.MyAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAdapter(): MyAdapter = MyAdapter(arrayListOf())
}