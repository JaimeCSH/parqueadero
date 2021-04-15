package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionServicioActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

public class ServicioCrearServicio {

    private static final String VEHICULO_ACTIVO = "Ya se encuentra un servicio activo para este vehículo";
    private static final String VEHICULO_NO_EXISTE = "El vehículo no existe en el sistema";

    private final RepositorioServicio repositorioServicio;

    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public Long ejecutar(Servicio servicio) {
        validarExistenciaActiva(servicio);
        validarExistenciaVehiculo(servicio);
        return this.repositorioServicio.crear(servicio);
    }

    private void validarExistenciaActiva(Servicio servicio) {
        boolean existeActivo = this.repositorioServicio.existeActivo(servicio.getVehiculo());
        if(existeActivo) {
            throw new ExcepcionServicioActivo(VEHICULO_ACTIVO);
        }
    }

    private void validarExistenciaVehiculo(Servicio servicio){
        boolean existeVehiculo = this.repositorioServicio.existeVehiculo(servicio.getVehiculo());
        if(!existeVehiculo) {
            throw new ExcepcionNoExiste(VEHICULO_NO_EXISTE);
        }
    }
}
