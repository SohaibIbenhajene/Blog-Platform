package dev.sohaib.blog.domain.dtos;

import dev.sohaib.blog.domain.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private UUID id;
    private String title;
    private String content;
    private AuthorResponse author;
    private CategoryResponse category;
    private Set<TagResponse> tags;
    private Integer readingTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PostStatus status;
}
