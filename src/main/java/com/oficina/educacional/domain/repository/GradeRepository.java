package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.ClassStudentsKey;
import com.oficina.educacional.domain.model.Grade;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, ClassStudentsKey>, JpaSpecificationExecutor<Grade> {

    static Specification<Grade> filter(Long studentId, Long classId) {
        return (root, cq, cb) -> {
          List<Predicate> predicates = new ArrayList<>();
            if(Objects.nonNull(studentId)) {
                predicates.add(cb.equal(root.get("student"), studentId));
            }

            if(Objects.nonNull(classId)){
                predicates.add(cb.equal(root.get("classModel"), classId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    @Query("SELECT g FROM Grade g WHERE g.gradeId = ?1")
    Optional<Grade> findByGradeId(String gradeId);
}
