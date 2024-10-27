package com.example.movieapp.screens.Screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId : String?) {

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
   Scaffold(
       topBar = {
           TopAppBar(backgroundColor = Color.DarkGray, elevation = 5.dp){
                Row (horizontalArrangement = Arrangement.Start){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back", tint = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigateUp()
                        })

                    Spacer(modifier = Modifier.width(100.dp))
                }
               Text("Movies", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
           }
       }
   ) {
       paddingValues ->
       Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

        ){
            MovieRow(movie = newMovieList.first())
            Spacer(modifier = Modifier.height(8.dp))

            Divider()
            Text(text = "Movie Images")
            LazyRow{
                items(newMovieList[0].images){
                    image ->
                    Card(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(240.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    ){
                        Image(painter = rememberImagePainter(data = image), contentDescription = "Movie image",modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
   }

}