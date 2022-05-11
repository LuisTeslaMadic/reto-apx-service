package com.entelgy.app.business.service;

import com.entelgy.app.EntityMock;
import com.entelgy.app.models.entity.User;
import com.entelgy.app.models.entity.UserModalData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserSerciceImplTest {

    @InjectMocks
    private UserSerciceImpl userServiceImpl;

    @Mock
    private RestTemplate userRest;

    @Mock
    private Environment env;

    @BeforeEach
    void beforeAll() {
        when(env.getProperty("servicio-users-url")).thenReturn("https://reqres.in/api/users");
        when(userRest.getForObject(anyString(),any())).thenReturn(EntityMock.mockUserModal());
    }

    @Test
    void testListaUsuarios() {
        List<User> result = userServiceImpl.listaUsuarios();
        assertNotNull(result);
        assertNotNull(result.get(0));
        assertNotNull(result.get(0).getId());
        assertNotNull(result.get(0).getAvatar());
        assertNotNull(result.get(0).getEmail());
        assertNotNull(result.get(0).getFirst_name());
        assertNotNull(result.get(0).getLast_name());
    }

    @Test
    void testListaModificada() {
        List<String> result = userServiceImpl.listaModificada();
        assertEquals(1,result.size());
        assertEquals("<1>|<Juarez>|<Fuero@gmail.com>",result.get(0));
    }



}