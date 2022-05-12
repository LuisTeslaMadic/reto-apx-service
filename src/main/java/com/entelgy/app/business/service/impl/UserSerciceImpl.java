package com.entelgy.app.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.entelgy.app.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.app.models.entity.User;
import com.entelgy.app.models.entity.UserModalData;

/**
 * @author CRISTIAN
 *
 */
@Service
public class UserSerciceImpl implements UserService {
    
	@Autowired
	private RestTemplate userRest;
	
	@Autowired
	private Environment env;
	
	@Override
	public List<User> listaUsuarios() {
		UserModalData userModalData = userRest.getForObject(env.getProperty("servicio-users-url"), UserModalData.class);
		return userModalData.getData();
	}

	@Override
	public List<String> listaModificada() {
		return listaUsuarios().stream().map(
				data -> "<"+data.getId()+">"+"|"+"<"+data.getLast_name()+">"+"|"+"<"+data.getEmail()+">")
				.collect(Collectors.toList());
	}

}
