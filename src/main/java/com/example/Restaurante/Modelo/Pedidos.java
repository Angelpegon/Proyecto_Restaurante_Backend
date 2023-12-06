package com.example.Restaurante.Modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pedidos")
public class Pedidos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_generator")
    @SequenceGenerator(name = "pedidos_generator", sequenceName = "pedidos_seq", allocationSize = 1)
    private Long id;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-0500")
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn (name="id_meseros")
    private Meseros mesero;
    @ManyToOne
    @JoinColumn (name="id_mesas")
    private Mesa mesa;
    @ManyToOne
    @JoinColumn (name="id_estados")
    private Estados estado;
    @ManyToOne
    @JoinColumn (name="id_mediosdepago")
    private MediosdePago mediodepago;
    @ManyToOne
    @JoinColumn (name="id_tiposdepedido")
    private TipodePedido tipodepedido;
    @ManyToOne
    @JoinColumn (name="id_clientes")
    private Clientes cliente;
}
