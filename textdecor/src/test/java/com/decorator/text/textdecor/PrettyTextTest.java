package com.decorator.text.textdecor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrettyTextTest {

    private static final String TEXT = "text";

    @Mock
    PrettyText prettyText ;

    @Test
    public void assertNull(){
        assertEquals(true,prettyText != null);
    }

}