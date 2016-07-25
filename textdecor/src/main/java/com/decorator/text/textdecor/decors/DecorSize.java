package com.decorator.text.textdecor.decors;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;

import com.decorator.text.textdecor.Decoration;

public class DecorSize {
    public static Decoration absoluteTextSize(final int size){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new AbsoluteSizeSpan(size);
            }
        };
    }

    public  static Decoration relativeTextSize(final int size){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new AbsoluteSizeSpan(size);
            }
        };
    }
}
