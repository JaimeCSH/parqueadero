package com.ceiba.servicio.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioMysql implements RepositorioServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="crear")
    private static String sqlCrearServicio;

    @SqlStatement(namespace="servicio", value="actualizar")
    private static String sqlActualizarServicio;

    @SqlStatement(namespace="servicio", value="eliminar")
    private static String sqlEliminarServicio;

    @SqlStatement(namespace="servicio", value="existe")
    private static String sqlExisteServicio;

    @SqlStatement(namespace="servicio", value="existeActivo")
    private static String sqlExisteActivoServicio;

    @SqlStatement(namespace="servicio", value="existeElVehiculo")
    private static String sqlExisteVehiculoServicio;


    public RepositorioServicioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Servicio servicio) {
        return this.customNamedParameterJdbcTemplate.crear(servicio, sqlCrearServicio);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarServicio, paramSource);
    }

    @Override
    public boolean existeActivo(Long vehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("vehiculo", vehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteActivoServicio,paramSource, Boolean.class);
    }
    @Override
    public void actualizar(Servicio servicio) {
        this.customNamedParameterJdbcTemplate.actualizar(servicio, sqlActualizarServicio);
    }

    @Override
    public boolean existeVehiculo(Long vehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("vehiculo", vehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteVehiculoServicio,paramSource, Boolean.class);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteServicio,paramSource, Boolean.class);
    }



}
