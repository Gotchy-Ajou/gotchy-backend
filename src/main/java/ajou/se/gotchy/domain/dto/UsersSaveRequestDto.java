package ajou.se.gotchy.domain.dto;

import ajou.se.gotchy.domain.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
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

    public Users toEntity() {
        return Users.builder()
                .password(password)
                .name(name)
                .nickname(nickname)
                .photoUrl(photoUrl)
                .gender(gender)
                .age(age)
                .phone(phone)
                .region(region)
                .manner(manner)
                .account(account)
                .build();
    }
}
