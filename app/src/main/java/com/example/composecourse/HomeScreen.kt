package com.example.composecourse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.composecourse.Navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
){
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Compose Course App") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            colors = TopAppBarColors(containerColor = Color.Black,
                titleContentColor = Color.White,
                scrolledContainerColor = Color.Transparent,
                navigationIconContentColor = Color.Transparent,
                actionIconContentColor = Color.Transparent
            )
        )
        },
    ) {
            innerPadding ->

        val chapter = listOf(
            CourseModel(navController = navController, Name = "Text Select", route = Screens.TextSelection.route),
            CourseModel(navController = navController, Name = "Text Customisation", route = Screens.TextCustomisation.route),
            CourseModel(navController = navController, Name = "Expanded Card", route = Screens.ExpandedCard.route),
            CourseModel(navController = navController, Name = "Google Button", route = Screens.GoogleButton.route),
            CourseModel(navController = navController, Name = "Coil Image", route = Screens.CoilImage.route),
            CourseModel(navController = navController, Name = "Password Field", route = Screens.PasswordField.route),
            CourseModel(navController = navController, Name = "Gradient Button", route = Screens.GradientButton.route),
            CourseModel(navController = navController, Name = "Lazy Column", route = Screens.LazyColumn.route),
            CourseModel(navController = navController, Name = "Custom Widget", route = Screens.CustomWidget.route),
            CourseModel(navController = navController, Name = "Bottom App Bar", route = Screens.BottomAppBar.route),
            CourseModel(navController = navController, Name = "Shimmer", route = Screens.Shimmer.route),
        )
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(items = chapter){
                chapter ->
                    Cards(name = chapter.Name, navController = chapter.navController, route = chapter.route)
            }
        }
    }
}
