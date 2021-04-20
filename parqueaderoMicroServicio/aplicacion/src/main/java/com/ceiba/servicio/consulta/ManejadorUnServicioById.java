package com.ceiba.servicio.consulta;

import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorUnServicioById {

    private final DaoServicio daoServicio;
    private final RepositorioServicio repositorioServicio;

    public ManejadorUnServicioById(DaoServicio daoServicio, RepositorioServicio repositorioServicio){
        this.daoServicio = daoServicio;
        this.repositorioServicio=repositorioServicio;
    }

    public DtoServicio ejecutar(Long id){

        boolean a=this.repositorioServicio.existe(id);
        if (a){
            return this.daoServicio.buscarServicioById(id);
        }
        else return null;
    }
}
