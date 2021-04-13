package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Vehiculo {

    private static final String SE_DEBE_INGRESAR_PLACA = "Se debe ingresar la placa del vehiculo";
    private static final String SE_DEBE_INGRESAR_CLIENTE = "Se debe ingresar cedula del responsable";

    private Long id;
    private Long cliente;
    private String placa;

    public Vehiculo(Long id, Long cliente, String placa) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_PLACA);
        validarObligatorio(cliente, SE_DEBE_INGRESAR_CLIENTE);

        this.id = id;
        this.cliente = cliente;
        this.placa = placa;
    }
}
