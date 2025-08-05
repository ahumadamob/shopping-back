package com.ahumadamob.service;

import com.ahumadamob.entity.ProductoAtributo;
import java.util.List;

public interface IProductoAtributoService {
    List<ProductoAtributo> findAll();
    ProductoAtributo findById(Long id);
    ProductoAtributo create(ProductoAtributo productoAtributo);
    ProductoAtributo update(ProductoAtributo productoAtributo);
    void deleteById(Long id);
}
