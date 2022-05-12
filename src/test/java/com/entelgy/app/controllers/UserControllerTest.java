package com.entelgy.app.controllers;

import com.entelgy.app.EntityMock;
import com.entelgy.app.business.service.UserService;
import com.entelgy.app.utils.FunctionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService cuentaService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void listOfUsersPost() throws Exception {
        when(cuentaService.listaModificada()).thenReturn(EntityMock.mockMapList());
        mvc.perform(get("/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.operationDate").value(FunctionUtils.fechaActual()))
                .andExpect(jsonPath("$.data.[0]").value("<1>|<Juarez>|<Fuero@gmail.com>"))
                .andExpect(jsonPath("$.data.[1]").value("<2>|<Weaver>|<janet.weaver@reqres.in>"));
        verify(cuentaService).listaModificada();
    }

    @Test
    void listOfUsersGet() throws Exception {
        when(cuentaService.listaModificada()).thenReturn(EntityMock.mockMapList());
        mvc.perform(post("/fechaConvert").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.operationDate").value(FunctionUtils.fechaActual()))
                .andExpect(jsonPath("$.data.[0]").value("<1>|<Juarez>|<Fuero@gmail.com>"))
                .andExpect(jsonPath("$.data.[1]").value("<2>|<Weaver>|<janet.weaver@reqres.in>"));;
        verify(cuentaService).listaModificada();
    }

    @Test
    void listOfUsersGetException() throws Exception {
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Ocurrio un error");
        when(cuentaService.listaModificada()).thenThrow(exception);
        mvc.perform(get("/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void listOfUsersPostException() throws Exception {
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Ocurrio un error");
        when(cuentaService.listaModificada()).thenThrow(exception);
        mvc.perform(post("/fechaConvert").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}