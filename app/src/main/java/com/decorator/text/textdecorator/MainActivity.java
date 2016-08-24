package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.custom_decors.RoundedBackgroundSpan;

public class MainActivity extends AppCompatActivity {

    PrettyText prettyText;
    PrettyText prettyText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.textDecor);
        prettyText2 = (PrettyText) findViewById(R.id.textDecor2);

        TextDecor rbackg = new TextDecor(
                TextDecor.relativeTextSize(30),
                TextDecor.BOLD,
                TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.CENTER),
                TextDecor.font(this, "fonts/Roboto-Thin.ttf")
        );

        TextDecor siz = new TextDecor(
                TextDecor.setTextColor(Color.BLACK),
                TextDecor.absoluteTextSize(70),
                TextDecor.setBackground(Color.RED),
                TextDecor.UNDERLINE,
                TextDecor.STRINKE,
                TextDecor.BOLD
                );


        prettyText.setText(
                siz.withText("\nYou pucharse\n"),
                rbackg.withText("Yesterday\n"),
                siz.withText("please show this QR......\n"),
                " simple text ",
                rbackg.withText("\n\nanother"),
                siz.withText(" siz\n")
        );

    }
}
