package me.juan.repesi.database.redis;

import lombok.Getter;
import me.juan.repesi.database.DatabaseManager;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

@Getter
public class RedisDatabase {

    private final String name;
    private final String database;
    private final int port;
    private Jedis jedis;
    private boolean connected = false;
    private HashMap<String, DatabaseManager> databaseManagerHashMap;


    public RedisDatabase(String name, String database, int port) {
        this.name = name;
        this.database = database;
        this.port = port;
        connect();
    }

    public void connect() {
        jedis = new Jedis(database, port);
        try {
            DatabaseManager.RedisMSG("   *  [" + name + "] ping status: " + jedis.ping("CONECTED"));
            connected = true;
        } catch (Exception e) {
            DatabaseManager.RedisMSG("   *   [" + name + "] ping status: " + "FAILED CONECTION");
        }
    }

}
