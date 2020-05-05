package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AppRepository extends Database{
    private PreparedStatement preparedStatement;
    private String query;

}
