package dev.sohaib.blog.domain.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryResponse(UUID id, String name, long postCount) {}