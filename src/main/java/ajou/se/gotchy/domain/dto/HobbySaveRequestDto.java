package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Hobby;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HobbySaveRequestDto {
    String hobbyName;
    String hobbyLevel;

    public Hobby toEntity() {
        return Hobby.builder()
                .hobbyName(hobbyName)
                .hobbyLevel(hobbyLevel)
                .build();
    }
}
