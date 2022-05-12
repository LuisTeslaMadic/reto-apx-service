package com.entelgy.app.controllers.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import com.entelgy.app.utils.ObjectMapperHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
	
	@Autowired
    private TestRestTemplate client;
	
	
	private ObjectMapperHelper objectMapperHelper;

	@BeforeEach
	void setUp() throws Exception {
		objectMapperHelper = new ObjectMapperHelper();
	}

	@Test
	@Order(1)
	void testListUsers() throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> respuesta = client.getForEntity("/listar", String.class);
		String json = respuesta.getBody();
		String fecha = objectMapperHelper.convertFromJsonToString(json,"operationDate");
		
		List<String> users = Arrays.asList(objectMapperHelper.convertFromJsonToString(json,"data")
				             .replace("]","").replace("[", "").replace("\"", "").split(","));
		assertNotNull(fecha);
		assertEquals(HttpStatus.OK,respuesta.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, respuesta.getHeaders().getContentType());
		assertEquals(6,users.size());
		assertEquals("<1>|<Bluth>|<george.bluth@reqres.in>",users.get(0));
		assertEquals("<2>|<Weaver>|<janet.weaver@reqres.in>",users.get(1));
		assertEquals("<3>|<Wong>|<emma.wong@reqres.in>",users.get(2));
		assertEquals("<4>|<Holt>|<eve.holt@reqres.in>",users.get(3));
		assertEquals("<5>|<Morris>|<charles.morris@reqres.in>",users.get(4));
		assertEquals("<6>|<Ramos>|<tracey.ramos@reqres.in>",users.get(5));
		
	}




}
