package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.Discipline;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>, JpaSpecificationExecutor<Discipline> {

    static Specification<Discipline> index(String disciplineName, String disciplineCode, long courseId) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(!disciplineName.isBlank()) {
                predicates.add(cb.like(root.get("disciplineName"), "%"+disciplineName+"%"));
            }

            if(!disciplineCode.isBlank()) {
                predicates.add(cb.equal(root.get("disciplineCode"), disciplineCode));
            }
            if(courseId != 0L) {
                predicates.add(cb.equal(root.get("courseId"), courseId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}