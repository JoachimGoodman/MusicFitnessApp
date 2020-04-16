package com.example.demo.Service;

import com.example.demo.Model.Music;
import com.example.demo.Repository.AppRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    private final AppRepository appRepository;
    private ResultSet resultSet;

    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public List<Music> getAllMusic() {
        List<Music> musics = new ArrayList<>();
        resultSet = appRepository.getAllMusic();
        try {
            while(resultSet.next()) {
                Music music = new Music();
                music.setName(resultSet.getString("name"));
                musics.add(music);
            }
            return musics;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
