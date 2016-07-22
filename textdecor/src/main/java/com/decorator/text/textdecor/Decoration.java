package com.decorator.text.textdecor;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;

public enum Decoration{
    UNDERLINE(new UnderlineSpan()),
    STRIKE(new StrikethroughSpan()),
    SUPERSKRIPT(new SuperscriptSpan()),
    SUBSCRIPT(new SubscriptSpan());

    private CharacterStyle characterStyle;

    Decoration(CharacterStyle span) {
        this.characterStyle = span;
    }

    public CharacterStyle getCharacterStyle() {
        return characterStyle;
    }
}
