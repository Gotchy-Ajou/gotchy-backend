package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Posts;
import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    String title;
    String content;
    Users author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
