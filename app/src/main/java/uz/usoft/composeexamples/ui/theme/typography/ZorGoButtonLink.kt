package uz.usoft.composeexamples.ui.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
class ZorGoButtonLink internal constructor(
    val normal: TextStyle,
    val medium: TextStyle,
    val small: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        normal: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),
        medium: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        ),
        small: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp
        ),
    ) : this(
        normal = normal.withDefaultFontFamily(defaultFontFamily),
        medium = medium.withDefaultFontFamily(defaultFontFamily),
        small = small.withDefaultFontFamily(defaultFontFamily),
    )

    fun copy(
        normal: TextStyle = this.normal,
        medium: TextStyle = this.medium,
        small: TextStyle = this.small,
    ): ZorGoButtonLink = ZorGoButtonLink(
        normal = normal,
        medium = medium,
        small = small,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ZorGoButtonLink) return false

        if (normal != other.normal) return false
        if (medium != other.medium) return false
        if (small != other.small) return false

        return true
    }

    override fun hashCode(): Int {
        var result = normal.hashCode()
        result = 31 * result + medium.hashCode()
        result = 31 * result + small.hashCode()
        return result
    }

    override fun toString(): String {
        return "ZorGoButtonLink(normal=$normal, medium=$medium, small=$small,)"
    }
}

internal val LocalZorGoButtonLink = staticCompositionLocalOf { ZorGoButtonLink() }

