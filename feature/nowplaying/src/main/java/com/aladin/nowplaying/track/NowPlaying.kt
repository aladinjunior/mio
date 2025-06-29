package com.aladin.nowplaying.track

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladin.nowplaying.R

@Composable
fun NowPlaying() {
    val context = LocalContext.current
    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, R.drawable.tiger)
    }

    var color by remember { mutableStateOf(Color.Black) }

    LaunchedEffect(bitmap) {
        val extractedColor = ColorExtractor.getDominantColor(bitmap)
        color = Color(extractedColor)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "Sample Image",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun PlayerControl(modifier: Modifier = Modifier) {
    Row {
        Icon(
            painter = painterResource(R.drawable.shuffle),
            contentDescription = ""
        )
    }
}

@Composable
fun Control(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Red)
            .size(
                70.dp
            )
            .background(color = Color)

    )
}

@Preview
@Composable
private fun ControlPreview() {
    Control()
}
