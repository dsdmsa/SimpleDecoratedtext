package com.decorator.text.textdecor;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DecoratedTxt {

    private static final String TAG = "decor text";
    private static int DEFAULT_ABSOLUTE_TEXT_SIZE = 25;
    private static float DEFAULT_RELATIVE_TEXT_SIZE = 1;
    private String text;
    private int index = 0;
    private List<String> strings = new ArrayList<>();
    private int textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
    private int textColor = Color.BLACK;
    private int backgroundColor = -1;
    private float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
    private int style = Typeface.NORMAL;
    private boolean underline = false;
    private boolean strike = false;
    private boolean superscript = false;
    private boolean subscript = false;
    private TypefaceSpan typeface;
    private boolean roundedbackgroundSpan = false;

    public DecoratedTxt(Builder builder) {
        this.textSize = builder.textSize;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.textSizeRelative = builder.textSizeRelative;
        this.style = builder.style;
        this.underline = builder.underline;
        this.strike = builder.strike;
        this.superscript = builder.superscript;
        this.subscript = builder.subscript;
        this.typeface = builder.typeface;
        this.roundedbackgroundSpan = builder.roundedbackgroundSpan;
    }

    public String getText() {
        text = strings.get(0);
        Log.d(TAG, "getText: " + text);
        strings.remove(0);
        return text;
    }

    public DecoratedTxt withText(String text) {
        Log.d(TAG, "withText: ");
        strings.add(text);
        return this;
    }

    public void decorateText(SpannableString spannableString, int firstCharIndex, int lastCharIndex) {
        spannableString.setSpan(new BackgroundColorSpan(backgroundColor), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(textSize), firstCharIndex, lastCharIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(textColor), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(textSizeRelative), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        if (underline) {
            spannableString.setSpan(new UnderlineSpan(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        if (strike) {
            spannableString.setSpan(new StrikethroughSpan(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        if (superscript) {
            spannableString.setSpan(new SuperscriptSpan(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        if (subscript) {
            spannableString.setSpan(new SubscriptSpan(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        // TODO: 7/21/16 rise performance with hashmap
        if (typeface != null) {
            spannableString.setSpan(typeface, firstCharIndex, lastCharIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (roundedbackgroundSpan){
            spannableString.setSpan(new RoundedBackgroundSpan(Color.GREEN,Color.RED), firstCharIndex, lastCharIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        spannableString.setSpan(new RoundedCornersBackgroundSpan(15,4),firstCharIndex,lastCharIndex,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    public static class Builder {
        private static DecoratedTxt textDecoration;

        private int textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
        private int textColor = Color.BLACK;
        private int backgroundColor = -1;
        private float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
        private int style = Typeface.NORMAL;
        private boolean underline = false;
        private boolean strike = false;
        private boolean superscript = false;
        private boolean subscript = false;
        private TypefaceSpan typeface;
        private boolean roundedbackgroundSpan = false;

        public Builder setRoundedbackgroundSpan() {
            this.roundedbackgroundSpan = true;
            return this;
        }

        public Builder setTypeface(TypefaceSpan typeface) {
            this.typeface = typeface;
            return this;
        }

        public Builder setTextDecoration(DecoratedTxt textDecoration) {
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

        public DecoratedTxt build() {
            return new DecoratedTxt(this);
        }

    }
}
