package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.util.TreeSet;
/**
 * @author Пименов Данила P3130
 * Команда, выводящая последние 5 введённых команд
 */
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