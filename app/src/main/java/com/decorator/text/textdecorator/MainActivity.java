package com.decorator.text.textdecorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.decorator.text.textdecor.PrettyText;

import static com.decorator.text.textdecorator.App.FONTANDUNDELINE;
import static com.decorator.text.textdecorator.App.IMAGE;
import static com.decorator.text.textdecorator.App.TEST;
import static com.decorator.text.textdecorator.App.alCenter;
import static com.decorator.text.textdecorator.App.alLeft;
import static com.decorator.text.textdecorator.App.alRight;
import static com.decorator.text.textdecorator.App.bold;
import static com.decorator.text.textdecorator.App.clikable;
import static com.decorator.text.textdecorator.App.redBack;
import static com.decorator.text.textdecorator.App.roundCorrner;
import static com.decorator.text.textdecorator.App.roundCorrner2;
import static com.decorator.text.textdecorator.App.roundRgadient;
import static com.decorator.text.textdecorator.App.shadowCol;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        PrettyText prettyText = (PrettyText) findViewById(R.id.textDecor);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new RVdapter());

        prettyText.setText(
                roundCorrner.withText("Lorem"), " ",
                roundCorrner2.withText("Ipsum"), " ",
                roundCorrner2.withText(" "), " ",
                FONTANDUNDELINE.withText(" is simply dummy text"),
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
                alRight.withText("right\n\n"),
                alRight.withText("right"),
                alLeft.withText("left\n"),
                alCenter.withText("center\n\n"),
                IMAGE.withText("     "),
                "  \n",
                clikable.withText("\n\n\n  asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),
                "\n\n",
                TEST.withText("asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),
                "\n"
        );

    }
}
