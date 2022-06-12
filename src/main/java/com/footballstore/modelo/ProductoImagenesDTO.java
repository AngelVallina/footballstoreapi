package com.footballstore.modelo;

import java.util.List;

public class ProductoImagenesDTO {


		private int id;
		private String nombre;
		private String descripcion;
 		private TipoVO tipo;
		private double precio;
		private String estado;
		private String tallas;
		private float valoracion;
		private List<String> imagenes;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public TipoVO getTipo() {
			return tipo;
		}
		public void setTipo(TipoVO tipo) {
			this.tipo = tipo;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getTallas() {
			return tallas;
		}
		public void setTallas(String tallas) {
			this.tallas = tallas;
		}
		public float getValoracion() {
			return valoracion;
		}
		public void setValoracion(float valoracion) {
			this.valoracion = valoracion;
		}
		public List<String> getImagenes() {
			return imagenes;
		}
		public void setImagenes(List<String> imagenes) {
			this.imagenes = imagenes;
		}
		
		
		
	}

