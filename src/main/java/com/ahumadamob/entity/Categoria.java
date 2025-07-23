package com.ahumadamob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.ahumadamob.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class Categoria extends BaseEntity {

    @Column(name = "nombre", nullable = false, length = 64)
    @NotBlank
    @Size(max = 64)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categoria parent;

}
