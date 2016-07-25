package com.decorator.text.textdecor.decors;

import android.content.Context;
import android.text.style.CharacterStyle;

import com.decorator.text.textdecor.Decoration;
import com.decorator.text.textdecor.utils.CustomTypefaceSpan;
import com.decorator.text.textdecor.utils.FontUtil;

public class DecorFonts {

    public static Decoration font(final Context context, final String font){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new CustomTypefaceSpan(font,FontUtil.get(context,font));
            }
        };
    }

}
