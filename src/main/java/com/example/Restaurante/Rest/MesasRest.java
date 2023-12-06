package com.example.Restaurante.Rest;

import com.example.Restaurante.Modelo.Mesa;
import com.example.Restaurante.Servicio.MesasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/mesas/")
public class MesasRest {
    @Autowired
    private MesasServicio mesasServicio;

    @GetMapping
    private ResponseEntity<List<Mesa>> getAllMesas (){
        return ResponseEntity.ok(mesasServicio.findAll());
    }
    @GetMapping(value = "verMesasLibres")
    private ResponseEntity<List<Mesa>> verMesasLibres (){
        return ResponseEntity.ok(mesasServicio.verMesasLibres());
    }
    @PostMapping
    private ResponseEntity<Mesa> saveMesa (@RequestBody Mesa mesa){
        try {
            Mesa mesaGuardada = mesasServicio.save(mesa);
            return ResponseEntity.created(new URI("/mesas/"+mesaGuardada.getId())).body(mesaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping(value = "delete/{id}")
    private ResponseEntity<Boolean> deleteMesa (@PathVariable("id") Long id){
        mesasServicio.deleteById(id);
        return ResponseEntity.ok(mesasServicio.findById(id).isEmpty());
    }
}
