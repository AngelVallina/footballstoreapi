package com.footballstore.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footballstore.core.ApiResponse;
import com.footballstore.modelo.DetallePedidoVO;
import com.footballstore.modelo.PedidoProductosRequestVO;
import com.footballstore.modelo.PedidoVO;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.servicios.PedidosService;

/**
 * @author avallina
 * Controlador de pedidos
 */
@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidosController {

	@Autowired
	private PedidosService pedidosService;

	/**
	 * Devuelve todos los pedidods
	 */
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),pedidosService.findAll()),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Devuelve un pedido por id
	 */
	@RequestMapping(value = "/getById" , method = RequestMethod.GET)
	public ResponseEntity<?> getById(@RequestParam int id) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),pedidosService.findById(id)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * Crea un pedido
	*/
	@PostMapping(value = "/create")
	public ResponseEntity<?> addPedido(@RequestBody PedidoProductosRequestVO pedidoProducto) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),pedidosService.crearPedido(pedidoProducto)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
