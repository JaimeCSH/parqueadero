package com.ceiba.servicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionServicioNoActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ServicioActualizarServicioTest {


    @Test
    public void validarExistenciaNoActiva(){
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        Mockito.when(repositorioServicio.existeActivo(Mockito.anyLong())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarServicio.ejecutar(servicio), ExcepcionServicioNoActivo.class,"No se encuentra un servicio activo para este vehículo");
    }

    @Test
    public void validarTotalHorasTest() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conFechaSalida(LocalDateTime.now().plusHours(2).plusMinutes(15)).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act -
        servicioActualizarServicio.calcularTotalHoras(servicio);
        // assert
        Assert.assertTrue(servicio.getHoras()==3);
    }

    @Test
    public void validarTotalHorasTest2() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conFechaSalida(LocalDateTime.now().plusHours(2)).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act -
        servicioActualizarServicio.calcularTotalHoras(servicio);
        // assert
        Assert.assertTrue(servicio.getHoras()==2);
    }

    @Test
    public void validarTotalaPagarTest() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conFechaSalida(LocalDateTime.now().plusHours(2)).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act -
        servicioActualizarServicio.calcularTotalHoras(servicio);
        servicioActualizarServicio.calcularTotalAPagar(servicio);
        // assert
        Assert.assertTrue(servicio.getValorAPagar().equals(BigDecimal.valueOf(4000)));
    }

    @Test
    public void validarTotalaPagarTest2() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conFechaSalida(LocalDateTime.now().plusHours(2).plusMinutes(34)).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act
        servicioActualizarServicio.calcularTotalHoras(servicio);
        servicioActualizarServicio.calcularTotalAPagar(servicio);
        // assert
        Assert.assertTrue(servicio.getValorAPagar().equals(BigDecimal.valueOf(6000)));
    }
}