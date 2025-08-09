package com.ahumadamob.repository;

import com.ahumadamob.entity.ProductoAtributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoAtributoRepository extends JpaRepository<ProductoAtributo, Long> {
}
