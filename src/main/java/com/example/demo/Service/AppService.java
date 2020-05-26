package com.example.demo.Service;

import com.example.demo.Model.Music;
import com.example.demo.Model.User;
import com.example.demo.Repository.DataContainer;
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
import java.util.Hashtable;
import java.util.List;
import java.net.Socket;
import java.util.Map;

@Service
public class AppService {
    Map<String,Socket> usersockets=new Hashtable<>();
    public static ServerSocket ss;
    Socket s;
    DataOutputStream sout;
    DataInputStream sin;
    public static Clienthandler ch;
    @Autowired
    private MusicRepo mr;

    public AppService() throws IOException {
    }

    public void startClient(String groupid,String userid) throws IOException {
        s=new Socket("localhost",8000);
        DataOutputStream cos=new DataOutputStream(s.getOutputStream());
        cos.writeUTF(groupid+";"+userid);
        usersockets.put(userid,s);


    }

    public Object waitForHost(String userid) throws IOException {
        DataInputStream csin=new DataInputStream(usersockets.get(userid).getInputStream());
        String msg = csin.readUTF();
        System.out.println("got: "+msg);
        Music music = new Music();
        String msga[]=msg.split(";");
        music.setPath(msga[0]);
        music.setTime_stamp(msga[1]);
        return music;
    }

    public List<Music> getAllMusic() {
        return mr.findAll();
    }

    public void exitGroup(int groupid,String username) throws IOException {
        for (int i = 0; i<DataContainer.Clientlistmap.get(groupid).size();i++){
            if (DataContainer.Clientlistmap.get(groupid).get(i).getUsername().equals(username)){
                DataContainer.Clientlistmap.get(groupid).get(i).getUsersocket().close();
                DataContainer.Clientlistmap.get(groupid).remove(i);
            }
        }
    }
    public void sendTrack(String path,String time,int groupid) throws IOException {
        for (int i =0;i<DataContainer.Clientlistmap.get(groupid).size();i++) {
            List<User> grouplist=DataContainer.Clientlistmap.get(groupid);
            sout = new DataOutputStream(grouplist.get(i).getUsersocket().getOutputStream());
            Float hours = Float.valueOf(time) / 3600;
            Float minutes = (Float.valueOf(time) % 3600) / 60;
            Float seconds = Float.valueOf(time) % 60;
            String timeString = String.format("%02d:%02d:%02d", Math.round(hours), Math.round(minutes), Math.round(seconds));
            System.out.println("Send: "+path + ";" + time);
            sout.writeUTF(path + ";" + timeString);
        }
    }

    public static void openServerSocket() throws IOException {
        DataContainer.Clientlistmap.put(1,new ArrayList<User>());
        DataContainer.Clientlistmap.put(2,new ArrayList<User>());
        ss=new ServerSocket(8000);
       ch=new Clienthandler();
       Thread t = new Thread(ch);
       t.start();
    }


    public static class Clienthandler implements Runnable {
        @Override
        public void run() {
            while (true){
                try {
                    Socket client=ss.accept();
                    DataInputStream sin=new DataInputStream(client.getInputStream());
                    String msg=sin.readUTF();
                    String msga[]=msg.split(";");
                    Integer groupid = Integer.valueOf(msga[0]);
                    DataContainer.Clientlistmap.get(groupid).add(new User(client,msga[1]));
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        }
    }
}
