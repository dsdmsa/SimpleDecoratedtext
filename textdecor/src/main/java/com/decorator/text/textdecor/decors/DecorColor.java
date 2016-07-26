package com.decorator.text.textdecor.decors;

import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import com.decorator.text.textdecor.Decoration;

public class DecorColor {

    public static Decoration setTextColor(final int color) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new ForegroundColorSpan(color);
            }
        };
    }

    public static Decoration setBackground(final int color) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new BackgroundColorSpan(color);
            }
        };
    }

    public static Decoration setRoundBackground(final int corner, final int padding, final int backgroundColor, final int textColor) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new RoundedBackgroundSpan(corner, padding, backgroundColor, textColor);
            }
        };
    }
}
