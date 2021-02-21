package com.JD.lab5.interp;

import com.JD.lab5.data.SpaceMarine;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cmd {
    private HashMap<String, Class> commandsMap;
    private static Cmd instance;
    private Stack<String> commandHistory;
    private TreeSet<SpaceMarine> curCollection;
    private LocalDateTime startDate;

    private Cmd(TreeSet<SpaceMarine> col) {
        System.out.println("Доброго времени суток, уважаемый юзер.\nДобро пожаловать в систему управления вашей коллекцией космических корбалей!\nПриятного пользования!\nДля просмотра существующих команд введите help.");
        commandsMap = new HashMap<String, Class>();
        commandsMap.put("exit", ExitCommand.class);
        commandsMap.put("help", HelpCommand.class);
        commandsMap.put("info", InfoCommand.class);
        commandsMap.put("show", ShowCommand.class);
        commandsMap.put("add", AddCommand.class);
        commandsMap.put("update", UpdateCommand.class);
        commandsMap.put("remove_by_id", RemoveCommand.class);
        commandsMap.put("clear", ClearCommand.class);
        commandsMap.put("save", SaveCommand.class);
        commandsMap.put("add_if_min", AddMinCommand.class);
        commandsMap.put("remove_lower", RemoveLowerCommand.class);
        commandsMap.put("history", HistoryCommand.class);
        commandsMap.put("print_descending", PrintDescendingCommand.class);
        curCollection = col;
        startDate = LocalDateTime.now();
        commandHistory = new Stack<String>();
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public static Cmd initCmd(TreeSet<SpaceMarine> col) {
        if (instance == null)
            instance = new Cmd(col);
        return instance;
    }

    public void listen()  {
        Scanner in = new Scanner(System.in);
        String curCom = "";
        String[] curArgs;
        Class[] params = {String[].class, TreeSet.class, Cmd.class};
        while (true) {
            curCom = in.next();
            curArgs = in.nextLine().split(" ");

            try {
                Class command = (commandsMap.get(curCom));
                if (command != null) {
                    Command executedCom = (Command)command.getConstructor(params).newInstance(curArgs, curCollection, instance);
                    executedCom.execute();
                    commandHistory.push(curCom);
                }
                else
                    System.out.println("Такой команды не существует");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Stack<String> getCommandHistory() {
        return commandHistory;
    }
}
