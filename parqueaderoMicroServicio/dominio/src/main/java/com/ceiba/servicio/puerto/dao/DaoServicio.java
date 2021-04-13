package com.ceiba.servicio.puerto.dao;

import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;

import java.util.List;

public interface DaoServicio {

    /**
     * Permite listar clientes
     * @return los servicios
     */
    List<DtoServicio> listar();

    /**
     * Permite devolver un servicio por id
     * @param id
     * @return un servicio por id
     */
    DtoServicio buscarServicioById (Long id);
}
