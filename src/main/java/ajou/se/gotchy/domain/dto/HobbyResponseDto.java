package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Hobby;
import lombok.Getter;

@Getter
public class HobbyResponseDto {
    Long hobbyId;
    String hobbyName;
    String hobbyLevel;

    public HobbyResponseDto(Hobby hobby) {
        this.hobbyId = hobby.getHobbyId();
        this.hobbyName = hobby.getHobbyName();
        this.hobbyLevel = hobby.getHobbyLevel();
    }
}
