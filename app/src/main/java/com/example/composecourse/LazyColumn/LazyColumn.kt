package com.example.composecourse.LazyColumn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composecourse.CodeCard.CodeCard
import com.example.composecourse.ui.theme.color1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumn1(
    navController: NavController
){
    val sections = listOf("A", "B", "C")

        LazyColumn() {
            sections.forEach { section->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color1),
                        text = section)
                }
                items(5){
                    Text(modifier = Modifier
                        .clickable {
                        }
                        .padding(5.dp)
                        .fillMaxWidth(),
                        text = "Item $it from the section $section")
                }
            }
        }
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
