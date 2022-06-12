package com.footballstore.modelo;
import javax.persistence.*;

@Entity
@Table(name="opiniones")
public class OpinionVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String comentario;
	private float valoracion;
	@ManyToOne
	private ProductoVO producto;
	@ManyToOne
	private User usuario;
	
	public OpinionVO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	public ProductoVO getProducto() {
		return producto;
	}
	public void setProducto(ProductoVO producto) {
		this.producto = producto;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User user) {
		this.usuario = user;
	}
	
	
}
