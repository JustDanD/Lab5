package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;
import com.JD.lab5.io.IO;

import java.util.TreeSet;

public class SaveCommand extends Command {
    public SaveCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        IO.writeTo("src/test/testfiles/out.csv", target);
    }
}