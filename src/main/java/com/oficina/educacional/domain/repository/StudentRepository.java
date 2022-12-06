package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    static Specification<Student> course(long courseId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("studentCourse"), courseId);
    }

    static Specification<Student> name(String studentName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user").get("userName"), studentName);
    }
}
