package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicio implements RowMapper<DtoServicio>, MapperResult {

    @Override
    public DtoServicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long vehiculo = resultSet.getLong("vehiculo");
        LocalDateTime fechaEntrada = extraerLocalDateTime(resultSet, "fecha_entrada");
        LocalDateTime fechaSalida = extraerLocalDateTime(resultSet, "fecha_salida");
        Integer activo = resultSet.getInt("activo");
        BigDecimal valorAPagar = resultSet.getBigDecimal("valor_a_pagar");
        Long horas = resultSet.getLong("horas");

        return new DtoServicio(id,vehiculo,fechaEntrada,fechaSalida,activo,valorAPagar,horas);
    }
}
