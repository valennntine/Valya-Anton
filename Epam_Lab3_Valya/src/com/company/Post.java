package com.company;

import java.util.ArrayList;
import java.util.List;

public class Post{
    String content;
    List<User> likedByList;
    {
        likedByList = new ArrayList<>();
    }
    public Post(String content) {
        this.content = content;
    }

    public Post(String content, List<User> likedByList) {
        this.content = content;
        this.likedByList = likedByList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<User> getLikedByList() {
        return likedByList;
    }

    public void setLikedByList(List<User> likedByList) {
        this.likedByList = likedByList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Post{");
        str.append("content='").append(content).append('\'');
        str.append("likedBy='");
        for(User u : likedByList){
            str.append(u.getName()).append(',');
        }
        str.append('\b');
        str.append('\'');
        str.append('}');
        return str.toString();
    }
}
