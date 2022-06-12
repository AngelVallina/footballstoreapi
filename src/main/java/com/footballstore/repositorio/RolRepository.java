package com.footballstore.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballstore.modelo.RolVO;

@Repository
public interface RolRepository  extends JpaRepository<RolVO, Integer>{
	RolVO findById(int id);
}
