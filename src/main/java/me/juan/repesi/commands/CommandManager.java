package me.juan.repesi.commands;

import me.juan.repesi.Main;
import me.juan.repesi.commands.cmds.EndCMD;
import me.juan.repesi.commands.cmds.ReloadCMD;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandManager {

    private final Scanner scanner;

    public CommandManager() {
        scanner = new Scanner(System.in);
        initEssentials();
        CommandManager();
        Main.log(" ");
        log("Commands manager loaded!");
        Main.lines();
    }

    private void initEssentials(){
        new EndCMD();
        new ReloadCMD();
    }

    public void log(String msg) {
        Main.log("[commands] " + msg);
    }



    public void CommandManager() {
        new Thread(() -> {
            boolean enable = true;
            while (enable) {
                try {
                    String command = scanner.nextLine();
                    String[] args = command.split(" ");
                    boolean found = false;
                    for (Command cmd : Command.getCommandList()){
                        if (cmd.getCmd().equalsIgnoreCase(args[0])) {
                            found = true;
                            Main.space();
                            cmd.run(args);
                            Main.space();
                            break;
                        }
                    }
                    if (args[0].equalsIgnoreCase("help")){
                        found = true;
                        log("Commands avaliable:");
                        log(" ");
                        for (Command cmd : Command.getCommandList()){
                            log("  *  "+cmd.getCmd());
                        }
                    }
                    if (!found)  log("Command not found. Use help");
                } catch (NoSuchElementException ignored){}
            }
        }).start();

    }

}
