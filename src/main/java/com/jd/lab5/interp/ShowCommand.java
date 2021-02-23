package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.TreeSet;

public class ShowCommand extends Command {
    public ShowCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        for (SpaceMarine marine : super.target)
            System.out.print(marine.toString());
    }
}