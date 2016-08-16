package com.decorator.text.textdecor

import android.text.style.CharacterStyle

interface Decoration {
    fun newDecorInstance(): CharacterStyle
}
