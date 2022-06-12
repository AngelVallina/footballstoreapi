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
import com.footballstore.repositorio.PedidosRepository;
import com.footballstore.repositorio.ProductoRepository;
import com.footballstore.servicios.DetallePedidoService;
import com.footballstore.servicios.PedidosService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
	

	@Autowired
	DetallesPedidosRepository detallesPedidosRepository;

	@Override
	public List<DetallePedidoVO> findByIdPedido(int id) {
		return detallesPedidosRepository.findByPedido_Id(id);
	}


	
}
