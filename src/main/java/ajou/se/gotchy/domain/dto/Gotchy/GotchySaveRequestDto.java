package ajou.se.gotchy.domain.dto.Gotchy;

import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GotchySaveRequestDto {
    String gotchyName;
    String mode;
    String gotchyHobby;
    String gotchyDate;
    String gotchyTime;
    String location;
    String gotchyPhotoUrl;
    int price;
    int headcount;
    String level;
    String gender;
    String useTime;

    public Gotchy toEntity() {
        return Gotchy.builder()
                .gotchyName(gotchyName)
                .mode(mode)
                .gotchyHobby(gotchyHobby)
                .gotchyDate(gotchyDate)
                .gotchyTime(gotchyTime)
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
