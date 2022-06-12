package com.footballstore.modelo;

public class OpinionProductoUsuarioRequestDTO {

	private int idProducto;
	private int idUsuario;
	private String comentario;
	private float valoracion;
	private String nombreUsuario;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public OpinionProductoUsuarioRequestDTO(int idProducto, int idUsuario, String comentario, float valoracion,
			String nombreUsuario) {
		super();
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.comentario = comentario;
		this.valoracion = valoracion;
		this.nombreUsuario = nombreUsuario;
	}
	
	
}
