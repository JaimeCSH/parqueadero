package com.ceiba.servicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionServicioActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearServicioTest {


    @Test
    public void validarServicioExistenciaActivaTest() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.existeActivo(Mockito.anyLong())).thenReturn(true);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearServicio.ejecutar(servicio), ExcepcionServicioActivo.class,"Ya se encuentra un servicio activo para este vehículo");
    }

    @Test
    public void validarVehiculoExistenciaTest() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.existeVehiculo(Mockito.anyLong())).thenReturn(false);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearServicio.ejecutar(servicio), ExcepcionNoExiste.class,"El vehículo no existe en el sistema");
    }
}
