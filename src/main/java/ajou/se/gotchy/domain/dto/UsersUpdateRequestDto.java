package ajou.se.gotchy.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    String password;
    String photoUrl;
    String phone;
    String region;
    String account;
}