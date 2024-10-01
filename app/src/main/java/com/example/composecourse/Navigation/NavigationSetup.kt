package com.example.composecourse.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecourse.CoilImage.CoilImage
import com.example.composecourse.ExpandedCard.ExpandedCard
import com.example.composecourse.GoogleButton.GoogleButton
import com.example.composecourse.GradientButton.GradientButton
import com.example.composecourse.HomeScreen
import com.example.composecourse.LazyColumn.CodeCardOfLazyColumn
import com.example.composecourse.LazyColumn.LazyColumn1
import com.example.composecourse.PasswordField.PasswordField
import com.example.composecourse.TextCustomisation.TextCustomisation
import com.example.composecourse.TextSelection.TextSelection

@Composable
fun SetupNavigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route) {

        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(navController)
        }

        composable(
            route = Screens.TextSelection.route
        ){
            TextSelection()
        }

        composable(
            route = Screens.TextCustomisation.route
        ){
            TextCustomisation(navController)
        }

        composable(
            route = Screens.ExpandedCard.route
        ){
            ExpandedCard()
        }
        composable(
            route = Screens.GoogleButton.route
        ){
            GoogleButton()
        }
        composable(
            route = Screens.CoilImage.route
        ){
            CoilImage()
        }
        composable(
            route = Screens.PasswordField.route
        ){
            PasswordField()
        }
        composable(
            route = Screens.GradientButton.route
        ){
            GradientButton()
        }

        composable(
            route = Screens.LazyColumn.route
        ){
            LazyColumn1(navController)
        }
        composable(
            route = Screens.CodeCard.route
        ){
            CodeCardOfLazyColumn()
        }

    }
}