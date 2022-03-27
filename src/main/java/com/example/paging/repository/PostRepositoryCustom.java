package com.example.paging.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.example.paging.dto.PostDto;

public interface PostRepositoryCustom {
    Page<PostDto> search(Pageable pageable);

    Slice<PostDto> searchV2(Pageable pageable);
}
