package com.footballstore.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballstore.modelo.DireccionVO;


@Repository
public interface DireccionRepository extends JpaRepository<DireccionVO, Integer>{
	
}

