package com.footballstore.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballstore.modelo.RolVO;
import com.footballstore.repositorio.RolRepository;
import com.footballstore.servicios.RolesService;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	RolRepository rolesRepository;
	@Override
	public RolVO findById(int id) {
		return rolesRepository.findById(id);
	}
}
