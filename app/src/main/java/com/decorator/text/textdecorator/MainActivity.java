package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.Decor;

public class MainActivity extends AppCompatActivity {

    PrettyText prityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prityText = (PrettyText) findViewById(R.id.decor);
        final Decor decor = new Decor.Builder()
                .setBackgroundColor(Color.GREEN)
                .setStrike()
                .setTextColor(Color.BLACK)
                .setUnderline()
                .setTextSize(80)
                .build();

        final Decor decor2 = new Decor.Builder()
                .setTextSizeRelative(2)
                .build();

        prityText.setText(
                "a" ,
                decor.withText("bssafasdfasdfa" ),
                "c",
                decor2.withText("dewqqewcor 2 "),
                decor.withText("\ndsdfdsf")
        );

    }
}
