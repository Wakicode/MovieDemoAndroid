package com.wksoftware.moviedemo.ui.movies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.SyncLock
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.LockClock
import androidx.compose.material.icons.outlined.SyncLock
import androidx.compose.material.icons.outlined.Textsms
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wksoftware.moviedemo.domain.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(
    viewmodel: MovieViewmodel,
    onMovieClick: (Movie) -> Unit = {}
) {

    val state by viewmodel.state.collectAsState()

    val isLoading by viewmodel.isLoading.collectAsState()

    AnimatedVisibility(visible = !isLoading) {
        Column(verticalArrangement = Arrangement.Center) {

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                FilterChip(
                    modifier = Modifier
                        .width(100.dp)
                        .padding(horizontal = 8.dp),
                    selected = state.orderType == OrderType.ByTitle,
                    onClick = {
                        viewmodel.loadingData(OrderType.ByTitle)
                    },
                    label = { Text(text = "Título") },
                    leadingIcon = {
                        Icon(
                            if (state.orderType == OrderType.ByTitle) Icons.Outlined.Textsms else Icons.Filled.Textsms,
                            contentDescription = null,
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    })

                FilterChip(
                    modifier = Modifier
                        .width(100.dp)
                        .padding(horizontal = 8.dp),
                    selected = state.orderType == OrderType.ByYear,
                    onClick = {
                        viewmodel.loadingData(OrderType.ByYear)
                    },
                    label = { Text(text = "Año") },
                    leadingIcon = {
                        Icon(
                            if (state.orderType == OrderType.ByYear) Icons.Outlined.CalendarMonth else Icons.Filled.CalendarMonth,
                            contentDescription = null,
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    })

                FilterChip(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(horizontal = 8.dp),
                    selected = state.orderType == OrderType.ByDuration,
                    onClick = {
                        viewmodel.loadingData(OrderType.ByDuration)
                    },
                    label = { Text(text = "Duración") },
                    leadingIcon = {
                        Icon(
                            if (state.orderType == OrderType.ByDuration) Icons.Outlined.LockClock else Icons.Filled.SyncLock,
                            contentDescription = null,
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    })
            }

            LazyColumn(contentPadding = PaddingValues(vertical = 4.dp)) {
                items(state.movies) { movie ->
                    println("titulo: ${movie.title}")
                    MovieItem(
                        movie = movie,
                        onMovieClick = onMovieClick,
                        modifier = Modifier
                            .padding(all = 4.dp)
                    )
                }

            }
        }

        AnimatedVisibility(visible = isLoading) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                )
            }

        }


    }


}