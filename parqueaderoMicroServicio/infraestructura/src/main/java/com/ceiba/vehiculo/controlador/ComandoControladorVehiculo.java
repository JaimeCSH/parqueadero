package com.ceiba.vehiculo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorActualizarVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorCrearVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorEliminarVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
@Api(tags = { "Controlador comando vehiculos"})
public class ComandoControladorVehiculo {

    private final ManejadorCrearVehiculo manejadorCrearVehiculo;
    private final ManejadorActualizarVehiculo manejadorActualizarVehiculo;
    private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;

    public ComandoControladorVehiculo( ManejadorCrearVehiculo manejadorCrearVehiculo,
                        ManejadorActualizarVehiculo manejadorActualizarVehiculo,
                        ManejadorEliminarVehiculo manejadorEliminarVehiculo){
        this.manejadorCrearVehiculo=manejadorCrearVehiculo;
        this.manejadorActualizarVehiculo=manejadorActualizarVehiculo;
        this.manejadorEliminarVehiculo=manejadorEliminarVehiculo;
    }

    @PostMapping
    @ApiOperation("Crear vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVehiculo comandoVehiculo) {
        return manejadorCrearVehiculo.ejecutar(comandoVehiculo);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Vehiculo")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarVehiculo.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Vehiculo")
    public void actualizar(@RequestBody ComandoVehiculo comandoVehiculo,@PathVariable Long id) {
        comandoVehiculo.setId(id);
        manejadorActualizarVehiculo.ejecutar(comandoVehiculo);
    }
}
