package ajou.se.gotchy.repository;

import ajou.se.gotchy.domain.dto.Gotchy.GotchySaveRequestDto;
import ajou.se.gotchy.domain.entity.Gotchy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GotchySpecifications {

    public static Specification<Gotchy> withFilter(GotchySaveRequestDto dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getMode() != null) {
                predicates.add(criteriaBuilder.equal(root.get("mode"), dto.getMode()));
            }
            if (dto.getLocation() != null) {
                predicates.add(criteriaBuilder.equal(root.get("location"), dto.getLocation()));
            }
            if (dto.getLevel() != null) {
                predicates.add(criteriaBuilder.equal(root.get("level"), dto.getLevel()));
            }
            if (dto.getGender() != null) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), dto.getGender()));
            }
            if (dto.getHeadcount() != null) {
                predicates.add(criteriaBuilder.equal(root.get("headcount"), dto.getHeadcount()));
            }
            if (dto.getGotchyHobby() != null) {
                predicates.add(criteriaBuilder.equal(root.get("gotchyHobby"), dto.getGotchyHobby()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}