package com.decorator.text.textdecor.decors;

import android.graphics.Typeface;
import android.text.style.CharacterStyle;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

import com.decorator.text.textdecor.Decoration;

public class DecorText {
    public static final Decoration UNDERLINE = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance(){
            return new UnderlineSpan();
        }
    };

    public static final Decoration STRINKE = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StrikethroughSpan();
        }
    };

    public static final Decoration SUBSCRIPT = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new SubscriptSpan();
        }
    };

    public static final Decoration SUPERSCRIPT = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new SuperscriptSpan();
        }
    };

    public static final Decoration BOLD = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.BOLD);
        }
    };

    public static final Decoration ITALIC = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.ITALIC);
        }
    };

    public static final Decoration ITALIC_BOLD = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.BOLD_ITALIC);
        }
    };

}
