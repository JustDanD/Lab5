package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Scanner;
import java.util.TreeSet;

public class AddMinCommand extends Command {
    public AddMinCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        SpaceMarine newMarine = Generators.marineGenerate();
        if (newMarine.compareTo(target.first()) < 0) {
            target.add(newMarine);
            System.out.println("Элемент успешно добавлен");
        }
        else
            System.out.println("Элемент не является наименьшим");
    }
}
