package com.decorator.text.textdecor;

public class DecorationData {
    private int[] coordinates = new int[2];
    private DecoratedTxt decoratedTxt;

    public DecorationData(int[] coordinates, DecoratedTxt decoratedTxt) {
        this.coordinates = coordinates;
        this.decoratedTxt = decoratedTxt;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public DecoratedTxt getDecoratedTxt() {
        return decoratedTxt;
    }

    public void setDecoratedTxt(DecoratedTxt decoratedTxt) {
        this.decoratedTxt = decoratedTxt;
    }
}
