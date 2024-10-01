package com.example.composecourse.CoilImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.ImageResult
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.composecourse.CodeCard.CodeCard
import com.example.composecourse.R


@Preview(showBackground = true)
@Composable
fun CoilImage(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://play-lh.googleusercontent.com/pMMOIP8F9rHUF-IMNr3Y4qCr7xdtlRonKpmIEDXUG0R_iZ7rHiCSEs_k8m2cv5Wm33M")
                    .size(Size.ORIGINAL)
                    .error(R.drawable.google_btn)
                    .crossfade(1000)
                    .transformations(
                        CircleCropTransformation(),
                        RoundedCornersTransformation()
                    )
                    .build()
            )
            val painterState = painter.state
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            if (painterState is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator()
            }
        }
        CodeCard(code = "fun CoilImage(){\n" +
                "    Box(modifier = Modifier\n" +
                "        .height(150.dp)\n" +
                "        .width(150.dp)){\n" +
                "        val painter = rememberAsyncImagePainter(\n" +
                "            model = ImageRequest.Builder(LocalContext.current)\n" +
                "                .data(\"https://play-lh.googleusercontent.com/pMMOIP8F9rHUF-IMNr3Y4qCr7xdtlRonKpmIEDXUG0R_iZ7rHiCSEs_k8m2cv5Wm33M\")\n" +
                "                .size(Size.ORIGINAL)\n" +
                "                .error(R.drawable.google_btn)\n" +
                "                .crossfade(1000)\n" +
                "                .transformations(\n" +
                "                    CircleCropTransformation(),\n" +
                "                    RoundedCornersTransformation()\n" +
                "                )\n" +
                "                .build())\n" +
                "        val painterState = painter.state\n" +
                "        Image(painter = painter,\n" +
                "            contentDescription = null,\n" +
                "            modifier = Modifier.fillMaxSize())\n" +
                "        if(painterState is AsyncImagePainter.State.Loading){\n" +
                "            CircularProgressIndicator()\n" +
                "        }\n" +
                "    }\n" +
                "}")
    }
}