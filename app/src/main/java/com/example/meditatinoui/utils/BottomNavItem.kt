package com.example.meditatinoui.utils

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.meditatinoui.ui.theme.ButtonBlue
import com.example.meditatinoui.ui.theme.DeepBlue

data class BottomNavItem(
    val route: String,
    val name: String,
    val iconiD: Int,
    val onClick: (BottomNavItem) -> Unit = {}
)


@Composable
fun BottomBarApp(
    items: List<BottomNavItem>,
    modifier: Modifier = Modifier,
    onClick: (BottomNavItem) -> Unit,
    navController: NavController
) {
    BottomNavigation(
        modifier = Modifier
            .background(color = DeepBlue)
            .padding(vertical = 10.dp, horizontal = 5.dp),
        elevation = 0.dp,

        backgroundColor = DeepBlue,

        ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        items.forEach { item ->
            val selectedItem = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(

                selected = selectedItem,
                onClick = { onClick(item) },
                selectedContentColor = ButtonBlue,
                unselectedContentColor = Color.White,

                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (selectedItem) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = ButtonBlue,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(5.dp)


                            ) {
                                Icon(
                                    painter = painterResource(id = item.iconiD),
                                    contentDescription = item.name,
                                    tint = Color.White,

                                    )
                            }
                        } else {
                            Icon(
                                painter = painterResource(id = item.iconiD),
                                contentDescription = item.name,
                                tint = Color.White
                            )
                        }

                        Text(text = item.name, fontSize = 14.sp)
                    }
                }
            )
        }
    }

}