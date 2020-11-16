package me.juan.repesi.database;

import lombok.Getter;
import lombok.Setter;
import me.juan.repesi.Main;
import me.juan.repesi.database.redis.RedisIndex;
import me.juan.repesi.database.sql.SQLIndex;
import me.juan.repesi.utils.ConfigCursor;
import me.juan.repesi.utils.FileConfig;

@Getter
@Setter
public class DatabaseManager {

    private RedisIndex redisIndex;
    private SQLIndex sqlIndex;


    public DatabaseManager() {
        Main.lines();
        loadSql();
        Main.log(" ");
        loadRedis();
        Main.log(" ");
        log("Database manager loaded!");
        Main.lines();
    }

    public void loadRedis(){
        FileConfig mainConfig = Main.getConfigurationManager().getMainConfiguration();
        ConfigCursor mainCursor = new ConfigCursor(mainConfig.getConfig(), "Databases");
        if (mainCursor.getBoolean("Redis")) {
            RedisMSG("Redis enabled!");
            redisIndex = new RedisIndex();
        } else {
            RedisMSG("Redis disabled!");
        }
    }
    public void loadSql(){
        FileConfig mainConfig = Main.getConfigurationManager().getMainConfiguration();
        ConfigCursor mainCursor = new ConfigCursor(mainConfig.getConfig(), "Databases");
        if (mainCursor.getBoolean("SQL")) {
            SQLMSG("MySQL enabled!");
            sqlIndex = new SQLIndex();
        } else {
            SQLMSG("MySQL disabled!");
        }
    }
    public static void RedisMSG(String msg) {
        Main.log("[redis] " + msg);
    }
    public static void log(String msg) {
        Main.log("[database] " + msg);
    }
    public static void SQLMSG(String msg) {
        Main.log("[mysql] " + msg);
    }
}
