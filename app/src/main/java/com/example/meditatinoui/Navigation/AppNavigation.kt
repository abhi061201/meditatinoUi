package com.example.meditatinoui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditatinoui.HomeScreen
import com.example.meditatinoui.Meditate
import com.example.meditatinoui.Music
import com.example.meditatinoui.Profile
import com.example.meditatinoui.Sleep

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            HomeScreen()
        }
        composable("Sleep"){
            Sleep()
        }
        composable("Meditate"){
            Meditate()
        }
        composable("Music"){
            Music()
        }
        composable("Profile"){
            Profile()
        }
    }
}

