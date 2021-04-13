package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente {

    private final FabricaCliente fabricaCliente;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        return new ComandoRespuesta<>(this.servicioCrearCliente.ejecutar(cliente));
    }
}
