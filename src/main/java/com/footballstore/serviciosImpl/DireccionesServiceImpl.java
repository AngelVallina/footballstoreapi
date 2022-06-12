package com.footballstore.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballstore.modelo.DireccionVO;
import com.footballstore.repositorio.DireccionRepository;
import com.footballstore.servicios.DireccionesService;

@Service
public class DireccionesServiceImpl implements DireccionesService{
	
	@Autowired
	DireccionRepository direccionesRepository;

	@Override
	public DireccionVO registrarDirecciones(DireccionVO direccion) {
		return this.direccionesRepository.save(direccion);
	}
	
}
