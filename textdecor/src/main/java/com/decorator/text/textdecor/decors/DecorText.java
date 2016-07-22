package com.decorator.text.textdecor.decors;

import android.text.style.CharacterStyle;
import android.text.style.StrikethroughSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;

import com.decorator.text.textdecor.Decoration;

public class DecorText {
    public static final Decoration UNDERLINE = new Decoration() {
        @Override
        public CharacterStyle newInstance(){
            return new UnderlineSpan();
        }
    };

    public static final Decoration STRINKE = new Decoration() {
        @Override
        public CharacterStyle newInstance() {
            return new StrikethroughSpan();
        }
    };

    public static final Decoration SUBSCRIPT = new Decoration() {
        @Override
        public CharacterStyle newInstance() {
            return new SuperscriptSpan();
        }
    };

}
