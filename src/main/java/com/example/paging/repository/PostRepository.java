package com.example.paging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paging.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}