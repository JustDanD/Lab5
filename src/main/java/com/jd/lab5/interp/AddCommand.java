package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.util.TreeSet;

public class AddCommand extends Command {
    public AddCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        if (curCMD.getIsInteractive()) {
            target.add(Generators.marineGenerate());
            System.out.println("Элемент успешно добавлен");
        } else {
            SpaceMarine newMarine = Generators.marineJSONGenerate(arguments.get(1));
            if (newMarine != null) {
                target.add(newMarine);
                System.out.println("Элемент успешно добавлен");
            } else
                System.out.println("Элемент добавить не удалось");
        }
    }
}
