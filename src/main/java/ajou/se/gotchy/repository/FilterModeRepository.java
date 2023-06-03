package ajou.se.gotchy.repository;

import ajou.se.gotchy.domain.entity.Gotchy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterModeRepository extends JpaRepository<Gotchy, Long> {
}
