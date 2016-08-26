package com.decorator.text.textdecor.spans;

public abstract class CharacterStyle implements Decoration<CharacterStyle>{

    @Override
    public CharacterStyle newDecorInstance() {
        return null;
    }
}
