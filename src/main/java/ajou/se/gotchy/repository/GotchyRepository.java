package ajou.se.gotchy.repository;

import ajou.se.gotchy.domain.entity.Gotchy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GotchyRepository extends JpaRepository<Gotchy, Long> {
    List<Gotchy> findByMode(String mode);
    
    List<Gotchy> findByLocation(String location);
    
    List<Gotchy> findByLevel(String level);
    
    List<Gotchy> findByGender(String gender);
    
    List<Gotchy> findByHeadcount(int headcount);
    
    List<Gotchy> findByGotchyHobby(String gotchyHobby);
}
