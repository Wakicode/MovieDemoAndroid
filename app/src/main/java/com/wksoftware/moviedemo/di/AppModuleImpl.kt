package com.wksoftware.moviedemo.di

import android.content.Context
import com.wksoftware.moviedemo.data.api.MovieApiImpl
import com.wksoftware.moviedemo.data.repository.MovieRepositoryImpl
import com.wksoftware.moviedemo.usecases.GetMoviesUseCases
import com.wksoftware.moviedemo.usecases.abstractions.MovieApi
import com.wksoftware.moviedemo.usecases.abstractions.MoviesRepository

data class AppModuleImpl(private val context: Context): AppModule {

    override val movieAPI: MovieApi by lazy {
        MovieApiImpl(context)
    }

    override val movieRepository: MoviesRepository by lazy {
        MovieRepositoryImpl(movieAPI)
    }

    override val getMoviesUseCases: GetMoviesUseCases by lazy {
        GetMoviesUseCases(movieRepository)
    }
}