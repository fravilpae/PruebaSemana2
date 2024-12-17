package com.curso.controller;

import java.io.IOException;

import com.curso.service.ProductoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FrontControlador
 * @author Francisco Manuel Villalobos
 * @version 1.0 17/12/2024
 */
public class FrontControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Dependiendo de la opción que se eliga en index.jsp, se accederá a una sección u otra.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Esto lo he hecho para que haya al menos durante la sesión cambios que se reflejen.
		if(request.getSession().getAttribute("service") == null) {
			ProductoService ps = new ProductoService();
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("service", ps);
			sesion.setMaxInactiveInterval(6000);
		}
		
		
		String option = request.getParameter("option");
		String urlVista = "/";
		switch (option) {
		case "alta":
			urlVista = "alta.jsp";
			break;
		case "baja":
			urlVista = "DarBajaServlet";
			break;
		case "modificar":
			urlVista = "ModificarServlet";
			break;
		case "buscar":
			urlVista = "buscador.jsp";
			break;
		case "listar":
			urlVista = "ListarServlet";
			break;
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(urlVista);
		dispatch.forward(request, response);
	}

}
