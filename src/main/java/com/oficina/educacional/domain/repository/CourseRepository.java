package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.Course;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    static Specification<Course> courseIsActive(Boolean isActive) {
        return (root, query, cb) -> cb.equal(root.get("courseIsActive"), isActive);
    }

    static Specification<Course> courseContainsName(String searchName) {
        return (root, query, cb) -> cb.like(root.get("courseNormalizedName"),"%"+searchName+"%");
    }
}