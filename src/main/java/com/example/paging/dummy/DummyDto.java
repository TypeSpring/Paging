package com.example.paging.dummy;

import java.time.OffsetDateTime;

import com.example.paging.entity.Post;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DummyDto {
    private String id;
    private String image;
    private String text;
    private OffsetDateTime publishDate;
    private DummyOwner owner;

    public Post toPost() {
        return Post.builder()
                   .title("Title - " + id)
                   .contents(text)
                   .author(owner.getFirstName() + " " + owner.getLastName())
                   .thumbnail(image)
                   .createDate(publishDate.toLocalDateTime())
                   .build();
    }
}
