package me.juan.repesi.commands;

import lombok.Getter;
import me.juan.repesi.Main;
import me.juan.repesi.configuration.ConfigurationManager;
import me.juan.repesi.database.DatabaseManager;
import me.juan.repesi.database.redis.RedisIndex;
import me.juan.repesi.database.sql.SQLIndex;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    @Getter
    private static List<Command> commandList = new ArrayList<>();
    public DatabaseManager databaseManager = Main.getDatabaseManager();
    public RedisIndex redisIndex = databaseManager.getRedisIndex();
    public SQLIndex sqlIndex = databaseManager.getSqlIndex();
    public CommandManager commandManager = Main.getCommandManager();
    public ConfigurationManager configurationManager = Main.getConfigurationManager();
    @Getter
    private String cmd;

    public Command(String cmd) {
        this.cmd = cmd;
        commandList.add(this);

    }

    public void log(String msg) {
        Main.log("[" + cmd + "] " + msg);
    }

    public abstract void run(String[] args);

}
