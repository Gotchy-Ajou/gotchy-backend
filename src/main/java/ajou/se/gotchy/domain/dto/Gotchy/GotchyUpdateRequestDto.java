package ajou.se.gotchy.domain.dto.Gotchy;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GotchyUpdateRequestDto {
    String gotchyName;
    String mode;
    String gotchyDate;
    String gotchyTime;
    String location;
    String gotchyPhotoUrl;
    int price;
    int headcount;
    String level;
    String gender;
    String useTime;
}