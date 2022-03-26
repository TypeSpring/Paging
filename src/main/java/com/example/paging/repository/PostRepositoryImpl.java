package com.example.paging.repository;

import static com.example.paging.entity.QPost.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import com.example.paging.dto.PostDto;
import com.example.paging.dto.QPostDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<PostDto> search(final Pageable pageable) {
        final JPAQuery<PostDto> query = queryFactory.select(new QPostDto(
                                                            post.id,
                                                            post.thumbnail,
                                                            post.title,
                                                            post.contents,
                                                            post.author,
                                                            post.createDate,
                                                            post.updateDate
                                                    )).from(post)
                                                    .offset(pageable.getOffset())
                                                    .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(post.getType(), post.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(o.getProperty())));
        }

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);

    }
}
