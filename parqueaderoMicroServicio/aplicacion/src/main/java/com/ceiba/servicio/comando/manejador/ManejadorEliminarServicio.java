package com.ceiba.servicio.comando.manejador;


import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarServicio implements ManejadorComando<Long> {

    private final ServicioEliminarVehiculo servicioEliminarVehiculo;

    public ManejadorEliminarServicio(ServicioEliminarVehiculo servicioEliminarVehiculo) {
        this.servicioEliminarVehiculo = servicioEliminarVehiculo;
    }

    public void ejecutar(Long idVehiculo) {
        this.servicioEliminarVehiculo.ejecutar(idVehiculo);
    }
}
