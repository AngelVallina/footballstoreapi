package com.footballstore.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detallespedidos")
public class DetallePedidoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private PedidoVO pedido;
	@ManyToOne
	private ProductoVO producto;
	private int cantidad;
	private String talla;
	
	public DetallePedidoVO() {
		
	}
	
	public DetallePedidoVO(PedidoVO pedido, ProductoVO producto, int cantidad , String talla) {
		this.setPedido(pedido);
		this.setProducto(producto);
		this.setCantidad(cantidad);
		this.setTalla(talla);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PedidoVO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoVO pedido) {
		this.pedido = pedido;
	}
	public ProductoVO getProducto() {
		return producto;
	}
	public void setProducto(ProductoVO producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}
	
}
