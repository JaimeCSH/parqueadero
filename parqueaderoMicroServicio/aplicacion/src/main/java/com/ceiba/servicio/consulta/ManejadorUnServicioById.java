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

        this.repositorioServicio.existe(id);
        return this.daoServicio.buscarServicioById(id); }
}
