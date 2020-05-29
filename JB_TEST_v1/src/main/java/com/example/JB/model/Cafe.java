package com.example.JB.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.Objects;


@Entity
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String text;
    private String description;
    private String phoneNumber;
    private String filename;

    @Column(length = 2048)
    private String googleMap;

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Cafe(){}
    public Cafe(String name, String text){
        this.name = name;
        this.text = text;
    }

    public Cafe(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("text") String text){
        this.id = id;
        this.name = name;
        this.text = text;
    }


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String address) {
        this.text = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe admins = (Cafe) o;
        return Objects.equals(id, admins.id) &&
                Objects.equals(name, admins.name) &&
                Objects.equals(text, admins.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text);
    }
}