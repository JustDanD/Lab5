package com.JD.lab5;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<SpaceMarine> collection;
        collection = IO.readFrom("FILENAME");
        collection.add(new SpaceMarine("Lancaster", new Coordinates(1, 2F), 15D, 2, true, MeleeWeapon.POWER_FIST, new Chapter("name", "")));
        System.out.printf(collection.toString());
    }
}
