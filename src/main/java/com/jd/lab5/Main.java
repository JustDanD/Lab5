package com.jd.lab5;

import com.jd.lab5.data.SpaceMarine;
import com.jd.lab5.interp.Cmd;
import com.jd.lab5.io.IO;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<SpaceMarine> collection;
        collection = IO.readFrom("FILENAME");
        Cmd console = new Cmd(collection, true, null);
        console.listen();
    }
}
