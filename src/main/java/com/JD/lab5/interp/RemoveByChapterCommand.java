package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveByChapterCommand extends Command {
    public RemoveByChapterCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        Chapter chapter = Generators.chapterGenerate();
        for (SpaceMarine marine : target) {
            if (marine.getChapter().equals(chapter)) {
                target.remove(marine);
                System.out.println("Элемент успешно удалён");
                return;
            }
        }
        System.out.println("Не существует элемента с таким значением chapter");
    }
}