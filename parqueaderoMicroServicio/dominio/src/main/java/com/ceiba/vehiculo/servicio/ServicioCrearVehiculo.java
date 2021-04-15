package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

    private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehículo ya existe en el sistema";
    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public Long ejecutar(Vehiculo vehiculo) {
        validarExistenciaPrevia(vehiculo);
        validarExistenciaCliente(vehiculo);
        return this.repositorioVehiculo.crear(vehiculo);
    }

    private void validarExistenciaPrevia(Vehiculo vehiculo) {
        boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaCliente(Vehiculo vehiculo) {
        boolean existeCliente = this.repositorioVehiculo.existeCliente(vehiculo.getCliente());
        if(!existeCliente) {
            throw new ExcepcionNoExiste(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
