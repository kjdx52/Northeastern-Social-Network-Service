package com.Group11.NortheasternSocialNetwork.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_logins")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "login_timestamp")
    private String loginTimestamp;

    // Constructors, getters, and setters

    // Default constructor
    public UserLogin() {
    }

    // Parameterized constructor
    public UserLogin(String username, String loginTimestamp) {
        this.username = username;
        this.loginTimestamp = loginTimestamp;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(String loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    // Equals and hashCode (optional, based on your needs)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin userLogin = (UserLogin) o;
        return Objects.equals(id, userLogin.id) && Objects.equals(username, userLogin.username) && Objects.equals(loginTimestamp, userLogin.loginTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, loginTimestamp);
    }
}