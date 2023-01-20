package uz.usoft.composeexamples.utils

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation() : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val trimmed = if (text.text.length >= 9) text.text.substring(0..8) else text.text
        val annotatedString = AnnotatedString.Builder().run {
            append(Constants.PHONE_CODE)
            //##.###.##.##
            for (i in trimmed.indices) {
                append(trimmed[i])
                if (i == 1 || i == 4 || i == 6) {
                    append(' ')
                }
            }
            toAnnotatedString()
        }

        return TransformedText(annotatedString, phoneNumberOffsetTranslator)
    }

    private val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            //##.###.##.## -> +998 ## ### ## ##
            if (offset <= 1) return offset + 5
            if (offset <= 4) return offset + 1 + 5
            if (offset <= 6) return offset + 2 + 5
            if (offset <= 9) return offset + 3 + 5
            return 12 + 5
        }

        override fun transformedToOriginal(offset: Int): Int {
            //+998 ## ### ## ##
            if (offset == 5) return 0
            if (offset <= 6) return offset - 5
            if (offset <= 9) return offset - 1 - 5
            if (offset <= 11) return offset - 2 - 5
            if (offset <= 14) return offset - 3 - 5
            return 9
        }
    }

}
