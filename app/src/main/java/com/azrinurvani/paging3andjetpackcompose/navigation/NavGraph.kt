package com.azrinurvani.paging3andjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.azrinurvani.paging3andjetpackcompose.screens.home.HomeScreen
import com.azrinurvani.paging3andjetpackcompose.screens.search.SearchScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController : NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    )
        {
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }
    }
}