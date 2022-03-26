package com.example.paging.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.paging.dto.QPostDto is a Querydsl Projection type for PostDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPostDto extends ConstructorExpression<PostDto> {

    private static final long serialVersionUID = -150460385L;

    public QPostDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> thumbnail, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> contents, com.querydsl.core.types.Expression<String> author, com.querydsl.core.types.Expression<java.time.LocalDateTime> createDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> updateDate) {
        super(PostDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, thumbnail, title, contents, author, createDate, updateDate);
    }

}

