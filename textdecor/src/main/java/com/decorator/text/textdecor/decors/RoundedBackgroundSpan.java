package com.decorator.text.textdecor.decors;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class RoundedBackgroundSpan extends ReplacementSpan {

    private int cornerRadius;
    private int paddingX;
    private int backgroundColor;
    private int textColor;

    public RoundedBackgroundSpan(int cornerRadius, int paddingX, int backgroundColor, int textColor) {
        this.cornerRadius = cornerRadius;
        this.paddingX = paddingX;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return (int) (paddingX + paint.measureText(text.subSequence(start, end).toString()) + paddingX);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float width = paint.measureText(text.subSequence(start, end).toString());
        RectF rect = new RectF(x, top, x + width + 2 * paddingX, bottom);
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
        paint.setColor(textColor);
        canvas.drawText(text, start, end, x + paddingX, y, paint);
    }
}