package com.decorator.text.textdecorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.decorator.text.textdecor.PrettyText;

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
                App.getAlCenter().withText("Lorem"), " ",
                App.getRoundCorrner2().withText("Ipsum"), " ",
                App.getRoundCorrner2().withText(" "), " ",
                App.getFONTANDUNDELINE().withText(" is simply dummy text"),
                " of the printing and typesetting industry.",
                App.getRoundRgadient().withText(" Lorem Ipsum "),
                "has been the industry's standard dummy text ever since the ",
                App.getRedBack().withText("1500s"),
                App.getShadowCol().withText(", when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the "),
                App.getRedBack().withText("1960s"),
                " with the release of ",
                App.getBold().withText("Letraset"),
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of ",
                App.getRoundRgadient().withText("Lorem Ipsum\n"),
                App.getAlRight().withText("right\n\n"),
                App.getAlRight().withText("right"),
                App.getAlLeft().withText("left\n"),
                App.getAlCenter().withText("center\n\n"),
                App.getIMAGE().withText("     "),
                "  \n",
                App.getClikable().withText("\n\n\n  asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),
                "\n\n",
                App.getTEST().withText("asddsfdgdfdgsdfgsdfgsd fg sdfg sdfg sdf gsd fg sd"),
                "\n"
        );

    }
}
