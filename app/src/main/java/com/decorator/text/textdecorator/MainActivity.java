package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.decors.DecorColor;
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
                .decorate(DecorText.SUPERSCRIPT)
//                .decorate(DecorSize.absoluteTextSize(25))
                .decorate(DecorColor.setRoundBackground(15,31,Color.BLACK,Color.RED))
                .build();

        TextDecor robofont = new TextDecor.Builder()
                .decorate(DecorFonts.font(this, "fonts/Roboto-Thin.ttf"))
                .decorate(DecorColor.setRoundBackground(30,30,Color.BLACK,Color.RED))
                .build();

        TextDecor withFont = new TextDecor.Builder()
                .decorate(DecorFonts.font(this, "fonts/doridrobot.ttf"))
                .decorate(DecorSize.absoluteTextSize(100))
                .build();

        TextDecor blueBack = new TextDecor.Builder()
                .decorate(DecorColor.setBackground(Color.BLUE))
                .decorate(DecorColor.setRoundBackground(30,30,Color.BLACK,Color.GREEN))
                .decorate(DecorColor.setTextColor(Color.GREEN))
                .build();

        TextDecor textMod = new TextDecor.Builder()
                .decorate(DecorText.ITALIC)
                .decorate(DecorColor.setRoundBackground(30,30,Color.BLACK,Color.RED))
                .decorate(DecorText.UNDERLINE)
                .build();

        prettyText.setText(
                "this is a simple text, with no decorations\n",
                blueBack.withText("this text is with blue backgrownd\n"),
                robofont.withText("fonts are cool to add\n"),
                textMod.withText("italic and underline easy way\n"),
                withFont.withText("ecuations :\n"),
                " 3 * 3 = 9"," or 3",power.withText("2\n")
        );

    }
}
