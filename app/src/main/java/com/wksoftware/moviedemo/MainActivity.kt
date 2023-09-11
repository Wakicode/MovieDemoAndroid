package com.wksoftware.moviedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wksoftware.moviedemo.ui.movie.MovieScreen
import com.wksoftware.moviedemo.ui.movies.MovieViewmodel
import com.wksoftware.moviedemo.ui.movies.MoviesScreen
import com.wksoftware.moviedemo.ui.theme.MovieDemoTheme
import com.wksoftware.moviedemo.ui.viewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {

            var isDarkTheme by rememberSaveable{
                mutableStateOf(false)
            }
            MovieDemoTheme(darkTheme = isDarkTheme) {


                val viewModel = viewModel<MovieViewmodel>(
                    factory = viewModelFactory {
                        MovieViewmodel(MyMoviesApp.appModule.getMoviesUseCases)
                    }
                )

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Column {
                        Row (modifier = Modifier.align(Alignment.CenterHorizontally) ) {
                            Text(text = "Modo oscuro", modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(all = 4.dp))
                            Switch(checked = isDarkTheme, onCheckedChange = {
                                isDarkTheme = !isDarkTheme
                            })
                        }
                        NavHost(
                            navController = navController,
                            startDestination = "MoviesScreen"
                        ) {
                            composable(route = "MoviesScreen") {
                                MoviesScreen(viewModel,
                                    onMovieClick = {
                                        navController.navigate(
                                            "MovieScreen?imdbID=${it.imdbID}"
                                        )
                                    })
                            }
                            composable(
                                route = "MovieScreen?imdbID={imdbID}",
                                arguments = listOf(
                                    navArgument(
                                        name = "imdbID"
                                    ) {
                                        type = NavType.StringType
                                        defaultValue = "-1"
                                    },
                                )
                            ) {

                                val id = it.arguments?.getString("imdbID") ?: "-1"
                                viewModel.setMovie(id)
                                MovieScreen(viewmodel = viewModel)
                            }
                        }
                    }
                    }

            }
        }
    }
}
