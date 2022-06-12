package com.footballstore.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.footballstore.core.ApiResponse;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.servicios.ProductosService;


/**
 * @author avallina
 * Controlador de productos
 */
@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductosController {

	@Autowired
	private ProductosService productosService;
	
	/**
	 * Devuelve todos los productos
	 */
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.findAll()),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Busca los productos por nombre o descripcion
	 */
	@RequestMapping(value = "/findByText" , method = RequestMethod.GET)
	public ResponseEntity<?> findByText(@RequestParam String text) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.findByNombreOrDescripcion(text,text)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Obtiene el producto pasando el id
	 */
	@RequestMapping(value = "/findById" , method = RequestMethod.GET)
	public ResponseEntity<?> findById(@RequestParam int id) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.findById(id)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Obtiene los productos pasando el tipo
	*/
	@RequestMapping(value = "/findByTipo" , method = RequestMethod.GET)
	public ResponseEntity<?> findByTipo(@RequestParam int tipo) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.findByTipo(tipo)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Actualiza un producto
	*/
	@PostMapping(value = "/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateProducto(@RequestBody ProductoVO producto) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.updateProducto(producto)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Aniade un producto
	*/
	@PostMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addProducto(@RequestBody ProductoVO producto) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.save(producto)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	
	/**
	 * Borra un producto
	*/
	@DeleteMapping(value = "/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteProducto(@RequestParam int id) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),productosService.deleteProducto(id)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	

}