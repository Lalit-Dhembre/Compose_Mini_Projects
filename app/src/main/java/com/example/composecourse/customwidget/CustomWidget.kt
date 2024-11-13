package com.example.composecourse.customwidget

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composecourse.CodeCard.CodeCard


@Composable
fun CustomWidgetScreen(){
    var state by remember {
        mutableStateOf("0")
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        CustomWidget(
            indicatorValue = if(state.isBlank()) 0 else state.toInt()
        )
        OutlinedTextField(
            value = state,
            onValueChange = {state = it},
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        CodeCard(code = "@Composable\n" +
                "fun CustomWidgetScreen(){\n" +
                "    var state by remember {\n" +
                "        mutableStateOf(\"0\")\n" +
                "    }\n" +
                "    Column(modifier = Modifier.fillMaxSize(),\n" +
                "        verticalArrangement = Arrangement.Center,\n" +
                "        horizontalAlignment = Alignment.CenterHorizontally) {\n" +
                "        CustomWidget(\n" +
                "            indicatorValue = if(state.isBlank()) 0 else state.toInt()\n" +
                "        )\n" +
                "        OutlinedTextField(\n" +
                "            value = state,\n" +
                "            onValueChange = {state = it},\n" +
                "            maxLines = 1,\n" +
                "            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)\n" +
                "        )\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "@Composable\n" +
                "fun CustomWidget(\n" +
                "    canvasSize: Dp = 300.dp,\n" +
                "    indicatorValue: Int,\n" +
                "    maxIndicatorValue: Int = 100,\n" +
                "    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),\n" +
                "    backgroundIndicatorStrokeWidth: Float = 100f,\n" +
                "    foregroundIndicatorColor : Color = MaterialTheme.colorScheme.tertiary,\n" +
                "    bigTextFontSize: TextStyle = MaterialTheme.typography.bodyLarge,\n" +
                "    bigTextColor: Color = MaterialTheme.colorScheme.onSurface,\n" +
                "    bigTextSuffix: String = \"GB\",\n" +
                "    smallText: String = \"Remaining\",\n" +
                "    smallTextFontSize: TextStyle = MaterialTheme.typography.bodySmall,\n" +
                "    smallTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)\n" +
                "){\n" +
                "    var allowedValue by remember {\n" +
                "        mutableStateOf(maxIndicatorValue)\n" +
                "    }\n" +
                "\n" +
                "    allowedValue = if(indicatorValue > maxIndicatorValue){ maxIndicatorValue} else{ indicatorValue }\n" +
                "    val animatedIndicatorValue = remember{ Animatable(initialValue = 0f) }\n" +
                "\n" +
                "    LaunchedEffect(key1 = allowedValue) {\n" +
                "        animatedIndicatorValue.animateTo(targetValue = indicatorValue.toFloat())\n" +
                "    }\n" +
                "    val percentage = (animatedIndicatorValue.value/maxIndicatorValue) * 100\n" +
                "    val sweepAngle by animateFloatAsState(\n" +
                "        targetValue = (2.4 * percentage).toFloat(),\n" +
                "        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)\n" +
                "    )\n" +
                "\n" +
                "    val receivedValue by animateFloatAsState(\n" +
                "        targetValue = allowedValue.toFloat(),\n" +
                "        animationSpec = tween(1000)\n" +
                "    )\n" +
                "    Column(\n" +
                "        modifier = Modifier\n" +
                "            .size(canvasSize)\n" +
                "            .drawBehind {\n" +
                "                val componentSize = size / 1.25f\n" +
                "                backgroundIndicator(\n" +
                "                    componentSize = componentSize,\n" +
                "                    indicatorColor = backgroundIndicatorColor,\n" +
                "                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth\n" +
                "                )\n" +
                "                foregroundIndicator(\n" +
                "                    sweepAngle = sweepAngle,\n" +
                "                    componentSize = componentSize,\n" +
                "                    indicatorColor = foregroundIndicatorColor,\n" +
                "                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth\n" +
                "                )\n" +
                "            },\n" +
                "            verticalArrangement = Arrangement.Center,\n" +
                "        horizontalAlignment = Alignment.CenterHorizontally\n" +
                "    ) {\n" +
                "        EmbeddedText(\n" +
                "            bigText = receivedValue.toInt().toString(),\n" +
                "            bigTextFontSize = bigTextFontSize,\n" +
                "            bigTextColor = bigTextColor,\n" +
                "            bigTextSuffix = bigTextSuffix,\n" +
                "            smallText = smallText,\n" +
                "            smallTextFontSize = smallTextFontSize,\n" +
                "            smallTextColor =smallTextColor\n" +
                "        )\n" +
                "    }\n" +
                "}\n" +
                "@Composable\n" +
                "fun EmbeddedText(\n" +
                "    bigText: String,\n" +
                "    bigTextFontSize: TextStyle,\n" +
                "    bigTextColor: Color,\n" +
                "    bigTextSuffix: String,\n" +
                "    smallText: String,\n" +
                "    smallTextFontSize: TextStyle,\n" +
                "    smallTextColor: Color,\n" +
                "){\n" +
                "    Text(\n" +
                "        text = smallText,\n" +
                "        color = smallTextColor,\n" +
                "        style = smallTextFontSize,\n" +
                "        textAlign = TextAlign.Center)\n" +
                "\n" +
                "    Text(\n" +
                "        text = \"\$bigText \${bigTextSuffix.take(2)}\",\n" +
                "        color = bigTextColor,\n" +
                "        style = bigTextFontSize,\n" +
                "        textAlign = TextAlign.Center\n" +
                "    )\n" +
                "}\n" +
                "\n" +
                "fun DrawScope.backgroundIndicator(\n" +
                "    componentSize: Size,\n" +
                "    indicatorColor : Color,\n" +
                "    indicatorStrokeWidth: Float\n" +
                "){\n" +
                "    drawArc(\n" +
                "        size = componentSize,\n" +
                "        color = indicatorColor,\n" +
                "        startAngle = 150f,\n" +
                "        sweepAngle = 240f,\n" +
                "        useCenter = false,\n" +
                "        style = Stroke(\n" +
                "            width = indicatorStrokeWidth,\n" +
                "            cap = StrokeCap.Round\n" +
                "        ),\n" +
                "        topLeft = Offset(\n" +
                "            x = (size.width - componentSize.width)/2f,\n" +
                "            y = (size.height - componentSize.height)/2f\n" +
                "        )\n" +
                "    )\n" +
                "}\n" +
                "\n" +
                "fun DrawScope.foregroundIndicator(\n" +
                "    sweepAngle: Float,\n" +
                "    componentSize: Size,\n" +
                "    indicatorColor : Color,\n" +
                "    indicatorStrokeWidth: Float\n" +
                "){\n" +
                "    drawArc(\n" +
                "        size = componentSize,\n" +
                "        color = indicatorColor,\n" +
                "        startAngle = 150f,\n" +
                "        sweepAngle = sweepAngle,\n" +
                "        useCenter = false,\n" +
                "        style = Stroke(\n" +
                "            width = indicatorStrokeWidth,\n" +
                "            cap = StrokeCap.Round\n" +
                "        ),\n" +
                "        topLeft = Offset(\n" +
                "            x = (size.width - componentSize.width)/2f,\n" +
                "            y = (size.height - componentSize.height)/2f\n" +
                "        )\n" +
                "    )\n" +
                "}")
    }
}

@Composable
fun CustomWidget(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
    backgroundIndicatorStrokeWidth: Float = 100f,
    foregroundIndicatorColor : Color = MaterialTheme.colorScheme.tertiary,
    bigTextFontSize: TextStyle = MaterialTheme.typography.bodyLarge,
    bigTextColor: Color = MaterialTheme.colorScheme.onSurface,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining",
    smallTextFontSize: TextStyle = MaterialTheme.typography.bodySmall,
    smallTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
){
    var allowedValue by remember {
        mutableStateOf(maxIndicatorValue)
    }

    allowedValue = if(indicatorValue > maxIndicatorValue){ maxIndicatorValue} else{ indicatorValue }
    val animatedIndicatorValue = remember{ Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = allowedValue) {
        animatedIndicatorValue.animateTo(targetValue = indicatorValue.toFloat())
    }
    val percentage = (animatedIndicatorValue.value/maxIndicatorValue) * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
    )

    val receivedValue by animateFloatAsState(
        targetValue = allowedValue.toFloat(),
        animationSpec = tween(1000)
    )
    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
            },
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmbeddedText(
            bigText = receivedValue.toInt().toString(),
            bigTextFontSize = bigTextFontSize,
            bigTextColor = bigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = smallText,
            smallTextFontSize = smallTextFontSize,
            smallTextColor =smallTextColor
        )
    }
}
@Composable
fun EmbeddedText(
    bigText: String,
    bigTextFontSize: TextStyle,
    bigTextColor: Color,
    bigTextSuffix: String,
    smallText: String,
    smallTextFontSize: TextStyle,
    smallTextColor: Color,
){
    Text(
        text = smallText,
        color = smallTextColor,
        style = smallTextFontSize,
        textAlign = TextAlign.Center)

    Text(
        text = "$bigText ${bigTextSuffix.take(2)}",
        color = bigTextColor,
        style = bigTextFontSize,
        textAlign = TextAlign.Center
    )
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor : Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y = (size.height - componentSize.height)/2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor : Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y = (size.height - componentSize.height)/2f
        )
    )
}

@Preview
@Composable
fun CustomWidgetPreview(){
    CustomWidgetScreen()
}