package com.JD.lab5.data;

public class Coordinates implements Comparable<Coordinates> {
    private long x;
    private Float y;

    public Coordinates(long x, Float y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "" +
                "x=" + x +
                ", y=" + y;
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        return (int) ((x + y) - (coordinates.x + coordinates.y));
    }
}
