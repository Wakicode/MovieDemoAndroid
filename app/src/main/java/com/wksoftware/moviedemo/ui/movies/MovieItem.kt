package com.wksoftware.moviedemo.ui.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wksoftware.moviedemo.domain.Movie

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (Movie) -> Unit = {}
) {
    Row (modifier = Modifier
        .fillMaxHeight(0.25f)
        .fillMaxWidth()
        .clickable {
            onMovieClick(movie)
        }
        .padding(all = 8.dp)){

        AsyncImage(
            modifier = Modifier
                .height(150.dp)
                .padding(all = 4.dp),
            model = movie.poster,
            contentDescription = "Profile picture",
            contentScale = ContentScale.Fit
        )

        Column (modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = "${movie.title}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(horizontal = 8.dp)

            )

            Text(
                text = "${movie.year}",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(horizontal = 8.dp)

            )

            Text(
                text = "${movie.runtimeMinutes} minutos",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(horizontal = 8.dp)

            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }


    }
}