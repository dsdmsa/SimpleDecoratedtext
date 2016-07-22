package com.decorator.text.textdecor;

public class DecorationData {
    private int[] coordinates = new int[2];
    private TextDecor textDecor;

    public DecorationData(int[] coordinates, TextDecor textDecor) {
        this.coordinates = coordinates;
        this.textDecor = textDecor;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public TextDecor getTextDecor() {
        return textDecor;
    }

    public void setTextDecor(TextDecor textDecor) {
        this.textDecor = textDecor;
    }
}
