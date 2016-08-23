package com.decorator.text.textdecor;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PrettyText extends TextView {

    public PrettyText(Context context) {
        super(context);
    }

    public PrettyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrettyText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(Object... strings) {
        TextDecor textDecor;
        SpannableString spannableString;
        StringBuilder stringBuilder = new StringBuilder();
        List<DecorationData> decorationDates = new ArrayList<>();

        int index = 0;
        String tempStr;

        for (Object string : strings) {
            if (string instanceof TextDecor) {
                textDecor = (TextDecor) string;
                tempStr = textDecor.getText();
                stringBuilder.append(tempStr);
                decorationDates.add(new DecorationData(new int[]{index, index + tempStr.length()}, textDecor));
                index += tempStr.length();
            } else {
                stringBuilder.append((String) string);
                index += ((String) string).length();
            }
        }

        spannableString = new SpannableString(stringBuilder);

        for (DecorationData decorationData : decorationDates) {
            if (decorationData.getTextDecor() != null)
                decorationData.getTextDecor().decorateText(spannableString, decorationData.getCoordinates()[0], decorationData.getCoordinates()[1]);
        }
        setText(spannableString);
    }
}
