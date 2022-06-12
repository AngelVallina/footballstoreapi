package com.footballstore.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.footballstore.modelo.OpinionVO;
import com.footballstore.modelo.ProductoVO;

public interface OpinionesRepository extends JpaRepository<OpinionVO, Integer>{
	List<OpinionVO> findByProducto_Id(int producto);
}
