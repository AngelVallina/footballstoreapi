package com.footballstore.core.utils;

import org.springframework.stereotype.Component;

@Component
public class ConstantesComunes {
	
	public static final String BEARER = "Bearer ";
	public static final String FORMATO_FECHA = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String EMAIL_REGEXP = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	public static final String EUROPE_MADRID = "Europe/Madrid";
	public static final String IDIOMA_ES = "es";
	public static final String REGION_ES = "es";
	public static final String RUTA_I18N = "i18n/messages";
}