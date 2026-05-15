package exception;

public class StockInsuficienteException extends Exception { //Creo la clase StockInsuficienteException que extiende de Exception para manejar el caso de stock insuficiente al agregar una línea de pedido a un pedido

        // Constructor que recibe un mensaje de error
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
    
}
