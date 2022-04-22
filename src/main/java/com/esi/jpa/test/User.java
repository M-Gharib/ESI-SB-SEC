package com.esi.jpa.test;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;


    public User() {
    }

/* public User(int i, String string, String string2, String string3) {
    } */



public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.roles = user.getRoles();
}

public int getId() {
        return this.id;
    }

        public void setId(int id) {
        this.id = id;
    }

public String getName() {
        return this.name;
    }

public void setName(String name) {
        this.name = name;
    }

public String getPassword() {
        return this.password;
    }

public void setPassword(String password) {
        this.password = password;
    }

public String getRoles() {
        return this.roles;
    }

public void setRoles(String roles) {
        this.roles = roles;
    }
}

    
 