package com.decorator.text.textdecor.decors;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.TypefaceSpan;

import com.decorator.text.textdecor.Decoration;
import com.decorator.text.textdecor.utils.FontUtil;

public class DecorFonts {

    public static Decoration font(final Context context, final String font){
        return new Decoration() {
            @Override
            public CharacterStyle newInstance() {
                return new TypefaceSpan(FontUtil.get(context,font).toString());
            }
        };
    }

}
