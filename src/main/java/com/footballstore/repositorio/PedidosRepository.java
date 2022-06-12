package com.footballstore.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballstore.modelo.PedidoVO;

@Repository
public interface PedidosRepository extends JpaRepository<PedidoVO, Integer>{

}
