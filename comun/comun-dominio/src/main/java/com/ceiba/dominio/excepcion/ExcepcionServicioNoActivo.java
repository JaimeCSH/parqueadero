package com.ceiba.dominio.excepcion;

public class ExcepcionServicioNoActivo extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionServicioNoActivo(String message){
        super(message);
    }
}
