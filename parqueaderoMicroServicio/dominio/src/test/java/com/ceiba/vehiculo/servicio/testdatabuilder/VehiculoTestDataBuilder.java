package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public class VehiculoTestDataBuilder {

    private Long id;
    private Long cliente;
    private String placa;


    public VehiculoTestDataBuilder(){
        cliente=1L;
        placa="VMV03C";
    }

    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id,cliente,placa);
    }
}
