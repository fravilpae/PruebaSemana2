package com.curso.servlet;

import java.io.IOException;
import java.util.List;

import com.curso.modelo.Producto;
import com.curso.service.ProductoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DarBajaServlet
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class DarBajaServlet extends HttpServlet {
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
		
		RequestDispatcher dispatch = request.getRequestDispatcher("baja.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Elimina al producto seleccionado de la lista
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("producto"));
		service.darBajaProducto(index);
		RequestDispatcher dispatch = request.getRequestDispatcher("bajacorrecto.jsp");
		dispatch.forward(request, response);
	}

}
