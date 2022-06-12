package com.footballstore.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballstore.modelo.ProductoVO;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoVO, Integer>{
	
	List<ProductoVO> findAll();
	List<ProductoVO> findByNombreContainingOrDescripcionContaining(String nombre,String descripcion);
	List<ProductoVO> findByTipo_Id(int tipo);
	ProductoVO findById(int id);
}
