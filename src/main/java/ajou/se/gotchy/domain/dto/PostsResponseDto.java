package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Posts;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class PostsResponseDto {
    Long postsId;
    String title;
    String content;
    String author;
    String createdDate;
    String modifiedDate;

    public PostsResponseDto(Posts posts){
        this.postsId = posts.getPostsId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor().getNickname();
        this.createdDate = posts.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        this.modifiedDate = posts.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
