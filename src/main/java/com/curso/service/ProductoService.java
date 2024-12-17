package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.curso.modelo.Categoria;
import com.curso.modelo.Producto;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public final class ProductoService {

	private static List<Producto> productos = new ArrayList<Producto>();
	
	/**
	 * Asignación estática por defecto de una lista de productos
	 */
	static {
		productos.add(new Producto("Producto 1", Categoria.Limpieza, "Producto de limpieza caro", 47.99, 10));
		productos.add(new Producto("Producto 2", Categoria.Limpieza, "Producto de limpieza barato", 12.99, 100));
		productos.add(new Producto("Producto 3", Categoria.Alimentacion, "Comida", 2.99, 400));
		productos.add(new Producto("Producto 4", Categoria.Mobiliario, "Armario grande", 117.99, 50));
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
	/**
	 * Método que devuelve las categorías disponibles para los productos (usado para el select en dar de alta)
	 * @return Categorías disponibles
	 */
	public static List<Categoria> obtenerCategorias() {
		return Arrays.asList(Categoria.values());
	}
	
	/**
	 * Añade un producto nuevo a la lista
	 * @param producto Producto a añadir
	 */
	public void darAltaProducto(Producto producto) {
		ProductoService.productos.add(producto);
	}
	
	/**
	 * Elimina el producto de la lista de productos
	 * @param index Índice en la lista de productos del producto a eliminar
	 */
	public void darBajaProducto(int index) {
		ProductoService.productos.remove(index);
	}
	
	/**
	 * Modifica el producto seleccionado
	 * 
	 * @param p Producto a modificar
	 * @param nombre Nombre nuevo del producto
	 * @param descripcion Descripción nueva del producto
	 * @param categoria Categoría nueva del producto
	 * @param precio Precio nuevo del producto
	 * @param stock Stock nuevo del producto
	 */
	public void modificarProducto(Producto p, String nombre, String descripcion, Categoria categoria, double precio, int stock) {
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		p.setCategoria(categoria);
		p.setPrecio(precio);
		p.setStock(stock);
	}
	
	/**
	 * Buscador de productos por nombre.
	 * 
	 * @param nombre Nombre del producto a buscar
	 * @return Lista de productos que en su nombre contienen el texto indicado
	 * en el parámetro
	 */
	public List<Producto> buscarProductosPorNombre(String nombre) {
		return ProductoService.productos.stream()
				.filter(x->x.getNombre().toLowerCase().contains(nombre.toLowerCase()))
				.toList();
	}
	
	/**
	 * Buscador de productos por descripción.
	 * 
	 * @param descripcion Descripción del producto a buscar
	 * @return Lista de productos que en su descripción contienen el texto indicado
	 * en el parámetro
	 */
	public List<Producto> buscarProductosPorDescripcion(String descripcion) {
		return ProductoService.productos.stream()
				.filter(x->x.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
				.toList();
	}
	
	/**
	 * Buscador de productos por categoría.
	 * 
	 * @param categoria Categoria del producto
	 * @return Lista de productos cuya categoría concuerda con la indicada
	 */
	public List<Producto> buscarProductosPorCategoria(Categoria categoria) {
		return ProductoService.productos.stream()
				.filter(x->x.getCategoria().equals(categoria))
				.toList();
	}
	
	/**
	 * Método para comprobar que todos los inputs se han introducido correctamente. Útil en dar de alta y modificar
	 * 
	 * @param nombre Nombre del producto
	 * @param descripcion Descripcion del producto
	 * @param categoria Categoria del producto
	 * @param precio Precio del producto
	 * @param stock Stock del producto
	 * @return Mensaje de error a mostrar
	 */
	public String validarDatos(String nombre, String descripcion, Categoria categoria, double precio, int stock) {
		String error = "";
		if(nombre == null | nombre == "") {
			error = "Introduzca un nombre válido";
		} else if (descripcion == null | descripcion == "") {
			error = "Introduzca una descripción válida";
		} else if (categoria == null) {
			error = "La categoría se ha introducido incorrectamente.";
		} else if (Double.valueOf(precio)==null) {
			error = "Introduzca un precio válido";
		} else if (stock <=0) {
			error = "Introduzca un stock válido";
		}
		return error;
	}
}