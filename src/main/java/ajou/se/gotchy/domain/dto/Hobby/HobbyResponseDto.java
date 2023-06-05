package ajou.se.gotchy.domain.dto.Hobby;

import ajou.se.gotchy.domain.entity.Hobby;
import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;

@Getter
public class HobbyResponseDto {
    Long hobbyId;
    Long usersId;
    String hobbyName;
    String hobbyLevel;

    public HobbyResponseDto(Users users, Hobby hobby) {
        this.hobbyId = hobby.getHobbyId();
        this.usersId = users.getUsersId();
        this.hobbyName = hobby.getHobbyName();
        this.hobbyLevel = hobby.getHobbyLevel();
    }
}

// 프론트단에서 사용자 취미별 레벨 조회시
// hobbyId 빼고 name이랑 level만 가져다가 사용하시면 될 듯 싶습니당