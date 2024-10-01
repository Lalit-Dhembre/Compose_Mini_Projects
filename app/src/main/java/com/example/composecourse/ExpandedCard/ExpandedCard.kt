package com.example.composecourse.ExpandedCard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecourse.CodeCard.CodeCard

@Preview
@Composable
fun ExpandedCard() {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "My Title",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(6f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(
                        onClick = { expandedState = !expandedState },
                        modifier = Modifier
                            .alpha(0.5f)
                            .rotate(rotationState)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                        )
                    }
                    if (expandedState) {
                        Text(
                            text = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque " +
                                    "corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in ",
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
        CodeCard(
            code = "fun ExpandedCard(){\n" +
                    "    var expandedState by remember {\n" +
                    "        mutableStateOf(false)\n" +
                    "    }\n" +
                    "    val rotationState by animateFloatAsState(\n" +
                    "        targetValue = if (expandedState) 180f else 0f)\n" +
                    "    Card(\n" +
                    "        modifier = Modifier\n" +
                    "            .fillMaxWidth()\n" +
                    "            .animateContentSize(\n" +
                    "                animationSpec = tween(\n" +
                    "                    durationMillis = 300,\n" +
                    "                    easing = LinearOutSlowInEasing\n" +
                    "                )\n" +
                    "            ),\n" +
                    "        onClick = {\n" +
                    "            expandedState = !expandedState\n" +
                    "        }\n" +
                    "    ) {\n" +
                    "        Column(\n" +
                    "            modifier = Modifier\n" +
                    "                .fillMaxWidth()\n" +
                    "                .padding(12.dp),\n" +
                    "        ) {\n" +
                    "            Row(\n" +
                    "                verticalAlignment = Alignment.CenterVertically\n" +
                    "            ){\n" +
                    "                Text(text = \"My Title\",\n" +
                    "                    fontSize = 20.sp,\n" +
                    "                    fontWeight = FontWeight.Bold,\n" +
                    "                    modifier = Modifier.weight(6f),\n" +
                    "                    maxLines = 1,\n" +
                    "                    overflow = TextOverflow.Ellipsis\n" +
                    "                )\n" +
                    "                IconButton(onClick = { expandedState = !expandedState },\n" +
                    "                    modifier = Modifier\n" +
                    "                        .alpha(0.5f)\n" +
                    "                        .rotate(rotationState)) {\n" +
                    "                Icon(imageVector = Icons.Filled.ArrowDropDown,\n" +
                    "                    contentDescription = null,)\n" +
                    "            }\n" +
                    "                if(expandedState){\n" +
                    "                    Text(text = \"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque \" +\n" +
                    "                            \"corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in \",\n" +
                    "                        maxLines = 4,\n" +
                    "                        overflow = TextOverflow.Ellipsis\n" +
                    "                        )\n" +
                    "                }\n" +
                    "                }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}"
        )
    }
}
