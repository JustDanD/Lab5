package com.jd.lab5;

import com.jd.lab5.data.SpaceMarine;
import com.jd.lab5.interp.Cmd;
import com.jd.lab5.io.IO;

import java.util.TreeSet;

/**
 * @autor Пименов Данила, P3130
 * Класс-инициализатор.
 * Содержит метод main без параметров и без вовзращаемого значения
 */
public class Main {
    public static void main(String[] args) {
        TreeSet<SpaceMarine> collection;
        collection = IO.readFrom("FILENAM");
        Cmd console = new Cmd(collection, true, null);
        console.listen();
    }
}
