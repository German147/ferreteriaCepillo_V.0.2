package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private Integer id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Boolean hay_stock;

    public void restarExistencia(Float cantidad) {
    }
}
