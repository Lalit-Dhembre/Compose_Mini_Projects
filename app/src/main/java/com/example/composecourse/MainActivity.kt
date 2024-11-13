package com.example.composecourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composecourse.Navigation.SetupNavigation
import com.example.composecourse.ui.theme.ComposeCourseTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().also { Log.d("Splash","Splash Screen Launched") }
        setContent {
            ComposeCourseTheme {
                navController = rememberNavController()
                SetupNavigation(navController)
            }
        }
    }
}

@Composable
fun Cards(
    name:String,
    modifier: Modifier = Modifier,
    navController: NavController,
    route: String
    ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(5.dp)
            .clickable{
                navController.navigate(route = route)
            },
    ) {
        Text(text = name,
            modifier = Modifier
                .padding(start = 10.dp, top = 2.dp)
                .align(Alignment.Start),
            fontSize = 20.sp)
    }
}
