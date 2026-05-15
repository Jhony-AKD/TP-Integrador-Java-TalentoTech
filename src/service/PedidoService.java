package service;

import java.util.ArrayList;
import model.Pedido;

public class PedidoService { //Creo la clase PedidoService con un ArrayList para almacenar los pedidos y métodos para agregar y listar pedidos
    
        // Atributos
    private ArrayList<Pedido> pedidos;

        // Constructor
    public PedidoService() {
        this.pedidos = new ArrayList<>();
    }

        // Método para agregar un pedido a la lista de pedidos
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

        // Método para listar todos los pedidos
    public void listarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

}
