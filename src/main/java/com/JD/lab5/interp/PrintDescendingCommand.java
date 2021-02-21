package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;
import com.JD.lab5.interp.Cmd;
import com.JD.lab5.interp.Command;

import java.lang.reflect.ParameterizedType;
import java.time.format.DateTimeFormatter;
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