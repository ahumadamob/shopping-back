package com.ahumadamob.service;

import com.ahumadamob.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);
}
