package uz.usoft.composeexamples.ui.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class ZorGoHeadlines(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = ZorGoFont,
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 38.sp,
            letterSpacing = (-0.5).sp
        ),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        h4: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
    ) : this(
        h1 = h1.withDefaultFontFamily(defaultFontFamily),
        h2 = h2.withDefaultFontFamily(defaultFontFamily),
        h3 = h3.withDefaultFontFamily(defaultFontFamily),
        h4 = h4.withDefaultFontFamily(defaultFontFamily),
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ZorGoHeadlines) return false

        if (h1 != other.h1) return false
        if (h2 != other.h2) return false
        if (h3 != other.h3) return false
        if (h4 != other.h4) return false

        return true
    }

    override fun hashCode(): Int {
        var result = h1.hashCode()
        result = 31 * result + h2.hashCode()
        result = 31 * result + h3.hashCode()
        result = 31 * result + h4.hashCode()

        return result
    }

    override fun toString(): String {
        return "ZorGoHeadlines(h1=$h1, h2=$h2, h3=$h3, h4=$h4)"
    }
}

internal val LocalZorGoHeadlines = staticCompositionLocalOf { ZorGoHeadlines() }
