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

    public void startClient() throws IOException {
        s=new Socket("localhost",8000);
        in=new DataInputStream(s.getInputStream());

    }

    public Object waitForHost() throws IOException {
        String msg = in.readUTF();
        System.out.println(msg);
        Music music = new Music();
        String msga[]=msg.split(";");
        music.setPath(msga[0]);
        music.setTime_stamp(msga[1]);

        return music;
    }

    public List<Music> getAllMusic() {
        return mr.findAll();
    }

    public void sendTrack(String path,String time) throws IOException {
        Socket client=ss.accept();
        out=new DataOutputStream(client.getOutputStream());
        Float hours = Float.valueOf(time) / 3600;
        Float minutes = (Float.valueOf(time) % 3600) / 60;
        Float seconds = Float.valueOf(time) % 60;
        String timeString = String.format("%02d:%02d:%02d", Math.round(hours), Math.round(minutes), Math.round(seconds));
        System.out.println(path+";"+time);
        out.writeUTF(path+";"+timeString);

    }

    public void openServerSocket() throws IOException {
       ss=new ServerSocket(8000);
    }

}
