package com.tienda.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class VentaDto {
    private Long idVenta;
    private ClienteDto clienteDto;
    private Date fecha;
    private String tipoComprobante;
    private double subTotalVentas;
    private double anticipos;
    private double descuentos;
    private double valorVenta;
    private double isc;
    private double igv;
    private double icbper;
    private double otrosCargos;
    private double otrosTributos;
    private double montoRedondeo;
    private double importeTotal;
    private List<DetalleVentaDto> detallesVenta;


    public VentaDto() {
        
    }


    public VentaDto(Long idVenta, ClienteDto clienteDto, Date fecha, String tipoComprobante, double subTotalVentas,
            double anticipos, double descuentos, double valorVenta, double isc, double igv, double icbper,
            double otrosCargos, double otrosTributos, double montoRedondeo, double importeTotal,
            List<DetalleVentaDto> detallesVenta) {
        this.idVenta = idVenta;
        this.clienteDto = clienteDto;
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
