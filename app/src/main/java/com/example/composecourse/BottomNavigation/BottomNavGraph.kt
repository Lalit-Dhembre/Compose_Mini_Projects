package com.example.composecourse.BottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecourse.CodeCard.CodeCard

@Composable
fun BottomNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingScreen()
        }
    }
}

@Composable
fun HomeScreen(){
    CodeCard(code = "sealed class BottomBarScreen(\n" +
            "    val route: String,\n" +
            "    val title: String,\n" +
            "    val icon: ImageVector\n" +
            "){\n" +
            "    object Home : BottomBarScreen(\n" +
            "        route = \"home\",\n" +
            "        title = \"Home\",\n" +
            "        icon = Icons.Filled.Home\n" +
            "    )\n" +
            "\n" +
            "    object Profile : BottomBarScreen(\n" +
            "        route = \"profile\",\n" +
            "        title = \"Profile\",\n" +
            "        icon = Icons.Filled.Person\n" +
            "    )\n" +
            "\n" +
            "    object Settings : BottomBarScreen(\n" +
            "        route = \"settings\",\n" +
            "        title = \"Settings\",\n" +
            "        icon = Icons.Filled.Settings\n" +
            "    )\n" +
            "}")
}

@Composable
fun ProfileScreen(){
    CodeCard(code = "package com.example.composecourse.BottomNavigation\n" +
            "\n" +
            "import androidx.compose.foundation.layout.fillMaxSize\n" +
            "import androidx.compose.material3.Text\n" +
            "import androidx.compose.runtime.Composable\n" +
            "import androidx.compose.ui.Modifier\n" +
            "import androidx.compose.ui.text.style.TextAlign\n" +
            "import androidx.navigation.NavHostController\n" +
            "import androidx.navigation.compose.NavHost\n" +
            "import androidx.navigation.compose.composable\n" +
            "\n" +
            "@Composable\n" +
            "fun BottomNavGraph(\n" +
            "    navHostController: NavHostController\n" +
            "){\n" +
            "    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {\n" +
            "        composable(route = BottomBarScreen.Home.route){\n" +
            "            HomeScreen()\n" +
            "        }\n" +
            "        composable(route = BottomBarScreen.Profile.route){\n" +
            "            ProfileScreen()\n" +
            "        }\n" +
            "        composable(route = BottomBarScreen.Settings.route){\n" +
            "            SettingScreen()\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "@Composable\n" +
            "fun HomeScreen(){\n" +
            "    Text(text = \"HOME SCREEN\",\n" +
            "        textAlign = TextAlign.Center,\n" +
            "        modifier = Modifier.fillMaxSize())\n" +
            "}\n" +
            "\n" +
            "@Composable\n" +
            "fun ProfileScreen(){\n" +
            "    Text(text = \"PROFILE SCREEN\",\n" +
            "        textAlign = TextAlign.Center,\n" +
            "        modifier = Modifier.fillMaxSize())\n" +
            "}\n" +
            "\n" +
            "@Composable\n" +
            "fun SettingScreen(){\n" +
            "    Text(text = \"Setting SCREEN\",\n" +
            "        textAlign = TextAlign.Center,\n" +
            "        modifier = Modifier.fillMaxSize())\n" +
            "}\n")
}

@Composable
fun SettingScreen(){
    CodeCard(code = "@SuppressLint(\"UnusedMaterial3ScaffoldPaddingParameter\")\n" +
            "@Composable\n" +
            "fun Screen(\n" +
            "){\n" +
            "    val navController = rememberNavController()\n" +
            "    Scaffold(\n" +
            "        bottomBar = { BottomBar(navHostController = navController)}\n" +
            "    ) {\n" +
            "        BottomNavGraph(navHostController = navController)\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "@Composable\n" +
            "fun BottomBar(\n" +
            "    navHostController: NavHostController\n" +
            "){\n" +
            "    val screenlist = listOf(\n" +
            "        BottomBarScreen.Home,\n" +
            "        BottomBarScreen.Settings,\n" +
            "        BottomBarScreen.Profile\n" +
            "    )\n" +
            "\n" +
            "    val navBackStackEntry by navHostController.currentBackStackEntryAsState()\n" +
            "    val currentDestination = navBackStackEntry?.destination\n" +
            "\n" +
            "    NavigationBar {\n" +
            "        screenlist.forEach {\n" +
            "            screen->\n" +
            "            AddItem(screen = screen, currentDestination = currentDestination, navHostController = navHostController)\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "@Composable\n" +
            "fun RowScope.AddItem(\n" +
            "    screen: BottomBarScreen,\n" +
            "    currentDestination: NavDestination?,\n" +
            "    navHostController: NavHostController\n" +
            "){\n" +
            "    NavigationBarItem(\n" +
            "        selected = currentDestination?.hierarchy?.any {\n" +
            "            it.route == screen.route\n" +
            "        } == true,\n" +
            "        onClick = { navHostController.navigate(screen.route){\n" +
            "            popUpTo(navHostController.graph.findStartDestination().id)\n" +
            "            launchSingleTop = true\n" +
            "        } },\n" +
            "        label = { Text(text = screen.title)},\n" +
            "        alwaysShowLabel = currentDestination?.hierarchy?.any{\n" +
            "            it.route == screen.route\n" +
            "        } == true,\n" +
            "        colors = NavigationBarItemColors(\n" +
            "             selectedIconColor = MaterialTheme.colorScheme.onPrimary,\n" +
            "             selectedTextColor = MaterialTheme.colorScheme.onPrimary,\n" +
            "             selectedIndicatorColor= MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f),\n" +
            "             unselectedIconColor= MaterialTheme.colorScheme.inversePrimary,\n" +
            "             unselectedTextColor= MaterialTheme.colorScheme.inversePrimary,\n" +
            "             disabledIconColor= MaterialTheme.colorScheme.onPrimary.copy(alpha = 0f),\n" +
            "            disabledTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0f)\n" +
            "        ),\n" +
            "        icon = { Icon(imageVector = screen.icon, contentDescription = null) })\n" +
            "}")
}
