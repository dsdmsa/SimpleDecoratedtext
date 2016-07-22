package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.decorator.text.textdecor.Decor;
import com.decorator.text.textdecor.Decoration;
import com.decorator.text.textdecor.PrettyText;

public class MainActivity extends AppCompatActivity {

    PrettyText prettyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.decor);
        Decor decor = new Decor.Builder()
                .decorate(Decoration.UNDERLINE)
                .decorate(Decoration.STRIKE)
                .decorate(new BackgroundColorSpan(Color.CYAN))
                .build();

        Decor decor2 = new Decor.Builder()
                .decorate(new BackgroundColorSpan(Color.RED))
                .decorate(new ForegroundColorSpan(Color.BLUE))
                .build();

        Decor decor3 = new Decor.Builder()
                .decorate(new ForegroundColorSpan(Color.GREEN))
                .build();

        prettyText.setText(
                " 12 ",
                decor3.withText("text"),
                decor.withText("  34  "),
                decor2.withText(" 56 "),
                decor.withText("  78  "),
                decor2.withText(" 90 ")
        );

    }
}
