package service;

import model.Producto;

import java.util.ArrayList;

public class ProductoService {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // o lanzar una excepción si no se encuentra
    }

    public void actualizarStock(int id, int nuevoStock) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            if (nuevoStock >= 0) {
                producto.setStock(nuevoStock);
                System.out.println("Stock actualizado: " + producto);
            } else {
                System.out.println("El stock no puede ser negativo.");
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void eliminarProducto(int id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto);
        } else {
            System.out.println("Producto no encontrado");
        }
    }
}
