package com.wksoftware.moviedemo.ui.movies

import com.wksoftware.moviedemo.domain.Movie

data class MoviesState(
    val movies : List<Movie> = emptyList(),
    val orderType: OrderType = OrderType.ByTitle)