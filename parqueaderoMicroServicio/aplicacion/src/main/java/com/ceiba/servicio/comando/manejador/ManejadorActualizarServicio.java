package com.ceiba.servicio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.fabrica.FabricaServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.servicio.ServicioActualizarServicio;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarServicio implements ManejadorComando<ComandoServicio> {

    private final FabricaServicio fabricaServicio;
    private final ServicioActualizarServicio servicioActualizarServicio;

    public ManejadorActualizarServicio(FabricaServicio fabricaServicio, ServicioActualizarServicio servicioActualizarServicio) {
        this.fabricaServicio = fabricaServicio;
        this.servicioActualizarServicio = servicioActualizarServicio;
    }

    public void ejecutar(ComandoServicio comandoServicio) {

        Servicio servicio = this.fabricaServicio.actualizar(comandoServicio);
        this.servicioActualizarServicio.ejecutar(servicio);
    }

}
