package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.repository;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
