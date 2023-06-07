package ajou.se.gotchy.domain.entity;

import ajou.se.gotchy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Gotchy extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gotchyId;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    @Column
    private String gotchyName;

    @Column
    private String mode;

    @Column
    private String gotchyHobby;

    @Column
    private String gotchyDate;

    @Column
    private String gotchyTime;

    @Column
    private String location;

    @Column
    private String gotchyPhotoUrl;

    @Column
    private int price;

    @Column
    private int headcount;

    @Column
    private String level;

    @Column
    private String gender;

    @Column
    private String useTime;

    @CreatedDate
    LocalDateTime createdDate;

    @LastModifiedDate
    LocalDateTime modifiedDate;

    @Builder
    public Gotchy(String gotchyName, String mode, String gotchyHobby, String gotchyDate, String gotchyTime, String location, String gotchyPhotoUrl, int price, int headcount, String level, String gender, String useTime){
        this.gotchyName = gotchyName;
        this.mode = mode;
        this.gotchyHobby = gotchyHobby;
        this.gotchyDate = gotchyDate;
        this.gotchyTime = gotchyTime;
        this.location = location;
        this.gotchyPhotoUrl = gotchyPhotoUrl;
        this.price = price;
        this.headcount = headcount;
        this.level = level;
        this.gender = gender;
        this.useTime = useTime;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public Gotchy update(String gotchyName, String mode, String gotchyDate, String gotchyTime, String location, String gotchyPhotoUrl, int price, int headcount, String level, String gender, String useTime){
        this.gotchyName = gotchyName;
        this.mode = mode;
        this.gotchyDate = gotchyDate;
        this.gotchyTime = gotchyTime;
        this.location = location;
        this.gotchyPhotoUrl = gotchyPhotoUrl;
        this.price = price;
        this.headcount = headcount;
        this.level = level;
        this.gender = gender;
        this.useTime = useTime;

        return this;
    }
}
