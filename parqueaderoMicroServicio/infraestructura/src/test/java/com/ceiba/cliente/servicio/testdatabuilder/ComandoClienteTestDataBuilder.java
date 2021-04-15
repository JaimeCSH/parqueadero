package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import java.util.UUID;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombre;

    public ComandoClienteTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        cedula = 12345L;
    }

    public ComandoClienteTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id,cedula, nombre);
    }
}
