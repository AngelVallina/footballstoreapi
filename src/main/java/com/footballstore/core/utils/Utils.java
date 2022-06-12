package com.footballstore.core.utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


/**
 * @author avallina
 *
 */
@Component
public class Utils {

	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
		
	
	/**
	 * Metodo para formatear los mensajes de error
	 * @param Errors errors
	 * @return
	 */
	public String mensajesError (Errors errors){
		
		List <ObjectError> msgError = errors.getAllErrors();
		List<String> mensajesError = new ArrayList<>();
		msgError.forEach(e -> {
			FieldError fe = (FieldError) e;
			mensajesError.add(fe.getField() + ": " + fe.getDefaultMessage());
		});
		logger.info(mensajesError.toString());
		return mensajesError.toString();
	}
	
	
	
}
