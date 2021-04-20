package com.ceiba.servicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.manejador.ManejadorActualizarServicio;
import com.ceiba.servicio.comando.manejador.ManejadorCrearServicio;
import com.ceiba.servicio.comando.manejador.ManejadorEliminarServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/servicios")
@Api(tags = { "Controlador comando servicios"})
public class ComandoControladorServicio {

    private final ManejadorCrearServicio manejadorCrearServicio ;
    private final ManejadorActualizarServicio  manejadorActualizarServicio ;
    private final ManejadorEliminarServicio  manejadorEliminarServicio ;


    public ComandoControladorServicio(ManejadorCrearServicio manejadorCrearServicio,
                                      ManejadorActualizarServicio  manejadorActualizarServicio,
                                      ManejadorEliminarServicio  manejadorEliminarServicio){
        this.manejadorCrearServicio=manejadorCrearServicio;
        this.manejadorActualizarServicio=manejadorActualizarServicio;
        this.manejadorEliminarServicio=manejadorEliminarServicio;
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

        manejadorActualizarServicio.ejecutar(comandoServicio);
    }
}
