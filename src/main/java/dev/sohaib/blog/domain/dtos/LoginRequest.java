package dev.sohaib.blog.domain.dtos;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {}