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
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String telefono;

}
