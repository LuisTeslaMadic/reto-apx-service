package com.entelgy.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.app.models.entity.User;
import com.entelgy.app.models.entity.UserModalData;

/**
 * @author CRISTIAN
 *
 */
@Service
public class UserSerciceImpl implements UserService{
    
	@Autowired
	private RestTemplate userRest;
	
	@Value("${servicio-users-url}")
	private String url;
	
	@Override
	public List<User> listaUsuarios() {
		UserModalData userModalData = userRest.getForObject(url, UserModalData.class);
		return userModalData.getData();
	}

}
