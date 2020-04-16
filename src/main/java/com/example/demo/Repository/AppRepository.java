package com.example.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AppRepository extends Database{
    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getAllMusic() {
        query = "SELECT * FROM music";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
