package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.repository;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
