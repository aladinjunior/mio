package com.aladin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aladin.ui.R

val SpartansFontFamily = FontFamily(
    Font(R.font.spartan, FontWeight.Normal),
    Font(R.font.spartan_medium, FontWeight.Medium),
    Font(R.font.spartan_semibold, FontWeight.SemiBold),
    Font(R.font.spartan_bold, FontWeight.Bold),
    Font(R.font.spartan_extrabold, FontWeight.ExtraBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    labelSmall = TextStyle(
        fontFamily = SpartansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = SpartansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = SpartansFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 15.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = SpartansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = SpartansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
    )
)