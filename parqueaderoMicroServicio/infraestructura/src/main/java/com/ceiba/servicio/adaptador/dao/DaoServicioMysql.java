package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioMysql implements DaoServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="servicio", value="servicioById")
    private static String sqlServicioById;

    public DaoServicioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicio());
    }

    @Override
    public DtoServicio buscarServicioById(Long id) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoServicio> servicios=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlServicioById, paramSource,new MapeoServicio());
        DtoServicio unServicioDto=servicios.get(0);
        return unServicioDto;
    }
}
