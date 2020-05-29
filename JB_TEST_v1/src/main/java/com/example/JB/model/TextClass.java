package com.example.JB.model;

public class TextClass {

    private  String name;
    private  String time;
    private  String codeWord;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TextClass(String name, String time, String codeWord) {
        this.name = name;
        this.time = time;
        this.codeWord = codeWord;
    }

    public TextClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCodeWord() {
        return codeWord;
    }

    public void setCodeWord(String codeWord) {
        this.codeWord = codeWord;
    }
}
