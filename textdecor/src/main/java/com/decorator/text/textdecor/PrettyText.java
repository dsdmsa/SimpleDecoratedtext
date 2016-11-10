package com.decorator.text.textdecor;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PrettyText extends TextView {

    private StringBuilder stringBuilder = new StringBuilder();
    private List<DecorationData> decorationDates = new ArrayList<>();


    public PrettyText(Context context) {
        super(context);
    }

    public PrettyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrettyText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // TODO: 9/9/16 add add text dinamicly

    public void setText(Object... strings) {
        this.setMovementMethod(LinkMovementMethod.getInstance());

        decorateStrings(strings);

        SpannableString spannableString = new SpannableString(stringBuilder);

        for (DecorationData decorationData : decorationDates) {
            if (decorationData.getTextDecor() != null)
                decorationData.getTextDecor()
                        .decorateText(spannableString, decorationData.getCoordinates()[0],
                                decorationData.getCoordinates()[1]);
        }
        setText(spannableString);
    }

    private void decorateStrings(Object[] strings) {
        int index = 0;
        for (Object string : strings) {
            if (string instanceof TextDecor) {
                TextDecor textDecor = (TextDecor) string;
                String tempStr = textDecor.getText();
                stringBuilder.append(tempStr);
                decorationDates.add(new DecorationData(new int[]{index, index + tempStr.length()}, textDecor));
                index += tempStr.length();
            } else {
                stringBuilder.append((String) string);
                index += ((String) string).length();
            }
        }
    }
}
