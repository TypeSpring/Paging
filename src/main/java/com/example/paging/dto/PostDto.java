package com.example.paging.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDto {
    private Long id;
    private String thumbnail;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
