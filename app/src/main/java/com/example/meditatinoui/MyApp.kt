package com.example.meditatinoui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.meditatinoui.Navigation.AppNavigation
import com.example.meditatinoui.utils.BottomBar
import com.example.meditatinoui.utils.BottomBarApp
import com.example.meditatinoui.utils.BottomNavItem

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem(
            route = "Home",
            name = "Home",

            iconiD = R.drawable.ic_home
        ),
        BottomNavItem(
            route = "Meditate",
            name = "Meditate",

            iconiD = R.drawable.ic_bubble
        ),
        BottomNavItem(
            route = "Sleep",
            name = "Sleep",

            iconiD = R.drawable.ic_moon
        ),
        BottomNavItem(
            route = "Music",
            name = "Music",

            iconiD = R.drawable.ic_music
        ),
        BottomNavItem(
            route = "Profile",
            name = "Profile",

            iconiD = R.drawable.ic_profile
        )
    )
    Scaffold(
        bottomBar = {
            BottomBarApp(
                items = items,
                onClick = {
                    navController.navigate(it.route)
                },
                navController = navController
            )
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            AppNavigation(
                navController
            )
        }
    }
}