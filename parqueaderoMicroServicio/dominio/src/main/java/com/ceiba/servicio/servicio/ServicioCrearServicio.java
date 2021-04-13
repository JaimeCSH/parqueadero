package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionServicioActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

public class ServicioCrearServicio {

    private static final String VEHICULO_ACTIVO = "El vehiculo se encuentra actualmente en el parqueadero";
    private final RepositorioServicio repositorioServicio;

    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public Long ejecutar(Servicio servicio) {
        validarExistenciaActiva(servicio);
        return this.repositorioServicio.crear(servicio);
    }

    private void validarExistenciaActiva(Servicio servicio) {
        boolean existeActivo = this.repositorioServicio.existeActivo(servicio.getVehiculo());
        if(existeActivo) {
            throw new ExcepcionServicioActivo(VEHICULO_ACTIVO);
        }
    }
}
