package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.ClassInputDTO;
import com.oficina.educacional.api.model.input.ClassUpdateInputDTO;
import com.oficina.educacional.domain.model.Class;
import com.oficina.educacional.domain.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public Class create(ClassInputDTO classInputDTO) {
        return null;
    }

    public Class update(ClassUpdateInputDTO classUpdateInputDTO) {
        return null;
    }

    public Page<Class> index(int page, int perPage, String classCode, boolean isActive, long courseId, long professorId) {
        return null;
    }

    public Class show(long classId) {
        return null;
    }

    public void delete(long classId) {

    }
}
