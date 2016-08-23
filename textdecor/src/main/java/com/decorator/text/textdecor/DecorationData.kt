package com.decorator.text.textdecor

internal class DecorationData(coordinates: IntArray, var textDecor: TextDecor?) {
    var coordinates = IntArray(2)
    init {
        this.coordinates = coordinates
    }
}
