package com.ceiba.servicio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ComandoServicioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorServicioTest.class)
public class ComandoControladorServicioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoServicio daoServicio;

    @Test
    @Order(1)
    public void crear() throws Exception{
        // arrange
        ComandoServicio servicio = new ComandoServicioTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/servicios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servicio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }

    @Test
    @Order(2)
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoServicio servicio = new ComandoServicioTestDataBuilder().build();
        servicio.setId(id);
        // act - assert
        mocMvc.perform(put("/servicios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servicio)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/servicios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
