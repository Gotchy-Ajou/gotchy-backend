package ajou.se.gotchy.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateReqeustDto {
    String title;
    String content;
}
