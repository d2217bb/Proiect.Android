package com.danielaboros.appandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.danielaboros.androidapp.routes.HomeRoute
import com.danielaboros.androidapp.ui.theme.AndroidAppTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danielaboros.androidapp.routes.DetailsRoute
import com.danielaboros.androidapp.routes.SearchRoute
import com.danielaboros.androidapp.screens.details.DetailsScreen
import com.danielaboros.androidapp.screens.home.HomeScreen
import com.danielaboros.androidapp.screens.search.SearchScreen
import com.danielaboros.androidapp.routes.FavoriteRoute
import com.danielaboros.androidapp.screens.favorites.FavoriteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                NavBar()
            }
        }
    }
}

@Composable
fun NavBar() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onSearch = {
                    navController.navigate(SearchRoute)
                },
                onClickArtObject = { objectId ->
                    navController.navigate(DetailsRoute(objectId))
                },
                onFavoritesClick = {
                    navController.navigate(FavoriteRoute)
                }
            )
        }
        composable<SearchRoute> {
            SearchScreen(onGoBack = {
                navController.popBackStack()
            }, onClickArtObject = { objectId ->
                navController.navigate(DetailsRoute(objectId))
            })
        }
        composable<DetailsRoute> {
            DetailsScreen(onGoBack = {
                navController.popBackStack()
            })
        }
        composable<FavoriteRoute> {
            FavoriteScreen(
                onGoBack = {
                    navController.popBackStack()
                },
                onClickArtObject = { objectId ->
                    navController.navigate(DetailsRoute(objectId))
                }
            )
        }
    }
}