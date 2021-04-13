package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionServicioActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ServicioActualizarServicio {

    private static final String VEHICULO_ACTIVO = "El vehiculo se encuentra actualmente en el parqueadero";
    private final RepositorioServicio repositorioServicio;

    public ServicioActualizarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutar(Servicio servicio) {
        estabelcerHoraSalida(servicio);
        calcularTotalHoras(servicio);
        calcularTotalAPagar(servicio);
        servicio.setActivo(0);
        this.repositorioServicio.actualizar(servicio);
    }

    private void calcularTotalHoras(Servicio servicio) {

        LocalDateTime fechayHoraInicial=servicio.getFechaEntrada();
        LocalDateTime fechayHoraFinal=servicio.getFechaSalida();
        Long horas = ChronoUnit.HOURS.between(fechayHoraInicial,fechayHoraFinal);

        //Falta sumar una hora mas cuando se pase por unos minutos de una hora exacta

        servicio.setHoras(horas);
    }

    private void calcularTotalAPagar(Servicio servicio){
        int tarifaUnica=2000;
        BigDecimal total= BigDecimal.valueOf(servicio.getHoras()*tarifaUnica);
        servicio.setValorAPagar(total);

    }

    private void estabelcerHoraSalida(Servicio servicio) {
        LocalDateTime fechaSalida = LocalDateTime.now();
        servicio.setFechaSalida(fechaSalida);
    }

    private void validarExistenciaActiva(Servicio servicio) {
        boolean existeActivo = this.repositorioServicio.existeActivo(servicio.getId());
        if(existeActivo) {
            throw new ExcepcionServicioActivo(VEHICULO_ACTIVO);
        }
    }
}
