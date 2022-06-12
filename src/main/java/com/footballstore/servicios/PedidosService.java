package com.footballstore.servicios;

import java.util.List;
import java.util.Optional;

import com.footballstore.modelo.PedidoProductosRequestVO;
import com.footballstore.modelo.PedidoVO;


public interface PedidosService {
	List<PedidoVO> findAll();
	PedidoVO crearPedido(PedidoProductosRequestVO carrito);
	Optional<PedidoVO> findById(int id);

}
