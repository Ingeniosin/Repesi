package me.juan.repesi;

import me.juan.repesi.commands.CommandManager;
import me.juan.repesi.configuration.ConfigurationManager;
import me.juan.repesi.database.DatabaseManager;

public class Main {

    private static Main instance;

    public static Main getInstance() { return instance; }
    private static CommandManager commandManager;
    private static DatabaseManager databaseManager;
    private static ConfigurationManager configurationManager;
    public static CommandManager getCommandManager() {
        return commandManager;
    }
    public static void setCommandManager(CommandManager commandManager) { Main.commandManager = commandManager; }
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
    private static void logo(){
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
        configurationManager = new ConfigurationManager();
        databaseManager = new DatabaseManager();
        commandManager = new CommandManager();
        log("The application started in: "+(System.currentTimeMillis()-startMillis)+" miliseconds.");
        lines();
    }

}