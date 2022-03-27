package com.example.paging.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.paging.dto.PostDto;
import com.example.paging.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Page<PostDto> getPosts(Pageable pageable) {
        return postRepository.search(pageable);
    }

    public Slice<PostDto> getPostsV2(Pageable pageable) {
        return postRepository.searchV2(pageable);
    }
}
