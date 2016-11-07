package com.decorator.text.textdecorator;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;
import com.decorator.text.textdecor.custom_decors.Click;

import org.w3c.dom.Text;

import static com.decorator.text.textdecor.TextDecor.*;

public class MainActivity extends AppCompatActivity {

    public static TextDecor rbackg = new Builder()
            .decorate(relativeTextSize(30))
            .decorate(BOLD)
            .build();
    PrettyText prettyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prettyText = (PrettyText) findViewById(R.id.textDecor);


        TextDecor bold = new Builder()
                .decorate(BOLD)
                .build();

        TextDecor fontAndUndeline = new Builder()
                .decorate(font(this, "fonts/Roboto-Thin.ttf"))
                .decorate(UNDERLINE)
                .build();

        TextDecor roundRgadient = new Builder()
                .decorate(setRoundBackground(9, 2, new LinearGradient(0, 0, 545, 545, Color.CYAN, Color.BLUE, Shader.TileMode.CLAMP), Color.BLACK))
                .decorate(BOLD)
                .build();

        TextDecor redBack = new Builder()
                .decorate(BOLD)
                .decorate(setTextColor(Color.RED))
                .decorate(setBackground(Color.BLACK))
                .decorate(absoluteTextSize(50))
                .build();

        TextDecor shadowCol = new Builder()
                .decorate(addShadow(2, 2, 5, Color.BLACK))
                .decorate(absoluteTextSize(40))
                .build();

        TextDecor alRight = new Builder()
                .decorate(alignCenter())
                .build();

        TextDecor alLeft = new Builder()
                .decorate(alignLeft())
                .build();

        TextDecor alCenter = new Builder()
                .decorate(alignRight())
                .build();

        TextDecor image = new Builder()
                .decorate(replaceTextWithImage(this, R.drawable.tst, 300))
                .decorate(alignRight())
                .build();

        TextDecor clikable = new Builder()
                .decorate(clickableText(new Click(Color.BLACK, Color.CYAN) {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),"toast",Toast.LENGTH_LONG).show();
                    }
                }))
                .build();


        TextDecor test = new Builder()
                .decorate(alignLeft())
                .decorate(test(getBaseContext(),R.drawable.im,200, 1 ))
                .build();


        TextDecor roundCorrner = new Builder()
                .decorate(setRoundBackground(15,1,Color.YELLOW,Color.BLACK))
                .build();

        TextDecor roundCorrner2 = new Builder()
                .decorate(setRoundBackground(0,1,Color.YELLOW,Color.BLACK))
                .build();

        prettyText.setText(
                roundCorrner.withText("Lorem")," ",
                roundCorrner2.withText("Ipsum")," ",
                roundCorrner2.withText(" ")," ",
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

                alRight.withText("right\n/n\n"),
                alRight.withText("right"),
                alLeft.withText("left\n"),
                alCenter.withText("center\n/n\n"),
                image.withText("     "),

                "  \n",

                clikable.withText("\n\n\n  asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),

                "\n\n",

                test.withText("asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),

                "\n"
        );

    }
}
