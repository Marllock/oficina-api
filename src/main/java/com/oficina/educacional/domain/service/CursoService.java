package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.CursoInputDTO;
import com.oficina.educacional.domain.model.Curso;
import com.oficina.educacional.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

//    @Transactional
//    public Curso createCurso(CursoInputDTO cursoInputDTO) {
//        return cursoRepository.save()
//    }
}
