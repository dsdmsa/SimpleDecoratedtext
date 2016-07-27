package com.decorator.text.textdecor;

import android.text.SpannableString;
import android.text.Spanned;

import java.util.ArrayList;
import java.util.List;

public class TextDecor {
    private String text;
    private List<String> strings = new ArrayList<>();
    private List<Decoration> characterStyles = new ArrayList<>();

    private TextDecor(Builder builder) {
        this.characterStyles = builder.decorations;
    }

    String getText() {
        text = strings.get(0);
        strings.remove(0);
        return text;
    }

    public TextDecor withText(String text) {
        strings.add(text);
        return this;
    }

    void decorateText(SpannableString spannableString, int firstCharIndex, int lastCharIndex) {
        for (Decoration characterStyle : characterStyles) {
            spannableString.setSpan(characterStyle.newDecorInstance(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
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
