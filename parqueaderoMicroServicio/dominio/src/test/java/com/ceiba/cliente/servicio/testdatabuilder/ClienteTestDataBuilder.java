package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombre;


    public ClienteTestDataBuilder(){
        cedula=1234L;
        nombre="Juan 23";
    }

    public ClienteTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente build() {
        return new Cliente(id,cedula,nombre);
    }

}
