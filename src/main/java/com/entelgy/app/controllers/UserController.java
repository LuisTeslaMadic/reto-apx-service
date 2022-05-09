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

import com.entelgy.app.models.service.UserService;
import com.entelgy.app.utils.FunctionUtils;

@RestController
public class UserController {
 
	@Autowired
	private UserService userService;
	
	/*
	 * Example : "Mon May 09 12:19:33 PET 2022"
	 * 
	 * */
	
	@PostMapping("/fechaConvert")
	public ResponseEntity<?> listOfUsers(@RequestBody String fecha){
		Map<String,Object> response = new HashMap<String,Object>();
		List<String> lisOfUSers = null;
		try {
			lisOfUSers = userService.listaUsuarios().stream().map(data ->{
				return "<"+data.getId()+">"+"|"+"<"+data.getLast_name()+">"+"|"+"<"+data.getEmail()+">";
			}).collect(Collectors.toList());
			
		}catch(HttpClientErrorException e) {
			response.put("Ocurrio un error :",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(fecha);
		response.put("operationDate",FunctionUtils.FechaActual());
		response.put("data",lisOfUSers );
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listOfUsers(){
		Map<String,Object> response = new HashMap<String,Object>();
		List<String> lisOfUSers = null;
		try {
			lisOfUSers = userService.listaUsuarios().stream().map(data ->{
				return "<"+data.getId()+">"+"|"+"<"+data.getLast_name()+">"+"|"+"<"+data.getEmail()+">";
			}).collect(Collectors.toList());
			
		}catch(HttpClientErrorException e) {
			response.put("Ocurrio un error :",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("operationDate",FunctionUtils.FechaActual());
		response.put("data",lisOfUSers );
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
}
