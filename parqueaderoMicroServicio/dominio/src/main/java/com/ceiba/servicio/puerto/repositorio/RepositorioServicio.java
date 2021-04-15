package com.ceiba.servicio.puerto.repositorio;

import com.ceiba.servicio.modelo.entidad.Servicio;

public interface RepositorioServicio {

    /**
     * Permite crear un cliente
     * @param servicio
     * @return el id generado
     */
    Long crear(Servicio servicio);

    /**
     * Permite actualizar un cliente
     * @param servicio
     */
    void actualizar(Servicio servicio);

    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un servicio activo para el vehiculo
     * @param vehiculo
     * @return si existe o no
     */
    boolean existeActivo(Long vehiculo);

    /**
     * Permite validar si existe un servicio
     * @param id
     * @return si existe o no
     */
    boolean existe (Long id);

    /**
     * Permite validar si existe un vehiculo para crear el servicio
     * @param vehiculo
     * @return si existe o no
     */
    boolean existeVehiculo(Long vehiculo);

}
