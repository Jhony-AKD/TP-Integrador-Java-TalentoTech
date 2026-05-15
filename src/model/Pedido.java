package model;

import java.util.ArrayList;

public class Pedido { //Creo la clase Pedido con sus atributos, constructor, getters, setters y método toString
    
        // Atributos
    private int id;
    private ArrayList<LineaPedido> lineas;

        // Constructor
    public Pedido(int id) {
        this.id = id;
        this.lineas = new ArrayList<>();
    }

        // Metodo para agregar una línea de pedido al pedido
    public void agregarLinea(LineaPedido linea) {
        this.lineas.add(linea);
    }

        // Metodo para calcular el total del pedido sumando los subtotales de cada línea
    public double calcularTotal() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }

        // ToString para mostrar la información del pedido, incluyendo el ID, las líneas de pedido y el total
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(id).append("\n");
        for (LineaPedido linea : lineas) {
            sb.append("  ").append(linea).append("\n");
        }
        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }
}
