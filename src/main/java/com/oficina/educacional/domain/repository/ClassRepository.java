package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.Class;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>, JpaSpecificationExecutor<Class> {

    static Specification<Class> isActive(boolean isActive) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("classIsActive"), isActive);
    }

    static Specification<Class> course( long courseId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("classCourse"), courseId);
    }

    static Specification<Class> professor(long professorId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("classProfessor"), professorId);
    }
}
