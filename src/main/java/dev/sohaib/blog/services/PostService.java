package dev.sohaib.blog.services;

import dev.sohaib.blog.domain.CreatePostRequest;
import dev.sohaib.blog.domain.UpdatePostRequest;
import dev.sohaib.blog.domain.entities.Post;
import dev.sohaib.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
