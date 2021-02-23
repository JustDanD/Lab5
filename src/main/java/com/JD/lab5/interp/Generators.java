package com.JD.lab5.interp;

import com.JD.lab5.data.Chapter;
import com.JD.lab5.data.Coordinates;
import com.JD.lab5.data.MeleeWeapon;
import com.JD.lab5.data.SpaceMarine;

import java.util.Scanner;

public class Generators {
    public static SpaceMarine marineGenerate() {
        Scanner in = new Scanner(System.in);
        String input;
        String name; // !=null, !="".
        long x;
        Float y; //!=null
        Double health; // !=null, >0.
        long heartCount; // >0, <=3;
        boolean loyal;
        MeleeWeapon meleeWeapon; // !=null.
        Chapter chapter;
        System.out.println("Введите имя корабля:");
        while(true) {
            if (!(input = in.nextLine()).equals("")) {
                name = input;
                break;
            }
            System.out.println("Введено неправильное имя. Повторите ввод:");
        }
        System.out.println("Введите коодинату x:");
        while(true) {
            try {
                x = Long.parseLong(in.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат координаты. Повторите ввод:");
            }
        }
        System.out.println("Введите коодинату y:");
        while(true) {
            try {
                y = Float.parseFloat(in.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат координаты. Повторите ввод:");
            }
        }
        System.out.println("Введите количество здоровья:");
        while(true) {
            try {
                health = Double.parseDouble(in.nextLine());
                if (health <= 0)
                    System.out.println("Здоровье должно быть больше 0. Повторите ввод:");
                else
                    break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат значения здоровья. Повторите ввод:");
            }
        }
        System.out.println("Введите количество жизней:");
        while(true) {
            try {
                heartCount = Long.parseLong(in.nextLine());
                if (heartCount <= 0)
                    System.out.println("Жизней должно быть больше 0. Повторите ввод:");
                else if (heartCount > 3)
                    System.out.println("Жизней должно быть не больше 3.  Повторите ввод:");
                else
                    break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат значения жизней. Повторите ввод:");
            }
        }
        System.out.println("Введите знгачение преданности (true/false):");
        while(true) {
            input = in.nextLine();
            if (!input.equals("true") && !input.equals("false"))
                System.out.println("Неверный формат. Повторите ввод:");
            else {
                loyal = Boolean.parseBoolean(input);
                break;
            }
        }
        System.out.println("Введите оружие (POWER_SWORD/CHAIN_AXE/POWER_BLADE/POWER_FIST):");
        while(true) {
            meleeWeapon = MeleeWeapon.parseMeleeWeapon(in.nextLine());
            if (meleeWeapon == null)
                System.out.println("Неверный формат. Повторите ввод:");
            else
                break;
        }
        chapter = chapterGenerate();
        return new SpaceMarine(name, new Coordinates(x, y), health, heartCount, loyal, meleeWeapon, chapter);
    }

    public static Chapter chapterGenerate(){
        Scanner in = new Scanner(System.in);
        String input;
        String chapterName;
        String parentLegion;
        System.out.println("Введите название части:");
        while(true) {
            if (!(input = in.nextLine()).equals("")) {
                chapterName = input;
                break;
            }
            System.out.println("Введено неправильное имя. Повторите ввод:");
        }
        System.out.println("Введите название головного легиона:");
        while(true) {
            if (!(input = in.nextLine()).equals(""))
                parentLegion = input;
            else
                parentLegion = null;
            break;
        }
        return new Chapter(chapterName, parentLegion);
    }
}
