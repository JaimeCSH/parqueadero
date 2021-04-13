package com.ceiba.servicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.adaptador.dao.DaoServicioMysql;
import com.ceiba.servicio.adaptador.dao.MapeoServicio;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.manejador.ManejadorActualizarServicio;
import com.ceiba.servicio.comando.manejador.ManejadorCrearServicio;
import com.ceiba.servicio.comando.manejador.ManejadorEliminarServicio;
import com.ceiba.servicio.consulta.ManejadorUnServicioById;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/servicios")
@Api(tags = { "Controlador comando servicios"})
public class ComandoControladorServicio {

    private final ManejadorCrearServicio manejadorCrearServicio ;
    private final ManejadorActualizarServicio  manejadorActualizarServicio ;
    private final ManejadorEliminarServicio  manejadorEliminarServicio ;

    private final ManejadorUnServicioById manejadorUnServicioById;

    public ComandoControladorServicio(ManejadorCrearServicio manejadorCrearServicio,
                                      ManejadorActualizarServicio  manejadorActualizarServicio,
                                      ManejadorEliminarServicio  manejadorEliminarServicio,
                                      ManejadorUnServicioById manejadorUnServicioById){
        this.manejadorCrearServicio=manejadorCrearServicio;
        this.manejadorActualizarServicio=manejadorActualizarServicio;
        this.manejadorEliminarServicio=manejadorEliminarServicio;
        this.manejadorUnServicioById=manejadorUnServicioById;
    }

    @PostMapping
    @ApiOperation("Crear servicio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicio comandoServicio) {
        comandoServicio.setFechaEntrada(LocalDateTime.now());
        comandoServicio.setActivo(1);
        return manejadorCrearServicio.ejecutar(comandoServicio);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar servicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarServicio.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar servicio")
    public void actualizar(@RequestBody ComandoServicio comandoServicio,@PathVariable Long id) {

        DtoServicio unServicio= manejadorUnServicioById.ejecutar(id);
        comandoServicio.setFechaEntrada(unServicio.getFechaEntrada());
        comandoServicio.setId(id);
        manejadorActualizarServicio.ejecutar(comandoServicio);
    }
}
