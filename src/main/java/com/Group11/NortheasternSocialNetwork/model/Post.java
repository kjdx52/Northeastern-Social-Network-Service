package com.Group11.NortheasternSocialNetwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to automatically generate boilerplate code
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    // Unique identifier for the post
    private String id;

    // Content of the post
    private String post;

    // Name of the user who created the post
    private String name;

    // Email of the user who created the post
    private String email;

    // Image associated with the post (not sure if this is used)
    private String image;

    // File associated with the post (e.g., attachments)
    private String file;

    // Profile picture of the user who created the post
    private String profilePic;

    // Timestamp indicating when the post was created
    private String timeStamp;

    // Name of the image associated with the post (not sure if this is used)
    private String imageName;
}
