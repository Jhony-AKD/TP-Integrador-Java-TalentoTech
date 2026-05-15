package model;

public class LineaPedido { // Creo la clase LineaPedido con sus atributos, constructor, getters, setters, método para calcular el subtotal y método toString

        // Atributos
    private Producto producto;
    private int cantidad;

        // Constructor
    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

        // Getters y Setters
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

        // Método para calcular el subtotal de la línea de pedido
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

        // Método toString para mostrar la información de la línea de pedido
    @Override
    public String toString() {
        return "[" + producto.getNombre() + " | cantidad=" + cantidad + " | subtotal=" + (calcularSubtotal()) + "]";
    }
}
