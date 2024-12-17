package com.curso.servlet;

import java.io.IOException;

import com.curso.modelo.Categoria;
import com.curso.modelo.Producto;
import com.curso.service.ProductoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DarAltaServlet
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoService service;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Comprueba que los valores dados son válidos. Si lo son, crea el producto y lo añade en la lista de productos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = (ProductoService) request.getSession().getAttribute("service");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Categoria categoria = Categoria.valueOf(request.getParameter("categoria"));
		double precio = Double.valueOf(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String error = service.validarDatos(nombre, descripcion, categoria, precio, stock);
		if (error.equals("")) {
			Producto p = new Producto(nombre, categoria, descripcion, precio, stock);
			service.darAltaProducto(p);
			request.setAttribute("producto", p);
			RequestDispatcher dispatch = request.getRequestDispatcher("altacorrecto.jsp");
			dispatch.forward(request, response);
			
		} else {
			request.setAttribute("errorMensaje", error);
			RequestDispatcher dispatch = request.getRequestDispatcher("alta.jsp");
			dispatch.include(request, response);
		}
	}

}
