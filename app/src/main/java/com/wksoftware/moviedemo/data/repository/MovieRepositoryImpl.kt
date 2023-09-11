package com.wksoftware.moviedemo.data.repository

import com.wksoftware.moviedemo.domain.Movie
import com.wksoftware.moviedemo.usecases.abstractions.MovieApi
import com.wksoftware.moviedemo.usecases.abstractions.MoviesRepository

class MovieRepositoryImpl(private val movieApi: MovieApi) : MoviesRepository {

    override fun getMovies(): List<Movie> {
        return movieApi.getMovies()
    }

    override fun addMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun updateMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun deleteMovie(movie: Movie) {
        TODO("Not yet implemented")
    }
}