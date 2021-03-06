package com.jd.lab5.interp;


import com.jd.lab5.data.SpaceMarine;

import java.util.TreeSet;
/**
 * @author Пименов Данила P3130
 * Команда, выводящая подсказку по командам.
 */
public class HelpCommand extends Command {
    public HelpCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        System.out.println("Список доступных комманд:\nhelp - справка\ninfo - вывести информацию о коллекции\nshow - вывести все элементы коллекции\nadd - добавить элемент в коллекцию\n" +
                "update id - обновить элемент с данным id\nremove_by_id id - удалить элемент с данным id\nclear - очситить коллекцию\nsave - сохранить коллекцию в файл\n" +
                "execute_script file_name - выполнить скрипт из файла\nexit - выход(без сохранения)\nadd_if_min - добавить элемент в коллекцию, если он меньше всех остальных элементов коллекции\n" +
                "remove_lower - удалить из коллекции все эелементы, меньшие, чем заданный\nhistory - вывести последние 5 команд\nremove_any_by_chapter chapter - удалить из коллекции один элемент, значение поля chapter которого эквивалентно заданному\n" +
                "group_counting_by_heart_count - сгруппировать элементы коллекции по значению поля heartCount, вывести количество элементов в каждой группе\n" +
                "print_descending - вывести элементы коллекции в порядке убывания");
    }
}
