package com.example.meditatinoui.utils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditatinoui.Feature
import com.example.meditatinoui.R
import com.example.meditatinoui.ui.theme.ButtonBlue
import com.example.meditatinoui.ui.theme.DarkerButtonBlue
import com.example.meditatinoui.ui.theme.Pink80
import com.example.meditatinoui.ui.theme.TextWhite
import kotlin.math.abs


@Composable
fun BottomBar(
    modifier: Modifier,
) {
    var selectedIndex = remember {
        mutableStateOf(0)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(
            selectedIndex.value,
            itemIndex = 0,
            iconId = R.drawable.ic_home,
            iconDesc = "Home",
            text = "Home",
            onClick = {
                selectedIndex.value = it
            }
        )
        BottomBarItem(
            selectedIndex.value,
            itemIndex = 1,
            iconId = R.drawable.ic_bubble,
            iconDesc = "meditation",
            text = "Meditate",
            onClick = {
                selectedIndex.value = it
            }
        )
        BottomBarItem(
            selectedIndex.value,
            itemIndex = 2,
            iconId = R.drawable.ic_moon,
            iconDesc = "sleep",
            text = "Sleep",
            onClick = {
                selectedIndex.value = it
            }
        )
        BottomBarItem(
            selectedIndex.value,
            itemIndex = 3,
            iconId = R.drawable.ic_music,
            iconDesc = "Music",
            text = "Music",
            onClick = {
                selectedIndex.value = it
            }
        )
        BottomBarItem(
            selectedIndex.value,
            itemIndex = 4,
            iconId = R.drawable.ic_profile,
            iconDesc = "Profile",
            text = "Profile",
            onClick = {
                selectedIndex.value = it
            }
        )

    }

}

@Composable
fun BottomBarItem(
    selected_index: Int,
    itemIndex: Int,
    iconId: Int,
    iconDesc: String,
    text: String,
    onClick: (Int) -> Unit
) {
    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .padding(top = 8.dp, bottom = 5.dp)
            .clickable {
                onClick(itemIndex)
            }
            .background(
                if (selected_index == itemIndex) ButtonBlue
                else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = iconDesc,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
        Text(text = text, style = MaterialTheme.typography.bodyLarge, color = Color.White)
    }
}

@Composable
fun FeaturesSections(
    featureList: List<Feature>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 10.dp),
            modifier = Modifier


        ) {
            items(featureList) {
                FeatureItem(it)
            }
        }


    }

}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor).fillMaxSize()
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier

                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .clickable {}
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}


@Composable
fun Greetingcomp() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column() {
            Text(
                text = "Good Morning, Ram",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier.size(24.dp).clickable {  },
            tint = Color.White
        )

    }
}


@Composable
fun chipSection(chips: List<String>) {
    val selectedIntexItem = remember {
        mutableStateOf(0)
    }
    LazyRow {
        itemsIndexed(chips) { index, it ->
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                    .clickable { selectedIntexItem.value = index }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedIntexItem.value == index) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)

            ) {
                Text(chips[index], color = Color.White)
            }
        }
    }
}


@Composable
fun DailyThought() {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .size(90.dp)
            .background(Pink80)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "DailyThought",
                    style = MaterialTheme.typography.headlineLarge,
                    color = TextWhite
                )
                Text(
                    text = "Meditation 3-10 min",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextWhite
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }

}

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}
