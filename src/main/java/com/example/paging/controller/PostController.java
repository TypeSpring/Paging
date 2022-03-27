package com.example.paging.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paging.dto.PostDto;
import com.example.paging.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    /**
     * PageableDefault로 default size는 10이다.
     * offset은 data의 시작 지점을 의미한다. 그래서 client 측은 ?page=pageNum-1 으로 요청해야 한다.(아님 백엔드에서 처리하던지 하면 된다)
     * 예를 들어, 1번 페이지에서 보여줄 데이터의 offset 0이고, 2번 페이지에서 보여줄 데이터의 offset은 10이다.
     * 1080개의 데이터가 있다면, 전체 페이지 수는 108일 것이고, offset은 0부터 1070으로 하고, size=10만큼 쿼리하면 되는 것이다.
     */
    @GetMapping("/api/v1/posts")
    public Page<PostDto> getPosts(@PageableDefault(sort = "createDate", direction = Direction.DESC) Pageable pageable) {
        log.info("{}", pageable);
        log.info("요청한 페이지 : {}, 크기 : {}", pageable.getOffset(), pageable.getPageSize());
        return postService.getPosts(pageable);
    }

    @GetMapping("/api/v2/posts")
    public Slice<PostDto> getPostsV2(@PageableDefault(sort = "createDate", direction = Direction.DESC) Pageable pageable) {
        log.info("{}", pageable);
        log.info("요청한 페이지 : {}, 크기 : {}", pageable.getOffset(), pageable.getPageSize());
        return postService.getPostsV2(pageable);
    }
}
