package com.decorator.text.textdecorator;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.decorator.text.textdecor.DecoratedText;
import com.decorator.text.textdecor.TextDecoration;
import com.decorator.text.textdecor.DecoratedTxt;

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

        final DecoratedTxt decor = new DecoratedTxt();
        decor.doNothing();


        decoratedText = (DecoratedText) findViewById(R.id.decor);

        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator(

        ));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();


                decoratedText.setText(
                        "a",
                        decor.text("b"),
                        "c",
                        decor.text("d"+value)
                );



            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();


    }
}
