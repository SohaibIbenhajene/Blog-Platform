package dev.sohaib.blog.services;

import dev.sohaib.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
