package me.juan.repesi.commands.cmds;

import me.juan.repesi.commands.Command;

import java.io.IOException;

public class ReloadCMD extends Command {
    public ReloadCMD() {
        super("reload");
    }

    @Override
    public void run(String[] args) {
        if (args.length <= 1 || args[1].equalsIgnoreCase("help")){
            help();
        } else {
            String database = args[1].toLowerCase();
            if (database.equals("sql")) {

                try {
                    configurationManager.loadSql();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (args.length == 2){
                    log("Refreshing all sql databases!");
                    databaseManager.loadSql();
                } else {
                    if (sqlIndex.keyExist(args[3])) {
                        log("Database '" + args[2] + "' found, loading...");
                        sqlIndex.loadDatabase(args[2]);
                        return;
                    }
                    log("Database not found, failed.");
                }
            } else if (database.equals("redis")){

                try {
                    configurationManager.loadRedis();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (args.length == 2){
                    log("Refreshing all redis databases!");
                    databaseManager.loadRedis();
                } else {
                    if (redisIndex.keyExist(args[2])) {
                        log("Database '"+args[2]+"' found, loading...");
                        redisIndex.loadDatabase(args[2]);
                        return;
                    }
                    log("Database not found, failed.");
                }
            } else {
                log("Database type '"+args[1]+"' not found.");
            }
        }
    }

    private void help(){
        log("Reload commands: ");
        log("  *  reload all");
        log("  *  reload redis [database]");
        log("  *  reload sql [database]");
    }
}
