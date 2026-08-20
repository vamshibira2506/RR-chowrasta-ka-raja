package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = DeepRed,
    onPrimary = Color.White,
    primaryContainer = DeepRedContainer,
    onPrimaryContainer = OnDeepRedContainer,
    secondary = SaffronOrange,
    onSecondary = Color.White,
    secondaryContainer = SaffronContainer,
    onSecondaryContainer = OnSaffronContainer,
    tertiary = RoyalGold,
    onTertiary = Color.White,
    tertiaryContainer = RoyalGoldLight,
    onTertiaryContainer = RoyalGoldDark,
    background = CreamBackground,
    onBackground = TextPrimary,
    surface = CreamSurface,
    onSurface = TextPrimary,
    surfaceVariant = CreamSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = CreamCardBorder,
    outlineVariant = GoldBorder
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkDeepRed,
    onPrimary = DeepRedDark,
    primaryContainer = DeepRed,
    onPrimaryContainer = DeepRedContainer,
    secondary = DarkSaffron,
    onSecondary = OnSaffronContainer,
    secondaryContainer = SaffronOrange,
    onSecondaryContainer = SaffronContainer,
    tertiary = RoyalGold,
    onTertiary = Color.Black,
    tertiaryContainer = RoyalGoldDark,
    onTertiaryContainer = RoyalGoldLight,
    background = DarkBackground,
    onBackground = DarkTextPrimary,
    surface = DarkSurface,
    onSurface = DarkTextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkTextSecondary,
    outline = Color(0xFF423933),
    outlineVariant = Color(0xFF6B582F)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // We intentionally prioritize our authentic CYGM brand color palette
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
