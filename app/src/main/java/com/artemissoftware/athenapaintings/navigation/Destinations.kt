package com.artemissoftware.athenapaintings.navigation

sealed class Destinations(val route: String){
    object Home: Destinations("home_screen")
    object Search: Destinations("search_screen")
}
