package com.entelgy.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class FunctionUtils {
  
	public static String fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(new Date());
	}
}
