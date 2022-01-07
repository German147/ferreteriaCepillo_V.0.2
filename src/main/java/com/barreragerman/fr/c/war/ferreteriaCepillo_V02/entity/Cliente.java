package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;

}
