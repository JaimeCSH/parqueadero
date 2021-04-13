package com.ceiba.dominio.excepcion;

public class ExcepcionServicioActivo extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionServicioActivo(String message){
        super(message);
    }
}
