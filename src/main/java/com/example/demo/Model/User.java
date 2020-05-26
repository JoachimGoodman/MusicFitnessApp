package com.example.demo.Model;

import javax.persistence.*;
import java.net.Socket;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Transient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private int fk_rank;
    @Id
    @Column(table="users",name = "username")
    private String username;
    @Column(table="users",name = "password")
    private String password;
    @Transient
    private Socket usersocket;
    @Transient
    private String firstname;
    @Transient
    private String lastname;
    @Transient
    private String email;


    @ManyToMany
    @JoinTable(
            name = "UserGroups",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "group"))
    List<Group> groups;
/*
    @ManyToMany
    @JoinTable(name="'Friendslists'",
            joinColumns=@JoinColumn(name="'User'"),
            inverseJoinColumns=@JoinColumn(name="'Friend'")
    )
    @Transient
    private List<User> friends;

    @ManyToMany
    @JoinTable(name="'Friendslists'",
            joinColumns=@JoinColumn(name="'User'"),
            inverseJoinColumns=@JoinColumn(name="'Friend'")
    )
    @Transient
    private List<User> friendOf;

*/

    //JPA uses a default constructer indirectly which is why it is protected,
    protected User () {}

    public User (/*int fk_rank,*/ String username, String password, String firstname, String lastname, String email) {
        //this.fk_rank = fk_rank;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(Socket usersocket, String username) {
        this.usersocket=usersocket;
        this.username=username;
    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getFirstname() {

        return firstname;

    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;

    }

    public String getLastname() {

        return lastname;

    }

    public void setLastname(String lastname) {

        this.lastname = lastname;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socket getUsersocket() {
        return usersocket;
    }

    public void setUsersocket(Socket usersocket) {
        this.usersocket = usersocket;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
/* public int getFk_rank() {
        return fk_rank;
    }

    public void setFk_rank(int roleid) {
        this.fk_rank = roleid;
    } */

}