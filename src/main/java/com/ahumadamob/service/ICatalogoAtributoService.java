package com.ahumadamob.service;

import com.ahumadamob.entity.CatalogoAtributo;
import java.util.List;

public interface ICatalogoAtributoService {
    List<CatalogoAtributo> findAll();
    CatalogoAtributo findById(Long id);
    CatalogoAtributo create(CatalogoAtributo catalogoAtributo);
    CatalogoAtributo update(CatalogoAtributo catalogoAtributo);
    void deleteById(Long id);
}
