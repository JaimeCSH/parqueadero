package com.ceiba.vehiculo.comando.fabrica;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {
    public Vehiculo crear(ComandoVehiculo comandoVehiculo) {
        return new Vehiculo(
                comandoVehiculo.getId(),
                comandoVehiculo.getCliente(),
                comandoVehiculo.getPlaca()
        );
    }
}
