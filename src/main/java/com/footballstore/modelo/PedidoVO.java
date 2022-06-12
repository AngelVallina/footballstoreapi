package com.footballstore.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="pedidos")
public class PedidoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double total;
	@ManyToOne
	private DireccionVO direccion;
	@ManyToOne
	private User usuario;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public DireccionVO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionVO direccion) {
		this.direccion = direccion;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
