package com.example.flightsrecomendationsapp.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

object Coroutines {
    fun io(work: suspend (() -> Unit)) = CoroutineScope(IO).launch {
        work()
    }
    fun main(work: suspend (() -> Unit)) = CoroutineScope(Main).launch {
        work()
    }
}