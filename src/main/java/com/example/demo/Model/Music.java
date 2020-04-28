package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table (name="music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "music_Name")
    private String musicName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String name) {
        this.musicName = name;
    }
}
