package com.footballstore.servicios;

import java.util.List;
import java.util.Optional;

import com.footballstore.modelo.DetallePedidoVO;
import com.footballstore.modelo.PedidoProductosRequestVO;
import com.footballstore.modelo.PedidoVO;


public interface DetallePedidoService {
	List<DetallePedidoVO> findByIdPedido(int id);

}
