package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GotchySaveRequestDto {
    String mode;
    String gotchyHobby;
    LocalDate gotchyDate;
    String location;
    String gotchyPhotoUrl;
    int price;
    Integer headcount;
    String level;
    String gender;
    String useTime;

    public Gotchy toEntity() {
        return Gotchy.builder()
                .mode(mode)
                .gotchyHobby(gotchyHobby)
                .gotchyDate(gotchyDate)
                .location(location)
                .gotchyPhotoUrl(gotchyPhotoUrl)
                .price(price)
                .headcount(headcount)
                .level(level)
                .gender(gender)
                .useTime(useTime)
                .build();
    }
}
