package com.entelgy.app.models.service;



import com.entelgy.app.models.entity.User;
import com.entelgy.app.models.entity.UserModalData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author CRISTIAN
 *
 */
@ExtendWith(MockitoExtension.class)
public class UserSerciceImplTest {
	
	@InjectMocks
	private UserSerciceImpl userServiceImpl;
	
	@Mock
	private RestTemplate userRest;

	@Value("${servicio-users-url}")
	private String url;
    
	@Test
	@Disabled
    void testListaUsuarios() {
	  UserModalData input = new UserModalData();
		input.setData(new ArrayList<>());
		doNothing().when(userRest).getForObject(any(), any());
	  List<User> result = userServiceImpl.listaUsuarios();
	  assertNotNull(result);
	  assertNotNull(result.get(0));
    }

}
