package com.example.composecourse.Navigation


sealed class Screens(val route : String) {
    object HomeScreen : Screens(route = "home_screen")

    object TextSelection : Screens(route = "text_selection")
    object TextCustomisation: Screens(route = "text_customisation")

    object  ExpandedCard : Screens(route = "expanded_card")

    object GoogleButton : Screens(route = "google_btn")

    object CoilImage : Screens(route = "coil_image")

    object PasswordField : Screens(route = "password_field")

    object GradientButton : Screens(route = "gradient_button")

    object LazyColumn : Screens(route = "lazy_column")
    object CodeCard : Screens(route = "lazy_column_code_card")
}