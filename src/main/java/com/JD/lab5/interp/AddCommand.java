package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Scanner;
import java.util.TreeSet;

public class AddCommand extends Command {
    public AddCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        target.add(Generators.marineGenerate());
        System.out.println("Элемент успешно добавлен");
    }
}
