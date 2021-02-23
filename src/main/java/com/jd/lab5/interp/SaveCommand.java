package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;
import com.jd.lab5.io.IO;

import java.util.TreeSet;
/**
 * @author Пименов Данила P3130
 * Команда сохранения коллекции в файл
 */
public class SaveCommand extends Command {
    public SaveCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        IO.writeTo("testfiles/out.csv", target);
    }
}