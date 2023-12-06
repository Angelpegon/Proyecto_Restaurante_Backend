package com.example.Restaurante.Repositorio;

import com.example.Restaurante.Modelo.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface MesasRepositorio extends JpaRepository<Mesa,Long> {
    @Query("SELECT m FROM Mesa m WHERE NOT EXISTS (SELECT p FROM Pedidos p WHERE p.mesa = m AND p.estado = 1)  ORDER BY m.nombre ASC")
    List<Mesa> verMesasLibres();
}
