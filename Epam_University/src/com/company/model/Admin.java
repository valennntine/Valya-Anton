package com.company.model;

import java.util.Objects;

public class Admin {
    private long id;
    private String email;
    private String password;

    public Admin(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Admin() {

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

    @Override
    public String toString() {
        return id+"\n"+email+"\n"+password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&
                Objects.equals(email, admin.email) &&
                Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
