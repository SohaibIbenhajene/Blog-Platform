package dev.sohaib.blog.mappers;

import dev.sohaib.blog.domain.CreatePostRequest;
import dev.sohaib.blog.domain.UpdatePostRequest;
import dev.sohaib.blog.domain.dtos.CreatePostRequestResponse;
import dev.sohaib.blog.domain.dtos.PostResponse;
import dev.sohaib.blog.domain.dtos.UpdatePostRequestResponse;
import dev.sohaib.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostResponse toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestResponse dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestResponse dto);
}
