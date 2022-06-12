package com.footballstore.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.footballstore.modelo.OpinionProductoUsuarioRequestDTO;
import com.footballstore.modelo.PedidoProductosRequestVO;
import com.footballstore.modelo.PedidoVO;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.servicios.OpinionesService;
import com.footballstore.servicios.PedidosService;

/**
 * @author avallina
 *	Controlador de opiniones
 */
@RestController
@RequestMapping("/opiniones")
@CrossOrigin
public class OpinionesController {

	@Autowired
	private OpinionesService opinionesService;

	/**
	 * Devuelve las opiniones de un producto
	 */
	@RequestMapping(value = "/getByIdProducto" , method = RequestMethod.GET)
	public ResponseEntity<?> getById(@RequestParam int idProducto) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),opinionesService.findByProducto_Id(idProducto)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * Devuelve la valoracion media de un producto
	 */
	@RequestMapping(value = "/getValoracionMedia" , method = RequestMethod.GET)
	public ResponseEntity<?> getValoracionMedia(@RequestParam int idProducto) {
		try {
			return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),opinionesService.getValoracionMedia(idProducto)),HttpStatus.OK);
		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * Aniade una opinion
	*/
	@PostMapping(value = "/add")
	public ResponseEntity<?> addOpinion(@RequestBody OpinionProductoUsuarioRequestDTO opinion) {
		
		//SecurityContextHolder.getContext().getAuthentication().getPrincipal(); obj userDetails
		try {
			if(opinion.getValoracion() >= 0  && opinion.getValoracion() <=5) {
				return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),opinionesService.addOpinion(opinion)),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(new ApiResponse(new Timestamp(new Date().getTime()),"La valoracion ha de estar entre 0 y 5"),HttpStatus.BAD_REQUEST);
			}

		}catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				return new ResponseEntity("Error: Violacion de restriccion", HttpStatus.BAD_REQUEST);
			if(e.getCause() instanceof DataException)
				return new ResponseEntity("Error: Uno de los campos no sigue el formato correcto", HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
