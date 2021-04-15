package com.ceiba.servicio.comando.fabrica;

import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicio {
    public Servicio crear(ComandoServicio comandoServicio) {
        return new Servicio(
                comandoServicio.getId(),
                comandoServicio.getVehiculo(),
                comandoServicio.getFechaEntrada(),
                comandoServicio.getFechaSalida(),
                comandoServicio.getActivo(),
                comandoServicio.getValorAPagar(),
                comandoServicio.getHoras()
        );
    }
    public Servicio actualizar(ComandoServicio comandoServicio) {
        return new Servicio(
                comandoServicio.getId(),
                comandoServicio.getVehiculo(),
                comandoServicio.getFechaEntrada()
        );
    }
}
