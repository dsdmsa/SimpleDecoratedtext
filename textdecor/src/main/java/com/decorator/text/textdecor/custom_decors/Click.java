package com.decorator.text.textdecor.custom_decors;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class Click extends ClickableSpan {

    private int textColor = -1;
    private int backColor = -1;

    public Click(int textColor, int backColor) {
        this.textColor = textColor;
        this.backColor = backColor;
    }

    public Click() {
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        if (textColor != -1) {
            ds.bgColor = backColor;
            ds.setColor(textColor);
        }
    }

}
