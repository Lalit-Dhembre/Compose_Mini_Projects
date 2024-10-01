package com.example.composecourse.LazyColumn

import androidx.compose.runtime.Composable
import com.example.composecourse.CodeCard.CodeCard


@Composable
fun CodeCardOfLazyColumn(){
    CodeCard(code = "fun LazyColumn1(){\n" +
            "    val sections = listOf(\"A\", \"B\", \"C\")\n" +
            "\n" +
            "    Column {\n" +
            "        LazyColumn() {\n" +
            "            sections.forEach { section->\n" +
            "                stickyHeader {\n" +
            "                    Text(\n" +
            "                        modifier =Modifier\n" +
            "                            .fillMaxWidth()\n" +
            "                            .background(color1),\n" +
            "                        text = section)\n" +
            "                }\n" +
            "                items(5){\n" +
            "                    Text(modifier = Modifier\n" +
            "                        .clickable { }\n" +
            "                        .padding(5.dp)\n" +
            "                        .fillMaxWidth(),\n" +
            "                        text = \"Item \$it from the section \$section\")\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}")
}