package me.juan.repesi;

import me.juan.repesi.commands.CommandManager;
import me.juan.repesi.configuration.ConfigurationManager;
import me.juan.repesi.database.DatabaseManager;
import me.juan.repesi.screen.ScreenManager;

public class Main {

    private static Main instance;
    private static ScreenManager screenManager;
    private static CommandManager commandManager;
    private static DatabaseManager databaseManager;
    private static ConfigurationManager configurationManager;

    public static Main getInstance() {
        return instance;
    }

    public static ScreenManager getScreenManager() {
        return screenManager;
    }

    public static CommandManager getCommandManager() {
        return commandManager;
    }

    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public static void log(String msg) {
        String PREFIX = "[Repesi] ";
        System.out.println(PREFIX + msg);
    }

    public static void lines() {
        log("----------------------------------");
    }

    public static void space() {
        System.out.println(" ");
    }

    private static void logo() {
        System.out.println("     → REPESI ←");
        System.out.println("        _..._");
        System.out.println("      .'     '.");
        System.out.println("     /    .-\"\"-\\   _/ \\");
        System.out.println("   .-|   /:.   |  |   |");
        System.out.println("   |  \\  |:.   /.-'-./");
        System.out.println("   | .-'-;:__.'    =/");
        System.out.println("   .'=  *=|REPESI.='");
        System.out.println("  /   _.  |    ;");
        System.out.println(" ;-.-'|    \\   |");
        System.out.println("/   | \\    _\\  _\\");
        System.out.println("\\__/'._;.  ==' ==\\");
        System.out.println("         \\    \\   |");
        System.out.println("         /    /   /");
        System.out.println("         /-._/-._/");
        System.out.println("         \\   `\\  \\");
        System.out.println("          `-._/._/");
        System.out.println("");
        lines();
        log("        Loading...");
        lines();
    }

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        Main.log(" ");
        logo();
        screenManager = new ScreenManager();
        screenManager.getIndex().enable();
        configurationManager = new ConfigurationManager();
        databaseManager = new DatabaseManager();
        commandManager = new CommandManager();
        log("The application started in: " + (System.currentTimeMillis() - startMillis) + " miliseconds.");
        lines();
    }

}
