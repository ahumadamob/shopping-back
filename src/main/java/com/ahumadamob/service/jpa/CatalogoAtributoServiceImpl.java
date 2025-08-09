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
        validate(catalogoAtributo);
        return catalogoAtributoRepository.save(catalogoAtributo);
    }

    @Override
    public CatalogoAtributo update(CatalogoAtributo catalogoAtributo) {
        validate(catalogoAtributo);
        return catalogoAtributoRepository.save(catalogoAtributo);
    }

    @Override
    public void deleteById(Long id) {
        catalogoAtributoRepository.deleteById(id);
    }

    private void validate(CatalogoAtributo catalogoAtributo) {
        if (catalogoAtributo.getOrden() != null && catalogoAtributo.getOrden() < 0) {
            throw new IllegalArgumentException("orden debe ser un valor positivo");
        }
        if (catalogoAtributo.getValorMin() != null && catalogoAtributo.getValorMax() != null
                && catalogoAtributo.getValorMin() > catalogoAtributo.getValorMax()) {
            throw new IllegalArgumentException("valorMin no puede ser mayor que valorMax");
        }
    }
}
