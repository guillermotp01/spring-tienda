package com.tienda.serviceInterface;

import java.util.List;

import com.tienda.model.dto.VentaDto;
import com.tienda.model.entity.Venta;

public interface IVentaService {
    
    
    public List<VentaDto> obtenerVenta();
    
    public List<Venta> Listar();

    public Venta Guardar(VentaDto ventaDto);

    public Venta Actualizar(VentaDto ventaDto, Integer idVenta);

    public Venta ListarId(Integer id);

    public void Eliminar(Venta venta);

    public boolean ExisteId(Integer idVenta);
}
