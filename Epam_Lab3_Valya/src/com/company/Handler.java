package com.company;

import java.util.*;

public class Handler {


    public boolean userPostsMoreThan(User[] users){
        ;
        return Arrays.stream(users).parallel()
                .peek(e -> System.out.print("Peeked:" + e)).anyMatch(u -> u.getPosts().size() > 300);
    }

    public User[] maxPostsUsers(User[] users){
        Optional<User> maxUser = Optional.of(
                Arrays.stream(users).parallel()
                        .max(Comparator.comparingInt(u -> u.getPosts().size())))
                .orElseThrow(NullPointerException::new);
        int maxPosts = maxUser.get().getPosts().size();
        return Arrays.stream(users).parallel()
                .filter(u -> u.getPosts().size() == maxPosts)
                .peek(e -> System.out.print("Peeked after filter:" + e))
                .toArray(User[]::new);
    }

    public User[] minPostsUsers(User[] users){
        User minUser = Arrays.stream(users).parallel()
                .min(Comparator.comparingInt(u -> u.getPosts().size())).orElse(new User());
        int minPosts = minUser.getPosts().size();
        return Arrays.stream(users).parallel()
                .filter(u -> u.getPosts().size() == minPosts)
                .peek(e -> System.out.print("Peeked after filter:" + e))
                .toArray(User[]::new);
    }

    public User[] sortAgePosts(User[] users){
        return Arrays.stream(users)
                .sorted(Comparator.comparing(User::getAge).thenComparingInt(u -> u.getPosts().size()))
                .peek(e -> System.out.print("Peeked sorted:" + e))
                .toArray(User[]::new);
    }

    public Post[] postsList(User[] users){
        List<Post> posts = new ArrayList();
        Arrays.stream(users).parallel()
                .forEach(
                        o -> {
                            posts.addAll(o.getPosts());
                            System.out.print("Posts: " + o.getPosts());
                        }
                );
        return posts.stream().toArray(Post[]::new);
    }

    public Post[] postsDistinctList(User[] users){
        List<Post> posts = new ArrayList();
        Arrays.stream(users).forEach(
                o -> {
                    posts.addAll(o.getPosts());
                    System.out.print("Posts: " + o.getPosts());
                }
        );
        return posts.stream().distinct().toArray(Post[]::new);

    }
    public void postsShowList(User[] users){
        List<Post> posts = new ArrayList();
        Arrays.stream(users).forEach(
                o -> {
                    posts.addAll(o.getPosts());
                    System.out.println( o.getPosts());
                }
        );
    }
}
