package com.decorator.text.textdecor.custom_decors;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class ShadowSpan extends CharacterStyle {

    private float dx;
    private float dy;
    private float radius;
    private int color;

    public ShadowSpan(float dx, float dy, float radius, int color) {
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(radius,dx,dy,color);
    }
}
