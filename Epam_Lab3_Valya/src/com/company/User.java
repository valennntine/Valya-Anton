package com.company;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    int age;
    List<Post> posts;
    {
        name = "";
        posts = new ArrayList<>();
    }
    public void addPost(Post post){
        this.posts.add(post);
    }
    public void likePost(Post post){
        if (!post.getLikedByList().stream().anyMatch(u -> u.equals(this))){
            post.getLikedByList().add(this);
        }
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, List<Post> posts) {
        this.name = name;
        this.age = age;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("User{");
        str.append("name='").append(name).append('\'');
        str.append("age='").append(age).append('\'');
        str.append("posts='").append(posts.size());
        str.append('\'');
        str.append('}');
        return str.toString();
    }
}
