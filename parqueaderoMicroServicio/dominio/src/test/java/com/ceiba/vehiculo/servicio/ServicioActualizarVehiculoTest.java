package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarVehiculoTest {

    @Test
    public void validarClienteExistenciaPreviaTest() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehículo ya existe en el sistema");
    }
}
