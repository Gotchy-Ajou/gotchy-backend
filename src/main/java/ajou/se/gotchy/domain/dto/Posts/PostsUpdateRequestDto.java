package ajou.se.gotchy.domain.dto.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    String title;
    String content;
}
