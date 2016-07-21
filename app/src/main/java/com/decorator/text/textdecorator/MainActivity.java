package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.DecoratedText;
import com.decorator.text.textdecor.DecoratedTxt;

public class MainActivity extends AppCompatActivity {

    DecoratedText decoratedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decoratedText = (DecoratedText) findViewById(R.id.decor);
        final DecoratedTxt decor = new DecoratedTxt.Builder()
                .setBackgroundColor(Color.GREEN)
                .setStrike(true)
                .setTextColor(Color.BLACK)
                .setUnderline(true)
                .setTextSize(50)
                .build();

        final DecoratedTxt decor2 = new DecoratedTxt.Builder()
                .setTextSize(55)
                .build();

        decoratedText.setText(
                "a" ,
                decor.withText("bssafasdfasdfa" ),
                "c",
                decor2.withText("dewqqewcor 2 "),
                decor.withText("\ndsdfdsf")
        );

    }
}
