package com.ceiba.cliente.puerto.repositorio;
import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * Permite crear un cliente
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un cliente con un nombre
     * @param cedula
     * @return si existe o no
     */
    boolean existe(Long cedula);

    /**
     * Permite validar si existe un cliente con un nombre excluyendo un id
     * @param cedula
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long cedula);
}
