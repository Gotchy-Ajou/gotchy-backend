package ajou.se.gotchy.domain.entity;

import ajou.se.gotchy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postsId;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    @Column(length = 500)
    private String title;

    @Column
    private String content;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Posts(String title, String content){
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public Posts update(String title, String content){
        this.title = title;
        this.content = content;

        return this;
    }

    // Posts와 Users의 연관관계 매핑 메소드 (양방향)
    static public Posts createPost(Users users, String title, String content) {
        Posts posts = Posts.builder()
                .title(title)
                .content(content)
                .build();

        posts.addUser(users);

        return posts;
    }

    public void addUser(Users users) {
        users.getPostsList().add(this);
        this.users = users;
    }
}
