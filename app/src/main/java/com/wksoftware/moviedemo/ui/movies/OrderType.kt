package com.wksoftware.moviedemo.ui.movies

sealed class OrderType {
    object ByYear: OrderType()
    object ByTitle: OrderType()
    object ByDuration: OrderType()
}
