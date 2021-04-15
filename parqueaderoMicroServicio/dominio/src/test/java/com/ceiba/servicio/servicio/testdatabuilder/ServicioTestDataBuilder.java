package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.entidad.Servicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServicioTestDataBuilder {

    private Long id;
    private Long vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer activo;
    private BigDecimal valorAPagar;
    private Long horas;

    public ServicioTestDataBuilder(){
         id=1l;
         vehiculo=1l;
         fechaEntrada=LocalDateTime.now();
         //fechaSalida=LocalDateTime.now().plusHours(2);
         activo=1;
         //valorAPagar= BigDecimal.valueOf(4000);
         //horas=0L;
    }

    public ServicioTestDataBuilder conVehiculo(Long vehiculo){
        this.vehiculo = vehiculo;
        return this;
    }

    public ServicioTestDataBuilder conFechaSalida(LocalDateTime fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }

    public Servicio build(){
        return new Servicio(id,vehiculo,fechaEntrada,fechaSalida,activo,valorAPagar,horas);
    }

}
