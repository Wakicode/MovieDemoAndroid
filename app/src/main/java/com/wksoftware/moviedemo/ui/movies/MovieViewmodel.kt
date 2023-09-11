package com.wksoftware.moviedemo.ui.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wksoftware.moviedemo.domain.Movie
import com.wksoftware.moviedemo.usecases.GetMoviesUseCases
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewmodel(private val useCases: GetMoviesUseCases): ViewModel() {

    private val _state = MutableStateFlow(MoviesState())

    private val _stateMovie = MutableStateFlow(useCases.getMoviesByTitle().first())

    val stateMovie : StateFlow<Movie> = _stateMovie

    private var _isLoading  =  MutableStateFlow(false);

    val isLoading: StateFlow<Boolean> = _isLoading

    val state: StateFlow<MoviesState> = _state

    fun loadingData(movieOrderType: OrderType) {
        viewModelScope.launch { _isLoading.emit(true)}
        getMovies(movieOrderType);
    }

    private fun getMovies(movieOrderType: OrderType) {


        val movies =  when  (movieOrderType){
            OrderType.ByTitle -> useCases.getMoviesByTitle()
            OrderType.ByYear -> useCases.getMoviesByYear()
            OrderType.ByDuration -> useCases.getMoviesByDuration()
        }


        viewModelScope.launch {

            _state.value = _state.value.copy(
                movies = movies,
                orderType = movieOrderType
            )
            _isLoading.emit(false)
        }
    }

     fun setMovie(id: String) {
         viewModelScope.launch {
            _stateMovie.emit(useCases.getMoviesByTitle().first { m -> m.imdbID == id })
         }
     }

    init{
        loadingData(OrderType.ByTitle)
    }
}