package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, исполняющая сторонний скрипт.
 * Содержит в себе стэк с именами уже запущенных "сверху" скриптов.
 */
public class ExecuteScriptCommand extends Command {
    private static Stack<String> executedScripts;

    public ExecuteScriptCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
        if (executedScripts == null)
            executedScripts = new Stack<String>();
    }

    @Override
    public void execute() {
        InputStream oldIn = System.in;
        if (arguments.size() < 2) {
            System.out.println("Не указано имя скрипта");
            return;
        }
        if (executedScripts.contains(arguments.get(1))) {
            System.out.println("Не бывать в нашем царстве рекурсии.");
            return;
        } else
            executedScripts.push(arguments.get(1));
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(arguments.get(1)))) {
            Cmd scriptCMD = new Cmd(target, false, curCMD);
            System.setIn(in);
            scriptCMD.listen();
            executedScripts.pop();
            System.setIn(oldIn);
        } catch (Exception e) {
            System.setIn(oldIn);
            System.out.println("Ошибка загрузки:" + e.getMessage());
            executedScripts.pop();
        }
    }
}