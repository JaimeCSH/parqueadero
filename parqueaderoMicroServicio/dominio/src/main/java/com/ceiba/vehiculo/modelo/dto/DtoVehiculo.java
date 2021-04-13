package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoVehiculo {

    private Long id;
    private Long cliente;
    private String placa;
}
