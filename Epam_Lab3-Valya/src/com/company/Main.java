package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        User[] users = new User[3];
        users[0] = new User("A", 1);
        users[1] = new User("B", 2);
        users[2] = new User("C", 3);

        Post[] posts = new Post[3];
        posts[0] = new Post("1");
        posts[1] = new Post("2");
        posts[2] = new Post("3");

        users[0].addPost(posts[0]);
        users[0].addPost(posts[1]);
        users[0].addPost(posts[2]);
        users[1].addPost(posts[0]);
        users[2].addPost(posts[1]);

        users[0].likePost(posts[0]);
        users[0].likePost(posts[0]);
        users[0].likePost(posts[0]);
        users[0].likePost(posts[1]);
        users[0].likePost(posts[2]);
        users[1].likePost(posts[0]);
        users[2].likePost(posts[1]);

        Arrays.stream(users).forEach(u -> System.out.println(u.toString()));
        Arrays.stream(users).forEach(u -> System.out.println(u.toString()));

        Handler handler = new Handler();
        System.out.println(Arrays.toString(handler.maxPostsUsers(users)));
        System.out.println(handler.userPostsMoreThan(users));
        System.out.println("Result: " + Arrays.toString(handler.minPostsUsers(users)));
        System.out.println(Arrays.toString(handler.maxPostsUsers(users)));
        System.out.println(Arrays.toString(handler.postsDistinctList(users)));


    }
}
