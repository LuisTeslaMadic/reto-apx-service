package com.entelgy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entelgy.app.utils.FunctionUtils;

@SpringBootApplication
public class ServicioUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsersApplication.class, args);
		System.out.println(FunctionUtils.FechaActual());
	}

}
