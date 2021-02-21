package com.JD.lab5;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;
import com.JD.lab5.io.IO;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<SpaceMarine> collection;
        collection = IO.readFrom("FILENAM");
        collection.add(new SpaceMarine("Lancaster", new Coordinates(1, 2F), 15D, 2, true, MeleeWeapon.POWER_FIST, new Chapter("name", "")));
        System.out.printf(collection.toString());
        IO.writeTo("src/test/testfiles/out1.csv", collection);
    }
}
