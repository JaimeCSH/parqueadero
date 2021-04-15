package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearVehiculoTest {

    @Test
    public void validarVehiculoExistenciaPreviaTest() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehículo ya existe en el sistema");
    }

    @Test
    public void validarClienteExistenciaTest() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existeCliente(Mockito.anyLong())).thenReturn(false);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionNoExiste.class,"El cliente no existe en el sistema");
    }
}
