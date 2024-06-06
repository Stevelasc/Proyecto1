package proyecto.main;

import proyecto.inventario.*;
import proyecto.clientes.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        while (true) {
            String[] options = {"Agregar Producto", "Eliminar Producto", "Mostrar Inventario", "Calcular Valor Total", "Agregar Cliente", "Mostrar Clientes", "Salir"};
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Inventario", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                break;
            }
// Estas son las opciones al momento de ejecutar el proyecto
            switch (seleccion) {
                case "Agregar Producto":
                    agregarProducto(inventario);
                    break;

                case "Eliminar Producto":
                    eliminarProducto(inventario);
                    break;

                case "Mostrar Inventario":
                    mostrarInventario(inventario);
                    break;

                case "Calcular Valor Total":
                    calcularValorTotal(inventario);
                    break;

                case "Agregar Cliente":
                    agregarCliente();
                    break;

                case "Mostrar Clientes":
                    mostrarClientes();
                    break;

            }
        }
    }

    private static void agregarProducto(Inventario inventario) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        double precio = Double.parseDouble(precioStr);

        Producto producto = new ProductoConcreto(nombre, precio);
        inventario.agregarProducto(producto);

        JOptionPane.showMessageDialog(null, "Producto agregado: " + producto.obtenerDescripcion());
    }

    private static void eliminarProducto(Inventario inventario) {
        if (inventario.getProductos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario para eliminar.");
            return;
        }

        String[] productos = inventario.obtenerDescripcionesProductos();
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el producto a eliminar", "Eliminar Producto", JOptionPane.QUESTION_MESSAGE, null, productos, productos[0]);

        if (seleccion != null) {
            Producto productoAEliminar = null;
            for (Producto producto : inventario.getProductos()) {
                if (producto.obtenerDescripcion().equals(seleccion)) {
                    productoAEliminar = producto;
                    break;
                }
            }
            if (productoAEliminar != null) {
                inventario.eliminarProducto(productoAEliminar);
                JOptionPane.showMessageDialog(null, "Producto eliminado: " + productoAEliminar.obtenerDescripcion());
            }
        }
    }

    private static void mostrarInventario(Inventario inventario) {
        if (inventario.getProductos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario.");
            return;
        }

        StringBuilder inventarioStr = new StringBuilder();
        for (Producto producto : inventario.getProductos()) {
            inventarioStr.append(producto.obtenerDescripcion()).append("\n");
        }

        JOptionPane.showMessageDialog(null, inventarioStr.toString(), "Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void calcularValorTotal(Inventario inventario) {
        double valorTotal = inventario.calcularValorTotal();
        JOptionPane.showMessageDialog(null, "El valor total del inventario es: " + valorTotal);
    }

    // Lista para almacenar los clientes
    private static List<Cliente> clientes = new ArrayList<>();

    private static void agregarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");

        Cliente cliente = new Cliente(nombre, direccion);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente agregado: " + cliente.obtenerInformacion());
    }

    private static void mostrarClientes() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        StringBuilder clientesStr = new StringBuilder();
        for (Cliente cliente : clientes) {
            clientesStr.append(cliente.obtenerInformacion()).append("\n");
        }

        JOptionPane.showMessageDialog(null, clientesStr.toString(), "Clientes", JOptionPane.INFORMATION_MESSAGE);
    }
}