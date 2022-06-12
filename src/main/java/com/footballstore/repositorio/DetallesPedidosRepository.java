package com.footballstore.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballstore.modelo.DetallePedidoVO;
import com.footballstore.modelo.PedidoVO;

@Repository
public interface DetallesPedidosRepository extends JpaRepository<DetallePedidoVO, Integer>{

	List<DetallePedidoVO> findByPedido_Id(int id);

}