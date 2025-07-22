package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.Categoria;
import com.ahumadamob.repository.CategoriaRepository;
import com.ahumadamob.service.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceIml implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceIml(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
