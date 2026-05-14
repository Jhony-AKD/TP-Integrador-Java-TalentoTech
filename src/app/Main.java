package app;

import model.Producto;
import service.ProductoService;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ProductoService servicio = new ProductoService();
        Scanner scanner = new Scanner(System.in);
        
        int opcion = 0;
        int idActual = 1;

        while (opcion !=6) {
            System.out.println("=== Menú ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito de errores
                continue; // Volver al inicio del bucle para mostrar el menú nuevamente
            }

            switch (opcion) {
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
