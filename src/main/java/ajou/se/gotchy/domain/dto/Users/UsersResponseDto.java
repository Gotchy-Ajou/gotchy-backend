package ajou.se.gotchy.domain.dto.Users;

import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class UsersResponseDto {
    Long usersId;
    String password;
    String name;
    String nickname;
    String photoUrl;
    String gender;
    int age;
    String phone;
    String region;
    String manner;
    String account;
    String createdDate;
    String modifiedDate;

    public UsersResponseDto(Users users){
        this.usersId = users.getUsersId();
        this.password = users.getPassword();
        this.name = users.getName();
        this.nickname = users.getNickname();
        this.photoUrl = users.getPhotoUrl();
        this.gender = users.getGender();
        this.age = users.getAge();
        this.phone = users.getPhone();
        this.region = users.getRegion();
        this.manner = users.getManner();
        this.account = users.getAccount();
        this.createdDate = users.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        this.modifiedDate = users.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
