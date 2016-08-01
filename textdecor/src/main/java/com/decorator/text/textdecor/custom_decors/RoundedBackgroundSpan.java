package com.decorator.text.textdecor.custom_decors;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import android.util.Log;

public class RoundedBackgroundSpan extends ReplacementSpan {

    private static final String TAG = "tag";
    private int cornerRadius = 1;
    private int paddingX = 15;
    private int paddingY = 1;
    private int backgroundColor;
    private int textColor;
    private Gravity gravity = Gravity.DEFAULT;

    public RoundedBackgroundSpan(int cornerRadius, int paddingX, int backgroundColor, int textColor) {
        this.cornerRadius = cornerRadius;
        this.paddingX = paddingX;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    public RoundedBackgroundSpan(int cornerRadius, int paddingX,int backgroundColor, int textColor, Gravity gravity) {
        this.cornerRadius = cornerRadius;
        this.paddingX = paddingX;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.gravity = gravity;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return (int) (paddingX + paint.measureText(text.subSequence(start, end).toString()) + paddingX);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {

        float width = paint.measureText(text.subSequence(start, end).toString());


//        RectF rect = new RectF(x, top+top/4, x + width + 2 * paddingX, bottom);

        RectF rect = new RectF(
                x + gravity.getX(),
                top + top / gravity.getY(),
                x + width + 2 * paddingX,
                bottom + bottom / gravity.getY1()
        );
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
        paint.setColor(textColor);
        canvas.drawText(text,
                start,
                end,
                x + paddingX,
                y + y / gravity.getY1(),
                paint);

//        canvas.drawText(text, start - 10, end, x + paddingX, y, paint);
    }

    public enum Gravity {
        TOP(0, -8, 0, -4),
        BOTTOM(0, 4, 0, 99),
        CENTER(0, 9, 0, -9),
        DEFAULT(0, 99, 0, 99);

        int x;
        int y;
        int x1;
        int y1;

        Gravity(int x, int y, int x1, int y1) {
            this.x = x;
            this.y = y;
            this.x1 = x1;
            this.y1 = y1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }
    }
}