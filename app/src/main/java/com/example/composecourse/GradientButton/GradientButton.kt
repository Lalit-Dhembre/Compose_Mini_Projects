package com.example.composecourse.GradientButton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.composecourse.CodeCard.CodeCard
import com.example.composecourse.ui.theme.color1
import com.example.composecourse.ui.theme.color2

@Composable
fun GradientButton(){
    Column {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Transparent,
                containerColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                color1,
                                color2
                            )
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Button", color = Color.White)
            }
        }
        CodeCard(code = "Button(\n" +
                "            onClick = { /*TODO*/ },\n" +
                "            colors = ButtonDefaults.buttonColors(\n" +
                "                contentColor = Color.Transparent,\n" +
                "                containerColor = Color.Transparent,\n" +
                "                disabledContentColor = Color.Transparent,\n" +
                "                disabledContainerColor = Color.Transparent,\n" +
                "            ),\n" +
                "            shape = RoundedCornerShape(10.dp),\n" +
                "            contentPadding = PaddingValues()\n" +
                "        ) {\n" +
                "            Box(\n" +
                "                modifier = Modifier\n" +
                "                    .background(\n" +
                "                        Brush.verticalGradient(\n" +
                "                            colors = listOf(\n" +
                "                                color1,\n" +
                "                                color2\n" +
                "                            )\n" +
                "                        )\n" +
                "                    )\n" +
                "                    .padding(horizontal = 16.dp, vertical = 8.dp),\n" +
                "                contentAlignment = Alignment.Center\n" +
                "            ){\n" +
                "                Text(text = \"Button\", color = Color.White)\n" +
                "            }")
    }
}