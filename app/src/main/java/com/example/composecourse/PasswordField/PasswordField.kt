package com.example.composecourse.PasswordField

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.composecourse.CodeCard.CodeCard
import com.example.composecourse.R

@Composable
fun PasswordField() {
    var textValue by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    var icon =
        if (passwordVisibility) painterResource(id = R.drawable.baseline_visibility_24) else painterResource(
            id = R.drawable.baseline_visibility_off_24
        )
    Column {

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(painter = icon, contentDescription = "password visibility")
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        CodeCard(code = "fun PasswordField(){\n" +
                "    var textValue by rememberSaveable {\n" +
                "        mutableStateOf(\"\")\n" +
                "    }\n" +
                "    var passwordVisibility by remember {\n" +
                "        mutableStateOf(false)\n" +
                "    }\n" +
                "    var icon = if(passwordVisibility) painterResource(id = R.drawable.baseline_visibility_24) else painterResource(\n" +
                "        id = R.drawable.baseline_visibility_off_24\n" +
                "    )\n" +
                "\n" +
                "    OutlinedTextField(\n" +
                "        value = textValue,\n" +
                "        onValueChange = {\n" +
                "            textValue = it\n" +
                "        },\n" +
                "        placeholder = { Text(text = \"Password\")},\n" +
                "        label = { Text(text = \"Password\")},\n" +
                "        trailingIcon = {\n" +
                "            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {\n" +
                "                Icon(painter = icon, contentDescription = \"password visibility\")\n" +
                "            }\n" +
                "        },\n" +
                "        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),\n" +
                "        keyboardOptions = KeyboardOptions(\n" +
                "            keyboardType = KeyboardType.Password\n" +
                "        )\n" +
                "    )\n" +
                "}")
    }
}