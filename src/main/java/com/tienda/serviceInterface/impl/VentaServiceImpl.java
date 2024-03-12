package com.tienda.serviceInterface.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.model.dao.VentaDao;
import com.tienda.model.dto.VentaDto;
import com.tienda.model.entity.Venta;
import com.tienda.serviceInterface.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    private VentaDao ventaDao;


    @Override
    public List<VentaDto> obtenerVenta() {
        List<Venta> ventas = ventaDao.findAll();
        return ventas.stream()
                .map(venta -> mapToVentaDto(venta))
                .collect(Collectors.toList());
    }

    @Override
    public List<Venta> Listar() {
        return (List<Venta>) ventaDao.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Venta Guardar(VentaDto ventaDto) {
        Venta venta = mapToVentaEntity(ventaDto);
        return ventaDao.save(venta);
    }

    @SuppressWarnings("null")
    @Override
    public Venta Actualizar(VentaDto ventaDto, Integer idVenta) {
        Optional<Venta> optionalVenta = ventaDao.findById(idVenta);

        if (optionalVenta.isPresent()) {
            Venta ventaExistente = optionalVenta.get();
            // Actualiza los campos necesarios con los valores del DTO
            // Puedes usar un mapeo similar al de mapToVentaEntity
            // ...
            return ventaDao.save(ventaExistente);
        } else {
            throw new RuntimeException("Venta no encontrada con id " + idVenta);
        }
    }

    @SuppressWarnings("null")
    @Override
    public Venta ListarId(Integer id) {
        return ventaDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id " + id));
    }

    @SuppressWarnings("null")
    @Override
    public void Eliminar(Venta venta) {
        ventaDao.delete(venta);
    }

    @SuppressWarnings("null")
    @Override
    public boolean ExisteId(Integer idVenta) {
        return ventaDao.existsById(idVenta);
    }

    // Métodos de mapeo entre entidades y DTOs
    private VentaDto mapToVentaDto(Venta venta) {
        // Implementa el mapeo de Venta a VentaDto según tus necesidades
        // ...
        return new VentaDto(/* asigna los valores correspondientes */);
    }

    private Venta mapToVentaEntity(VentaDto ventaDto) {
        // Implementa el mapeo de VentaDto a Venta según tus necesidades
        // ...
        return new Venta(/* asigna los valores correspondientes */);
    }
}
