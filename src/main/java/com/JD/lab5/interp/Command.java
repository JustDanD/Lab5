package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public abstract class Command {
    ArrayList<String> arguments;
    TreeSet<SpaceMarine> target;
    public Command(String[] args, TreeSet<SpaceMarine> trg) {
        if(args != null) {
            arguments = new ArrayList<String>();
            arguments.addAll(Arrays.asList(args));
        }
        if (trg != null)
            target = trg;
    }

    public abstract void execute();
}
