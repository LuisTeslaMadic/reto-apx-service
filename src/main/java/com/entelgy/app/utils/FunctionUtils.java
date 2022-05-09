package com.entelgy.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class FunctionUtils {
  
	public static String FechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(new Date());
	}
	
	public static String fechaConvert(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(fecha);
	}
	
}
