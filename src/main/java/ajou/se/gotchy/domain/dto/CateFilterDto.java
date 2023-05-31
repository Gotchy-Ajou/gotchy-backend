package ajou.se.gotchy.domain.dto;
import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.Getter;

@Getter
public class CateFilterDto {
    String mode;
    String gotchyHobby;
    String location;
    int headcount;
    String level;
    String gender;

    public GotchyResponseDto(Gotchy gotchy){
        this.mode = gotchy.getMode();
        this.gotchyHobby = gotchy.getGotchyHobby();
        this.location = gotchy.getLocation();
        this.headcount = gotchy.getHeadcount();
        this.level = gotchy.getLevel();
        this.gender = gotchy.getGender();
    }
}