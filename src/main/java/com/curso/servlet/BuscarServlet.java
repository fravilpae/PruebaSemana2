package com.curso.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Categoria;
import com.curso.modelo.Producto;
import com.curso.service.ProductoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscarServlet
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoService service;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Dependiendo del parámetro por el que se haya decidido buscar, se buscan los productos que concuerden con el valor del parámetro
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = (ProductoService) request.getSession().getAttribute("service");
		String option = request.getParameter("option");
		List<Producto> productos = new ArrayList<Producto>();
		
		switch (option) {
		case "nombre":
			String nombre = request.getParameter("nombre");
			request.setAttribute("valor", nombre);
			productos = service.buscarProductosPorNombre(nombre);
			break;
		case "descripcion":
			String descripcion = request.getParameter("descripcion");
			request.setAttribute("valor", descripcion);
			productos = service.buscarProductosPorDescripcion(descripcion);
			break;
		case "categoria":
			Categoria categoria = Categoria.valueOf(request.getParameter("categoria"));
			request.setAttribute("valor", categoria.name()); //Para que sea String como los demás
			productos = service.buscarProductosPorCategoria(categoria);
			break;
		}
		
		request.setAttribute("option", option);
		request.setAttribute("productos", productos);
		RequestDispatcher dispatch = request.getRequestDispatcher("productosbuscados.jsp");
		dispatch.forward(request, response);
	}

}
