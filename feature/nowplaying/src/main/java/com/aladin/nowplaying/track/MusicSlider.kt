package com.aladin.nowplaying.track

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladin.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicSlider(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChange: (Float) -> Unit,
) {

    val activeGradient = Brush.horizontalGradient(
        listOf(Color(0xFF2566C9), Color(0xFF36C4F5))
    )

    Slider(
        value = value,
        onValueChange = onValueChange,
        track = {
            val progressFraction =
                (value - valueRange.start) / (valueRange.endInclusive - valueRange.start)

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            ) {
                val trackHeight = 4.dp.toPx()
                val sliderWidth = size.width
                val progressX = progressFraction * sliderWidth

                drawRoundRect(
                    brush = activeGradient,
                    cornerRadius = CornerRadius(30f, 30f),
                    size = Size(progressX, trackHeight)
                )
                drawRoundRect(
                    color = Color(0xFF14263C),
                    cornerRadius = CornerRadius(30f, 30f),
                    topLeft = Offset(progressX, 0f),
                    size = Size(sliderWidth - progressX, trackHeight)
                )
            }
        },
        thumb = {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .offset(y = 2.5.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color(0xFF36C4F5), Color(0xFF2566C9))
                        ),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = Color(0xFF14263B),
                            shape = CircleShape
                        )

                )
            }
        }
    )
}

@Preview
@Composable
private fun CustomPlayerPreview() {
    AppTheme {
        var value by remember { mutableFloatStateOf(0.5f) }
        MusicSlider(value = value) {
            value = it
        }
    }
}