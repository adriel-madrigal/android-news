package com.adrielmadrigal.androidnews.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.reactivex.rxjava3.core.Observable

@Composable
fun <T> Observable<T>.toComposeState(): State<T?> {
    val state = remember { mutableStateOf<T?>(null) }

    DisposableEffect(this) {
        val disposable = this@toComposeState.subscribe { result ->
            state.value = result
        }
        onDispose { disposable.dispose() }
    }

    return state
}