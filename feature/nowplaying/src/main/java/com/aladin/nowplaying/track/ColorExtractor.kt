package com.aladin.nowplaying.track

import android.graphics.Bitmap
import android.graphics.Color
import androidx.palette.graphics.Palette
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal object ColorExtractor {
    suspend fun getDominantColor(bitmap: Bitmap): Int {
        return withContext(Dispatchers.IO) {
            val palette = Palette.from(bitmap).generate()
            palette.dominantSwatch?.rgb ?: Color.TRANSPARENT
        }
    }
}