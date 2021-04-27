package com.ceiba.vehiculo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="vehiculo", value="crear")
    private static String sqlCrearVehiculo;

    @SqlStatement(namespace="vehiculo", value="actualizar")
    private static String sqlActualizarVehiculo;

    @SqlStatement(namespace="vehiculo", value="eliminar")
    private static String sqlEliminarVehiculo;

    @SqlStatement(namespace="vehiculo", value="existe")
    private static String sqlExisteVehiculo;

    @SqlStatement(namespace="vehiculo", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdVehiculo;

    @SqlStatement(namespace="vehiculo", value="existeCliente")
    private static String sqlExisteClienteVehiculo;

    public RepositorioVehiculoMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Vehiculo vehiculo) {
        return this.customNamedParameterJdbcTemplate.crear(vehiculo, sqlCrearVehiculo);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarVehiculo, paramSource);
    }

    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteVehiculo,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        this.customNamedParameterJdbcTemplate.actualizar(vehiculo, sqlActualizarVehiculo);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdVehiculo,paramSource, Boolean.class);
    }

    @Override
    public boolean existeCliente(Long cliente){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cliente", cliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteClienteVehiculo,paramSource, Boolean.class);
    }
}
