import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

enum class CardGradient(val brush: Brush) {
    BLUE(
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFF6671D3),
                Color(0xFF9F9FE2),
            )
        )
    ),

    RED(
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFB88BDB),
                Color(0xFFCF5942)
            )
        )
    ),

    YELLOW(
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFF9ED80),
                Color(0xFFDF832E),
            )
        )
    ),

    PINK(
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFCADFFF),
                Color(0xFF703AB5),
            )
        )
    ),

    GREEN(
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFB6FDDC),
                Color(0xFF396466),
            )
        )
    )
}