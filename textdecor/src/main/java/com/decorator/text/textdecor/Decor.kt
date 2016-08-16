package com.decorator.text.textdecor

import android.text.style.CharacterStyle
import android.text.style.UnderlineSpan

/**
 * Created by dsdmsa on 8/16/16.
 */

 object UNDERLINE:Decoration {
    override fun newDecorInstance(): CharacterStyle {
        return UnderlineSpan()
    }
}