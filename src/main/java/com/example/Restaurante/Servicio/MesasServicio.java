package com.example.Restaurante.Servicio;

import com.example.Restaurante.Modelo.Mesa;
import com.example.Restaurante.Repositorio.MesasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesasServicio {
    @Autowired
    private MesasRepositorio mesasRepositorio;

    public List<Mesa> findAll() {
        return mesasRepositorio.findAll();
    }
    public List<Mesa> verMesasLibres(){
        return mesasRepositorio.verMesasLibres();
    }
    public List<Mesa> findAll(Sort sort) {
        return mesasRepositorio.findAll(sort);
    }

    public Page<Mesa> findAll(Pageable pageable) {
        return mesasRepositorio.findAll(pageable);
    }

    public <S extends Mesa> S save(S entity) {
        return mesasRepositorio.save(entity);
    }

    public Optional<Mesa> findById(Long id) {
        return mesasRepositorio.findById(id);
    }


    public Boolean deleteById(Long id) {
        if (mesasRepositorio.existsById(id)) {
            mesasRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public void delete(Mesa entity) {
        mesasRepositorio.delete(entity);
    }

}
