package com.wksoftware.moviedemo.usecases.abstractions

import com.wksoftware.moviedemo.domain.Movie

interface MoviesRepository {
    fun getMovies(): List<Movie>
    fun addMovie(movie: Movie)
    fun updateMovie(movie: Movie)
    fun deleteMovie(movie: Movie)
}