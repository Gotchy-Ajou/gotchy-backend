package ajou.se.gotchy.repository;
 import java.util.Optional;
import ajou.se.gotchy.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
     Optional<Users> findByName(String name);
}
