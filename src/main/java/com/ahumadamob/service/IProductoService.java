package com.ahumadamob.service;

import com.ahumadamob.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto create(Producto producto);
    Producto update(Producto producto);
    void deleteById(Long id);
}
