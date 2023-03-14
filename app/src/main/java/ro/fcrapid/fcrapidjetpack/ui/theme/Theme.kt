package ro.fcrapid.fcrapidjetpack.ui.theme

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val LightColors = lightColorScheme(
    primary = lightPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,
    inversePrimary = lightInversePrimary,
    onPrimary = lightOnPrimary,
    secondary = lightSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondary = lightOnSecondary,
    tertiary = lightTertiary,
    error = lightError,
    background = lightBackground,
    inverseSurface = lightInverseSurface,
    outline = lightOutline,
    outlineVariant = lightOutlineVariant,
    surfaceVariant = lightSurfaceVariant,
    surfaceTint = lightSurfaceTint,
    onSurface = lightOnSurface,
    onSurfaceVariant = lightOnSurfaceVariant
)


private val DarkColors = darkColorScheme(
    primary = darkPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,
    inversePrimary = darkInversePrimary,
    onPrimary = darkOnPrimary,
    secondary = darkSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondary = darkOnSecondary,
    tertiary = darkTertiary,
    error = darkError,
    background = darkBackground,
    inverseSurface = darkInverseSurface,
    outline = darkOutline,
    outlineVariant = darkOutlineVariant,
    surfaceVariant = darkSurfaceVariant,
    surfaceTint = darkSurfaceTint,
    onSurface = darkOnSurface,
    onSurfaceVariant = darkOnSurfaceVariant
)

@Composable
fun FcRapidJetpackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            //println
        }
        darkTheme -> {println("dark colors used")
            DarkColors
        }
        else -> {
            println("light colors used")
            LightColors
        }
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.background.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}