# Sistema de Gestión - Talento Tech

Proyecto realizado en Java como trabajo práctico integrador.

## Descripción

Este sistema permite gestionar productos y pedidos desde consola utilizando Programación Orientada a Objetos (POO), colecciones, excepciones y estructuras de control en Java.

El programa funciona mediante un menú interactivo que permite:

- Agregar productos
- Listar productos
- Buscar productos por ID
- Actualizar stock
- Eliminar productos
- Crear pedidos
- Listar pedidos realizados

---

# Funcionalidades principales

## Gestión de productos

Cada producto posee:

- ID
- Nombre
- Precio
- Stock

Los productos se almacenan utilizando:

```java
ArrayList<Producto>
```

---

## Gestión de pedidos

Los pedidos permiten agregar múltiples productos con distintas cantidades.

Cada pedido contiene:

- ID del pedido
- Lista de líneas de pedido
- Total calculado automáticamente

Cada línea de pedido relaciona:

- Un producto
- Una cantidad solicitada
- Un subtotal

---

# Validaciones implementadas

El sistema incluye validaciones para:

- Evitar stock negativo
- Verificar existencia de productos
- Controlar stock insuficiente
- Manejar errores de entrada mediante `try/catch`

---

# Excepciones personalizadas

Se implementó una excepción personalizada:

```java
StockInsuficienteException
```

La misma se utiliza cuando el usuario intenta solicitar una cantidad mayor al stock disponible.

---

# Tecnologías utilizadas

- Java
- Visual Studio Code
- Programación Orientada a Objetos
- ArrayList
- Scanner
- Manejo de excepciones

---

# Estructura del proyecto

```txt
src/
│
├── app/
│   └── Main.java
│
├── model/
│   ├── Producto.java
│   ├── Pedido.java
│   └── LineaPedido.java
│
├── service/
│   ├── ProductoService.java
│   └── PedidoService.java
│
└── exception/
    └── StockInsuficienteException.java
```

---

# Conceptos aplicados

Durante el desarrollo se trabajó con:

- Clases y objetos
- Encapsulamiento
- Composición
- Herencia
- Polimorfismo básico
- Colecciones
- Métodos
- Constructores
- Sobrescritura de `toString()`
- Manejo de excepciones

---

# Ejemplo de uso

```txt
1. Agregar producto
2. Listar productos
3. Buscar producto
4. Actualizar stock
5. Eliminar producto
6. Crear pedido
7. Listar pedidos
8. Salir
```

---

# Autor

Jonatan Esquivel

Proyecto desarrollado como práctica de Java y Programación Orientada a Objetos.# TP-Integrador-Java-TalentoTech
