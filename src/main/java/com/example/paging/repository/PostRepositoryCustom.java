package com.example.paging.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.paging.dto.PostDto;

public interface PostRepositoryCustom {
    List<PostDto> search(Pageable pageable);
}
