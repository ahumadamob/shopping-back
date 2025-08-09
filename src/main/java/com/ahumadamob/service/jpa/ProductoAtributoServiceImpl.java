package com.ahumadamob.service.jpa;

import com.ahumadamob.common.DataType;
import com.ahumadamob.common.DataTypeUtils;
import com.ahumadamob.entity.ProductoAtributo;
import com.ahumadamob.entity.Producto;
import com.ahumadamob.entity.CatalogoAtributo;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.ProductoAtributoRepository;
import com.ahumadamob.service.IProductoAtributoService;
import com.ahumadamob.service.IProductoService;
import com.ahumadamob.service.ICatalogoAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoAtributoServiceImpl implements IProductoAtributoService {

    @Autowired
    private ProductoAtributoRepository productoAtributoRepository;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICatalogoAtributoService catalogoAtributoService;

    @Override
    public List<ProductoAtributo> findAll() {
        return productoAtributoRepository.findAll();
    }

    @Override
    public ProductoAtributo findById(Long id) {
        return productoAtributoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductoAtributo", id));
    }

    @Override
    public ProductoAtributo create(ProductoAtributo productoAtributo) {
        Long productoId = productoAtributo.getProducto() != null ? productoAtributo.getProducto().getId() : null;
        if (productoId != null) {
            Producto producto = productoService.findById(productoId);
            productoAtributo.setProducto(producto);
        }
        Long catalogoId = productoAtributo.getCatalogoAtributo() != null ? productoAtributo.getCatalogoAtributo().getId() : null;
        if (catalogoId != null) {
            CatalogoAtributo catalogo = catalogoAtributoService.findById(catalogoId);
            productoAtributo.setCatalogoAtributo(catalogo);
        }
        normalizeValor(productoAtributo);
        return productoAtributoRepository.save(productoAtributo);
    }

    @Override
    public ProductoAtributo update(ProductoAtributo productoAtributo) {
        Long productoId = productoAtributo.getProducto() != null ? productoAtributo.getProducto().getId() : null;
        if (productoId != null) {
            Producto producto = productoService.findById(productoId);
            productoAtributo.setProducto(producto);
        }
        Long catalogoId = productoAtributo.getCatalogoAtributo() != null ? productoAtributo.getCatalogoAtributo().getId() : null;
        if (catalogoId != null) {
            CatalogoAtributo catalogo = catalogoAtributoService.findById(catalogoId);
            productoAtributo.setCatalogoAtributo(catalogo);
        }
        normalizeValor(productoAtributo);
        return productoAtributoRepository.save(productoAtributo);
    }

    @Override
    public void deleteById(Long id) {
        productoAtributoRepository.deleteById(id);
    }

    private void normalizeValor(ProductoAtributo productoAtributo) {
        if (productoAtributo.getCatalogoAtributo() != null) {
            var catalogo = productoAtributo.getCatalogoAtributo();
            var tipo = catalogo.getDataType();
            var valorNormalizado = DataTypeUtils.normalize(productoAtributo.getValor(), tipo);
            if (tipo == DataType.NUMERIC) {
                Double valor = Double.valueOf(valorNormalizado);
                if (catalogo.getValorMin() != null && valor < catalogo.getValorMin()) {
                    throw new IllegalArgumentException("valor por debajo de valorMin");
                }
                if (catalogo.getValorMax() != null && valor > catalogo.getValorMax()) {
                    throw new IllegalArgumentException("valor por encima de valorMax");
                }
            }
            productoAtributo.setValor(valorNormalizado);
        }
    }
}
