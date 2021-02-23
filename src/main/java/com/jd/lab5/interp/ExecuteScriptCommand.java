package com.jd.lab5.interp;

import com.jd.lab5.data.SpaceMarine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.TreeSet;

public class ExecuteScriptCommand extends Command {
    private static Stack<String> executedScripts;

    public ExecuteScriptCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
        if (executedScripts == null)
            executedScripts = new Stack<String>();
    }

    @Override
    public void execute() {
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
        } catch (Exception e) {
            System.out.println("Ошибка загрузки:" + e.getMessage());
            executedScripts.pop();
        }
    }
}