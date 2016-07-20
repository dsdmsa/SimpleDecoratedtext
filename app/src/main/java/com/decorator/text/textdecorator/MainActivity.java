package com.decorator.text.textdecorator;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.decorator.text.textdecor.DecoratedText;
import com.decorator.text.textdecor.DecoratedTextPiece;
import com.decorator.text.textdecor.TextDecoration;
import com.decorator.text.textdecor.txt.Decoration;

public class MainActivity extends AppCompatActivity {

    DecoratedText decoratedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextDecoration textDecoration = new TextDecoration.Builder()
                .setBackgroundColor(Color.CYAN)
                .setTextSize(50)
                .build();


        decoratedText = (DecoratedText) findViewById(R.id.decor);

//        ValueAnimator animator = ValueAnimator.ofInt(0, 9000);
//        animator.setDuration(3000);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator(
//
//        ));
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Integer value = (Integer) animation.getAnimatedValue();
//
//
//                decoratedText.setText(
//                        new DecoratedTextPiece(" text \n"),
//                        new DecoratedTextPiece(" another ", new TextDecoration.Builder()
//                                .setBackgroundColor(Color.GREEN)
//                                .setTextSize(value/50)
//                                .build()),
//                        new DecoratedTextPiece(" \n text \n ", textDecoration),
//                        new DecoratedTextPiece(" \n text  " + value, textDecoration),
//                        new DecoratedTextPiece("  text \n "),
//                        new DecoratedTextPiece(" \n text \n ", textDecoration)
//                );
//
//
//            }
//        });
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.start();

        Decoration head = new Decoration();
        head.doNothing();



        decoratedText.setText(
                "thirst",
                head.text(" tx t \n"),
                "aaaaa\n",
                head.text(" decor "),
                "last"
        );

    }
}
