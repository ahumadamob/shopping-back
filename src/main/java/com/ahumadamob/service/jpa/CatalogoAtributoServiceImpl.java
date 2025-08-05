package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.CatalogoAtributo;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.CatalogoAtributoRepository;
import com.ahumadamob.service.ICatalogoAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoAtributoServiceImpl implements ICatalogoAtributoService {

    @Autowired
    private CatalogoAtributoRepository catalogoAtributoRepository;

    @Override
    public List<CatalogoAtributo> findAll() {
        return catalogoAtributoRepository.findAll();
    }

    @Override
    public CatalogoAtributo findById(Long id) {
        return catalogoAtributoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CatalogoAtributo", id));
    }

    @Override
    public CatalogoAtributo create(CatalogoAtributo catalogoAtributo) {
        return catalogoAtributoRepository.save(catalogoAtributo);
    }

    @Override
    public CatalogoAtributo update(CatalogoAtributo catalogoAtributo) {
        return catalogoAtributoRepository.save(catalogoAtributo);
    }

    @Override
    public void deleteById(Long id) {
        catalogoAtributoRepository.deleteById(id);
    }
}
