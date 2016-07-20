package com.decorator.text.textdecor;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.util.Size;

public class TextDecoration {

    private static int DEFAULT_ABSOLUTE_TEXT_SIZE = 25;
    private static float DEFAULT_RELATIVE_TEXT_SIZE = 1;



    private int textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
    private int textColor = Color.BLACK;
    private int backgroundColor = -1;
    private float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
    private int style = Typeface.NORMAL;
    private boolean underline = false;
    private boolean strike = false;
    private boolean superscript = false;
    private boolean subscript = false;

    private TextDecoration(Builder builder) {
        this.textSize = builder.textSize;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.textSizeRelative = builder.textSizeRelative;
        this.style = builder.style;
        this.underline = builder.underline;
        this.strike = builder.strike;
        this.superscript = builder.superscript;
        this.subscript = builder.subscript;
    }


    public static class Builder{
        private static TextDecoration textDecoration;

        private int textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
        private int textColor = Color.BLACK;
        private int backgroundColor = -1;
        private float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
        private int style = Typeface.NORMAL;
        private boolean underline = false;
        private boolean strike = false;
        private boolean superscript = false;
        private boolean subscript = false;


        public Builder setTextDecoration(TextDecoration textDecoration) {
            Builder.textDecoration = textDecoration;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setTextSizeRelative(float textSizeRelative) {
            this.textSizeRelative = textSizeRelative;
            return this;
        }

        public Builder setStyle(int style) {
            this.style = style;
            return this;
        }

        public Builder setUnderline(boolean underline) {
            this.underline = underline;
            return this;
        }

        public Builder setStrike(boolean strike) {
            this.strike = strike;
            return this;
        }

        public Builder setSuperscript(boolean superscript) {
            this.superscript = superscript;
            return this;
        }

        public Builder setSubscript(boolean subscript) {
            this.subscript = subscript;
            return this;
        }

        public TextDecoration build(){
            return new TextDecoration(this);
        }

    }

    protected void decorate(SpannableString spannableString, int index, int i) {
        spannableString.setSpan(new BackgroundColorSpan(backgroundColor),index,i, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(textSize),index,i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
