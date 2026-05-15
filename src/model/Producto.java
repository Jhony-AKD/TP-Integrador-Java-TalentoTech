package model;

public class Producto { //Creo la clase Producto con sus atributos, constructor, getters, setters y método toString

    // Atributos
 private int id;
 private String nombre;
 private double precio;
 private int stock;

    // Constructor
 public Producto(int id, String nombre, double precio, int stock) {
     this.id = id;
     this.nombre = nombre;
     this.precio = precio;
     this.stock = stock;
 }
 
    // Getters y Setters
  public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método toString para mostrar la información del producto
  @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
    }

}