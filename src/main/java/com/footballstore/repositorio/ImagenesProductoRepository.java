package com.footballstore.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.footballstore.modelo.ImagenesProductosVO;

public interface ImagenesProductoRepository extends JpaRepository<ImagenesProductosVO, Integer>{
	List<ImagenesProductosVO> findByProducto_id(int idProducto);
}
