package com.example.paging.dummy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dummyClient", url = "https://dummyapi.io/data/v1/post")
public interface DummyClient {
    @GetMapping
    DummyResponse getDummy(@RequestHeader("app-id") String appId, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit);
}
