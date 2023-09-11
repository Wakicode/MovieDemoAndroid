package com.wksoftware.moviedemo.usecases

import com.wksoftware.moviedemo.domain.Movie
import com.wksoftware.moviedemo.usecases.abstractions.MoviesRepository

class GetMoviesUseCases(private val repository: MoviesRepository) {

    fun getMoviesByYear(): List<Movie>{
        return repository.getMovies().sortedByDescending { k -> k.year }
    }

    fun getMoviesByTitle(): List<Movie>{
        return repository.getMovies().sortedBy { k -> k.title }
    }

    fun getMoviesByDuration(): List<Movie> {
        return repository.getMovies().sortedBy { k -> k.runtimeMinutes?.toInt() }
    }

}