package com.Group11.NortheasternSocialNetwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="posts")  // Specifies the name of the database table to which this entity is mapped
@Data  // Lombok annotation to automatically generate getter, setter, toString, equals, and hashCode methods
@Builder  // Lombok annotation to generate a builder pattern for the entity
@NoArgsConstructor  // Lombok annotation for generating a no-argument constructor
@AllArgsConstructor  // Lombok annotation for generating a constructor with all arguments
public class PostEntity {

    @Id  // Indicates that this field is the primary key
    @GeneratedValue(generator = "uuid")  // Specifies the generation strategy for the primary key
    @GenericGenerator(name = "uuid", strategy = "uuid2")  // Configures the generator used for the primary key
    private String id;  // Unique identifier for the post

    @Lob  // Specifies that the attribute should be persisted as a large object in the database
    private String post;  // The content of the post

    private String name;  // Name of the user who made the post
    private String email;  // Email of the user who made the post

    @Lob  // Specifies that the attribute should be persisted as a large object in the database
    @Column(columnDefinition = "LONGTEXT")  // Specifies the column definition for the attribute
    private String image;  // The image attached to the post

    private String profilePic;  // Profile picture of the user who made the post
    private String timeStamp;  // Timestamp indicating when the post was created
}
