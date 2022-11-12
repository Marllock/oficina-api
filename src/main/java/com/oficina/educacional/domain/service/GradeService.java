package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.GradeInputDTO;
import com.oficina.educacional.api.model.input.GradeUpdateInputDTO;
import com.oficina.educacional.domain.model.Grade;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    public Grade create(GradeInputDTO gradeInputDTO) {
        return null;
    }

    public Grade update(GradeUpdateInputDTO gradeUpdateInputDTO, long gradeId) {
        return null;
    }

    public Page<Grade> index(int page, int perPage, long studentId, long classId) {
        return null;
    }

    public void delete(long gradeId) {

    }

    public Grade show(long gradeId) {
        return null;
    }
}
