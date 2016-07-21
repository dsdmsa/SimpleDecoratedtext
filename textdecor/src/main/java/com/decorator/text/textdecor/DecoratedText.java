package com.decorator.text.textdecor;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DecoratedText extends TextView {

    private static final String TAG = "withText view";

    public DecoratedText(Context context) {
        super(context);
    }

    public DecoratedText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DecoratedText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setText(Object... strings) {

        DecoratedTxt decoratedTxt;
        SpannableString spannableString;

        StringBuilder stringBuilder = new StringBuilder();

        List<DecorationData> decorationDates = new ArrayList<>();

        int index = 0;
        String tempStr;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] instanceof DecoratedTxt) {
                decoratedTxt = (DecoratedTxt) strings[i];
                tempStr = decoratedTxt.getText();
                stringBuilder.append(tempStr);
                decorationDates.add(new DecorationData(new int[]{index, index + tempStr.length()}, decoratedTxt));
                index += tempStr.length();
            } else {
                stringBuilder.append((String) strings[i]);
                index += ((String) strings[i]).length();
            }
        }


        spannableString = new SpannableString(stringBuilder);

        for (DecorationData decorationData : decorationDates) {
            Log.d(TAG, "setText: "+ decorationData.getCoordinates()[0]+ " " + decorationData.getCoordinates()[1]);
            decorationData.getDecoratedTxt().decorateText(spannableString, decorationData.getCoordinates()[0], decorationData.getCoordinates()[1]);
        }

        setText(spannableString);

    }

}
