package me.juan.repesi.database.sql;

import lombok.Getter;
import me.juan.repesi.database.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase {
    private final String name, address, database, username, password, table;
    private final int port;
    @Getter
    private boolean loaded = false;
    private Connection connection;

    public SQLDatabase(String name, String address, String database, int port, String username, String password, String table) {
        this.name = name;
        this.address = address;
        this.database = database;
        this.port = port;
        this.username = username;
        this.password = password;
        this.table = table;
        this.openConnection();
    }

    private void openConnection() {
        try {
            //    Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.address + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.username, this.password);
            this.loaded = true;
            DatabaseManager.SQLMSG("   *  [" + this.name + "] Connection to the database was successful.");
        } catch (SQLException ex) {
            this.loaded = false;
            DatabaseManager.SQLMSG("   *  [" + this.name + "] Could not establish a connection to a database... Shutting down");
            DatabaseManager.SQLMSG("   *  [" + this.name + "] Reason: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) openConnection();
        return connection;
    }


}
