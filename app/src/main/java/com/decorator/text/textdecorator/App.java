package com.decorator.text.textdecorator;

import android.app.Application;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.Toast;

import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.custom_decors.Click;

import static com.decorator.text.textdecor.TextDecor.BOLD;
import static com.decorator.text.textdecor.TextDecor.UNDERLINE;
import static com.decorator.text.textdecor.TextDecor.absoluteTextSize;
import static com.decorator.text.textdecor.TextDecor.addShadow;
import static com.decorator.text.textdecor.TextDecor.alignCenter;
import static com.decorator.text.textdecor.TextDecor.alignLeft;
import static com.decorator.text.textdecor.TextDecor.alignRight;
import static com.decorator.text.textdecor.TextDecor.clickableText;
import static com.decorator.text.textdecor.TextDecor.font;
import static com.decorator.text.textdecor.TextDecor.relativeTextSize;
import static com.decorator.text.textdecor.TextDecor.replaceTextWithImage;
import static com.decorator.text.textdecor.TextDecor.setBackground;
import static com.decorator.text.textdecor.TextDecor.setRoundBackground;
import static com.decorator.text.textdecor.TextDecor.setTextColor;
import static com.decorator.text.textdecor.TextDecor.test;

/**
 * Created by winify on 5/31/17.
 */

public class App extends Application{

    // context needed
    public static TextDecor IMAGE;
    public static TextDecor FONTANDUNDELINE;
    public static TextDecor TEST;
    public static  TextDecor decor2;

    @Override
    public void onCreate() {
        super.onCreate();

        decor2 = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(9,1,new LinearGradient(45,1,1,5,Color.CYAN,Color.BLUE, Shader.TileMode.CLAMP),Color.BLACK))
                .decorate(TextDecor.absoluteTextSize(35))
                .decorate(TextDecor.font(getBaseContext(), "fonts/Roboto-Thin.ttf"))
                .build();
        IMAGE = new TextDecor.Builder()
                .decorate(replaceTextWithImage(getBaseContext(), R.drawable.tst, 300))
                .decorate(alignRight())
                .build();

        FONTANDUNDELINE = new TextDecor.Builder()
                .decorate(font(getBaseContext(), "fonts/Roboto-Thin.ttf"))
                .decorate(UNDERLINE)
                .build();

        TEST = new TextDecor.Builder()
                .decorate(alignLeft())
                .decorate(test(getBaseContext(), R.drawable.im, 200, 1))
                .build();

    }

    public static  TextDecor line = new TextDecor.Builder()
            .decorate(TextDecor.setBackground(Color.WHITE))
            .decorate(TextDecor.setTextColor(Color.BLACK))
            .decorate(TextDecor.BOLD)
            .decorate(TextDecor.STRINKE)
            .build();

    public static  TextDecor decor1 = new TextDecor.Builder()
            .decorate(TextDecor.setBackground(Color.BLUE))
            .decorate(TextDecor.UNDERLINE)
            .decorate(TextDecor.addShadow(4,4,5,Color.BLACK))
            .decorate(TextDecor.setTextColor(Color.GREEN))
            .build();


    public static TextDecor rbackg = new TextDecor.Builder()
            .decorate(relativeTextSize(30))
            .decorate(BOLD)
            .build();

    public static TextDecor bold = new TextDecor.Builder()
            .decorate(BOLD)
            .decorate(TextDecor.absoluteTextSize(100))
            .build();


    public static TextDecor roundRgadient = new TextDecor.Builder()
            .decorate(setRoundBackground(9, 2, new LinearGradient(0, 0, 545, 545, Color.CYAN, Color.BLUE, Shader.TileMode.CLAMP), Color.BLACK))
            .decorate(BOLD)
            .build();

    public static TextDecor redBack = new TextDecor.Builder()
            .decorate(BOLD)
            .decorate(setTextColor(Color.RED))
            .decorate(setBackground(Color.BLACK))
            .decorate(absoluteTextSize(50))
            .build();

    public static TextDecor shadowCol = new TextDecor.Builder()
            .decorate(addShadow(2, 2, 5, Color.BLACK))
            .decorate(absoluteTextSize(40))
            .build();

    public static TextDecor alRight = new TextDecor.Builder()
            .decorate(alignCenter())
            .build();

    public static TextDecor alLeft = new TextDecor.Builder()
            .decorate(alignLeft())
            .build();

    public static TextDecor alCenter = new TextDecor.Builder()
            .decorate(alignRight())
            .build();

    public static TextDecor clikable = new TextDecor.Builder()
            .decorate(clickableText(new Click(Color.BLACK, Color.CYAN) {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "toast", Toast.LENGTH_LONG).show();
                }
            }))
            .build();




    public static TextDecor roundCorrner = new TextDecor.Builder()
            .decorate(setRoundBackground(15, 1, Color.YELLOW, Color.BLACK))
            .build();

    public static TextDecor roundCorrner2 = new TextDecor.Builder()
            .decorate(setRoundBackground(0, 1, Color.YELLOW, Color.BLACK))
            .build();

}
