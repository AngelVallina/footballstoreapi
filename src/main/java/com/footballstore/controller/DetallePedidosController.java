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
import com.footballstore.servicios.DetallePedidoService;
import com.footballstore.servicios.PedidosService;

/**
 * @author avallina
 * Controlador de pedidos
 */
@RestController
@RequestMapping("/detalles")
@CrossOrigin
public class DetallePedidosController {

	@Autowired
	private DetallePedidoService detallePedidoService;
	
	/**
	 * Devuelve los detalles por id pedido
	 */
	@RequestMapping(value = "/getByIdPedido" , method = RequestMethod.GET)
	public ResponseEntity<?> getByIdPedido(@RequestParam int idPedido) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),detallePedidoService.findByIdPedido(idPedido)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

}
