package com.example.paging.dummy;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.paging.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DummyService {

    @Value("${fake.api.appId}")
    private String appId;

    private final PostRepository postRepository;
    private final DummyClient client;

    @Transactional
    public void insert(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, 50);
        final DummyResponse response = client.getDummy(appId, pageable);

        response.getData().stream()
                  .map(DummyDto::toPost)
                  .forEach(post -> postRepository.save(post));
    }

}