package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

    /**
     * Permite crear un cliente
     * @param vehiculo
     * @return el id generado
     */
    Long crear(Vehiculo vehiculo);

    /**
     * Permite actualizar un cliente
     * @param vehiculo
     */
    void actualizar(Vehiculo vehiculo);

    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un cliente con un nombre
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

    /**
     * Permite validar si existe un cliente con un nombre excluyendo un id
     * @param placa
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String placa);

    /**
     * Permite validar si existe un cliente para crear el vehiculo
     * @param cliente
     * @return si existe o no
     */
    boolean existeCliente(Long cliente);
}
