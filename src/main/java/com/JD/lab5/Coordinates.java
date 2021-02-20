package com.JD.lab5;

public class Coordinates implements Comparable<Coordinates>{
    private long x;
    private Float y; // != NULL

    public Coordinates(long x, Float y) {
        if (y == null)
            System.exit(0); //Exception
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        return (int)((x + y) - (coordinates.x + coordinates.y));
    }
}
