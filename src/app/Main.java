package app;

import model.Producto;
import service.ProductoService;
import java.util.Scanner;
import java.util.InputMismatchException;
import service.PedidoService;
import model.Pedido;
import model.LineaPedido;
import exception.StockInsuficienteException;

public class Main { // Creo la clase Main con el método main para ejecutar el programa y mostrar un menú de opciones para gestionar los productos y pedidos
    public static void main(String[] args) { // Creo una instancia de ProductoService para manejar los productos y una instancia de Scanner para leer la entrada del usuario
        ProductoService servicio = new ProductoService();
        Scanner scanner = new Scanner(System.in);
        
            // Variables para manejar las opciones del menú y el ID actual para los productos
        int opcion = 0;
        int idActual = 1;
        int idPedidoActual = 1; // Variable para manejar el ID actual de los pedidos

        PedidoService pedidoService = new PedidoService(); // Creo una instancia de PedidoService para manejar los pedidos

        while (opcion !=8) { // Bucle para mostrar el menú hasta que el usuario decida salir
            System.out.println("=== Menú ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Crear pedido");
            System.out.println("7. Listar pedidos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try { // Manejo de excepciones para evitar que el programa se caiga si el usuario ingresa un valor no numérico
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito de errores
                continue; // Volver al inicio del bucle para mostrar el menú nuevamente
            }

            switch (opcion) { // Estructura switch para manejar las diferentes opciones del menú y llamar a los métodos correspondientes del servicio de productos
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    scanner.nextLine(); // Limpiar el buffer después de leer un número
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese el stock del producto: ");
                    int stock = scanner.nextInt();
                    Producto producto = new Producto(idActual, nombre, precio, stock);
                    servicio.agregarProducto(producto);
                    System.out.println("Producto agregado correctamente");
                    idActual++; // Incrementar el ID para el próximo producto
                    break;
                case 2:
                    servicio.listarProductos(); // Lógica para listar productos
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int idBusqueda = scanner.nextInt();
                    Producto productoEncontrado = servicio.buscarProductoPorId(idBusqueda);
                    if (productoEncontrado != null) {
                        System.out.println("Producto encontrado: " + productoEncontrado);
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idActualizacion = scanner.nextInt();
                    System.out.print("Ingrese el nuevo stock: ");
                    int nuevoStock = scanner.nextInt();
                    servicio.actualizarStock(idActualizacion, nuevoStock);
                    break;
                case 5:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminacion = scanner.nextInt();
                    servicio.eliminarProducto(idEliminacion);
                    break;
                case 6:
                    try {
                        Pedido pedido = new Pedido(idPedidoActual);
                        boolean seguirAgregando = true;
                        while (seguirAgregando) {
                            System.out.print("Ingrese el ID del producto para agregar al pedido: ");
                            int idProductoPedido = scanner.nextInt();
                            Producto productoPedido = servicio.buscarProductoPorId(idProductoPedido);
                            if (productoPedido != null) {
                                System.out.print("Ingrese la cantidad: ");
                                int cantidad = scanner.nextInt();
                                // VALIDAR STOCK
                                if (cantidad > productoPedido.getStock()) {
                                    throw new StockInsuficienteException(
                                        "Stock insuficiente para el producto: "
                                        + productoPedido.getNombre()
                                    );
                                }
                                // CREAR LINEA
                                LineaPedido linea = new LineaPedido(productoPedido, cantidad);
                                // AGREGAR LINEA AL PEDIDO
                                pedido.agregarLinea(linea);
                                // DESCONTAR STOCK
                                productoPedido.setStock(
                                    productoPedido.getStock() - cantidad
                                );
                                System.out.println("Producto agregado al pedido");
                                // PREGUNTAR SI QUIERE CONTINUAR
                                System.out.print("¿Desea agregar otro producto? (s/n): ");
                                String respuesta = scanner.next();
                                if (respuesta.equalsIgnoreCase("n")) {
                                    seguirAgregando = false;
                                }
                            } else {
                                System.out.println("Producto no encontrado");
                            }
                        }
                        // GUARDAR PEDIDO UNA SOLA VEZ
                        pedidoService.agregarPedido(pedido);
                        System.out.println("Pedido creado correctamente");
                        System.out.println(pedido);
                        idPedidoActual++;
                    } catch (StockInsuficienteException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    pedidoService.listarPedidos(); // Lógica para listar pedidos
                    break;    
                case 8:
                    System.out.println("Saliendo del sistema..."); // Lógica para salir
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
    }
}