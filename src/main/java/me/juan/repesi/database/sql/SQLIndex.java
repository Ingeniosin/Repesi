package me.juan.repesi.database.sql;

import me.juan.repesi.Main;
import me.juan.repesi.utils.ConfigCursor;

import java.util.HashMap;

public class SQLIndex {

    public HashMap<String, SQLDatabase> databases;

    public SQLIndex() {
        databases = new HashMap<>();
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getSqlConfiguration().getConfig(), "credentials");
        for (String key : cursor.getKeys()) {
            loadDatabase(key);
        }
    }


    public boolean keyExist(String keyS){
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getSqlConfiguration().getConfig(), "credentials");
        for (String key : cursor.getKeys()) {
            if (keyS.equals(key)){
                return true;
            }
        }
        return false;
    }

    public void loadDatabase(String key){
        ConfigCursor cursor = new ConfigCursor(Main.getConfigurationManager().getSqlConfiguration().getConfig(), "credentials");
        cursor.setPath("credentials." + key);
        databases.put(key, new SQLDatabase(
                key,
                cursor.getString("address"),
                cursor.getString("database"),
                cursor.getInt("port"),
                cursor.getString("username"),
                cursor.getString("password"),
                cursor.getString("table")));
    }

}
