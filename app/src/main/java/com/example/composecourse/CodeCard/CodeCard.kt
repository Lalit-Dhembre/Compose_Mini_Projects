package com.example.composecourse.CodeCard

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeCard(
    code: String
){
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        colors = CardColors(
            containerColor = Color(0XFF494F55),
            contentColor = Color.Green,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Text(text = code,
            fontSize = 10.sp,
            color = Color.Green,
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Left)
    }
}