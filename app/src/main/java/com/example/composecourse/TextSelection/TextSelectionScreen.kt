package com.example.composecourse.TextSelection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composecourse.CodeCard.CodeCard

@Composable
fun TextSelection(){
    Surface {
        SelectionContainer {
            Column {
                Text(text = "Hello Android")
                DisableSelection {
                Text(text = "Hello Android")
                }
                Text(text = "Hello Android")
                
                CodeCard(code = "@Composable\n" +
                        "fun TextSelection(){\n" +
                        "    Surface {\n" +
                        "        SelectionContainer {\n" +
                        "            Column {\n" +
                        "                Text(text = \"Hello Android\")\n" +
                        "                DisableSelection {\n" +
                        "                Text(text = \"Hello Android\")\n" +
                        "                }\n" +
                        "                Text(text = \"Hello Android\")\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
            }
        }
    }
}

