package ajou.se.gotchy.domain.dto.Posts;

import ajou.se.gotchy.domain.entity.Posts;
import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    Long authorId;
    String title;
    String content;

}
