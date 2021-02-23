package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.util.TreeSet;

public class HistoryCommand extends Command {
    public HistoryCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        for (int i = 0; i < curCMD.getCommandHistory().size(); i++) {
            System.out.println(curCMD.getCommandHistory().get(i));
            if (i >= 5)
                break;
        }
    }
}