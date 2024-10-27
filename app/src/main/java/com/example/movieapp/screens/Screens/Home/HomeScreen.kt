package com.example.movieapp.screens.Screens.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreen
import com.example.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    androidx.compose.material.Scaffold(
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = Color.DarkGray,
                elevation = 5.dp,
                title = { Text(
                    text = "Movies",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ) })
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList : List<Movie> = getMovies()
){

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn{
            items(items = movieList){

                MovieRow(movie = it){
                        movie ->
                    navController.navigate(route = MovieScreen.DetailsScreen.name+"/$movie")

//                    Log.d("TAG", "MainContent: $movie")


                }
            }
        }
    }
}

