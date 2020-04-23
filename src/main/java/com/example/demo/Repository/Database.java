package com.example.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/fitnessmusicapp?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&autoReconnect=true",
                    "fitnessmusicapp",
                    "Oy59kYn5!~9Z");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
