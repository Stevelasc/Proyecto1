package proyecto.inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto.obtenerDescripcion());
        }
    }

    public String[] obtenerDescripcionesProductos() {
        String[] descripciones = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
            descripciones[i] = productos.get(i).obtenerDescripcion();
        }
        return descripciones;
    }
}