package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import com.decorator.text.textdecor.Decoration;

public class Cl  implements Decoration {

    @Override
    public CharacterStyle newInstance() {
        return new ForegroundColorSpan(Color.CYAN);
    }
}
