package com.tienda.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "tb_ventas")

public class Venta implements Serializable {


    public enum TipoComprobante {
        FACTURA,
        BOLETA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    // Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comprobante", length = 10, nullable = false)
    private TipoComprobante tipoComprobante;  

    // Datos de totales y subtotales
    @Column(name = "sub_total_ventas", nullable = false)
    private double subTotalVentas;

    @Column(name = "anticipos", nullable = false)
    private double anticipos;

    @Column(name = "descuentos", nullable = false)
    private double descuentos;

    @Column(name = "valor_venta", nullable = false)
    private double valorVenta;

    @Column(name = "isc", nullable = false)
    private double isc;

    @Column(name = "igv", nullable = false)
    private double igv;

    @Column(name = "icbper", nullable = false)
    private double icbper;

    @Column(name = "otros_cargos", nullable = false)
    private double otrosCargos;

    @Column(name = "otros_tributos", nullable = false)
    private double otrosTributos;

    @Column(name = "monto_redondeo", nullable = false)
    private double montoRedondeo;

    @Column(name = "importe_total", nullable = false)
    private double importeTotal;

    // Relación con DetalleVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta;

    public Venta() {
    }

    public Venta(Long idVenta, Cliente cliente, Date fecha, TipoComprobante tipoComprobante, double subTotalVentas,
            double anticipos, double descuentos, double valorVenta, double isc, double igv, double icbper,
            double otrosCargos, double otrosTributos, double montoRedondeo, double importeTotal,
            List<DetalleVenta> detallesVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.subTotalVentas = subTotalVentas;
        this.anticipos = anticipos;
        this.descuentos = descuentos;
        this.valorVenta = valorVenta;
        this.isc = isc;
        this.igv = igv;
        this.icbper = icbper;
        this.otrosCargos = otrosCargos;
        this.otrosTributos = otrosTributos;
        this.montoRedondeo = montoRedondeo;
        this.importeTotal = importeTotal;
        this.detallesVenta = detallesVenta;
    }

    
}
