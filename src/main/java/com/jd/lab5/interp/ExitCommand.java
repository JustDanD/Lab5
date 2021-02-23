package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.util.TreeSet;

public class ExitCommand extends Command {
    public ExitCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        System.out.println("Спасибо за визит! Хорошо вам провести время!");
        System.exit(0);
    }
}
