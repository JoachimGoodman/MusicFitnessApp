package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private int fk_rank;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    private String firstname;

    private String lastname;

    private String email;

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



   /* public int getFk_rank() {
        return fk_rank;
    }

    public void setFk_rank(int roleid) {
        this.fk_rank = roleid;
    } */

}