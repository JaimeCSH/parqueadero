package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_CEDULA = "Se debe ingresar la cedula del responsable";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre del responsable";

    private Long id;
    private Long cedula;
    private String nombre;

    public Cliente (Long id, Long cedula, String nombre){
        validarObligatorio(cedula, SE_DEBE_INGRESAR_CEDULA);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;

    }

}
