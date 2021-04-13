package com.ceiba.servicio.consulta;

import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorUnServicioById {

    private final DaoServicio daoServicio;

    public ManejadorUnServicioById(DaoServicio daoServicio){
        this.daoServicio = daoServicio;
    }

    public DtoServicio ejecutar(Long id){ return this.daoServicio.buscarServicioById(id); }
}
