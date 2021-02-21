package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public abstract class Command {
    ArrayList<String> arguments;
    TreeSet<SpaceMarine> target;
    Cmd curCMD;
    public Command(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        if(args != null) {
            arguments = new ArrayList<String>();
            arguments.addAll(Arrays.asList(args));
        }
        if (trg != null)
            target = trg;
        curCMD = cmd;
    }

    public abstract void execute();

}
