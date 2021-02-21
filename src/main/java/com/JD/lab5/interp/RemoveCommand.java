package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Scanner;
import java.util.TreeSet;

public class RemoveCommand extends Command {
    public RemoveCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        for (SpaceMarine marine : target ) {
            try {
                if (marine.getId() == Long.parseLong(arguments.get(1))) {
                    marine.clear();
                    target.remove(marine);
                    System.out.println("Элемент успешно удалён");
                    return;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат ID");
            }
        }
        System.out.println("Элемент c таким ID не существует");
    }
}