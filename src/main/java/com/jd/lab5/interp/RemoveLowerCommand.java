package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * @author Пименов Данила P3130
 * Команда удаления всех элементов меньше данного
 */
public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        int cnt = 0;
        SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine = Generators.marineGenerate();
        else
            newMarine = Generators.marineJSONGenerate(arguments.get(1));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }
        Iterator iterator = target.iterator();
        while (iterator.hasNext()) {
            Object elem = iterator.next();
            if (newMarine.compareTo((SpaceMarine) elem) > 0) {
                iterator.remove();
                cnt++;
            }
        }
        System.out.println("Удалено " + cnt + " элемента(-ов)");
    }
}