package com.decorator.text.textdecor;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Decor {

    private static final String TAG = "decor text";
    private String text;
    private List<String> strings = new ArrayList<>();

    private List<Decoration> decorations = new ArrayList<>();
    private List<CharacterStyle> characterStyles = new ArrayList<>();

    public Decor(Builder builder) {
        this.decorations = builder.decorations;
        this.characterStyles = builder.characterStyles;
    }

    public String getText() {
        text = strings.get(0);
        Log.d(TAG, "getText: " + text);
        strings.remove(0);
        return text;
    }

    public Decor withText(String text) {
        Log.d(TAG, "withText: ");
        strings.add(text);
        return this;
    }

    public void decorateText(SpannableString spannableString, int firstCharIndex, int lastCharIndex) {

        Log.d(TAG, "decorateText: "+spannableString);

        for (CharacterStyle characterStyle : characterStyles) {
            spannableString.setSpan(characterStyle, firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        for (Decoration decoration : decorations) {
            spannableString.setSpan(decoration.getCharacterStyle(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }


    }

    public static class Builder {
        private List<Decoration> decorations = new ArrayList<>();
        private List<CharacterStyle> characterStyles = new ArrayList<>();

        public Builder decorate(Decoration decoration) {
            decorations.add(decoration);
            return this;
        }

        public Builder decorate(CharacterStyle characterStyle){
            characterStyles.add(characterStyle);
            return this;
        }

        public Decor build() {
            return new Decor(this);
        }
    }
}
