package com.decorator.text.textdecor.txt;

import java.util.StringTokenizer;

public class Decoration  implements CharSequence{
    private String text;


    public String getText() {
        return text;
    }

    public Decoration text(String text) {
        this.text = text;
        return this;
    }

    public void doNothing(){

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }
}
