package uz.usoft.composeexamples.ui.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
class ZorGoField internal constructor(
    val text1: TextStyle,
    val text2: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = ZorGoFont,
        text1: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),
        text2: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp
        ),
    ) : this(
        text1 = text1.withDefaultFontFamily(defaultFontFamily),
        text2 = text2.withDefaultFontFamily(defaultFontFamily),
    )

    /**
     * Returns a copy of this Typography, optionally overriding some of the values.
     */
    fun copy(
        text1: TextStyle = this.text1,
        text2: TextStyle = this.text2,
    ): ZorGoField = ZorGoField(
        text1 = text1,
        text2 = text2,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ZorGoField) return false

        if (text1 != other.text1) return false
        if (text2 != other.text2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text1.hashCode()
        result = 31 * result + text2.hashCode()
        return result
    }

    override fun toString(): String {
        return "ZorGoField(text1=$text1, text2=$text2)"
    }
}

internal val LocalZorGoField = staticCompositionLocalOf { ZorGoField() }

