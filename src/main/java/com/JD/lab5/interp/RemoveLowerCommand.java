package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        int cnt = 0;
        SpaceMarine newMarine = Generators.marineGenerate();
        Iterator iterator = target.iterator();
        while(iterator.hasNext()) {
            Object elem = iterator.next();
            if (newMarine.compareTo((SpaceMarine)elem) > 0) {
                iterator.remove();
                cnt++;
            }
        }
        System.out.println("Удалено " + cnt +  " элемента(-ов)");
    }
}