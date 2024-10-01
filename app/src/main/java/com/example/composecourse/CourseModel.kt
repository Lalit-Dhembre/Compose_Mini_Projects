package com.example.composecourse

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
data class CourseModel(
    val Name : String,
    val route : String,
    val navController: NavController
)