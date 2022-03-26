package com.example.paging.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String thumbnail;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @QueryProjection
    public PostDto(final Long id, final String thumbnail, final String title, final String contents, final String author, final LocalDateTime createDate,
                   final LocalDateTime updateDate) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
