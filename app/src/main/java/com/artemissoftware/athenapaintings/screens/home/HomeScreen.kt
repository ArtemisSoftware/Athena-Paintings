package com.artemissoftware.athenapaintings.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.artemissoftware.athenapaintings.navigation.Destinations
import com.artemissoftware.athenapaintings.screens.composables.ListContent
import com.artemissoftware.athenapaintings.screens.home.composables.HomeTopBar

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navController.navigate(Destinations.Search.route)
                }
            )
        },
        content = {
            ListContent(items = getAllImages)
        }
    )
}