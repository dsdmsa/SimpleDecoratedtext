package com.decorator.text.textdecorator;

import android.app.Application;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.Toast;

import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.custom_decors.Click;


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
                .decorate(TextDecor.replaceTextWithImage(getBaseContext(), R.drawable.tst, 300))
                .decorate(TextDecor.alignRight())
                .build();

        FONTANDUNDELINE = new TextDecor.Builder()
                .decorate(TextDecor.font(getBaseContext(), "fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.UNDERLINE)
                .build();

        TEST = new TextDecor.Builder()
                .decorate(TextDecor.alignLeft())
                .decorate(TextDecor.test(getBaseContext(), R.drawable.im, 200, 1))
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
            .decorate(TextDecor.relativeTextSize(30))
            .decorate(TextDecor.BOLD)
            .build();

    public static TextDecor bold = new TextDecor.Builder()
            .decorate(TextDecor.BOLD)
            .decorate(TextDecor.absoluteTextSize(100))
            .build();


    public static TextDecor roundRgadient = new TextDecor.Builder()
            .decorate(TextDecor.setRoundBackground(9, 2, new LinearGradient(0, 0, 545, 545, Color.CYAN, Color.BLUE, Shader.TileMode.CLAMP), Color.BLACK))
            .decorate(TextDecor.BOLD)
            .build();

    public static TextDecor redBack = new TextDecor.Builder()
            .decorate(TextDecor.BOLD)
            .decorate(TextDecor.setTextColor(Color.RED))
            .decorate(TextDecor.setBackground(Color.BLACK))
            .decorate(TextDecor.absoluteTextSize(50))
            .build();

    public static TextDecor shadowCol = new TextDecor.Builder()
            .decorate(TextDecor.addShadow(2, 2, 5, Color.BLACK))
            .decorate(TextDecor.absoluteTextSize(40))
            .build();

    public static TextDecor alRight = new TextDecor.Builder()
            .decorate(TextDecor.alignCenter())
            .build();

    public static TextDecor alLeft = new TextDecor.Builder()
            .decorate(TextDecor.alignLeft())
            .build();

    public static TextDecor alCenter = new TextDecor.Builder()
            .decorate(TextDecor.alignRight())
            .build();

    public static TextDecor clikable = new TextDecor.Builder()
            .decorate(TextDecor.clickableText(new Click(Color.BLACK, Color.CYAN) {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "toast", Toast.LENGTH_LONG).show();
                }
            }))
            .build();




    public static TextDecor roundCorrner = new TextDecor.Builder()
            .decorate(TextDecor.setRoundBackground(15, 1, Color.YELLOW, Color.BLACK))
            .build();

    public static TextDecor roundCorrner2 = new TextDecor.Builder()
            .decorate(TextDecor.setRoundBackground(0, 1, Color.YELLOW, Color.BLACK))
            .build();

}
