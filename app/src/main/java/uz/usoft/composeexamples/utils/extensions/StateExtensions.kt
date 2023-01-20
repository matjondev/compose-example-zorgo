package uz.usoft.composeexamples.utils.extensions

import androidx.compose.runtime.MutableState
import kotlin.reflect.KProperty

fun <T> MutableState<T>.update(body: (T) -> T) {
    this.value = body(value)
}
