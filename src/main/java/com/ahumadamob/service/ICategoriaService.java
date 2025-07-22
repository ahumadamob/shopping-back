package com.ahumadamob.service;

import com.ahumadamob.entity.Categoria;

import java.util.List;


public interface ICategoriaService {
    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria create(Categoria categoria);
    Categoria update(Categoria categoria);
    void deleteById(Long id);
}
