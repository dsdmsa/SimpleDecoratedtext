package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;

public class MainActivity extends AppCompatActivity {

    PrettyText prettyText;
    PrettyText prettyText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.textDecor);
        prettyText2 = (PrettyText) findViewById(R.id.textDecor2);

        TextDecor rbackg = new TextDecor.Builder()
                .decorate(TextDecor.Companion.UNDERLINE())
                .decorate(TextDecor.Companion.relativeTextSize(30))
//                .decorate(TextDecor.Companion.font(this, "fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.Companion.setBackground(Color.RED))
                .decorate(TextDecor.Companion.setTextColor(Color.BLACK))
                .decorate(TextDecor.Companion.BOLD())
                .build();

        TextDecor siz = new TextDecor.Builder()
//                .decorate(TextDecor.setTextColor(Color.WHITE))
//                .decorate(TextDecor.absoluteTextSize(70))
//                .decorate(TextDecor.setBackground(Color.RED))
//                .decorate(TextDecor.UNDERLINE)
//                .decorate(TextDecor.STRINKE)
//                .decorate(TextDecor.BOLD)
                .build();

        TextDecor col = new TextDecor.Builder()
//                .decorate(TextDecor.setBackground(Color.BLUE))
//                .decorate(TextDecor.setTextColor(Color.WHITE))
                .build();

        TextDecor round = new TextDecor.Builder()
//                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK))
                .build();

        TextDecor round1 = new TextDecor.Builder()
//                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.BOTTOM))
                .build();

        TextDecor round2 = new TextDecor.Builder()
//                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.TOP))
                .build();

        prettyText.setText(
                round.withText(" round "),
                siz.withText("\nYou pucharse\n"),
                rbackg.withText("Yesterday\n"),
                siz.withText("please show this QR......\n"),
                " simple text ",
                rbackg.withText("\n\nanother"),
                siz.withText(" siz\n"),
                col.withText(" col text \n")
        );

        prettyText2.setText( " ",
                round.withText(" round "),
                round1.withText(" round "),
                round2.withText(" round ")
        );

    }
}
