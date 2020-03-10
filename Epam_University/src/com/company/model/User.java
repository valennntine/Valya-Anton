package com.company.model;

import java.util.Objects;

public class User {
    private long id;
    private String email;
    private String password;
    private String username;
    private String phonenumber;

    public User(long id, String email, String password, String username, String phonenumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.phonenumber = phonenumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username) &&
                Objects.equals(phonenumber, user.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username, phonenumber);
    }

    @Override
    public String toString() {
        return id+"\n"+email+"\n"+password +"\n" +username + "\n" + phonenumber;
    }
}
