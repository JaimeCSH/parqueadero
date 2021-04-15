package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionServicioActivo;
import com.ceiba.dominio.excepcion.ExcepcionServicioNoActivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ServicioActualizarServicio {

    private static final String VEHICULO_NO_ACTIVO = "No se encuentra un servicio activo para este vehículo";
    private static final String SERVICIO_NO_EXISTE ="El servicio no existe";
    private final RepositorioServicio repositorioServicio;

    public ServicioActualizarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutar(Servicio servicio) {
        validarExistencia(servicio);
        estabelcerHoraSalida(servicio);
        calcularTotalHoras(servicio);
        calcularTotalAPagar(servicio);
        servicio.setActivo(0);
        this.repositorioServicio.actualizar(servicio);
    }

    public void calcularTotalHoras(Servicio servicio) {

        LocalDateTime fechayHoraInicial=servicio.getFechaEntrada();
        LocalDateTime fechayHoraFinal=servicio.getFechaSalida();
        Long minutes = ChronoUnit.MINUTES.between(fechayHoraInicial,fechayHoraFinal);
        Long horas = ChronoUnit.HOURS.between(fechayHoraInicial,fechayHoraFinal);

        if(minutes%60!=0){
            horas++;
        }

        servicio.setHoras(horas);
    }

    public void calcularTotalAPagar(Servicio servicio){
        int tarifaUnica=2000;
        BigDecimal total= BigDecimal.valueOf(servicio.getHoras()*tarifaUnica);
        servicio.setValorAPagar(total);

    }

    private void estabelcerHoraSalida(Servicio servicio) {
        LocalDateTime fechaSalida = LocalDateTime.now();
        servicio.setFechaSalida(fechaSalida);
    }

    private void validarExistencia(Servicio servicio) {
        boolean existeActivo = this.repositorioServicio.existe(servicio.getId());
        if(!existeActivo) {
            throw new ExcepcionNoExiste(SERVICIO_NO_EXISTE);
        }
    }
}
