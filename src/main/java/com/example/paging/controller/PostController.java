package com.example.paging.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paging.dto.PostDto;
import com.example.paging.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getPosts(@PageableDefault(size = 10, page = 0, sort = "create_date", direction = Direction.DESC) Pageable pageable) {
        return postService.getPosts(pageable);
    }
}
