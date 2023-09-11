package com.wksoftware.moviedemo.usecases.abstractions

import com.wksoftware.moviedemo.domain.Movie

interface MovieApi {
    fun getMovies(): List<Movie>
    fun mapperMovies()
}