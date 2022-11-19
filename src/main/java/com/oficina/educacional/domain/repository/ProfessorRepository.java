package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.Professor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>, JpaSpecificationExecutor<Professor> {

    static Specification<Professor> userId(Long userId) {
        return (root, cq, cb) -> cb.equal(root.get("user").get("userId"), userId);
    }

    static Specification<Professor> courseId(long courseId) {
        return (root, cq, cb) -> cb.equal(root.get("professorCourse").get("courseId"), courseId);
    }

    static Specification<Professor> userName(String userName){
        return (root, cq, cb) -> cb.like(root.get("user").get("userNormalizedName"), "%"+userName+"%");
    }

    static Specification<Professor> userEmail(String userEmail){
        return (root, cq, cb) -> cb.equal(root.get("user").get("userEmail"), userEmail);
    }

    static Specification<Professor> userProfile(long userProfile){
        return (root, cq, cb) -> cb.equal(root.get("user").get("userProfile"), userProfile);
    }
}
