package me.juan.repesi.configuration;

import lombok.Getter;
import lombok.SneakyThrows;
import me.juan.repesi.Main;
import me.juan.repesi.utils.FileConfig;

import java.io.IOException;

public class ConfigurationManager {
    @Getter
    FileConfig mainConfiguration, redisConfiguration, sqlConfiguration;


    @SneakyThrows
    public ConfigurationManager() {
        loadMain();
        loadRedis();
        loadSql();
        Main.log(" ");
        log("Configuration manager loaded!");
    }

    public void loadMain() throws IOException {
        mainConfiguration = new FileConfig("settings.yml", "");
    }
    public void loadRedis() throws IOException {
        redisConfiguration = new FileConfig("credentials.yml", "redis");
    }
    public void loadSql() throws IOException {
        sqlConfiguration = new FileConfig("credentials.yml", "sql");

    }
    public static void log(String msg) {
        Main.log("[configuration] " + msg);
    }
}
