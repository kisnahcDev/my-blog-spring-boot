package com.project.myblog.dto;

import com.project.myblog.domain.Member;
import com.project.myblog.domain.board.Post;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreatePostRequestDto {

    @NotEmpty(message = "제목을 작성해 주세요.")
    private String title;

    private String authorEmail;

    @NotNull
    private String content;

    public Post toPost(Member member) {
        return Post.builder()
                .title(getTitle())
                .author(member)
                .content(getContent())
                .build();
    }
}
