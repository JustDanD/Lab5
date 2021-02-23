package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class InfoCommand extends Command {
    public InfoCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        System.out.println("Информация о коллекции:\nДата инициалиазции: " + curCMD.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + curCMD.getStartDate().format(DateTimeFormatter.ISO_LOCAL_TIME) +
                "\nТип коллекции: " + target.getClass() + "\nТип элементов: SpaceMarine" +
                "\nРазмер коллекции: " + target.size());
    }
}