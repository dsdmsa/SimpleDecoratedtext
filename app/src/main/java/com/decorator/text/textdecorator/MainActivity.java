package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.custom_decors.RoundedBackgroundSpan;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static TextDecor rbackg = new TextDecor.Builder()
            .decorate(TextDecor.relativeTextSize(30))
            .decorate(TextDecor.BOLD)
            .build();
    PrettyText prettyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.textDecor);


        TextDecor bold = new TextDecor.Builder()
                .decorate(TextDecor.BOLD)
                .build();
        TextDecor fontAndUndeline = new TextDecor.Builder()
                .decorate(TextDecor.font(this,"fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.UNDERLINE)
                .build();
        TextDecor roundRgadient = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(9,2, new LinearGradient(0,0,545,545,Color.CYAN,Color.BLUE, Shader.TileMode.CLAMP),Color.BLACK))
                .decorate(TextDecor.BOLD)
                .build();
        TextDecor redBack = new TextDecor.Builder()
                .decorate(TextDecor.BOLD)
                .decorate(TextDecor.setTextColor(Color.RED))
                .decorate(TextDecor.setBackground(Color.BLACK))
                .decorate(TextDecor.absoluteTextSize(50))
                .build();

        TextDecor shadowCol = new TextDecor.Builder()
                .decorate(TextDecor.addShadow(2,2,5,Color.BLACK))
                .decorate(TextDecor.absoluteTextSize(40))
                .build();

        TextDecor alRight = new TextDecor.Builder()
                .decorate(TextDecor.alignCenter())
                .build();

        TextDecor alLeft = new TextDecor.Builder()
                .decorate(TextDecor.alignLeft())
                .build();

        TextDecor alCenter = new TextDecor.Builder()
                .decorate(TextDecor.alignRight())
                .build();

        TextDecor test = new TextDecor.Builder()
                .decorate(TextDecor.test(this))
                .build();

        prettyText.setText(
                roundRgadient.withText("Lorem Ipsum"),
                fontAndUndeline.withText(" is simply dummy text"),
                " of the printing and typesetting industry.",
                roundRgadient.withText(" Lorem Ipsum "),
                "has been the industry's standard dummy text ever since the ",
                redBack.withText("1500s"),
                shadowCol.withText(", when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the "),
                redBack.withText("1960s"),
                " with the release of ",
                bold.withText("Letraset"),
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of ",
                roundRgadient.withText("Lorem Ipsum\n"),

                alRight.withText("right\n"),
                alRight.withText("right\n"),
                alLeft.withText("left\n"),
                alCenter.withText("center\n"),

                "\n\n",

//                test.withText("asdsd"),

                "\n"
        );

    }
}
