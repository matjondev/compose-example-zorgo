package uz.usoft.composeexamples.ui.theme.typography

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
class ZorGoBody internal constructor(
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = ZorGoFont,
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        ),
        body3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp
        ),
        body4: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            letterSpacing = 0.sp
        ),
    ) : this(
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
        body3 = body3.withDefaultFontFamily(defaultFontFamily),
        body4 = body4.withDefaultFontFamily(defaultFontFamily),
    )

    /**
     * Returns a copy of this Typography, optionally overriding some of the values.
     */
    fun copy(
        body1: TextStyle = this.body1,
        body2: TextStyle = this.body2,
        body3: TextStyle = this.body3,
        body4: TextStyle = this.body4,
    ): ZorGoBody = ZorGoBody(
        body1 = body1,
        body2 = body2,
        body3 = body3,
        body4 = body4,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ZorGoBody) return false

        if (body1 != other.body1) return false
        if (body2 != other.body2) return false
        if (body3 != other.body3) return false
        if (body4 != other.body4) return false

        return true
    }

    override fun hashCode(): Int {
        var result = body1.hashCode()
        result = 31 * result + body2.hashCode()
        result = 31 * result + body3.hashCode()
        result = 31 * result + body4.hashCode()
        return result
    }

    override fun toString(): String {
        return "ZorGoBody(body1=$body1, body2=$body2, body3=$body3, body4=$body4,)"
    }
}

internal val LocalZorGoBody = staticCompositionLocalOf { ZorGoBody() }
