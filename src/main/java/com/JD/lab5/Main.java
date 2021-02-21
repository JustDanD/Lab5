package com.JD.lab5;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;
import com.JD.lab5.interp.Cmd;
import com.JD.lab5.io.IO;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<SpaceMarine> collection;
        collection = IO.readFrom("FILENAM");
        Cmd console = Cmd.initCmd(collection);
        console.listen();
    }
}
