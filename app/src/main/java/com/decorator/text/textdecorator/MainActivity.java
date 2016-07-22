package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.decors.DecorColor;
import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.decors.DecorFonts;
import com.decorator.text.textdecor.decors.DecorSize;
import com.decorator.text.textdecor.decors.DecorText;

public class MainActivity extends AppCompatActivity {

    PrettyText prettyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.textDecor);

        TextDecor power = new TextDecor.Builder()
                .decorate(DecorText.SUBSCRIPT)
                .decorate(DecorSize.absoluteTextSize(25))
                .build();

        TextDecor redback = new TextDecor.Builder()
                .decorate(DecorColor.setBackground(Color.BLUE))
                .decorate(DecorColor.setTextColor(Color.GREEN))
                .decorate(DecorFonts.font(this,"fonts/Roboto-Thin.ttf"))
                .decorate(DecorText.UNDERLINE)
                .build();

        TextDecor withFont = new TextDecor.Builder()
                .decorate(DecorColor.setBackground(Color.GREEN))
                .decorate(DecorText.BOLD)
                .decorate(DecorFonts.font(this, "fonts/doridrobot.ttf"))
                .build();


            prettyText.setText(
                    withFont.withText("text with font\n"),
                   " 3 * 3 = ",
                    redback.withText("9"),
                    " or 3",
                    power.withText("2")
            );

    }
}
