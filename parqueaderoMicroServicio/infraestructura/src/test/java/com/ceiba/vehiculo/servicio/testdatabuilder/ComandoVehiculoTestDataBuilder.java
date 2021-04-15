package com.ceiba.vehiculo.servicio.testdatabuilder;
import com.ceiba.vehiculo.comando.ComandoVehiculo;

import java.util.UUID;

public class ComandoVehiculoTestDataBuilder {

    private Long id;
    private Long cliente;
    private String placa;

    public ComandoVehiculoTestDataBuilder() {
        cliente = 1L;
        placa = UUID.randomUUID().toString();
    }

    public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoVehiculo build() {
        return new ComandoVehiculo(id,cliente, placa);
    }
}
