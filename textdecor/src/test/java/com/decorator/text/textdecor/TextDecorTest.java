package com.decorator.text.textdecor;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class TextDecorTest {

    private static final String TEXT = "text";

     TextDecor textDecor = new TextDecor.Builder().build();

    @Test public void buildTextDecor(){
        assertNotNull(textDecor);
    }

    @Test public void getSameText(){
        textDecor.withText(TEXT);
        assertEquals(TEXT,textDecor.getText());
    }

    @Test public void addingTest(){
        textDecor.withText(TEXT);
        assertEquals(TEXT.length(),textDecor.getText().length());
        textDecor.withText(TEXT);
        textDecor.withText(TEXT);
        assertEquals(TEXT.length()*2,textDecor.getText().length() + textDecor.getText().length());
    }


}