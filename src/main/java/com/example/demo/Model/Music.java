package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.web.JsonPath;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table (name="music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "music_Name")
    private String musicName;
    private String path;
    private String time_stamp;
    private String pitch;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty
    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
    @JsonProperty
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @JsonProperty
    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
    @JsonProperty
    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }
}

