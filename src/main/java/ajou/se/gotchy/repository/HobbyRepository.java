package ajou.se.gotchy.repository;

import ajou.se.gotchy.domain.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby,Long> {
}
