package ajou.se.gotchy.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

    @Column(nullable = false)
    private String hobbyName;

    @Column(nullable = false)
    private String hobbyLevel;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    @Builder
    public Hobby(String hobbyName, String hobbyLevel){
        this.hobbyName = hobbyName;
        this.hobbyLevel = hobbyLevel;
    }

    public Hobby update(String hobbyLevel){
        this.hobbyLevel = hobbyLevel;
        return this;
    }

    // Hobby와 Users의 연관관계 생성 메소드
    public void addUsers(Users users) {
        this.users = users;
        users.getHobbyList().add(this);
    }
}
