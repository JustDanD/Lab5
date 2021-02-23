package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.NavigableSet;
import java.util.TreeSet;

public class PrintDescendingCommand extends Command {
    public PrintDescendingCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        NavigableSet<SpaceMarine> descended = target.descendingSet();
        for (SpaceMarine marine : descended)
            System.out.print(marine.toString());
    }
}