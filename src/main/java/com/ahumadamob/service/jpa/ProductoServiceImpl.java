package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.Producto;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.ProductoRepository;
import com.ahumadamob.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto", id));
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
