package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class GotchyResponseDto {
    Long gotchyId;
    String mode;
    String gotchyHobby;
    LocalDate gotchyDate;
    String location;
    String gotchyPhotoUrl;
    int price;
    int headcount;
    String level;
    String gender;
    String useTime;
    String createdDate;
    String modifiedDate;

    public GotchyResponseDto(Gotchy gotchy){
        this.gotchyId = gotchy.getGotchyId();
        this.mode = gotchy.getMode();
        this.gotchyHobby = gotchy.getGotchyHobby();
        this.gotchyDate = gotchy.getGotchyDate();
        this.location = gotchy.getLocation();
        this.gotchyPhotoUrl = gotchy.getGotchyPhotoUrl();
        this.price = gotchy.getPrice();
        this.headcount = gotchy.getHeadcount();
        this.level = gotchy.getLevel();
        this.gender = gotchy.getGender();
        this.useTime = gotchy.getUseTime();
        this.createdDate = gotchy.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        this.modifiedDate = gotchy.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
