package com.example.composecourse.BottomNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen(
){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navHostController = navController)}
    ) {
        BottomNavGraph(navHostController = navController)
    }
}

@Composable
fun BottomBar(
    navHostController: NavHostController
){
    val screenlist = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Settings,
        BottomBarScreen.Profile
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screenlist.forEach {
            screen->
            AddItem(screen = screen, currentDestination = currentDestination, navHostController = navHostController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
){
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = { navHostController.navigate(screen.route){
            popUpTo(navHostController.graph.findStartDestination().id)
            launchSingleTop = true
        } },
        label = { Text(text = screen.title)},
        alwaysShowLabel = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        colors = NavigationBarItemColors(
             selectedIconColor = MaterialTheme.colorScheme.onPrimary,
             selectedTextColor = MaterialTheme.colorScheme.onPrimary,
             selectedIndicatorColor= MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f),
             unselectedIconColor= MaterialTheme.colorScheme.inversePrimary,
             unselectedTextColor= MaterialTheme.colorScheme.inversePrimary,
             disabledIconColor= MaterialTheme.colorScheme.onPrimary.copy(alpha = 0f),
            disabledTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0f)
        ),
        icon = { Icon(imageVector = screen.icon, contentDescription = null) })
}