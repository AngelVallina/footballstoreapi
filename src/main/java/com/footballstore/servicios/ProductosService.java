package com.footballstore.servicios;

import java.util.List;

import com.footballstore.modelo.ProductoImagenesDTO;
import com.footballstore.modelo.ProductoVO;

public interface ProductosService {
	List<ProductoImagenesDTO> findAll();
	List<ProductoImagenesDTO> findByNombreOrDescripcion(String nombre,String descripcion);
	ProductoImagenesDTO findById(int id);
	List<ProductoImagenesDTO> findByTipo(int tipo);
	boolean updateProducto(ProductoVO producto);
	boolean deleteProducto(int id);
	boolean save(ProductoVO producto);
	ProductoVO addValoracion(ProductoVO producto);	
}
