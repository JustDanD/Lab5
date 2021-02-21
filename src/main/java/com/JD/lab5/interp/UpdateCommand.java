package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Scanner;
import java.util.TreeSet;

public class UpdateCommand extends Command {
    public UpdateCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        for (SpaceMarine marine : target ) {
          try {
              if (marine.getId() == Long.parseLong(arguments.get(1))) {
                  SpaceMarine newMarine = Generators.marineGenerate();
                  marine.clear();
                  target.remove(marine);
                  newMarine.setId(Long.parseLong(arguments.get(1)));
                  target.add(newMarine);
                  System.out.println("Элемент успешно обновлён");
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