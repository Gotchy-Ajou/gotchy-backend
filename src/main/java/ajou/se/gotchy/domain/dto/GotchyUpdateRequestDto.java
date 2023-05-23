package ajou.se.gotchy.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GotchyUpdateRequestDto {
    String mode;
    LocalDate gotchyDate;
    String location;
    String gotchyPhotoUrl;
    int price;
    int headcount;
    String level;
    String gender;
    String useTime;
}