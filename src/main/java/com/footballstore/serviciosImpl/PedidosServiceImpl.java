package com.footballstore.serviciosImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballstore.modelo.DetallePedidoVO;
import com.footballstore.modelo.PedidoProductosRequestVO;
import com.footballstore.modelo.PedidoVO;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.repositorio.DetallesPedidosRepository;
import com.footballstore.repositorio.DireccionRepository;
import com.footballstore.repositorio.PedidosRepository;
import com.footballstore.repositorio.ProductoRepository;
import com.footballstore.servicios.PedidosService;

@Service
public class PedidosServiceImpl implements PedidosService{
	
	@Autowired
	PedidosRepository pedidosRepository;
	@Autowired
	ProductoRepository productosRepository;
	@Autowired
	DireccionRepository direccionRepository;
	@Autowired
	DetallesPedidosRepository detallesPedidosRepository;

	@Override
	public List<PedidoVO> findAll() {
		return pedidosRepository.findAll();
	}
	@Override
	public Optional<PedidoVO> findById(int id) {
		return pedidosRepository.findById(id);
	}
	
	@Override
	public PedidoVO crearPedido(PedidoProductosRequestVO carrito) {
		PedidoVO pedido = carrito.getPedido();
		direccionRepository.save(pedido.getDireccion());
		//Obtiene el total del carrito de base de datos, para evitar totales falsos
		double total = 0;
		for (DetallePedidoVO detallePedido : carrito.getListadoProductos()) {		
			total+= (productosRepository.getById(detallePedido.getProducto().getId()).getPrecio())*detallePedido.getCantidad();
		}
		pedido.setTotal(total);
		//Asigna la nueva direccion guardada en bd
		pedido.setDireccion(direccionRepository.save(pedido.getDireccion()));
		//Guarda el pedido y lo asigna al detalle
		pedido = pedidosRepository.save(pedido);
		for (DetallePedidoVO detallePedido : carrito.getListadoProductos()) {
			detallePedido.setPedido(pedido);
		}
		
		detallesPedidosRepository.saveAll(carrito.getListadoProductos());
		
		return pedido;
	}

	
	
	
	
	
}
