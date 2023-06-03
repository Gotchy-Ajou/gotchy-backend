package ajou.se.gotchy.domain.entity;

import ajou.se.gotchy.domain.BaseTimeEntity;
import ajou.se.gotchy.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usersId;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column
    private String photoUrl;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String manner;

    @Column(nullable = false, unique = true)
    private String account;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Gotchy> gotchyList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Hobby> hobbyList = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Posts> postsList = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Users(String password, String name, String nickname, String photoUrl, String gender, int age, String phone, String region, String manner, String account, Role role){
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.photoUrl = photoUrl;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.region = region;
        this.manner = manner;
        this.account = account;
        this.role = role;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public Users update(String password, String photoUrl, String phone, String region, String account){
        this.password = password;
        this.photoUrl = photoUrl;
        this.phone = phone;
        this.region = region;
        this.account = account;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    // Gotchy와 Users 연관관계 매핑 메소드 (단방향 Gothcy -> Users)
    public void addGotchy(Gotchy gotchy) {
        this.gotchyList.add(gotchy);
    }

}
