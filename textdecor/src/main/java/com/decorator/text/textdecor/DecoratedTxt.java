package com.decorator.text.textdecor;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;

import java.util.ArrayList;
import java.util.List;

public class DecoratedTxt {
    private String text;
    private int index = 0;
    private List<String> strings = new ArrayList<>();


    public String getText() {
        if (strings.size() > 0) {
            text = strings.get(0);
            strings.remove(0);
        }
        return text;
    }

    public DecoratedTxt text(String text) {
        strings.add(text);
        return this;
    }

    public void decorateText(SpannableString spannableString, int first, int last) {
        spannableString.setSpan(new BackgroundColorSpan(Color.CYAN), first, last, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(55), first, last, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public void doNothing() {

    }
}
