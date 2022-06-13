package com.footballstore.serviciosImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.footballstore.modelo.ImagenesProductosVO;
import com.footballstore.modelo.OpinionVO;
import com.footballstore.modelo.ProductoImagenesDTO;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.repositorio.ImagenesProductoRepository;
import com.footballstore.repositorio.ProductoRepository;
import com.footballstore.servicios.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	ProductoRepository productosRepository;
	
	@Autowired
	ImagenesProductoRepository imagenesProductosRespository;

	
	@Override
	public List<ProductoImagenesDTO> findAll() {
		try {
			List<ProductoImagenesDTO> listaRetorno = new ArrayList<>();
			List<ProductoVO> listaProductos = productosRepository.findAllByOrderByIdDesc();
			
			for (ProductoVO producto : listaProductos) {
				
				ProductoImagenesDTO dto = new ProductoImagenesDTO();
				
				dto.setId(producto.getId());
				dto.setDescripcion(producto.getDescripcion());
				dto.setEstado(producto.getEstado());
				dto.setNombre(producto.getNombre());
				dto.setDescripcion(producto.getDescripcion());
				dto.setPrecio(producto.getPrecio());
				dto.setTallas(producto.getTallas());
				dto.setTipo(producto.getTipo());
				dto.setValoracion(producto.getValoracion());
				
				List<ImagenesProductosVO> listaImagenes = imagenesProductosRespository.findByProducto_id(producto.getId());
				
				List<String> imagenes = new ArrayList<>();
				
				for (ImagenesProductosVO ipVO : listaImagenes) {
					imagenes.add(ipVO.getUrl());
				}
				dto.setImagenes(imagenes);
				listaRetorno.add(dto);
			}
			
			return listaRetorno;
			
		}catch(Exception error) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage(), error);
		}
	}

	@Override
	public List<ProductoImagenesDTO> findByNombreOrDescripcion(String nombre, String descripcion) {
		try {
			List<ProductoImagenesDTO> listaRetorno = new ArrayList<>();
			List<ProductoVO> listaProductos =productosRepository.findByNombreContainingOrDescripcionContaining(nombre, descripcion);

			
			for (ProductoVO producto : listaProductos) {
				
				ProductoImagenesDTO dto = new ProductoImagenesDTO();
				
				dto.setId(producto.getId());
				dto.setDescripcion(producto.getDescripcion());
				dto.setEstado(producto.getEstado());
				dto.setNombre(producto.getNombre());
				dto.setDescripcion(producto.getDescripcion());
				dto.setPrecio(producto.getPrecio());
				dto.setTallas(producto.getTallas());
				dto.setTipo(producto.getTipo());
				dto.setValoracion(producto.getValoracion());
				
				List<ImagenesProductosVO> listaImagenes = imagenesProductosRespository.findByProducto_id(producto.getId());
				
				List<String> imagenes = new ArrayList<>();
				
				for (ImagenesProductosVO ipVO : listaImagenes) {
					imagenes.add(ipVO.getUrl());
				}
				dto.setImagenes(imagenes);
				listaRetorno.add(dto);
			}
			return listaRetorno;

		}catch(Exception error) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage(), error);
		}
	}

	@Override
	public ProductoImagenesDTO findById(int id) {
		try {
			
			ProductoVO producto = productosRepository.findById(id);
			
			ProductoImagenesDTO dto = new ProductoImagenesDTO();
			
			dto.setId(producto.getId());
			dto.setDescripcion(producto.getDescripcion());
			dto.setEstado(producto.getEstado());
			dto.setNombre(producto.getNombre());
			dto.setDescripcion(producto.getDescripcion());
			dto.setPrecio(producto.getPrecio());
			dto.setTallas(producto.getTallas());
			dto.setTipo(producto.getTipo());
			dto.setValoracion(producto.getValoracion());
			
			List<ImagenesProductosVO> listaImagenes = imagenesProductosRespository.findByProducto_id(producto.getId());
			
			List<String> imagenes = new ArrayList<>();
			
			for (ImagenesProductosVO ipVO : listaImagenes) {
				imagenes.add(ipVO.getUrl());
			}
			dto.setImagenes(imagenes);
			
			return dto;
		}catch(Exception error) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage(), error);
		}
	}

	@Override
	public List<ProductoImagenesDTO> findByTipo(int tipo) {
		try {
			List<ProductoImagenesDTO> listaRetorno = new ArrayList<>();
			List<ProductoVO> listaProductos =productosRepository.findByTipo_Id(tipo);

			
			for (ProductoVO producto : listaProductos) {
				
				ProductoImagenesDTO dto = new ProductoImagenesDTO();
				
				dto.setId(producto.getId());
				dto.setDescripcion(producto.getDescripcion());
				dto.setEstado(producto.getEstado());
				dto.setNombre(producto.getNombre());
				dto.setDescripcion(producto.getDescripcion());
				dto.setPrecio(producto.getPrecio());
				dto.setTallas(producto.getTallas());
				dto.setTipo(producto.getTipo());
				dto.setValoracion(producto.getValoracion());
				
				List<ImagenesProductosVO> listaImagenes = imagenesProductosRespository.findByProducto_id(producto.getId());
				
				List<String> imagenes = new ArrayList<>();
				
				for (ImagenesProductosVO ipVO : listaImagenes) {
					imagenes.add(ipVO.getUrl());
				}
				dto.setImagenes(imagenes);
				listaRetorno.add(dto);

			}
			return listaRetorno;

		}catch(Exception error) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage(), error);
		}
	}

	@Override
	public boolean updateProducto(ProductoVO producto) {
		boolean result= false;
		try {
			ProductoVO productoFromDB = productosRepository.findById(producto.getId());
			
			productoFromDB.setNombre(producto.getNombre());
			productoFromDB.setDescripcion(producto.getDescripcion());
			productoFromDB.setPrecio(producto.getPrecio());
			productoFromDB.setTallas(producto.getTallas());
			productoFromDB.setTipo(producto.getTipo());
			productoFromDB.setEstado(producto.getEstado());

			if(productosRepository.save(productoFromDB) != null) result = true;
			return result;

		}catch(Exception e) {
			return false;
		}
		
		
	}

	@Override
	public boolean deleteProducto(int id) {
		try {
			if(productosRepository.findById(id) != null) {
				productosRepository.deleteById(id);
				return true;
			}else return false;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

	}

	@Override
	public boolean save(ProductoVO producto) {
		try {
			if(productosRepository.save(producto) != null ) 
			return true;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		return false;

	}

	@Override
	public ProductoVO addValoracion(ProductoVO producto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	


	
	
}
