package com.example.composecourse.TextCustomisation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composecourse.CodeCard.CodeCard

@Composable
fun TextCustomisation(
    navController: NavController
){
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Thin
                    )){
                    append("CLICK ON ")
                    }
                    withStyle(style = SpanStyle(
                        color = Color.Green,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        baselineShift = BaselineShift.Superscript
                    )
                    ){
                        append("ME")
                    }
                },
                modifier = Modifier.clickable {

                })

            CodeCard(code = "Text(\n" +
                    "                buildAnnotatedString {\n" +
                    "                    withStyle(style = SpanStyle(\n" +
                    "                        color = Color.Blue,\n" +
                    "                        fontSize = 28.sp,\n" +
                    "                        fontWeight = FontWeight.Thin\n" +
                    "                    )){\n" +
                    "                    append(\"CLICK ON \")\n" +
                    "                    }\n" +
                    "                    withStyle(style = SpanStyle(\n" +
                    "                        color = Color.Green,\n" +
                    "                        fontSize = 34.sp,\n" +
                    "                        fontWeight = FontWeight.Bold,\n" +
                    "                        baselineShift = BaselineShift.Superscript\n" +
                    "                    )\n" +
                    "                    ){\n" +
                    "                        append(\"ME\")\n" +
                    "                    }\n" +
                    "                },\n" +
                    "                modifier = Modifier.clickable {\n" +
                    "\n" +
                    "                })")
        }
    }
}