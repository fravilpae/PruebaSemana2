package com.curso.modelo;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public final class Producto {

	private String nombre;
	private Categoria categoria;
	private String descripcion;
	private double precio;
	private int stock;
	
	public Producto(String nombre, Categoria categoria, String descripcion, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return nombre + ". Categoria: " + categoria + ". Descripcion: " + descripcion + ". Precio: "
				+ precio + ". Stock: " + stock;
	}
	
	
}
