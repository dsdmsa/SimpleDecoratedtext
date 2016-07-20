package com.decorator.text.textdecor;

public class DecoratedTextPiece {
    private String decoratedText;
    private TextDecoration textDecoration;


    public DecoratedTextPiece(String decoratedText) {
        this.decoratedText = decoratedText;
    }

    public DecoratedTextPiece(String decoratedText, TextDecoration textDecoration) {
        this.decoratedText = decoratedText;
        this.textDecoration = textDecoration;
    }

    public String getDecoratedText() {
        return decoratedText;
    }

    public TextDecoration getTextDecoration() {
            return textDecoration;
    }
}
