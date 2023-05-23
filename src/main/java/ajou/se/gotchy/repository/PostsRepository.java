package ajou.se.gotchy.repository;

import ajou.se.gotchy.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
