package me.juan.repesi.database.redis;

import me.juan.repesi.Main;
import me.juan.repesi.utils.ConfigCursor;

import java.util.HashMap;

public class RedisIndex {

    public HashMap<String, RedisDatabase> databases;

    public RedisIndex() {
        databases = new HashMap<>();
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getRedisConfiguration().getConfig(), "credentials");
        for (String key : cursor.getKeys()) {
            loadDatabase(key);
        }
    }

    public boolean keyExist(String keyS){
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getRedisConfiguration().getConfig(), "credentials");
        for (String key : cursor.getKeys()) {
            if (keyS.equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }

    public void loadDatabase(String key){
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getRedisConfiguration().getConfig(), "credentials");
        cursor.setPath("credentials." + key);
        databases.put(key, new RedisDatabase(key, cursor.getString("address"), cursor.getInt("port")));
    }


}
