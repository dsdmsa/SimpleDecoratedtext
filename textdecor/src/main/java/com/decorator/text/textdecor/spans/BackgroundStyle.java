package com.decorator.text.textdecor.spans;

import com.decorator.text.textdecor.custom_decors.BackgroundSpannable;

public abstract class BackgroundStyle implements Decoration<BackgroundSpannable> {

    @Override
    public BackgroundSpannable newDecorInstance() {
        return null;
    }
}
