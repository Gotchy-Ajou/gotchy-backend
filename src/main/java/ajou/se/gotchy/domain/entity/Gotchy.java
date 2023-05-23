package ajou.se.gotchy.domain.entity;

import ajou.se.gotchy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.LazyToOne;
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

    @Column(nullable = false)
    private String mode;

    @Column(nullable = false)
    private String gotchyHobby;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate gotchyDate;

    @Column(nullable = false)
    private String location;

    @Column
    private String gotchyPhotoUrl;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int headcount;

    @Column(nullable = false)
    private String level;

    @Column
    private String gender;

    @Column(nullable = false)
    private String useTime;

    @CreatedDate
    LocalDateTime createdDate;

    @LastModifiedDate
    LocalDateTime modifiedDate;

    @Builder
    public Gotchy(String mode, String gotchyHobby, LocalDate gotchyDate, String location, String gotchyPhotoUrl, int price, int headcount, String level, String gender, String useTime){
        this.mode = mode;
        this.gotchyHobby = gotchyHobby;
        this.gotchyDate = gotchyDate;
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

    public Gotchy update(String mode, LocalDate gotchyDate, String location, String gotchyPhotoUrl, int price, int headcount, String level, String gender, String useTime){
        this.mode = mode;
        this.gotchyDate = gotchyDate;
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
