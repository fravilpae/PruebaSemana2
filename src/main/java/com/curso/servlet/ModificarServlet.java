package com.curso.servlet;

import java.io.IOException;
import java.util.List;

import com.curso.modelo.Categoria;
import com.curso.modelo.Producto;
import com.curso.service.ProductoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ModificarServlet
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoService service;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Devuelve la lista de productos disponibles
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		service = (ProductoService) sesion.getAttribute("service");
		List<Producto> productos = service.getProductos();
		request.setAttribute("productos", productos);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("modifica.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Comprueba que los valores dados son válidos. Si lo son, modifica el producto seleccionado
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = (ProductoService) request.getSession().getAttribute("service");
		int index = Integer.parseInt(request.getParameter("index"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Categoria categoria = Categoria.valueOf(request.getParameter("categoria"));
		double precio = Double.valueOf(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String error = service.validarDatos(nombre, descripcion, categoria, precio, stock);
		if (error.equals("")) {
			Producto p = service.getProductos().get(index);
			service.modificarProducto(p, nombre, descripcion, categoria, precio, stock);
			request.setAttribute("producto", p);
			RequestDispatcher dispatch = request.getRequestDispatcher("modificacorrecto.jsp");
			dispatch.forward(request, response);
			
		} else {
			request.setAttribute("errorMensaje", error);
			RequestDispatcher dispatch = request.getRequestDispatcher("modificaincorrecto.jsp");
			dispatch.forward(request, response);
		}
	}

}
