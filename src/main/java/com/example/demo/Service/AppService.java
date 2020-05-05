package com.example.demo.Service;

import com.example.demo.Model.Music;
import com.example.demo.Repository.MusicRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;

@Service
public class AppService {
    ServerSocket ss;
    Socket s;
    DataOutputStream out;
    DataInputStream in;
    @Autowired
    private MusicRepo mr;

    public AppService() throws IOException {
    }

    public Object waitForHost() throws IOException {
        //String msg = in.readUTF();
        JSONObject jo = new JSONObject();
        jo.put("path", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        jo.put("time_stamp", "00:01:07");
        return jo;
    }

    public List<Music> getAllMusic() {
        return mr.findAll();
    }

    public void sendTrack(Object o) throws IOException {
        Socket client=ss.accept();
        in=new DataInputStream(s.getInputStream());
        out=new DataOutputStream(s.getOutputStream());
    }

    public void openServerSocket() throws IOException {
       ss=new ServerSocket(8000);
    }
}
