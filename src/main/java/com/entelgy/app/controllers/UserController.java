package com.entelgy.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.entelgy.app.business.service.UserService;
import com.entelgy.app.utils.FunctionUtils;

@RestController
public class UserController {
 
	@Autowired
	private UserService userService;

	@PostMapping("/fechaConvert")
	public ResponseEntity<?> listOfUsersPost(){
		return getResponseEntity();
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listOfUsersGet(){
		return getResponseEntity();
	}

	private ResponseEntity<Map<String,Object>> getResponseEntity() {
		Map<String,Object> response = new HashMap<>();
		List<String> lisOfUSers = null;
		try {
			lisOfUSers = userService.listaModificada();

		}catch(HttpClientErrorException e) {
			response.put("Ocurrio un error :",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("operationDate", FunctionUtils.fechaActual());
		response.put("data",lisOfUSers );
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
