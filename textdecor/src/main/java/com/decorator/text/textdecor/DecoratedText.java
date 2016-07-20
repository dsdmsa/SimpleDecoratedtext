package com.decorator.text.textdecor;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.decorator.text.textdecor.txt.Decoration;

import java.util.ArrayList;
import java.util.List;

public class DecoratedText extends TextView {

    private static final String TAG = "text view";

    public DecoratedText(Context context) {
        super(context);
    }

    public DecoratedText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DecoratedText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public void setText(Object... o) {
//
//        DecoratedTextPiece decoratedText;
//
//        String s;
//
//        for (Object o1 : o) {
//
//            try {
//                decoratedText = (DecoratedTextPiece) o1;
//
//
//            } catch (Exception text) {
//                Log.d(TAG, "setText: error decor");
//            }
//
//            try {
//                s = (String) o1;
//
//            } catch (Exception e) {
//                Log.d(TAG, "setText: string");
//            }
//
//        }
//    }


    public void setText(CharSequence... text) {

        List<String> strings = new ArrayList<>();
        Decoration teDecoration;

        // List<Decoration> decoration = new ArrayList<>();
        SpannableString spannableString;
        spannableString = new SpannableString("");
        for (CharSequence charSequence : text) {
            if (charSequence instanceof Decoration) {
                teDecoration = (Decoration) charSequence;
                spannableString = new SpannableString(spannableString + teDecoration.getText());
                strings.add(((Decoration) charSequence).getText());
                Log.d(TAG, "setText: instance");
            }else{
                spannableString = new SpannableString(spannableString + (String)charSequence);
            }
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Decoration decoration1 : decoration) {
//            stringBuilder.append(decoration1.getText());
//        }
        setText(spannableString);

    }

//    public void setText(DecoratedTextPiece... textPieces) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        SpannableString spannableString;
//        for (DecoratedTextPiece textPiece : textPieces) {
//            stringBuilder.append(textPiece.getDecoratedText());
//        }
//        spannableString = new SpannableString(stringBuilder);
//
//        int index = 0;
//
//        for (DecoratedTextPiece textPiece : textPieces) {
//            if (textPiece.getTextDecoration() != null)
//                textPiece.getTextDecoration().decorate(spannableString, index, index + textPiece.getDecoratedText().length());
//            index += textPiece.getDecoratedText().length();
//        }
//
//        setText(spannableString);
//    }

}
