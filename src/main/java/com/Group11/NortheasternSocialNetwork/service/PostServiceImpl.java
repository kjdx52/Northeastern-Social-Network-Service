package com.Group11.NortheasternSocialNetwork.service;

import com.Group11.NortheasternSocialNetwork.entity.PostEntity;
import com.Group11.NortheasternSocialNetwork.model.Post;
import com.Group11.NortheasternSocialNetwork.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostEntityRepository postEntityRepository;

    // Constructor injection of PostEntityRepository
    public PostServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    // Method to add a new post
    @Override
    public Post addPost(Post post) throws Exception {
        try {
            // Create a new PostEntity and copy properties from the Post DTO
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post, postEntity);

            // Check if the post has a file attached
            if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
                postEntity.setImage(post.getFile());
            else
                postEntity.setImage(null);

            // Save the PostEntity to the repository
            postEntity = postEntityRepository.save(postEntity);

            // Update the Post DTO with the saved entity details
            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());

        } catch (Exception e) {
            // Throw an exception if there is an error saving the post
            throw new Exception("Could not save Post: " + e);
        }
        // Return the updated Post DTO
        return post;
    }

    // Method to retrieve all posts
    @Override
    public List<Post> getPost() {
        // Retrieve all PostEntities from the repository
        List<PostEntity> postEntities = postEntityRepository.findAll();

        // Map PostEntity objects to Post DTOs
        List<Post> posts = postEntities.stream()
                .map((postEntity) ->
                        Post.builder()
                                .id(postEntity.getId())
                                .timeStamp(postEntity.getTimeStamp())
                                .email(postEntity.getEmail())
                                .name(postEntity.getName())
                                .post(postEntity.getPost())
                                .image(postEntity.getImage())
                                .profilePic(postEntity.getProfilePic())
                                .build()
                ).collect(Collectors.toList());
        // Return the list of Post DTOs
        return posts;
    }
}