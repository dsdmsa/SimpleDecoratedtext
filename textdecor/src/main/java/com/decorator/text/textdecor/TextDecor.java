package com.decorator.text.textdecor;

import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TextDecor {

    private static final String TAG = "DecorColor text";
    private String text;
    private List<String> strings = new ArrayList<>();

    private List<Decoration> characterStyles = new ArrayList<>();

    public TextDecor(Builder builder) {
        this.characterStyles = builder.decorations;
    }

    public String getText() {
        text = strings.get(0);
        Log.d(TAG, "getText: " + text + " " + characterStyles.size());
        strings.remove(0);
        return text;
    }

    public TextDecor withText(String text) {
        Log.d(TAG, "withText: ");
        strings.add(text);
        return this;
    }

    public void decorateText(SpannableString spannableString, int firstCharIndex, int lastCharIndex)  {

        Log.d(TAG, "decorateText: "+spannableString);

        for (Decoration characterStyle : characterStyles) {
            spannableString.setSpan(  characterStyle.newInstance(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        }
    }

    public static class Builder {
        private List<Decoration> decorations = new ArrayList<>();
        public Builder decorate(Decoration decoration) {
            decorations.add(decoration);
            return this;
        }

        public TextDecor build() {
            return new TextDecor(this);
        }
    }
}
