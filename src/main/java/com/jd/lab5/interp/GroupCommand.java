package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда группировки по значению heartCount
 */
public class GroupCommand extends Command {
    public GroupCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        int[] groups = new int[4];

        for (SpaceMarine marine : target)
            groups[(int) (marine.getHeartCount())]++;
        for (int i = 1; i <= 3; i++)
            System.out.println((i) + "-" + groups[i]);
    }
}