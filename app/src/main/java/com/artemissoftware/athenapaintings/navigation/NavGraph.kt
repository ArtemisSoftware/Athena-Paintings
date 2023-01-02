package com.artemissoftware.athenapaintings.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.artemissoftware.athenapaintings.screens.home.HomeScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route
    ) {
        composable(route = Destinations.Home.route){
            HomeScreen(navController = navController)
        }
//        composable(route = Destinations.Search.route){
//            SearchScreen(navController = navController)
//        }
    }
}