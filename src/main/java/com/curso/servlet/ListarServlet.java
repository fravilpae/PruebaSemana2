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
 * Servlet implementation class ListarServlet
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoService service;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Listado de todos los productos disponibles
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		service = (ProductoService) sesion.getAttribute("service");
		List<Producto> productos = service.getProductos();
		request.setAttribute("productos", productos);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
		dispatch.forward(request, response);
	}

}
