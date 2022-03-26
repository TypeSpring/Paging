package com.example.paging.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.paging.dto.PostDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostDto> search(final Pageable pageable) {
        return List.of(new PostDto());
    }
}
