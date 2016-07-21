package com.decorator.text.textdecor;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class RoundedBackgroundSpan extends ReplacementSpan
{

    private static final int CORNER_RADIUS = 20;
    private static final int PADDING_X = 12;

    private int   mBackgroundColor;
    private int   mTextColor;

    /**
     * @param backgroundColor background color
     * @param textColor       text color
     */
    public RoundedBackgroundSpan(int backgroundColor, int textColor) {
        mBackgroundColor = backgroundColor;
        mTextColor = textColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return (int) (PADDING_X + paint.measureText(text.subSequence(start, end).toString()) + PADDING_X);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float width = paint.measureText(text.subSequence(start, end).toString());
        Rect bounds = new Rect();
        paint.getTextBounds(text.toString(), start, end, bounds);
        RectF rect = new RectF(x, y-bounds.height(), x + width + 2 * PADDING_X, bottom+bounds.height());
        paint.setColor(mBackgroundColor);
        canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);
        paint.setColor(mTextColor);


//        canvas.drawText(text, canvasWidht >> 1, (canvasHeight + bounds.height()) >> 1, paint);

        canvas.drawText(text, start, end, x + PADDING_X, top, paint);
    }
}