package ajou.se.gotchy.domain.dto;
import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.Getter;

@Getter
public class GotchyFilterDto {
    String mode;
    String gotchyHobby;
    String location;
    int headcount;
    String level;
    String gender;

    public GotchyFilterDto(Gotchy gotchy){
        this.mode = gotchy.getMode();
        this.gotchyHobby = gotchy.getGotchyHobby();
        this.location = gotchy.getLocation();
        this.headcount = gotchy.getHeadcount();
        this.level = gotchy.getLevel();
        this.gender = gotchy.getGender();
    }

    @Override
    public String toString() {
        return "GotchyFilterDto [mode=" + mode + ", gotchyHobby=" + gotchyHobby + ", location=" + location + "]";
    }
}