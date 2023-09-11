package com.wksoftware.moviedemo.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wksoftware.moviedemo.ui.movies.MovieViewmodel

@Composable
fun MovieScreen(
    viewmodel: MovieViewmodel
) {
    val state by viewmodel.stateMovie.collectAsState()
    
    Column (modifier = Modifier
        .padding(all = 8.dp)) {
        Row {
            AsyncImage(
                modifier = Modifier
                    .height(300.dp)
                    .padding(all = 4.dp),
                model = state.poster,
                contentDescription = "Profile picture",
                contentScale = ContentScale.Fit
            )
            Column (modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = "${state.title}",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)

                )

                Text(
                    text = "Director: ${state.director}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(all = 8.dp)

                )

                Text(
                    text = "Actores: ${state.actors}",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(all = 8.dp)

                )

                Text(
                    text = "Año: ${state.year}",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)

                )

                Text(
                    text = "Duración: ${state.runtimeMinutes} minutos",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)

                )


            }


        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        LazyRow( ){
            items(state.images){
                AsyncImage(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(all = 4.dp),
                    model = it,
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}