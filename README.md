# Proyecto Gestión de almacén

Este es un proyecto Java Dynamic Web Project, que trata sobre la gestión de productos de un almacén. En este almacén se podrán realizar distintas funcionalidades, como dar de alta un producto, darlo de baja, listar los productos disponibles, modificar un producto y buscar productos específicos.

Para utilizar este proyecto no requiere instalación previa.

## Descripción

**Clases**

La clase Producto representa a los productos del almacén. La información de un producto es su nombre, descripción, categoría, precio y stock(cantidad almacenada en el almacén).

La clase Categoria es un enumerado con los distintos valores de categoría de un producto.

En la clase ProductoService se encuentran las funcionalidades que se podrán realizar en la gestión de productos. En ella además se asignan unos productos por defecto para poder tener unos datos iniciales.

**Servlets**

El servlet ListarServlet proporciona la lógica necesaria para mostrar los productos disponibles.

El servlet DarAltaServlet proporciona la lógica necesaria para dar de alta a un producto.

El servlet DarBajaServlet proporciona la lógica necesaria para dar de baja a un producto.

El servlet ModificarServlet proporciona la lógica necesaria para modificar un producto.

El servlet BuscarServlet proporciona la lógica necesaria para buscar productos específicos.

**Archivos jsp**

El contenido de alta.jsp se muestra cuando se quiere dar de alta un producto.

El contenido de altacorrecto.jsp se muestra cuando se da de alta un producto correctamente.

El contenido de baja.jsp se muestra cuando se quiere dar de baja un producto.

El contenido de bajacorrecto.jsp se muestra cuando se da de baja un producto correctamente.

El contenido de buscador.jsp se muestra cuando se quiere buscar productos específicos.

El contenido de index.jsp es la página inicial del proyecto.

El contenido de listado.jsp se muestra cuando se quiere listar los productos disponibles.

El contenido de modifica.jsp se muestra cuando se quiere modificar un producto.

El contenido de modificacorrecto.jsp se muestra cuando se modifica un producto correctamente.

El contenido de modificaincorrecto.jsp se muestra cuando se modifica un producto incorrectamente.

El contenido de productosbuscados.jsp se muestra cuando se realiza una búsqueda de productos específicos.

## Funcionalidades
**Clase Producto**

La clase Producto tiene las siguientes funcionalidades:

- Constructor: Crea una instancia de producto con un nombre, descripción, categoría, precio y stock.
- getNombre(): Devuelve el nombre del producto.
- setNombre(String nombre): Modifica el nombre del producto.
- getDescripcion(): Devuelve la descripción del producto.
- setDescripcion(String descripcion): Modifica la descripción del producto.
- getCategoria(): Devuelve la categoría del producto.
- setCategoria(Categoria categoria): Modifica la categoría del producto.
- getPrecio(): Devuelve el precio del producto.
- setPrecio(double precio): Modifica el precio del producto.
- getStock(): Devuelve el stock del producto.
- setStock(int stock): Modifica el stock del producto.

**Clase ProductoService**

La clase ProductoService() tiene las siguientes funcionalidades:

- Asignación estática para crear unos productos iniciales por defecto.
- getProductos(): Devuelve la lista de productos disponibles.
- obtenerCategorias(): Devuelve las categorías disponibles.
- darAltaProducto(Producto producto): Añade un producto a la lista.
- darBajaProducto(int index): Elimina un producto de la lista.
- modificarProducto(int index, String nombre, String descripcion, Categoria categoria, double precio, int stock): Modifica un producto existente de la lista.
- buscarProductosPorNombre(String nombre): Devuelve los productos que concuerden con el nombre indicado en el parámetro.
- buscarProductosPorDescripcion(String descripcion): Devuelve los productos que concuerden con la descripción indicada en el parámetro.
- buscarProductosPorCategoria(Categoria categoria): Devuelve los productos que concuerden con la categoría indicada en el parámetro.
- validarDatos(String nombre, String descripcion, Categoria categoria, double precio, int stock): Valida los datos de un producto. Útil para dar de alta o modificar un producto.

**Clases controladores y servlets**

FrontControlador.doGet(HttpServletRequest request, HttpServletResponse response): Redirige a las distintas funcionalidades del programa, en función de la que se eliga.

ListarServlet.doGet(HttpServletRequest request, HttpServletResponse response): Devuelve el listado de todos los productos disponibles.

DarAltaServlet.doPost(HttpServletRequest request, HttpServletResponse response): Crea un producto y lo añade a la lista de productos.

DarBajaServlet.doGet(HttpServletRequest request, HttpServletResponse response): Devuelve todos los productos disponibles.
DarBajaServlet.doPost(HttpServletRequest request, HttpServletResponse response): Elimina al producto elegido de la lista de productos.

ModificarServlet.doGet(HttpServletRequest request, HttpServletResponse response): Devuelve todos los productos disponibles.
ModificarServlet.doPost(HttpServletRequest request, HttpServletResponse response): Modifica el producto seleccionado de la lista de productos con los datos indicados.

BuscarServlet.doPost(HttpServletRequest request, HttpServletResponse response): En función del parámetro que se eliga para buscar, devuelve los productos que cumplen esa condición.

## Uso
Para utilizar el programa, debe arrancar en un servidor el archivo index.jsp. Una vez hecho, se cargará en su navegador la página inicial, donde podrá acceder a las distintas funcionalidades del programa.

## Historia
Versión 1.0 (2024-12-17) - Lanzamiento inicial
