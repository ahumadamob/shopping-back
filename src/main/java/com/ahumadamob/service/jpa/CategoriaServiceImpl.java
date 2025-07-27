package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.Categoria;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.exception.CircularReferenceException;
import com.ahumadamob.repository.CategoriaRepository;
import com.ahumadamob.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria", id));
    }

    @Override
    public Categoria create(Categoria categoria) {
        validateNoCircularReference(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        validateNoCircularReference(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    private void validateNoCircularReference(Categoria categoria) {
        Categoria parent = categoria.getParent();
        Long id = categoria.getId();
        while (parent != null) {
            if (id != null && parent.getId() != null && parent.getId().equals(id)) {
                throw new CircularReferenceException("Parent cannot be a descendant of the category");
            }
            parent = parent.getParent();
        }
    }
}
