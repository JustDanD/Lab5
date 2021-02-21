package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.TreeSet;

public class ExitCommand extends Command {
    public ExitCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }
    @Override
    public void execute() {
        System.out.println("Спасибо за визит! Хорошо вам провести время!");
        System.exit(0);
    }
}
