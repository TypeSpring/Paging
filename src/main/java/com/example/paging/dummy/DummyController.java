package com.example.paging.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/api/v1/dummy")
@RestController
@Slf4j
public class DummyController {

    private final DummyService dummyService;

    @GetMapping("/start")
    public void start() {
        for (int pageNumber = 0; pageNumber < 18; pageNumber++) {
            log.info("{} 페이지 insert 시작", pageNumber);
            dummyService.insert(pageNumber);
        }
    }
}
