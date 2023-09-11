package com.wksoftware.moviedemo.di

import com.wksoftware.moviedemo.usecases.GetMoviesUseCases
import com.wksoftware.moviedemo.usecases.abstractions.MovieApi
import com.wksoftware.moviedemo.usecases.abstractions.MoviesRepository

interface AppModule {
    val movieAPI: MovieApi
    val movieRepository: MoviesRepository
    val getMoviesUseCases: GetMoviesUseCases
}