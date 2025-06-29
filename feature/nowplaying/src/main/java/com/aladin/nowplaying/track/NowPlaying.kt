package com.aladin.nowplaying.track

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladin.nowplaying.R
import com.aladin.ui.theme.AppTheme
import com.aladin.ui.theme.primaryLight
import com.aladin.ui.theme.tertiaryLight

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
fun PlayerControl() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 40.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.shuffle),
            contentDescription = null
        )
        Icon(
            painter = painterResource(R.drawable.fast_rewind),
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
        Control()
        Icon(
            painter = painterResource(R.drawable.fast_forward),
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
        Icon(
            painter = painterResource(R.drawable.repeat),
            contentDescription = null
        )
    }
}

@Composable
fun Control() {
    var isPlaying by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Red)
            .size(
                70.dp
            )
            .background(color = MaterialTheme.colorScheme.tertiary)
            .clickable {
                isPlaying = !isPlaying
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(if (isPlaying) R.drawable.play else R.drawable.pause),
            contentDescription = null,
        )
    }
}

@Composable
fun MusicProgressBar(
    progress: Float, // de 0f a 1f
    onSeekChanged: (Float) -> Unit
) {
    Slider(
        value = progress,
        onValueChange = onSeekChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.primary,
            activeTrackColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
private fun MusicProgressBarPreview() {
    AppTheme {
        var progress by remember { mutableStateOf(0.3f) }

        Column {
            MusicProgressBar(progress = progress) { newValue ->
                progress = newValue
                // Aqui você atualiza o player (ExoPlayer, MediaPlayer, etc)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "${(progress * 100).toInt()}% reproduzido")
        }
    }
}

@Preview
@Composable
private fun PlayerControlPreview() {
    AppTheme {
        PlayerControl()
    }
}

@Preview
@Composable
private fun ControlPreview() {
    AppTheme {
        Control()
    }

}