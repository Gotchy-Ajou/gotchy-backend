package ajou.se.gotchy.domain.dto.Users;

import ajou.se.gotchy.domain.entity.Gotchy;
import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;

@Getter
public class UserWithGotchyResponseDto {
    Long usersId;
    Long gotchyId;
    String userNickname;
    String gotchyName;
    String gotchyMode;
    String gotchyHobby;
    String gotchyDate;
    String gotchyTime;
    String location;
    int headcount;

    public UserWithGotchyResponseDto(Users users, Gotchy gotchy) {
        this.usersId = users.getUsersId();
        this.gotchyId = gotchy.getGotchyId();
        this.userNickname = users.getNickname();
        this.gotchyName = gotchy.getGotchyName();
        this.gotchyMode = gotchy.getMode();
        this.gotchyHobby = gotchy.getGotchyHobby();
        this.gotchyDate = gotchy.getGotchyDate();
        this.gotchyTime = gotchy.getGotchyTime();
        this.location = gotchy.getLocation();
        this.headcount = gotchy.getHeadcount();
    }


}
