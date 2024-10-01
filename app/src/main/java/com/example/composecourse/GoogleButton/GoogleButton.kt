package com.example.composecourse.GoogleButton

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecourse.CodeCard.CodeCard
import com.example.composecourse.R

@Preview
@Composable
fun GoogleButton(){
    var buttonclicke by remember {
        mutableStateOf(false)
    }
    Column {
        Card(
            onClick = {
                buttonclicke = !buttonclicke
            },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .height(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 12.dp,
                        end = 16.dp,
                        top = 12.dp,
                        bottom = 12.dp
                    )
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 400,
                            easing = LinearOutSlowInEasing
                        )
                    )
            ){
                Icon(
                    painter = painterResource(id = R.drawable.google_btn),
                    contentDescription = null,
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = "Sign In With Google")
                Spacer(modifier = Modifier.width(5.dp))
                if(buttonclicke){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp),
                        strokeWidth = 2.dp,
                        color = Color.Green
                    )
                }
            }
        }
        CodeCard(code = "fun GoogleButton(){\n" +
                "    var buttonclicke by remember {\n" +
                "        mutableStateOf(false)\n" +
                "    }\n" +
                "    Column {\n" +
                "        Card(\n" +
                "            onClick = {\n" +
                "                buttonclicke = !buttonclicke\n" +
                "            },\n" +
                "            shape = RoundedCornerShape(5.dp),\n" +
                "            modifier = Modifier\n" +
                "                .padding(\n" +
                "                    start = 12.dp,\n" +
                "                    end = 16.dp,\n" +
                "                    top = 12.dp,\n" +
                "                    bottom = 12.dp\n" +
                "                )\n" +
                "                .height(50.dp)\n" +
                "        ) {\n" +
                "            Row(\n" +
                "                verticalAlignment = Alignment.CenterVertically,\n" +
                "                modifier = Modifier\n" +
                "                    .fillMaxHeight()\n" +
                "                    .padding(\n" +
                "                        start = 12.dp,\n" +
                "                        end = 16.dp,\n" +
                "                        top = 12.dp,\n" +
                "                        bottom = 12.dp\n" +
                "                    )\n" +
                "                    .animateContentSize(\n" +
                "                        animationSpec = tween(\n" +
                "                            durationMillis = 400,\n" +
                "                            easing = LinearOutSlowInEasing\n" +
                "                        )\n" +
                "                    )\n" +
                "            ){\n" +
                "                Icon(\n" +
                "                    painter = painterResource(id = R.drawable.google_btn),\n" +
                "                    contentDescription = null,\n" +
                "                    tint = Color.Unspecified)\n" +
                "                Spacer(modifier = Modifier.width(2.dp))\n" +
                "                Text(text = \"Sign In With Google\")\n" +
                "                Spacer(modifier = Modifier.width(5.dp))\n" +
                "                if(buttonclicke){\n" +
                "                    CircularProgressIndicator(\n" +
                "                        modifier = Modifier\n" +
                "                            .height(16.dp)\n" +
                "                            .width(16.dp),\n" +
                "                        strokeWidth = 2.dp,\n" +
                "                        color = Color.Green\n" +
                "                    )\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}")
    }
}