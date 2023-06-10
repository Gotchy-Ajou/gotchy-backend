package ajou.se.gotchy.domain.dto.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    Long authorId;
    String title;
    String content;

}
