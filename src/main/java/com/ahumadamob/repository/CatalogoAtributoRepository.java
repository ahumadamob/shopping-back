package com.ahumadamob.repository;

import com.ahumadamob.entity.CatalogoAtributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoAtributoRepository extends JpaRepository<CatalogoAtributo, Long> {
}
