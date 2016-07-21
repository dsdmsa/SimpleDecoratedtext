package com.decorator.text.textdecor;

public class DecorationData {
    private int[] coordinates = new int[2];
    private Decor decor;

    public DecorationData(int[] coordinates, Decor decor) {
        this.coordinates = coordinates;
        this.decor = decor;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public Decor getDecor() {
        return decor;
    }

    public void setDecor(Decor decor) {
        this.decor = decor;
    }
}
