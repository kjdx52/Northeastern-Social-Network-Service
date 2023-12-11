package com.Group11.NortheasternSocialNetwork.service;

import com.Group11.NortheasternSocialNetwork.model.Post;

import java.util.List;

// Interface defining the contract for handling posts
public interface PostService {

    // Method to add a new post
    // Throws an exception if there is an issue adding the post
    Post addPost(Post post) throws Exception;

    // Method to retrieve all posts
    List<Post> getPost();
}
