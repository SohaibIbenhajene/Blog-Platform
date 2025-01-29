# Blog Platform

## Overview

A web app for creating, managing, and publishing blog posts with reader engagement features.

## Features

- Rich text editor with formatting options
- Categorization and tagging
- Draft management with previews

## Extras

- Comments with timestamps and basic formatting
- Full-text search, filtering, sorting
- SEO metadata, RSS feed, archive view

## Tech Stack

- Frontend: React.js
- Backend: Java Spring Boot
- Database: PostgreSQL
- Authentication: Spring Security & JWT
- Styling: Tailwind CSS
- Deployment: Vercel / Docker

## Data Model

```mermaid
erDiagram
    User {
        UUID id
        string email
        string password
        timestamp createdAt
    }
    
    Post {
        UUID id
        string title
        string content
        UUID userId
        UUID categoryId
        Poststatus status
        int readingTime
        timestamp createdAt
        timestamp updatedAt
    }
    
    Category {
        UUID id
        string name
    }
    
    PostTags {
        UUID postId
        UUID tagId
    }
    
    Tag {
        UUID id
        string name
    }
    
    User ||--o{ Post : owns
    Category ||--o{ Post : categorizes
    Post ||--o{ PostTags : has
    Tag ||--o{ PostTags : tagged
```

## Enumerations

### PostStatus
Defines the status of a blog post:
- `DRAFT`
- `PUBLISHED`

