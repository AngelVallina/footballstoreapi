package com.footballstore.modelo;

import java.util.List;


public class PedidoProductosRequestVO {

	private PedidoVO pedido;
	private List<DetallePedidoVO> listadoProductos;
	
	public PedidoVO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoVO pedido) {
		this.pedido = pedido;
	}
	public List<DetallePedidoVO> getListadoProductos() {
		return listadoProductos;
	}
	public void setListadoProductos(List<DetallePedidoVO> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}
	
}
