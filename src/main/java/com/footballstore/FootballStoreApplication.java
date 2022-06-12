package com.footballstore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.footballstore.core.utils.ConstantesComunes;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class FootballStoreApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FootballStoreApplication.class);

	public static void main(String[] args) {
		// Seteamos el timzone es decir codigo ETC
		TimeZone.setDefault(TimeZone.getTimeZone(ConstantesComunes.EUROPE_MADRID));
		// Seteamos el locale ES por defecto
		Locale defaultLocale = new Locale.Builder().setLanguage(ConstantesComunes.IDIOMA_ES).setRegion(ConstantesComunes.REGION_ES).build();
		Locale.setDefault(defaultLocale);
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantesComunes.FORMATO_FECHA);
		
		LOGGER.info("La aplicación se está ejecutando con el timezone y el locale : {} - {}", sdf.format(new Date()), defaultLocale.getLanguage());
		SpringApplication.run(FootballStoreApplication.class, args);
	}
	
}
