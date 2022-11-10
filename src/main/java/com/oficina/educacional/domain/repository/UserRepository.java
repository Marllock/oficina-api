package com.oficina.educacional.domain.repository;

import com.oficina.educacional.domain.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    static Specification<User> index(){
        return null;
    }

    Optional<User> findByUserEmail(String userEmail);
}
