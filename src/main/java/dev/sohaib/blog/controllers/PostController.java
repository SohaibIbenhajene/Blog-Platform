package dev.sohaib.blog.controllers;

import dev.sohaib.blog.domain.CreatePostRequest;
import dev.sohaib.blog.domain.UpdatePostRequest;
import dev.sohaib.blog.domain.dtos.CreatePostRequestResponse;
import dev.sohaib.blog.domain.dtos.PostResponse;
import dev.sohaib.blog.domain.dtos.UpdatePostRequestResponse;
import dev.sohaib.blog.domain.entities.Post;
import dev.sohaib.blog.domain.entities.User;
import dev.sohaib.blog.mappers.PostMapper;
import dev.sohaib.blog.services.PostService;
import dev.sohaib.blog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(
            @RequestParam(required = false)UUID categoryId,
            @RequestParam(required = false)UUID tagId) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostResponse> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostResponse>> getDrafts(@RequestAttribute UUID userId) {
        User loggedInUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggedInUser);
        List<PostResponse> postDtos = draftPosts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @Valid @RequestBody CreatePostRequestResponse createPostRequestResponse,
            @RequestAttribute UUID userId) {
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestResponse);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostResponse createdPostDto = postMapper.toDto(createdPost);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostResponse> updatePost (
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePostRequestResponse updatePostRequestResponse) {
        UpdatePostRequest updatePostRequest = postMapper.toUpdatePostRequest(updatePostRequestResponse);
        Post updatedPost = postService.updatePost(id, updatePostRequest);
        PostResponse updatedPostDto = postMapper.toDto(updatedPost);
        return ResponseEntity.ok(updatedPostDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostResponse> getPost(
            @PathVariable UUID id) {
        Post post = postService.getPost(id);
        PostResponse postDto = postMapper.toDto(post);
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(
            @PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
